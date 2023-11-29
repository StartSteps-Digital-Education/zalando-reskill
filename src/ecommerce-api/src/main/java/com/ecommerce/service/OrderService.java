package com.ecommerce.service;

import com.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(String id);
    List<Order> getOrdersByDateRange(String startDate, String endDate);
    List<Order> getOrdersByCustomer(String customerDetails);
}
