package com.earth.Trading.controller;

import com.earth.Trading.domain.WalletTransactionType;
import com.earth.Trading.modal.*;
import com.earth.Trading.response.PaymentResponse;
import com.earth.Trading.service.OrderService;
import com.earth.Trading.service.PaymentService;
import com.earth.Trading.service.UserService;
import com.earth.Trading.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.PrimitiveIterator;

@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentService paymentService;

//    @Autowired
//    private TransactionService transactionService;


    @GetMapping("/api/wallet")
    public ResponseEntity<Wallet> getUserWallet(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        Wallet wallet = walletService.getUserWallet(user);

        return new ResponseEntity<>(wallet, HttpStatus.ACCEPTED);

    }

    @PutMapping("/api/wallet/{walletId}/transfer")
    public ResponseEntity<Wallet> walletToWalletTransfer(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long walletId,
            @RequestBody WalletTransaction req)
            throws Exception{
        User senderUser = userService.findUserProfileByJwt(jwt);
        Wallet receiverWallet = walletService.findWalletById(walletId);
        Wallet wallet = walletService.walletToWalletTransfer(
                senderUser,
                receiverWallet,
                req.getAmount());

//        transactionService.createTransaction(wallet,
//                WalletTransactionType.WALLET_TRANSFER,
//                receiverWallet.getId(),
//                req.getPurpose(),
//                req.getAmount());


        return new ResponseEntity<>(wallet,HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/order/{orderId}/pay")
    public ResponseEntity<Wallet> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId
    ) throws Exception{
        User user = userService.findUserProfileByJwt(jwt);

        Order order = orderService.getOrderById(orderId);

        Wallet wallet= walletService.payOrderPayment(order,user);

        return new ResponseEntity<>(wallet,HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/wallet/deposit")
    public ResponseEntity<Wallet> addBalanceToWallet(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(name = "order_id") Long orderId,
            @RequestParam(name = "payment_id") String paymentId
    ) throws Exception{
        User user = userService.findUserProfileByJwt(jwt);

        Wallet wallet= walletService.getUserWallet(user);

        PaymentOrder order = paymentService.getPaymentOrderById(orderId);

        Boolean status = paymentService.ProceedPaymentOrder(order,paymentId);

        if(wallet.getBalance()==null){
            wallet.setBalance(BigDecimal.valueOf(0));
        }
        if(status){
            wallet = walletService.addBalance(wallet,order.getAmount());
        }

        return new ResponseEntity<>(wallet,HttpStatus.ACCEPTED);
    }
}
