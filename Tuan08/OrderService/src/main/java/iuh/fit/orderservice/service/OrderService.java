package iuh.fit.orderservice.service;

import iuh.fit.orderservice.dto.request.CreateOrderRequest;
import iuh.fit.orderservice.dto.request.UpdateDeliveryStatus;
import iuh.fit.orderservice.dto.response.OrderResponse;
import iuh.fit.orderservice.mapper.OrderMapper;
import iuh.fit.orderservice.model.Order;
import iuh.fit.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public OrderResponse createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setPromotionId(request.getPromotionId());
        order.setCreatedDate(LocalDate.now());
        order.setTotalAmount(request.getTotalAmount());
        order.setStatus("PENDING");
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setDeliveryStatus(request.getDeliveryStatus());
        order.setDeliveryDate(request.getDeliveryDate());
        order.setOrderDetails(request.getOrderDetails());

        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(savedOrder);
    }

    public OrderResponse getOrderById(String orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        return orderMapper.toOrderResponse(order);
    }

    public OrderResponse updateOrder(String orderId, CreateOrderRequest request) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        order.setUserId(request.getUserId());
        order.setPromotionId(request.getPromotionId());
        order.setTotalAmount(request.getTotalAmount());
        order.setStatus(request.getStatus());
        order.setDeliveryAddress(request.getDeliveryAddress());
        order.setDeliveryStatus(request.getDeliveryStatus());
        order.setDeliveryDate(request.getDeliveryDate());
        order.setOrderDetails(request.getOrderDetails());

        Order updatedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(updatedOrder);
    }

    public void deleteOrder(String orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found with id: " + orderId);
        }
        orderRepository.deleteById(orderId);
    }

    public OrderResponse updateDeliveryStatus(String orderId, UpdateDeliveryStatus request) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        order.setDeliveryStatus(request.getDeliveryStatus());
        order.setDeliveryDate(request.getDeliveryDate());

        Order updatedOrder = orderRepository.save(order);
        return orderMapper.toOrderResponse(updatedOrder);
    }
}