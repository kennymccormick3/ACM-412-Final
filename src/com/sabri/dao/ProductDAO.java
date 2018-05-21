package com.sabri.dao;

import java.util.List;

import com.sabri.entity.Product;

public interface ProductDAO {
	public List<Product> getProducts();

	public Product getProduct(int theId);

	public void saveQuantity(Product theProduct);
}
