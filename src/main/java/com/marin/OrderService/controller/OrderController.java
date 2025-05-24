package com.marin.OrderService.controller;

import com.marin.OrderService.entities.Order;
import com.marin.OrderService.service.OrderService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        Order savedOrder = orderService.saveOrder(order);

        return ResponseEntity.ok(savedOrder);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<Order> cancelOrder(@PathParam("id") int id){
        Order cancelledOrder = orderService.cancelOrder(id);

        return ResponseEntity.ok(cancelledOrder);
    }

    @PostMapping("/process/{id}")
    public ResponseEntity<Order> processOrder(@PathParam("id") int id){
        Order processedOrder = orderService.processOrder(id);

        return ResponseEntity.ok(processedOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> fetchAllOrders(){
        List<Order> orders = orderService.getOrders();

        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> fetchOrderById(@PathParam("id") int id){
        Order order = orderService.getOrderById(id);

        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Order>> fetchOrdersByUserId(@PathParam("id") int id){
        List<Order> userOrders = orderService.getOrdersByUserId(id);

        return ResponseEntity.ok(userOrders);
    }
}
