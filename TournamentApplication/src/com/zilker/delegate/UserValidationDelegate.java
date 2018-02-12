package com.zilker.delegate;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zilker.dao.UserValidation;

public class UserValidationDelegate {
	public String checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String pattern = "(.*[a-z].*)";
		UserValidation userValidate = new UserValidation();
		boolean check = true;
		if (password.length() < 8) {
			request.setAttribute("msg", "Enter password of atleast 8 characters");
			return "false";
		} else if (!password.matches(pattern)) {
			request.setAttribute("msg", "Enter password with atleast 1 lower case letter");
			return "false";
		} else {
			check = userValidate.userValidate(user, password);
			if (check == true && user.equals("admin")) {
				return "admin";
			} else if (check == true) {
				return user;
			} else {
				request.setAttribute("msg", "Invalid");
				return "false";
			}
		}
	}
}
