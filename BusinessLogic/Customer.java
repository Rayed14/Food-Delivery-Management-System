package BusinessLogic;

import java.util.ArrayList;
import DB.*;

public class Customer extends User{
	
	private String address;
	private int custId;
	private ArrayList<Order> orderList;
	private ArrayList<Bill> billList;
	private ArrayList<Feedback> feedbackList;
	private Cart custCart;
	
	//constructors
	public Customer() {
		super();
		this.address = null;
		this.custId = 0;
		this.orderList = new ArrayList<>();
		this.billList = new ArrayList<>();
		this.feedbackList = new ArrayList<>();
		this.custCart = new Cart();
	}
	
	
	public Customer(String name, String phNumber, String email, Account userAccount, String address, int custId,
			 Cart custCart) {
		super(name, phNumber, email, userAccount);
		this.address = address;
		this.custId = custId;
		this.orderList = new ArrayList<>();
		this.billList = new ArrayList<>();
		this.feedbackList = new ArrayList<>();
		this.custCart = custCart;
	}

	
	//setters and getters
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	public ArrayList<Bill> getBillList() {
		return billList;
	}

	public void setBillList(ArrayList<Bill> billList) {
		this.billList = billList;
	}

	public ArrayList<Feedback> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(ArrayList<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public Cart getCustCart() {
		return custCart;
	}

	public void setCustCart(Cart custCart) {
		this.custCart = custCart;
	}
	
	
	
	public void addToCart(FoodItem itemObj)
	{
		this.custCart.getItemsInCart().add(itemObj);
		
		int totalItems = 0;
		double totalPrice = 0.0;
		
		totalItems = this.custCart.getItemsInCart().size();
		for (FoodItem obj : this.custCart.getItemsInCart())
		{
			totalPrice = totalPrice + obj.getPrice();
		}
		
		this.custCart.setTotalItems(totalItems);
		this.custCart.setTotalPrice(totalPrice);
		
		
		DBHandler dbObj = new DBHandler();
		ArrayList<Cart> allCarts = dbObj.getCarts();
		ArrayList<FoodItem> allFood = dbObj.getFoodItems();
		
		String query = "Update FoodItems set cartID = '" + this.custCart.getCartId() + "' Where itemID = '" + itemObj.getItemId() + "'";
		dbObj.queuryFoodItem(query);
		
		query = "Update Cart set totalItems = '" + this.custCart.getTotalItems() + "' , totalPrice = '" + this.custCart.getTotalPrice() +"' Where cartID = '" + this.custCart.getCartId() + "'";
		dbObj.queuryCart(query);
		
		
	}
	
	public void setOrder(int nextOrderId, int restId)
	{
		Order ord = new Order(nextOrderId, "27-11-22", "new", custId, restId, 0);
		this.orderList.add(ord);
	}
	
	public void emptyCart()
	{
		DBHandler dbObj = new DBHandler();
		String query = "Update FoodItems set cartID = NULL Where cartID = '" + this.custCart.getCartId() + "'";
		dbObj.queuryFoodItem(query);
		this.custCart.getItemsInCart().clear();
	}
	
	public void changeOrderStatusToCanceled(Order orderObj)
	{
		//changing in the array list of the restraunt Order list
		for (Order obj : this.getOrderList())
		{
			if (obj.getOrderId() == orderObj.getOrderId())
			{
				obj.setOrderStatus("canceled");
				break;
			}

		}
	}

}
