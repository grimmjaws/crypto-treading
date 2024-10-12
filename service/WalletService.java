package com.earth.Trading.service;

import com.earth.Trading.modal.Order;
import com.earth.Trading.modal.User;
import com.earth.Trading.modal.Wallet;

public interface WalletService {

    Wallet getUserWallet(User user);
    Wallet addBalance(Wallet wallet, Long money);
    Wallet findWalletById(Long id) throws Exception;
    Wallet walletToWalletTransfer(User sender,Wallet receiverWallet ,Long amount) throws Exception;
    Wallet payOrderPayment(Order order, User user) throws Exception;

}
