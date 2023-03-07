package BusinessLogic;

public class Order {
	
	private int orderId;
	private String dateCreated;
	private String orderStatus;
	private int custId;
	private int restId;
	private int riderId;
	
	public Order() {
		super();
		this.orderId = 0;
		this.dateCreated = null;
		this.orderStatus = "new";
		this.custId = 0;
		this.restId = 0;
		this.riderId = 0;
	}
	
	
	public Order(int orderId, String dateCreated, String orderStatus, int custId, int restId, int riderId) {
		super();
		this.orderId = orderId;
		this.dateCreated = dateCreated;
		this.orderStatus = orderStatus;
		this.custId = custId;
		this.restId = restId;
		this.riderId = riderId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public int getRestId() {
		return restId;
	}


	public void setRestId(int restId) {
		this.restId = restId;
	}


	public int getCustId() {
		return custId;
	}


	public void setCustId(int custId) {
		this.custId = custId;
	}


	public int getRiderId() {
		return riderId;
	}


	public void setRiderId(int riderId) {
		this.riderId = riderId;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", dateCreated=" + dateCreated + ", orderStatus=" + orderStatus
				+ ", custId=" + custId + ", restId=" + restId + ", riderId=" + riderId + "]";
	}
	
	
	
	

}
