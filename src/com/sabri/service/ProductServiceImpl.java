package com.sabri.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sabri.dao.CartDAO;
import com.sabri.dao.ProductDAO;
import com.sabri.entity.Cart;
import com.sabri.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartDAO cartDAO;

	@Override
	@Transactional
	public List<Product> getProducts() {
		
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		return productDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public void saveProductQuantity(Product theProduct) {
		productDAO.saveQuantity(theProduct);
	}

	@Override
	@Transactional
	public List<Cart> getCart() {
		return cartDAO.getCart();
	}
	
	@Override
	@Transactional
	public void saveCartQuantity(Cart theCart) {
		cartDAO.saveQuantity(theCart);
	}

	@Override
	@Transactional
	public boolean exist(int theId) {
		return cartDAO.exist(theId);
	}

	@Override
	@Transactional
	public Cart getOneCart(int theId) {
		return cartDAO.getOneCart(theId);
	}

	@Override
	@Transactional
	public void dropFromCart(int theId) {
		cartDAO.dropFromCart(theId);
	}

	@Override
	@Transactional
	public void deleteCart() {
		cartDAO.deleteCart();
	}

}
