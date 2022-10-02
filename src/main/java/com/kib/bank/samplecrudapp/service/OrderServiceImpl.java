package com.kib.bank.samplecrudapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kib.bank.samplecrudapp.model.OrderDetails;
import com.kib.bank.samplecrudapp.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDetails getOrderById(long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public List<OrderDetails> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public OrderDetails createOrder(OrderDetails order) {
		try {
			return orderRepository.save(order);
		} catch (Exception e) {
			LOGGER.error("Exception occured while creating Order", e);
			return null;
		}
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDetails existingOrder = orderRepository.findById(order.getOrderId()).orElse(null);

		try {
			if (existingOrder != null) {
				existingOrder.setArea(order.getArea());
				existingOrder.setProductName(order.getProductName());
				existingOrder.setBrandName(order.getBrandName());
				existingOrder.setQuantity(order.getQuantity());
				return orderRepository.save(existingOrder);
			} else {
				LOGGER.error("No Order found to update with id " + order.getOrderId());
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while updating Order", e);
			return null;
		}
	}

	@Override
	public OrderDetails deleteOrderById(long id) {
		try {
			OrderDetails existingOrder = orderRepository.findById(id).orElse(null);
			if (existingOrder != null) {
				orderRepository.deleteById(id);
				return existingOrder;
			} else {
				LOGGER.error("No Order found to delete with id " + id);
				return null;
			}
		} catch (Exception e) {
			LOGGER.error("Exception occured while Deleting Order with Id " + id, e);
			return null;
		}
	}
}
