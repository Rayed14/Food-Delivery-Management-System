package BusinessLogic;
import java.util.ArrayList;

import DB.*;

public class Restaurant extends User{
	
	private String address;
	private double rating;
	private int restId;
	private String authorize;
	private Menu menuObj = new Menu();
	private ArrayList<Order> orderList = new ArrayList<>();
	private ArrayList<RestaurantFeedback> restFeedbackList = new ArrayList<>();
	
	//constructors
	
	public Restaurant() {
		super();
		this.address = null;
		this.rating = 0.0;
		this.restId = 0;
		this.authorize = null;
		this.menuObj = null;
		this.orderList = new ArrayList<>();
		this.restFeedbackList = new ArrayList<>();
	}
	
	public Restaurant(String name, String phNumber, String email, Account userAccount, 
			String address, double rating, int restId, String authorize, Menu menuObj) {
		super(name, phNumber, email, userAccount);
		this.address = address;
		this.rating = rating;
		this.restId = restId;
		this.authorize = authorize;
		this.menuObj = menuObj;
		this.orderList = new ArrayList<>();
		this.restFeedbackList = new ArrayList<>();
	}
	
	//setters and getters

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getAuthorize() {
		return authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

	public Menu getMenuObj() {
		return menuObj;
	}

	public void setMenuObj(Menu menuObj) {
		this.menuObj = menuObj;
	}

	public ArrayList<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}

	public ArrayList<RestaurantFeedback> getRestFeedbackList() {
		return restFeedbackList;
	}

	public void setRestFeedbackList(ArrayList<RestaurantFeedback> restFeedbackList) {
		this.restFeedbackList = restFeedbackList;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + this.getName() + ", phNumber=" + this.getPhNumber() + ", email=" + this.getEmail() + ", address=" + address + ", restId=" + restId + ", authorize=" + authorize + "]";
	}
	
	
	
	
	public void addFoodItem(String name, double price, String details)
	{
		this.menuObj.addInMenu(name, price, details);
	}
	
	public void modifyItem(FoodItem itemObj, String newName, double newPrice, String newIngredients)
	{
		//changing in the array list of the restraunt menu
		for (FoodItem obj : this.getMenuObj().getFoodList())
		{
			if (obj.getItemId() == itemObj.getItemId())
			{
				obj.setFoodName(newName);
				obj.setPrice(newPrice);
				obj.setDetails(newIngredients);
			}
		}
		
		//chenging in the DB
		DBHandler DBObj = new DBHandler();
		String query = "Update FoodItems set foodName = '" + newName + "' , description = '" + newIngredients + "' , price = '" + newPrice + "' Where itemID = '" + itemObj.getItemId() + "'";
		DBObj.queuryFoodItem(query);
		
	}
	
	public void deleteItem(FoodItem itemObj)
	{
		//changing in the array list of the restraunt menu
		int count = 0;
		for (FoodItem obj : this.getMenuObj().getFoodList())
		{
			if (obj.getItemId() == itemObj.getItemId())
			{
				this.getMenuObj().getFoodList().remove(count);
				break;
			}
			count++;
		}
		
		//chenging in the DB
		DBHandler DBObj = new DBHandler();
		String query = "Delete from FoodItems Where itemID = '" + itemObj.getItemId() + "'";
		DBObj.queuryFoodItem(query);

	}
	
	public void changeOrderStatusToPrepared(Order orderObj)
	{
		//changing in the array list of the restraunt Order list
		for (Order obj : this.getOrderList())
		{
			if (obj.getOrderId() == orderObj.getOrderId())
			{
				obj.setOrderStatus("prepared");
				break;
			}

		}
		
		//chenging in the DB
		DBHandler DBObj = new DBHandler();
		String query = "Update Orders set orderStatus = '" + "prepared" + "' Where orderID = '" + orderObj.getOrderId() + "'";
		DBObj.queuryOrder(query);
	}
	
	public void changeOrderStatusToDelivering(Order orderObj, Rider riderObj)
	{
		//changing in the array list of the restraunt Order list
		for (Order obj : this.getOrderList())
		{
			if (obj.getOrderId() == orderObj.getOrderId())
			{
				obj.setOrderStatus("delivered");
				break;
			}

		}
		
		//chenging in the DB
		DBHandler DBObj = new DBHandler();
		String query = "Update Orders set orderStatus = '" + "delivering" + "' , riderID = '" + riderObj.getRiderId() + "' Where orderID = '" + orderObj.getOrderId() + "'";
		DBObj.queuryOrder(query);
	}
	
	
	public void changeOrderStatusToCompleted(Order orderObj)
	{
		//changing in the array list of the restraunt Order list
		for (Order obj : this.getOrderList())
		{
			if (obj.getOrderId() == orderObj.getOrderId())
			{
				obj.setOrderStatus("completed");
				break;
			}

		}
		
		//chenging in the DB
		DBHandler DBObj = new DBHandler();
		String query = "Update Orders set orderStatus = '" + "completed" + "' Where orderID = '" + orderObj.getOrderId() + "'";
		DBObj.queuryOrder(query);
	}
	
	public void setOrder(int nextOrderId, int custId)
	{
		Order ord = new Order(nextOrderId, "27-11-22", "new", custId, restId, 0);
		this.orderList.add(ord);
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
		
		//chenging in the DB
		DBHandler DBObj = new DBHandler();
		String query = "Update Orders set orderStatus = '" + "canceled" + "' Where orderID = '" + orderObj.getOrderId() + "'";
		DBObj.queuryOrder(query);
	}

}
