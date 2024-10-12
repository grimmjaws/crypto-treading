package com.earth.Trading.repository;

import com.earth.Trading.modal.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WithdrawalRepository extends JpaRepository<Withdrawal,Long> {

    List<Withdrawal> findByUserId(Long userId);
}
