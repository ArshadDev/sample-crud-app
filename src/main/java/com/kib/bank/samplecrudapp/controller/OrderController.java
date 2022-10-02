package com.kib.bank.samplecrudapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kib.bank.samplecrudapp.model.OrderDetails;
import com.kib.bank.samplecrudapp.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.GET, value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OrderDetails>> getAllOrders() {
		return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDetails> getOrderById(@PathVariable("id") long id) {
		return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createOrder(@RequestBody OrderDetails order) {
		OrderDetails createdOrder = orderService.createOrder(order);
		if (createdOrder != null) {
			return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to create Order", HttpStatus.CREATED);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/orders", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateOrder(@RequestBody OrderDetails order) {
		OrderDetails updatedOrder = orderService.updateOrder(order);

		if (updatedOrder != null) {
			return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update Order", HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> deleteOrder(@PathVariable("id") long id) {
		OrderDetails deleteOrder = orderService.deleteOrderById(id);
		if (deleteOrder != null) {
			return new ResponseEntity<>(deleteOrder, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to delete Order", HttpStatus.OK);
		}
	}
}
