package com.zilker.delegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.UserType;

public class UserTypeDelegate {
public String findUserType(HttpServletRequest request, HttpServletResponse response) {
	String user=null;
	String username = request.getParameter("username");
	UserType userType=new UserType();
	user=userType.retrieveType(username);
	return user;
}

public Object findUserType(String string) {
	// TODO Auto-generated method stub
	return null;
}


}
