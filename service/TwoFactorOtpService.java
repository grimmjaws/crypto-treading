package com.earth.Trading.service;

import com.earth.Trading.modal.TwoFactorOTP;
import com.earth.Trading.modal.User;

public interface TwoFactorOtpService {

    TwoFactorOTP createTwoFactorOtp(User user, String otp , String jwt);

    TwoFactorOTP findByUser(Long userId);

    TwoFactorOTP findById(String id);

    boolean verifyTwoFactorOtp(TwoFactorOTP twoFactorOTP,String otp);

    void deleteTwoFactorOtp(TwoFactorOTP twoFactorOTP);
}
