package com.earth.Trading.repository;

import com.earth.Trading.modal.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

    Wallet findByUserId(Long userId);
}
