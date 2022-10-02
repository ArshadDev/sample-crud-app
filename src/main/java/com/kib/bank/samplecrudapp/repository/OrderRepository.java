package com.kib.bank.samplecrudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kib.bank.samplecrudapp.model.OrderDetails;

public interface OrderRepository extends JpaRepository<OrderDetails, Long> {

}
