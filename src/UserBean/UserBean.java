package UserBean;

public class UserBean {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean validate(String username){
		if (username.equals("zhangsan"))
			return true;
		else 
			return false;
	}
}
