package BusinessLogic;

public abstract class User {
	
	private String name;
	private String phNumber;
	private String email;
	private Account userAccount = new Account();
	
	//Constructors
	public User()
	{
		super();
		this.name = null;
		this.phNumber = null;
		this.email = null;
		this.userAccount = null;
	}
	
	public User(String name, String phNumber, String email, Account userAccount) {
		super();
		this.name = name;
		this.phNumber = phNumber;
		this.email = email;
		this.userAccount = userAccount;
	}
	
	//getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Account userAccount) {
		this.userAccount = userAccount;
	}

	
	@Override
	public String toString() {
		return "User [name=" + name + ", phNumber=" + phNumber + ", email=" + email +"]";
	}
	
	

}
