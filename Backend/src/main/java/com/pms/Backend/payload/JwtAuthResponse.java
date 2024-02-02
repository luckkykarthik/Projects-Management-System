package com.pms.Backend.payload;

public class JwtAuthResponse {
	private String token;
	private String role;
	private String tokenType="Bearer";
	public JwtAuthResponse(String token,String role) {
		this.token = token;
		this.role =role;
	}
	public String getToken() {
		return token;
	}
	public String getTokenType() {
		return tokenType;
	}
	@Override
	public String toString() {
		return "JwtAuthResponse [token=" + token + ", role=" + role + ", tokenType=" + tokenType + "]";
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
