package com.ecommerce.service;

import com.ecommerce.model.Order;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order createOrder(Order order) {
        return null; // implementation
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(String id) {
        return null;
    }

    @Override
    public List<Order> getOrdersByDateRange(String startDate, String endDate) {
        return null;
    }

    @Override
    public List<Order> getOrdersByCustomer(String customerDetails) {
        return null;
    }
}
