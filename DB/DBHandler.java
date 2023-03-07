package DB;

import java.sql.*;
import BusinessLogic.*;
import java.util.ArrayList;

public class DBHandler {
	
	String userName = "root"; //The username of the sql database
	String pass = "Barcelonano1"; //The pass of your database
	Connection con; //Connection object
	
	public DBHandler()
	{
		//Connect to DB
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalprojectdb", userName, pass);
			System.out.println("Connected to DB");
		}
		catch(SQLException e)
		{
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
	}
	
	
	
	//readAllRestaurants
	public ArrayList<Restaurant> getRestaurants()
	{
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		
		Statement st;
		String query1 = "select * from Restaurant";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				//get the restaurant account
				ArrayList<Account> accounts = getAccounts();
				Account restAcc = new Account();
				
				for (Account obj : accounts)
				{
					if (rs.getInt(8) == obj.getAccountId())
					{
						restAcc = obj;
						break;
					}
						
				}
				
				//get the restaurant menu
				ArrayList<Menu> menus = getMenus();
				Menu restMen = new Menu();
				
				for (Menu obj : menus)
				{
					if (rs.getInt(9) == obj.getMenuId())
					{
						restMen = obj;
						break;
					}
						
				}
				
				Restaurant rest = new Restaurant(rs.getString(1), rs.getString(2), rs.getString(3), restAcc, rs.getString(4), rs.getDouble(5), rs.getInt(6), rs.getString(7), restMen);
				//System.out.println(s.toString());
				
				restaurants.add(rest);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return restaurants;
	}
		
		
		
