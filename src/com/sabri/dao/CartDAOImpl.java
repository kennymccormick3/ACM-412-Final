package com.sabri.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sabri.entity.Cart;
import com.sabri.entity.Product;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cart> getCart() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Cart> theQuery = currentSession.createQuery("from Cart", Cart.class);
		List<Cart> cart = theQuery.getResultList();
		return cart;
	}

	@Override
	public void saveQuantity(Cart theCart) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCart);		
	}

	@Override
	public boolean exist(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("select 1 from Cart c where c.id=:theId");
		theQuery.setParameter("theId", theId);
		return (theQuery.uniqueResult() != null);
	}

	@Override
	public Cart getOneCart(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Cart theCart = currentSession.get(Cart.class,theId); 
		return theCart;
	}

	@Override
	public void dropFromCart(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Cart where id=:productId");
		theQuery.setParameter("productId", theId);
		theQuery.executeUpdate();
	}

	@Override
	public void deleteCart() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Cart");
		theQuery.executeUpdate();
	}

	

}
