package com.earth.Trading.repository;

import com.earth.Trading.modal.PaymentDetails;
import com.earth.Trading.service.PaymentDetailsService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Long> {

    PaymentDetails findByUserId(Long userId);
}
