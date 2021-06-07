package com.cart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.Exceptions.NoRecordsException;
import com.cart.dao.CartDao;
import com.cart.models.Cart;

@Service
public class CartService {

	@Autowired
	private CartDao dao;
	
	public List<Cart> getAll()
	{
		List<Cart> list=dao.getAll();
		if(list.isEmpty()) {
			throw new NoRecordsException("No records found");
		}
		else {
			return list;
		}
	}
	
	public boolean addToCart(Cart item) {
		return dao.addToCart(item);

	}
	
	public boolean delete(int id)
	{
		if(dao.delete(id)) {
			return true;
			}
		else {
			throw new NoRecordsException("No record to delete");
		}
	}
	public boolean deleteAll() {
		if(dao.deleteAll()) {
			return true;
			}
		else {
			throw new NoRecordsException("No record to delete");
		}
	}
}
