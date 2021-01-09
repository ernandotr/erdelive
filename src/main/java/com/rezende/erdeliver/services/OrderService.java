package com.rezende.erdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rezende.erdeliver.dto.OrderDTO;
import com.rezende.erdeliver.entities.Order;
import com.rezende.erdeliver.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
	}
}
