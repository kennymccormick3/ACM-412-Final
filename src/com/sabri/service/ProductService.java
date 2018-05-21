package com.sabri.service;

import java.util.List;

import com.sabri.entity.Cart;
import com.sabri.entity.Product;

public interface ProductService {
	public List<Product> getProducts();

	public Product getProduct(int theId);

	public void saveProductQuantity(Product theProduct);
	
	public void saveCartQuantity(Cart theCart);
	
	public List<Cart> getCart();

	public boolean exist(int theId);

	public Cart getOneCart(int theId);

	public void dropFromCart(int theId);

	public void deleteCart();
		
	
}
