package com.earth.Trading.service;

import com.earth.Trading.domain.VerificationType;
import com.earth.Trading.modal.ForgotPasswordToken;
import com.earth.Trading.modal.User;

public interface ForgotPasswordService {

    ForgotPasswordToken createToken(User user ,
                                    String id, String otp,
                                    VerificationType verificationType,
                                    String sendTo);
    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);

}
