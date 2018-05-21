package com.sabri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sabri.entity.Cart;
import com.sabri.entity.Product;
import com.sabri.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping("/")
	public String listProducts(Model theModel) {
		
		List<Product> theProduct = productService.getProducts();
		theModel.addAttribute("products", theProduct);
		List<Cart> theCart = productService.getCart();
		int cartSum = theCart.size();
		theModel.addAttribute("product", cartSum);
		return "index";
	}
	
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam("productID") int theId, Model theModel) {
		Product theProduct = productService.getProduct(theId);		
		int productQuantity = theProduct.getQuantity();
		
		
		
		
		//Check and Decrease Quantity
		if (productQuantity > 0) {
			productQuantity -= 1;
			theProduct.setQuantity(productQuantity);
			
			//Check if it is already exist in cart
			if (productService.exist(theId)) {
				Cart theCart = productService.getOneCart(theId);
				int cartQuantity = theCart.getQuantity();
				cartQuantity += 1;
				theCart.setQuantity(cartQuantity);
				productService.saveCartQuantity(theCart);
			}
			
			//if not
			else {
				Cart cart = new Cart();
				cart.setId(theProduct.getId());
				cart.setPrice(theProduct.getPrice());
				cart.setQuantity(1);
				cart.setProductname(theProduct.getProductname());
				productService.saveCartQuantity(cart);
			}
			
		}
		//Update Quantity from Database
		productService.saveProductQuantity(theProduct);
		return "redirect:/";
	}
	
	@GetMapping("/showCart")
	public String showCart(Model theModel) {
		
		//Show Products from Cart
		List<Cart> theCart = productService.getCart();
		List<Product> theProduct = productService.getProducts();
		theModel.addAttribute("cart", theCart);
		
		//How many product in your cart
		int cartSum = theCart.size();
		theModel.addAttribute("product", cartSum);
		int total = 0;
		
		//Get Total 
		for(int i = 1; i <= theProduct.size(); i++) {
			if (productService.exist(i)) {
				Cart cart = productService.getOneCart(i);
				total += cart.getPrice() * cart.getQuantity();
			}
			
			else {
				continue;
			}
		}
		
		theModel.addAttribute("summary", total);
		return "cart";
	}
	
	@GetMapping("/dropFromCart")
	public String dropFromCart(@RequestParam("productID") int theId, Model theModel) {
		
		Cart theCart = productService.getOneCart(theId);
		Product theProduct = productService.getProduct(theId);
		int cartQuantity = theCart.getQuantity();
		int productQuantity = theProduct.getQuantity();
		
		if (cartQuantity > 0) {
			theProduct.setQuantity(productQuantity + cartQuantity);
			productService.saveProductQuantity(theProduct);
			productService.dropFromCart(theId);
		}
		
		
		return "redirect:/showCart";
		
	}
	
	@GetMapping("/buyAll")
	public String buyAll() {
		productService.deleteCart();
		return "redirect:/showCart";
	}
	
	
	
	
}
