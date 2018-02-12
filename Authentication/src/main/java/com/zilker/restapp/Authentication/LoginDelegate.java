package com.zilker.restapp.Authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class LoginDelegate {

	public boolean validateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(userName.isEmpty()==true || password.isEmpty()==true)
		{
			request.setAttribute("msg", "Field empty");
			return false;
		}
		String prefix = "http://localhost:8080/AuthenticationRest/rest";
		String line;
		StringBuffer stringBuffer = new StringBuffer();
		boolean check=false;
		
			
			HttpURLConnection conn = null;
			String jwt="";
			try {
				URL url = new URL(prefix + "/login?username="+userName+"&password="+password);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "text/plain");
				conn.setRequestProperty("Content-Type", "text/plain");
				try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				if ((line = reader.readLine()) != null) {
					check=true;
					stringBuffer.append(line);
					
				}
			
				 jwt = conn.getHeaderField("jwt");
				 System.out.println("Received "+stringBuffer.toString());
				 System.out.println("Header is "+jwt);
                if(check==true) {
                
				request.setAttribute("msg", "Login successful");
				request.getSession().setAttribute("token", jwt);
				return true;
                }
                else
                {
                	request.getSession().setAttribute("msg", "Invalid User");
                	return false;
                }
				}
				catch(IOException e) {
					System.out.println("Invalid 1");
					request.getSession().setAttribute("msg", "Invalid user");
					return false;
				}
			}
			
			catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Invalid");
				request.setAttribute("msg", "Invalid user");
				return false;
			
			}
		
		return false;
	}

}
