package com.example.ordermanagement.service;

import com.example.ordermanagement.dto.OrderDto;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public List<OrderDto> fetchOrderList(){
       List<Order> orderList= orderRepository.findAll();
       List<OrderDto> orderDtoList= orderList.stream().
               map(order ->order.convertOrderToDto(order)).collect(Collectors.toList());

       return orderDtoList;

    }

    public void placeOrder(OrderDto orderDto) {
        System.out.println(orderDto.getOrderDetails()+"  "+ orderDto.getOrderStatus());
 Order order=new Order();
 Order orderDetails=order.convertOrderDtoToOrder(orderDto);
 orderRepository.save(orderDetails);

    }
}
