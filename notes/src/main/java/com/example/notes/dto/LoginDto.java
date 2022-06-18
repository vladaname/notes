package com.example.notes.dto;

public class LoginDto {
	
	private String pass;
	private String username;
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "LoginDto [pass=" + pass + ", username=" + username + "]";
	}
	
	
	

}
