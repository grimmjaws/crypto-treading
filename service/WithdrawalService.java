package com.earth.Trading.service;

import com.earth.Trading.modal.User;
import com.earth.Trading.modal.Withdrawal;

import java.util.List;

public interface WithdrawalService {


    Withdrawal requestWithdrawal(Long amount, User user);

    Withdrawal proceedWithWithdrawal(Long withdrawalId , boolean accept) throws Exception;

    List<Withdrawal> getUsersWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();
}
