package com.example.ordermanagement;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class OrderManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(OrderManagementApplication.class, args);
		System.out.println("fsdfsdfsdf");
	}

	@Autowired
	private OrderRepository orderRepository;
	public List<Order> prepareList(){
		System.out.println("this is prepareList");
		List<Order> orderList=Stream.of(
				new Order(101L,"OrderPlaced","Mobile"),
				new Order(102L,"Cancelled","Refrigerator"),
				new Order(103L,"OrderPlaced","Television")
				).collect(Collectors.toList());

		return orderList;
	}
	@PostConstruct
	public void saveAll(){

	prepareList().forEach(order -> orderRepository.save(order));


	}

}
