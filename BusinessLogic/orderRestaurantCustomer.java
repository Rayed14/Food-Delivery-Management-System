package BusinessLogic;

public class orderRestaurantCustomer {
	
	private int orderId;
	private String orderDate;
	private String orderStatus;
	private String deliverAddress;
	private String rest;
	
	public orderRestaurantCustomer() {
		super();
		this.orderId = 0;
		this.orderDate = null;
		this.orderStatus = null;
		this.deliverAddress = null;
		this.rest = null;
	}
	
	
	public orderRestaurantCustomer(int orderId, String orderDate, String orderStatus, String deliverAddress,
			String rest) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.deliverAddress = deliverAddress;
		this.rest = rest;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getDeliverAddress() {
		return deliverAddress;
	}


	public void setDeliverAddress(String deliverAddress) {
		this.deliverAddress = deliverAddress;
	}


	public String getRest() {
		return rest;
	}


	public void setRest(String rest) {
		this.rest = rest;
	}


	@Override
	public String toString() {
		return "orderRestaurantCustomer [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus="
				+ orderStatus + ", deliverAddress=" + deliverAddress + ", rest=" + rest + "]";
	}
	
	

}
