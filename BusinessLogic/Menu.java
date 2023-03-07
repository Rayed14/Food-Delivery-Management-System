package BusinessLogic;

import java.util.ArrayList;
import DB.*;

public class Menu {
	
	private int menuId;
	private String menuName;
	private ArrayList<FoodItem> foodList;
	
	//constructor
	public Menu() {
		this.menuId = 0;
		this.menuName = null;
		this.foodList = new ArrayList<>();
	}
	
	public Menu(int menuId, String menuName) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.foodList = new ArrayList<>();
	}
	
	
	//setters and getters
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public ArrayList<FoodItem> getFoodList() {
		return foodList;
	}

	public void setFoodList(ArrayList<FoodItem> foodList) {
		this.foodList = foodList;
	}


	
	public void addInMenu(String name, double price, String details)
	{
		DBHandler DBObj = new DBHandler();
		
		int lastId = DBObj.getLastFoodItem();
		
		FoodItem newFood = new FoodItem(lastId+1, name, details, price, this.menuId, 0);
		
		DBObj.writeFoodItem(lastId+1, name, details, price, this.menuId);
		
		foodList.add(newFood);
		
	}
	
	
	

}
