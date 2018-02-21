package com.niit.DevOpsShoppingBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Cart {

	@Id
	private String cartId;
	private double grandtotal=0.0;
	private int totalitem=0;
	
	@OneToMany(mappedBy="cart")
	private List<CartItems> cartItems;
//	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="userId")
//	private User user;
	
	public Cart()
	{
		this.cartId="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public double getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}
	public int getTotalitem() {
		return totalitem;
	}
	public void setTotalitem(int totalitem) {
		this.totalitem = totalitem;
	}
	public List<CartItems> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
}
