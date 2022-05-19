package com.stacksimplify.restservices.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

import antlr.collections.List;

@RestController
@RequestMapping(value="/users/")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@GetMapping("/{userid}/orders")
	public  java.util.List<Order> getAllOrdes(@PathVariable Long userid ) throws UserNotFoundException
	{
	 Optional<User> userOptional=userRepository.findById(userid);
	 if(!userOptional.isPresent())
		 throw new UserNotFoundException("user not found");
	
	return  userOptional.get().getOrders();
}
	@PostMapping("/{userid}/orders")
	public Order createOrder(@PathVariable Long userid,@RequestBody  Order order) throws UserNotFoundException
		{
		
		 Optional<User> userOptional=userRepository.findById(userid);
		 if(!userOptional.isPresent())
			 throw new UserNotFoundException("user not found");
		 User user=userOptional.get();
		 order.setUser(user);
		 return  orderRepository.save(order);
		 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}