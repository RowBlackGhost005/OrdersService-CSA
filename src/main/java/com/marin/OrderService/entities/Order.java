package com.marin.OrderService.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "order_date")
    private Timestamp orderDate;

    private String status;

    private float total;

    @OneToMany(mappedBy = "id" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;

    public Order() {
    }

    public Order(int id, int userId, Timestamp orderDate, String status, float total, List<OrderDetails> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.status = status;
        this.total = total;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
