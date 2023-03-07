package BusinessLogic;

import java.util.ArrayList;

import DB.DBHandler;

public class Rider extends User {

	private int liscenceNo;
	private ArrayList<Order> orderList;
	private int riderId;
	private String authorize;
	private ArrayList<RiderFeedback> riderFeedbackList;
	
	
	//constructor
	public Rider() {
		super();
		this.liscenceNo = 0;
		this.orderList =  new ArrayList<>();
		this.riderId = 0;
		this.authorize = null;
		this.riderFeedbackList = new ArrayList<>();
	}
	
	public Rider(String name, String phNumber, String email, Account userAccount, int liscenceNo, int riderId, String authorize) {
		super(name, phNumber, email, userAccount);
		this.liscenceNo = liscenceNo;
		this.orderList =  new ArrayList<>();
		this.riderId = riderId;
		this.authorize = authorize;
		this.riderFeedbackList = new ArrayList<>();
	}


	
	//setters and getters
	public int getLiscenceNo() {
		return liscenceNo;
	}


	public void setLiscenceNo(int liscenceNo) {
		this.liscenceNo = liscenceNo;
	}


	public ArrayList<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}


	public int getRiderId() {
		return riderId;
	}


	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}


	public String getAuthorize() {
		return authorize;
	}


	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}


	public ArrayList<RiderFeedback> getRiderFeedbackList() {
		return riderFeedbackList;
	}


	public void setRiderFeedbackList(ArrayList<RiderFeedback> riderFeedbackList) {
		this.riderFeedbackList = riderFeedbackList;
	}



	@Override
	public String toString() {
		return "Rider [name=" + this.getName() + ", phNumber=" + this.getPhNumber() + ", email=" + this.getEmail() + ", liscenceNo=" + liscenceNo + ", riderId=" + riderId + ", authorize=" + authorize + "]";
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
	}
	
}