	//InsertRestaurant
	public void writeRestaurant(Restaurant rest)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Restaurant values('"+rest.getName()+"' ,'" + rest.getPhNumber()+ "','" + rest.getEmail() + "','" +rest.getAddress() + "','" +rest.getRating() + "','" +rest.getRestId() + "','" +rest.getAuthorize() + "','" +rest.getUserAccount().getAccountId() + "','" +rest.getMenuObj().getMenuId() + "','" + 25262 +"')";        
			st.executeUpdate(query1);
			System.out.println("Restaurant Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Restaurant insertion");
			e.printStackTrace();
		}
	}
	
	//update/Delete Restaurants
	public void queuryRestaurant(String query)
	{
		
		try (Statement st = con.createStatement();)
		{
			st.executeUpdate(query);
			System.out.println("Succesfully updated/deleted Restuarant");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in updation/deletion of Restaurant");
			e.printStackTrace();
		}
	}
	
	//GetLast from Restaurant table
	public int getLastRestaurant()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM Restaurant ORDER BY resID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(6);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	
	
	
	//readAllCustomers
		public ArrayList<Customer> getCustomers()
		{
			ArrayList<Customer> customers = new ArrayList<Customer>();
			
			Statement st;
			String query1 = "select * from Customer";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				while (rs.next())
				{
					ArrayList<Account> accounts = getAccounts();
					Account custAcc = new Account();
					
					for (Account obj : accounts)
					{
						if (rs.getInt(6) == obj.getAccountId())
						{
							custAcc = obj;
							break;
						}
							
					}
					
					ArrayList<Cart> carts = getCarts();
					Cart crt = new Cart();
					
					for (Cart obj : carts)
					{
						if (rs.getInt(8) == obj.getCartId())
						{
							crt = obj;
							break;
						}
							
					}
					
					Customer cust = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), custAcc, rs.getString(4), rs.getInt(5), crt);
					//System.out.println(s.toString());
					
					customers.add(cust);
				}
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return customers;
		}
		
		//InsertCustomers
		public void writeCustomer(Customer cust)
		{
			Statement st;
			try
			{
				st = con.createStatement();
				
				String query1 = "insert into Customer values('"+cust.getName()+"' ,'" + cust.getPhNumber()+ "','" + cust.getEmail() + "','" +cust.getAddress() + "','" +cust.getCustId() + "','" +cust.getUserAccount().getAccountId() + "','" +25262 + "','" +cust.getCustCart().getCartId() +"')";        
				st.executeUpdate(query1);
				System.out.println("Customer Succesfully inserted");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Error in Customer insertion");
				e.printStackTrace();
			}
		}
		
		//GetLast from Customer table
		public int getLastCustomer()
		{
			int lastId = 0;
			
			Statement st;
			String query1 = "SELECT * FROM Customer ORDER BY cusID DESC LIMIT 1;";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				if (rs.next()) //not empty
				{
					lastId = rs.getInt(5);
				}
				else //is empty
				{
					lastId = 0;
				}
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lastId;
		}
		
		
	//readAllAdmins
	public ArrayList<Admin> getAdmins()
	{
		ArrayList<Admin> admins = new ArrayList<Admin>();
		
		Statement st;
		String query1 = "select * from Admin";
		
		try 
		{
			
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				ArrayList<Account> accounts = getAccounts();
				Account adminAcc = new Account();
				
				for (Account obj : accounts)
				{
					if (rs.getInt(5) == obj.getAccountId())
					{
						adminAcc = obj;
						break;
					}
						
				}
				
				Admin admin = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), adminAcc, rs.getInt(4), null, null, null);
				//System.out.println(s.toString());
				
				admins.add(admin);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return admins;
	}
	
	
	
	//readAllRiders
	public ArrayList<Rider> getRiders()
	{
		ArrayList<Rider> riders = new ArrayList<Rider>();
		
		Statement st;
		String query1 = "select * from Rider";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				ArrayList<Account> accounts = getAccounts();
				Account riderAcc = new Account();
				
				for (Account obj : accounts)
				{
					if (rs.getInt(7) == obj.getAccountId())
					{
						riderAcc = obj;
						break;
					}
						
				}
				
				Rider rider = new Rider(rs.getString(1), rs.getString(2), rs.getString(3), riderAcc, rs.getInt(4), rs.getInt(5), rs.getString(6));
				//System.out.println(s.toString());
				
				riders.add(rider);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return riders;
	}
	
	
	//InsertRiders
	public void writeRider(Rider rid)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Rider values('"+rid.getName()+"' ,'" + rid.getPhNumber()+ "','" + rid.getEmail() + "','" +rid.getLiscenceNo() + "','" +rid.getRiderId() + "','" +rid.getAuthorize() + "','" +rid.getUserAccount().getAccountId() + "','" +25262 +"')";        
			st.executeUpdate(query1);
			System.out.println("Rider Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Rider insertion");
			e.printStackTrace();
		}
	}
	
	//update/Delete Rider
	public void queuryRider(String query)
	{
		
		try (Statement st = con.createStatement();)
		{
			st.executeUpdate(query);
			System.out.println("Succesfully updated/deleted Rider");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in updation/deletion of Rider");
			e.printStackTrace();
		}
	}
	
	//GetLast from Rider table
		public int getLastRider()
		{
			int lastId = 0;
			
			Statement st;
			String query1 = "SELECT * FROM Rider ORDER BY riderID DESC LIMIT 1;";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				if (rs.next()) //not empty
				{
					lastId = rs.getInt(5);
				}
				else //is empty
				{
					lastId = 0;
				}
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lastId;
		}
	
	
	
	//readAllAccounts
	public ArrayList<Account> getAccounts()
	{
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		Statement st;
		String query1 = "select * from Account";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				Account acc = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				//System.out.println(s.toString());
				
				accounts.add(acc);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	//InsertAccount
	public void writeAccount(Account acc)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Account values('"+acc.getAccountId()+"' ,'" + acc.getDateCreated()+ "','" + acc.getUserName() + "','" + acc.getPassword() +"')";        
			st.executeUpdate(query1);
			System.out.println("Account Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Account insertion");
			e.printStackTrace();
		}
	}
	
	//GetLast from Accounts table
	public int getLastAccount()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM Account ORDER BY accountID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(1);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	
	
	
	//InsertMenu
	public void writeMenu(Menu men)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Menu values('"+men.getMenuId() +"')";        
			st.executeUpdate(query1);
			System.out.println("Menu Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in Menu insertion");
			e.printStackTrace();
		}
	}
	
	//readAllMenus
	public ArrayList<Menu> getMenus()
	{
		ArrayList<Menu> menus = new ArrayList<Menu>();
		
		Statement st;
		String query1 = "select * from Menu";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				Menu men = new Menu(rs.getInt(1), "menuName");
				//System.out.println(s.toString());
				
				menus.add(men);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menus;
	}
	
	//GetLast from Menu table
		public int getLastMenu()
		{
			int lastId = 0;
			
			Statement st;
			String query1 = "SELECT * FROM Menu ORDER BY menuID DESC LIMIT 1;";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				if (rs.next()) //not empty
				{
					lastId = rs.getInt(1);
				}
				else //is empty
				{
					lastId = 0;
				}
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lastId;
		}
	
	
	
	//InsertCart
	public void writeCart(Cart cart)
	{
		Statement st;
		try
		{
			st = con.createStatement();
			
			String query1 = "insert into Cart values('"+ cart.getTotalItems() +"' ,'" + cart.getTotalPrice()+ "','" + cart.getCartId() +"')";        
			st.executeUpdate(query1);
			System.out.println("Cart Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Cart in Menu insertion");
			e.printStackTrace();
		}
	}
	
	//readAllCart
		public ArrayList<Cart> getCarts()
		{
			ArrayList<Cart> carts = new ArrayList<Cart>();
			
			Statement st;
			String query1 = "select * from Cart";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				while (rs.next())
				{
					ArrayList<FoodItem> allFood = getFoodItems();
					ArrayList<FoodItem> foodInCart = new ArrayList<FoodItem>();
					
					for (FoodItem obj : allFood)
					{
						if (obj.getCartId() == rs.getInt(3))
							foodInCart.add(obj);
					}
					
					Cart crt = new Cart(rs.getInt(1), rs.getDouble(2), rs.getInt(3), foodInCart);
					//System.out.println(s.toString());
					
					carts.add(crt);
				}
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return carts;
		}
	
	//GetLast from Cart table
	public int getLastCart()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM Cart ORDER BY cartID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(3);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	//update/Delete Cart
	public void queuryCart(String query)
	{
		
		try (Statement st = con.createStatement();)
		{
			st.executeUpdate(query);
			System.out.println("Succesfully updated/deleted Cart");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in updation/deletion of Cart");
			e.printStackTrace();
		}
	}
	
	
	//GetLast from Food Item table
	public int getLastFoodItem()
	{
		int lastId = 0;
		
		Statement st;
		String query1 = "SELECT * FROM FoodItems ORDER BY itemID DESC LIMIT 1;";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			if (rs.next()) //not empty
			{
				lastId = rs.getInt(1);
			}
			else //is empty
			{
				lastId = 0;
			}
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastId;
	}
	
	//InsertFoodItem
	public void writeFoodItem(int foodId, String name, String details, double price, int menuId)
	{
		Statement st;
		try 
		{
			st = con.createStatement();
			
			String query1 = "insert into FoodItems (itemID, foodName, description, price, menuID) values('"+foodId+"' ,'" + name+ "','" + details + "','" + price + "','" + menuId +"')";        
			st.executeUpdate(query1);
			System.out.println("FoodItem Succesfully inserted");
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Error in FoodItem insertion");
			e.printStackTrace();
		}
	}
	
	//readAllFoodItems
	public ArrayList<FoodItem> getFoodItems()
	{
		ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
		
		Statement st;
		String query1 = "select * from FoodItems";
		
		try 
		{
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
			
			while (rs.next())
			{
				FoodItem item = new FoodItem(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6));
				//System.out.println(s.toString());
				
				foodItems.add(item);
			}
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return foodItems;
	}
	
	
	//update/Delete FoodItems
		public void queuryFoodItem(String query)
		{
			
			try (Statement st = con.createStatement();)
			{
				st.executeUpdate(query);
				System.out.println("Succesfully updated/deleted FoodItems");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Error in updation/deletion of FooItems");
				e.printStackTrace();
			}
		}
		
		
	
	
		//readAllOrders
		public ArrayList<Order> getOrders()
		{
			ArrayList<Order> orders = new ArrayList<Order>();
			
			Statement st;
			String query1 = "select * from Orders";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				while (rs.next())
				{
					int riderId = rs.getInt(6);
					if (rs.wasNull())
						riderId = 0;
						
					Order ord = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), riderId);
					//System.out.println(s.toString());
					
					orders.add(ord);
				}
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return orders;
		}
		
		//update/Delete Order
		public void queuryOrder(String query)
		{
			
			try (Statement st = con.createStatement();)
			{
				st.executeUpdate(query);
				System.out.println("Succesfully updated/deleted Order");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Error in updation/deletion of Order");
				e.printStackTrace();
			}
		}
		
		//GetLast from order table
		public int getLastOrder()
		{
			int lastId = 0;
			
			Statement st;
			String query1 = "SELECT * FROM Orders ORDER BY orderID DESC LIMIT 1;";
			
			try 
			{
				st = con.createStatement();
				ResultSet rs = st.executeQuery(query1); //Only select query will return rows (not insert, delete, update). these also not usedin statement
				
				if (rs.next()) //not empty
				{
					lastId = rs.getInt(1);
				}
				else //is empty
				{
					lastId = 0;
				}
				
				
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return lastId;
		}
		
		//InsertFoodItem
		public void writeOrder(Order orderObj)
		{
			Statement st;
			try 
			{
				st = con.createStatement();
				
				String query1 = "insert into Orders (orderID, dateCreated, orderStatus, cusID, resID) values('"+ orderObj.getOrderId() +"' ,'" + orderObj.getDateCreated() + "','" + orderObj.getOrderStatus() + "','" + orderObj.getCustId() + "','" + orderObj.getRestId() +"')";        
				st.executeUpdate(query1);
				System.out.println("Order Succesfully inserted");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Error in Order insertion");
				e.printStackTrace();
			}
		}

}
