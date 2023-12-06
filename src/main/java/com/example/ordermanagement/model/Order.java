package com.example.ordermanagement.model;


import com.example.ordermanagement.dto.OrderDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="ORDER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ORDER_ID")
    private Long OrderId;
    @Column(name="ORDER_STATUS")
    private String OrderStatus;
    @Column(name="ORDER_DETAILS")
    private String OrderDetails;


    public OrderDto convertOrderToDto(Order order){
        return OrderDto.builder().orderId(order.getOrderId()).
                orderStatus(order.getOrderStatus()).orderDetails(order.getOrderDetails()).build();
    }

    public Order convertOrderDtoToOrder(OrderDto orderDto){
        return Order.builder().OrderId(orderDto.getOrderId()).
                OrderStatus(orderDto.getOrderStatus()).OrderDetails(orderDto.getOrderDetails()).build();
    }


}
