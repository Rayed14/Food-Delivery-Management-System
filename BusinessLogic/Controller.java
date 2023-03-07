package BusinessLogic;

import DB.*;
import java.util.ArrayList;

public class Controller {

	DBHandler dbObj = new DBHandler();
	static Admin adminObj = new Admin();
	static Restaurant restObj = new Restaurant();
	static Rider riderObj = new Rider();
	static Customer custObj = new Customer();
	
	//Logins
	public ArrayList<Admin> getAdmins()
	{
		return dbObj.getAdmins();
	}
	
	public ArrayList<Restaurant> getRestaurants()
	{	
		return dbObj.getRestaurants();
	}
	
	public void setCurrentRestaurant(Restaurant obj)
	{
		restObj = obj;
	}
	
	public ArrayList<Account> getAccounts()
	{
		return dbObj.getAccounts();
	}
	
	public ArrayList<Rider> getRiders()
	{
		return dbObj.getRiders();
	}
	
	public void setCurrentRider(Rider obj)
	{
		riderObj = obj;
	}
	
	public ArrayList<Customer> getCustomers()
	{
		return dbObj.getCustomers();
	}

	public void setCurrentCustomer(Customer obj)
	{
		custObj = obj;
	}
	
	//Registrations
	public void enterSignUpButtonRest(String name, String phNum, String email, String address, String userName, String pass, String menuName)
	{
		adminObj.detailsEntryRest(name, phNum, email, address, userName, pass, menuName);
	}
	
	public void enterSignUpButtonCust(String name, String phNum, String email, String address, String userName, String pass)
	{
		adminObj.detailsEntryCust(name, phNum, email, address, userName, pass);
	}
	
	public void enterSignUpButtonRid(String name, String phNum, String email, int liscenceNo, String userName, String pass)
	{
		adminObj.detailsEntryRid(name, phNum, email, liscenceNo, userName, pass);
	}
	
	//Authorizations
	public ArrayList<Restaurant> selectRestaurant()
	{
		adminObj.setCustomerList(getCustomers());
		adminObj.setRestaurantList(getRestaurants());
		adminObj.setRiderList(getRiders());
		return adminObj.selectRestaurant();
	}
	
	public void authorizeRestaurant(Restaurant rest)
	{
		adminObj.setCustomerList(getCustomers());
		adminObj.setRestaurantList(getRestaurants());
		adminObj.setRiderList(getRiders());
		adminObj.authorizeRestaurant(rest);
	}
	
	public ArrayList<Rider> selectRider()
	{
		adminObj.setCustomerList(getCustomers());
		adminObj.setRestaurantList(getRestaurants());
		adminObj.setRiderList(getRiders());
		return adminObj.selectRider();
	}
	
	public void authorizeRider(Rider rid)
	{
		adminObj.setCustomerList(getCustomers());
		adminObj.setRestaurantList(getRestaurants());
		adminObj.setRiderList(getRiders());
		adminObj.authorizeRider(rid);
	}
	
	
	//RestaurantFunctions
	
	//Add
	public void clickOnAddButtonRes(String name, double price, String details)
	{
		restObj.addFoodItem(name, price, details);
	}
	
	//Modify 
	public void clickOnModify(FoodItem itemObj, String newName, double newPrice, String newIngredients)
	{
		restObj.modifyItem(itemObj, newName, newPrice, newIngredients);
	}
	
	public ArrayList<FoodItem> getFoodItems()
	{
		ArrayList<FoodItem> foodList = dbObj.getFoodItems();
		ArrayList<FoodItem> listToReturn =new ArrayList<>();
		
		for (FoodItem obj : foodList)
		{
			if (obj.getMenuId() == restObj.getMenuObj().getMenuId())
				listToReturn.add(obj);
		}
		
		return listToReturn;
	}
	
	//Delete
	public void clickOnDelete(FoodItem itemObj)
	{
		restObj.deleteItem(itemObj);
	}
	
	//Process Orders
	public ArrayList<Order> getOrders()
	{
		ArrayList<Order> orderList = dbObj.getOrders();
		ArrayList<Order> listToReturn =new ArrayList<>();
		
		for (Order obj : orderList)
		{
			if (obj.getRestId() == restObj.getRestId())
				listToReturn.add(obj);
		}
		
		return listToReturn;
	}
	
	public void processOrderRestaurant(Order orderObj)
	{
		restObj.changeOrderStatusToPrepared(orderObj);
	}
	
	//RiderFunctions
	
	public ArrayList<Order> getAllOrders()
	{
		return dbObj.getOrders();
	}
	
	public void acceptOrderRider(Order orderObj)
	{
		restObj.changeOrderStatusToDelivering(orderObj, riderObj);
	}
	
	public ArrayList<Order> getRiderOrders()
	{
		ArrayList<Order> orderList = dbObj.getOrders();
		ArrayList<Order> listToReturn =new ArrayList<>();
		
		for (Order obj : orderList)
		{
			if (obj.getRiderId() == riderObj.getRiderId())
				listToReturn.add(obj);
		}
		
		return listToReturn;
	}
	
	public void competeOrderRider(Order orderObj)
	{
		restObj.changeOrderStatusToCompleted(orderObj);
		riderObj.changeOrderStatusToCompleted(orderObj);
	}
	
	
	//CustomerFunction
	public void addToCart(FoodItem itemObj)
	{
		custObj.addToCart(itemObj);
	}
	
	public ArrayList<FoodItem> getCustomerFoodList()
	{
		ArrayList<FoodItem> allFood = dbObj.getFoodItems();
		ArrayList<FoodItem> returnList = new ArrayList<FoodItem>();
		
		for (FoodItem obj : allFood)
		{
			if (obj.getCartId() == custObj.getCustCart().getCartId())
			{
				returnList.add(obj);
			}
		}
		
		
		return returnList;
	}
	
	public void setOrder()
	{
		int nextOrderId = dbObj.getLastOrder() + 1;
		Order orderObj = new Order(nextOrderId, "27-11-22", "new", custObj.getCustId(), restObj.getRestId(), 0);
		dbObj.writeOrder(orderObj);
		
		custObj.setOrder(nextOrderId, restObj.getRestId());
		restObj.setOrder(nextOrderId, custObj.getCustId());
	}
	
	public void emptyCart()
	{
		custObj.emptyCart();
	}
	
	public ArrayList<Order> getCustomerOrders()
	{
		ArrayList<Order> orderList = dbObj.getOrders();
		ArrayList<Order> listToReturn =new ArrayList<>();
		
		for (Order obj : orderList)
		{
			if (obj.getCustId() == custObj.getCustId())
				listToReturn.add(obj);
		}
		
		return listToReturn;
	}
	
	public void cancelOrder(Order orderObj)
	{
		restObj.changeOrderStatusToCanceled(orderObj);
		custObj.changeOrderStatusToCanceled(orderObj);
	}
}
