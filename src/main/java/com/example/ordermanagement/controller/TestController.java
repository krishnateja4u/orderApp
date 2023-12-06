package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.OrderDto;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

@Autowired
private OrderService orderService;
    @GetMapping("/fetchorders")
    public ResponseEntity fetchOrders(){


       List<OrderDto> orderDtoList= orderService.fetchOrderList();
       // List<OrderDto> orderDtoList= new ArrayList<>();
       if(orderDtoList.size()>0){
           return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
       }else {

           return new ResponseEntity<>("No data",HttpStatus.NOT_FOUND);
       }
    }
 @PostMapping("/placeorder")
    public ResponseEntity  placeOrder(@RequestBody OrderDto orderDto){

System.out.println(orderDto.getOrderDetails());

        orderService.placeOrder(orderDto);

        return new ResponseEntity<>("Order Placed Successfully",HttpStatus.CREATED);
    }





}
