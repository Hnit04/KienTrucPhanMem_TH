package iuh.fit.orderservice.dto.request;

import iuh.fit.orderservice.model.OrderDetail;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CreateOrderRequest {
    private String userId;
    private String promotionId;
    private double totalAmount;
    private String status;
    private String deliveryAddress;
    private String deliveryStatus;
    private LocalDate deliveryDate;
    private List<OrderDetail> orderDetails; // Thêm trường orderDetails
}