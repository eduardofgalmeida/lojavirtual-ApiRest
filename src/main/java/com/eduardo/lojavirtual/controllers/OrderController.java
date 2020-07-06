package com.eduardo.lojavirtual.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.lojavirtual.models.Order;
import com.eduardo.lojavirtual.repository.OrderRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/order")
@Api(value = "API REST Order")
public class OrderController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	OrderRepository orderRepository;
	
	@ResponseBody
	@GetMapping("/all")
	@ApiOperation(value = "Returns all orders")
	public List<Order> orderAll() throws Exception {

		List<Order> ltResult = null;
		try {
			ltResult = orderRepository.findAll();
		} catch (Exception e) {
			log.error("orderAll: {}", e.toString());
		}
		return ltResult;
	}
	
	@ResponseBody
	@GetMapping("/findcod/cod/{cod}")
	@ApiOperation(value = "Returning order by code")
	public List<Order> orderFindCod(@PathVariable("cod") BigDecimal cod) throws Exception {

		log.info("Returning order by code");
		List<Order> ltResult = null;
		try {
			ltResult = orderRepository.findByCod(cod);
		} catch (Exception e) {
			log.error("productCod: {}", e.toString());
		}
		return ltResult;
	}
	
	@ApiOperation(value = "Register Order")
	@PostMapping("/register")
	//@PreAuthorize("hasrole('ADMIN')")
	public Order registerOrder(@RequestBody Order order) {

		Order result = new Order();
		log.info("Registering the order");
		try {
			result = orderRepository.save(order);
		} catch (Exception e) {
			log.error("registerOrder: {}", e.toString());
		}
		return result;
	}
	
	@ApiOperation(value = "Delete orders")
	@DeleteMapping("delete/id/{id}")
//	@PreAuthorize("hasrole('ADMIN')")
	public void deleteOrder(@RequestBody Order order, Long id) {

		log.info("Deleting order");
		try {
			orderRepository.deleteById(id);
		} catch (Exception e) {
			log.error("deleteOrder: {}", e.toString());
		}
	}
	
	@ApiOperation(value = "Updates Product")
	@PutMapping("/update")
	//@PreAuthorize("hasrole('ADMIN')")
	public Order updatesOrder(@RequestBody Order order) {
		Order result = new Order();

		log.info("Updating order");
		try {
			result = orderRepository.save(order);
		} catch (Exception e) {
			log.error("updatesProduct: {}", e.toString());
		}
		return result;
	}
	
}
