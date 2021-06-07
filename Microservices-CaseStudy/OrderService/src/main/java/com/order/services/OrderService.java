package com.order.services;

import org.springframework.stereotype.Service;

import com.order.dao.OrderItemDao;
import com.order.dao.OrdersDao;
import com.order.models.Order;
import com.order.models.OrderItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderService {
	
	@Autowired
	private OrdersDao dao;
	
	@Autowired
	private OrderItemDao otdao;
	
	public List<Order> getAll(){
		return dao.getAll();
	}
	
	public boolean add(Order order) {
		return dao.add(order);
	}
	
	public boolean addOrderItems(Order order) {
		List<Order> list=dao.getAll();
		int n=list.size()-1;
		int id=list.get(n).getOrderId();
		List<OrderItem> items=order.getOrderItems();
		for(OrderItem o:items) {
			o.setOrderId(id);
			if(!otdao.addItem(o)) {return false;}
		}
		return true;
		}
}
