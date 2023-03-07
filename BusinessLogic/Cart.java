package BusinessLogic;

import java.util.ArrayList;

public class Cart {
	
	private int totalItems;
	private double totalPrice;
	private int cartId;
	private ArrayList<FoodItem> itemsInCart;
	
	public Cart() {
		super();
		this.totalItems = 0;
		this.totalPrice = 0.0;
		this.cartId = 0;
		this.itemsInCart = new ArrayList<>();
	}
	
	public Cart(int cartId) {
		super();
		this.totalItems = 0;
		this.totalPrice = 0.0;
		this.cartId = cartId;
		this.itemsInCart = new ArrayList<>();
	}
	
	public Cart(int totalItems, double totalPrice, int cartId, ArrayList<FoodItem> itemsInCart) {
		super();
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
		this.cartId = cartId;
		this.itemsInCart = new ArrayList<>();
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public ArrayList<FoodItem> getItemsInCart() {
		return itemsInCart;
	}

	public void setItemsInCart(ArrayList<FoodItem> itemsInCart) {
		this.itemsInCart = itemsInCart;
	}
	
	

}
