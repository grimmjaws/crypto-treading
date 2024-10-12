package com.earth.Trading.service;

import com.earth.Trading.domain.VerificationType;
import com.earth.Trading.modal.User;
import com.earth.Trading.modal.VerificationCode;
import com.earth.Trading.repository.VerificationCodeRepository;
import com.earth.Trading.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class verificationCodeServiceImpl implements VerificationCodeService {

    @Autowired
    private VerificationCodeRepository verificationCodeRepository;

    @Override
    public VerificationCode sendVerificationCode(User user , VerificationType verificationType) {
        VerificationCode verificationCode1 = new VerificationCode();
        verificationCode1.setOtp(OtpUtils.generateOTP());
        verificationCode1.setVerificationType(verificationType);
        verificationCode1.setUser(user);

        return verificationCodeRepository.save(verificationCode1);
    }

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {
        Optional<VerificationCode> verificationCode =
                verificationCodeRepository.findById(id);
        if(verificationCode.isPresent()){
            return verificationCode.get();
        }
        throw new Exception("verification code not found");
    }

    @Override
    public VerificationCode getVerificationByUser(Long userId) {
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {

        verificationCodeRepository.delete(verificationCode);
    }
}
