package com.earth.Trading.repository;

import com.earth.Trading.modal.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset,Long> {

    List<Asset> findByUserId(Long userid);

    Asset findByUserIdAndCoinId(Long userId , String coinId);
}
