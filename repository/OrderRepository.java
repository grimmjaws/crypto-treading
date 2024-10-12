package com.earth.Trading.repository;

import com.earth.Trading.modal.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

  List<Order> findByUserId(Long userId);

}
