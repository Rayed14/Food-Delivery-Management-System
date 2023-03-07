package BusinessLogic;

public class Account {
	
	//data members
	private int accountId;
	private String dateCreated;
	private String userName;
	private String password;
	
	//Constructors
	public Account()
	{
		super();
		this.accountId = 0;
		this.dateCreated = null;
		this.userName = null;
		this.password = null;
	}
	
	public Account(int accountId, String dateCreated, String userName, String password) {
		super();
		this.accountId = accountId;
		this.dateCreated = dateCreated;
		this.userName = userName;
		this.password = password;
	}
	
	
	//getters and setters
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", dateCreated=" + dateCreated + ", userName=" + userName
				+ ", password=" + password + "]";
	}
	
	
	
	

}
