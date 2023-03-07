package BusinessLogic;

public class FoodItem {
	
	private int itemId;
	private String foodName;
	private String details;
	private double price;
	private int menuId;
	private int cartId;
	
	public FoodItem() {
		super();
		this.itemId = 0;
		this.foodName = null;
		this.details = null;
		this.price = 0.0;
		this.menuId = 0;
		this.cartId = 0;
	}
	
	
	public FoodItem(int itemId, String foodName, String details, double price, int menuId, int cartId) {
		super();
		this.itemId = itemId;
		this.foodName = foodName;
		this.details = details;
		this.price = price;
		this.menuId = menuId;
		this.cartId = cartId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public String getFoodName() {
		return foodName;
	}


	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	
	

}
