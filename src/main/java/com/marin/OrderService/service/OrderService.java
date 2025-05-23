package com.marin.OrderService.service;

import com.marin.OrderService.entities.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);

    Order getOrderById(int id);

    List<Order> getOrders();

    List<Order> getOrdersByUserId(int id);

    Order updateOrder(Order order, int id);

    Order processOrder(int id);

    Order cancelOrder(int id);

    void deleteOrder(int id);


}
