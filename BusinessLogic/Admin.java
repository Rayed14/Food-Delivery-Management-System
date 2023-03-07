package BusinessLogic;

import java.util.ArrayList;

import BusinessLogic.testMain.accountCount;
import BusinessLogic.testMain.cartCount;
import BusinessLogic.testMain.customerCount;
import BusinessLogic.testMain.menuCount;
import BusinessLogic.testMain.restaurantCount;
import BusinessLogic.testMain.riderCount;

import java.util.Scanner;
import DB.*;

public class Admin extends User{
	
	private int cnic;
	private ArrayList<Customer> customerList;
	private ArrayList<Rider> riderList;
	private ArrayList<Restaurant> restaurantList;
	
	
	//constructors
	public Admin() {
		super();
		this.cnic = 0;
		this.customerList = new ArrayList<>();
		this.riderList = new ArrayList<>();
		this.restaurantList = new ArrayList<>();
	}
	
	public Admin(String name, String phNumber, String email, Account userAccount, int cnic, ArrayList<Customer> customerList, ArrayList<Rider> riderList,
			ArrayList<Restaurant> restaurantList) {
		super(name, phNumber, email, userAccount);
		this.cnic = cnic;
		this.customerList = customerList;
		this.riderList = riderList;
		this.restaurantList = restaurantList;
	}


	//getters setters
	public int getCnic() {
		return cnic;
	}


	public void setCnic(int cnic) {
		this.cnic = cnic;
	}


	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}


	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}


	public ArrayList<Rider> getRiderList() {
		return riderList;
	}


	public void setRiderList(ArrayList<Rider> riderList) {
		this.riderList = riderList;
	}


	public ArrayList<Restaurant> getRestaurantList() {
		return restaurantList;
	}


	public void setRestaurantList(ArrayList<Restaurant> restaurantList) {
		this.restaurantList = restaurantList;
	}
	
	
	//Restuarant functions
	public void detailsEntryRest(String name, String phNum, String email, String address, String userName, String pass, String menuName)
	{
		DBHandler DBObj = new DBHandler();
		restaurantList = DBObj.getRestaurants();
		customerList = DBObj.getCustomers();
		riderList = DBObj.getRiders();
		
		//creating a restaurant Object
		int lastAccId = DBObj.getLastAccount();
		Account resAccount = new Account(lastAccId+1, "20-11-22", userName, pass);
		DBObj.writeAccount(resAccount);
		accountCount.count++;
		
		int lastMenuId = DBObj.getLastMenu();
		Menu resMenu = new Menu(lastMenuId+1 , menuName);
		DBObj.writeMenu(resMenu);
		menuCount.count++;
		
		int lastRestId = DBObj.getLastRestaurant();
		Restaurant newRest = new Restaurant(name, phNum, email, resAccount, address, 0.0, lastRestId+1, "no", resMenu);
		DBObj.writeRestaurant(newRest);
		restaurantCount.count++;
		
		restaurantList.add(newRest);
	}
	
	
	
	public ArrayList<Restaurant>  selectRestaurant()
	{
		return restaurantList;
	}
	
	public void authorizeRestaurant(Restaurant rest)
	{
		for (Restaurant obj : restaurantList)
		{
			if (obj.getRestId() == rest.getRestId())
			{
				obj.setAuthorize("yes");
				//System.out.println(obj.toString());
			}
		}
		
		
		DBHandler DBObj = new DBHandler();
		String query = "Update Restaurant set authorize = '" + "yes" + "' Where resID = '" + rest.getRestId() + "'";
		DBObj.queuryRestaurant(query);
		
	}
	
	//Rider functions
	public void detailsEntryRid(String name, String phNum, String email, int liscenceNo, String userName, String pass)
	{
		DBHandler DBObj = new DBHandler();
		restaurantList = DBObj.getRestaurants();
		customerList = DBObj.getCustomers();
		riderList = DBObj.getRiders();
		
		//creating a customer Object
		int lastAccId = DBObj.getLastAccount();
		Account ridAccount = new Account(lastAccId+1, "20-11-22",userName, pass);
		DBObj.writeAccount(ridAccount);
		accountCount.count++;
		
		int lastRidId = DBObj.getLastRider();
		Rider newRider = new Rider(name, phNum, email, ridAccount, liscenceNo, lastRidId+1, "no");
		DBObj.writeRider(newRider);
		riderCount.count++;
		
		riderList.add(newRider);
	}
	

	
	public ArrayList<Rider>  selectRider()
	{
		return riderList;
	}
	
	public void authorizeRider(Rider rid)
	{
		for (Rider obj : riderList)
		{
			if (obj.getRiderId() == rid.getRiderId())
			{
				obj.setAuthorize("yes");
				//System.out.println(obj.toString());
			}
		}
		
		
		DBHandler DBObj = new DBHandler();
		String query = "Update Rider set riderAuthorize = '" + "yes" + "' Where riderID = '" + rid.getRiderId() + "'";
		DBObj.queuryRider(query);
		
	}
	
	
	//Customer functions
	public void detailsEntryCust(String name, String phNum, String email, String address, String userName, String pass)
	{
		DBHandler DBObj = new DBHandler();
		restaurantList = DBObj.getRestaurants();
		customerList = DBObj.getCustomers();
		riderList = DBObj.getRiders();
		
		//creating a restaurant Object
		
		int lastAccId = DBObj.getLastAccount();
		Account custAccount = new Account(lastAccId+1, "20-11-22", userName, pass);
		DBObj.writeAccount(custAccount);
		accountCount.count++;
		
		int lastCartId = DBObj.getLastCart();
		Cart custCart = new Cart(lastCartId+1);
		DBObj.writeCart(custCart);
		cartCount.count++;
		
		int lastCustId = DBObj.getLastCustomer();
		Customer newCust = new Customer(name, phNum, email, custAccount, address, lastCustId+1, custCart);
		DBObj.writeCustomer(newCust);
		restaurantCount.count++;
		
		customerList.add(newCust);
	}
	
	
}
