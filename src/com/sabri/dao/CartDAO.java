package com.sabri.dao;

import java.util.List;

import com.sabri.entity.Cart;

public interface CartDAO {
	public List<Cart> getCart();
	
	public void saveQuantity(Cart theCart);

	public boolean exist(int theId);

	public Cart getOneCart(int theId);

	public void dropFromCart(int theId);

	public void deleteCart();

}
