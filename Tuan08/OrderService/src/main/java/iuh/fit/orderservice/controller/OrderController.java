package iuh.fit.orderservice.controller;

import iuh.fit.orderservice.dto.request.CreateOrderRequest;
import iuh.fit.orderservice.dto.request.UpdateDeliveryStatus;
import iuh.fit.orderservice.dto.response.OrderResponse;
import iuh.fit.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody CreateOrderRequest request) {
        OrderResponse orderResponse = orderService.createOrder(request);
        return ResponseEntity.status(201).body(orderResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        OrderResponse order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable String id, @RequestBody CreateOrderRequest request) {
        OrderResponse order = orderService.updateOrder(id, request);
        return ResponseEntity.ok(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/delivery-status")
    public ResponseEntity<OrderResponse> updateDeliveryStatus(
            @PathVariable String id,
            @RequestBody UpdateDeliveryStatus request) {
        OrderResponse orderResponse = orderService.updateDeliveryStatus(id, request);
        return ResponseEntity.ok(orderResponse);
    }
}
