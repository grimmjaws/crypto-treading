package com.earth.Trading.service;


import com.earth.Trading.domain.OrderType;
import com.earth.Trading.modal.Coin;
import com.earth.Trading.modal.Order;
import com.earth.Trading.modal.OrderItem;
import com.earth.Trading.modal.User;

import java.util.List;

public interface OrderService {


    Order createOrder(User user, OrderItem orderItem,OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;

    List<Order> getAllOrderOfUser(Long userId,OrderType orderType,String assetSymbol);

    Order processOrder(Coin coin , double quantity , OrderType orderType,User user) throws Exception;

}
