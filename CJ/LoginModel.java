package pro_06_19_project;

public class LoginModel {
	public String username;
	public String password;
	public String userType;
	
	public LoginModel(String username, String password, String userType) {
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
}