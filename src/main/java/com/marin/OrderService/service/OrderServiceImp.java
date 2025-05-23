package com.marin.OrderService.service;

import com.marin.OrderService.entities.Order;
import com.marin.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImp(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUserId(int id){
        return orderRepository.getOrdersByUserId(id);
    }

    @Override
    public Order updateOrder(Order order, int id) {
        return null;
    }

    @Override
    public Order processOrder(int id) {
        Order orderDB = orderRepository.findById(id).orElseThrow();

        switch(orderDB.getStatus()){
            case "Ordered":
                orderDB.setStatus("Processing");
                break;
            case "Processing":
                orderDB.setStatus("Shipped");
                break;
            case "Shipped":
                orderDB.setStatus("Delivered");
                break;
        }

        return orderRepository.save(orderDB);
    }

    @Override
    public Order cancelOrder(int id) {
        Order orderDB = orderRepository.findById(id).orElseThrow();

        orderDB.setStatus("Cancelled");

        return orderRepository.save(orderDB);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
