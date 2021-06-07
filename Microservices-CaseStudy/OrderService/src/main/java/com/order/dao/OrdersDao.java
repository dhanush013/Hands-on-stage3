package com.order.dao;

import java.util.List;

import com.order.models.Order;

public interface OrdersDao {

	public boolean add(Order order);
	public List<Order> getAll();
	
}
