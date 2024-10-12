package com.earth.Trading.controller;

import com.earth.Trading.domain.OrderType;
import com.earth.Trading.modal.Coin;
import com.earth.Trading.modal.Order;
import com.earth.Trading.modal.User;
import com.earth.Trading.request.CreateOrderRequest;
import com.earth.Trading.service.CoinService;
import com.earth.Trading.service.OrderService;
import com.earth.Trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private CoinService coinService;

//    @Autowired
//    private WalletTransationService walletTransationService;

    @PostMapping("/pay")
    public ResponseEntity<Order> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req
    ) throws Exception{
        User user = userService.findUserProfileByJwt(jwt);
        Coin coin = coinService.findById(req.getCoinId());

        Order order = orderService.processOrder(coin,req.getQuantity(),req.getOrderType(),user);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(
            @RequestHeader("Authorization") String jwtToken,
            @PathVariable Long orderId
    ) throws Exception{
        if(jwtToken == null){
            throw new Exception("token missing..");
        }

        User user = userService.findUserProfileByJwt(jwtToken);

        Order order= orderService.getOrderById(orderId);

        if(Objects.equals(order.getUser().getId(), user.getId())){

            return ResponseEntity.ok(order);
        } else {
            throw new Exception("you don't have access");
        }
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(required = false) OrderType order_type,
            @RequestParam(required = false) String asset_symbol
    ) throws Exception{
        if(jwt==null){
            throw new Exception("token missing..");
        }

        Long userId = userService.findUserProfileByJwt(jwt).getId();

        List<Order> userOrders = orderService.getAllOrderOfUser(userId,order_type,asset_symbol);
        return  ResponseEntity.ok(userOrders);
    }

}
