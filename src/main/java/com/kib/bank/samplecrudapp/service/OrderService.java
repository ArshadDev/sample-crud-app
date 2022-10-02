package com.kib.bank.samplecrudapp.service;

import java.util.List;

import com.kib.bank.samplecrudapp.model.OrderDetails;

public interface OrderService {

	OrderDetails getOrderById(long id);

	List<OrderDetails> getAllOrders();

	OrderDetails createOrder(OrderDetails order);

	OrderDetails updateOrder(OrderDetails order);

	OrderDetails deleteOrderById(long id);

}
