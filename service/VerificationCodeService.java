package com.earth.Trading.service;

import com.earth.Trading.domain.VerificationType;
import com.earth.Trading.modal.User;
import com.earth.Trading.modal.VerificationCode;

public interface VerificationCodeService {

    VerificationCode sendVerificationCode(User user , VerificationType verificationType);

    VerificationCode getVerificationCodeById(Long id) throws Exception;

    VerificationCode getVerificationByUser(Long userId);

    void deleteVerificationCodeById(VerificationCode verificationCode);
}
