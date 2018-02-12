package com.zilker.restapp.Authentication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDelegate {

	public boolean viewData(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String prefix = "http://localhost:8080/AuthenticationRest/rest";
		String line;
		StringBuffer stringBuffer = new StringBuffer();
		boolean check=false;
			HttpURLConnection conn = null;
			String jwt="";
			try {
				URL url = new URL(prefix + "/access");
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "text/plain");
				conn.setRequestProperty("Content-Type", "text/plain");
				conn.setRequestProperty("Authorization", "Bearer "+request.getSession().getAttribute("token"));
				try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				if ((line = reader.readLine()) != null) {
					check=true;
					stringBuffer.append(line);
					
				}
			
	            System.out.println(stringBuffer);
	            request.setAttribute("content",stringBuffer);
                return true;
                
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Invalid");
					request.setAttribute("msg", "Invalid user");
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
