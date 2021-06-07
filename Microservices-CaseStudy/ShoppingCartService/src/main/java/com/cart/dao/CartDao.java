package com.cart.dao;

import java.util.List;

import com.cart.models.Cart;

public interface CartDao {

	public List<Cart> getAll();
	public boolean addToCart(Cart item);
	public boolean delete(int id);
	public boolean deleteAll();
	
}
