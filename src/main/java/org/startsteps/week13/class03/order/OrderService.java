package org.startsteps.week13.class03.order;

import org.startsteps.week13.class03.product.Product;
import org.startsteps.week13.class03.product.ProductService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class OrderService {

    private static final Map<Integer, Order> orders = new ConcurrentHashMap<>();
    private static final AtomicInteger orderIdCounter = new AtomicInteger();
    private static final ProductService productService = new ProductService();

    public static Order placeOrder(Order order) {
        // Validate product availability
        Product orderedProduct = productService.getProduct(order.getProductId());
        if (orderedProduct == null || orderedProduct.getStockQuantity() < order.getQuantity()) {
            throw new IllegalStateException("Product not available in sufficient quantity");
        }

        // Update product stock quantity
        orderedProduct.setStockQuantity(orderedProduct.getStockQuantity() - order.getQuantity());
        productService.updateProduct(orderedProduct.getId(), orderedProduct);

        // Create the order
        int orderId = orderIdCounter.incrementAndGet();
        order.setId(orderId);
        orders.put(orderId, order);
        return order;
    }

    public static Order getOrder(int id) {
        return orders.get(id);
    }

    public static List<Order> getOrders(int page, int size) {
        return orders.values().stream()
                .skip((long) (page - 1) * size)
                .limit(size)
                .collect(Collectors.toList());
    }
}

