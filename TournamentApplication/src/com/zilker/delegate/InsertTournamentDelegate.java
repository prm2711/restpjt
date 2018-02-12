package com.zilker.delegate;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zilker.bean.Tour;
import com.zilker.dao.InsertData;

public class InsertTournamentDelegate {


	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String tourname = request.getParameter("tourname");
		boolean valid = Pattern.compile("([a-zA-Z\\s]+)").matcher(tourname).matches();
		Tour tour = new Tour();
		InsertData insertData = new InsertData();
		Gson gson = new Gson();
		String prefix = "http://localhost:8080/TournamentRestApplication/rest";
		if (valid == true) {
			tour.setTourName(tourname);
		   // insertData.insertTour(tour);
			String JSONString = gson.toJson(tour);
			URL url = null;
			String output;
			StringBuffer buffer = new StringBuffer();
			HttpURLConnection httpCon = null;
			try {
				url = new URL(prefix +"/tour");
				httpCon = (HttpURLConnection) url.openConnection();
				httpCon.setDoOutput(true);
				httpCon.setRequestMethod("POST");
				httpCon.setRequestProperty("Accept", "application/json");
				httpCon.setRequestProperty("Content-type", "application/json");

				OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
				out.write(JSONString);
				out.close();
				BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
				while ((output = br.readLine()) != null) {
					buffer.append(output);
				}
				System.out.println("buffer content = " + buffer.toString());
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("msg", "Data inserted successfully");
			return true;
		} else {
			request.setAttribute("msg", "Enter valid data");
			return false;
		}

	}

}
