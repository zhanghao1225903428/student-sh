package entity;

public class Users {
	private int uid;
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(int uid  ,String username, String password) {
		this.uid=uid;
		this.username = username;
		this.password = password;
	}
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Users() {
	}
	
	

}
