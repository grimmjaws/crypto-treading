package com.earth.Trading.repository;

import com.earth.Trading.modal.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<WatchList,Long> {

    WatchList findByUserId(Long userId);
}
