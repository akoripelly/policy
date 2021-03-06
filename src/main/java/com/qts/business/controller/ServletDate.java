package com.qts.business.controller;

import java.io.IOException;

import java.util.List;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.qts.business.common.AppResponse;
import com.qts.business.service.EmployeeService;
import com.qts.business.vo.Employee;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.qts.business.vo.Business;


/**
 * Servlet implementation class ServletDate
 */
@WebServlet("/ServletDate")
public class ServletDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JsonObject reqJson;
		/*JsonObject respJson = new JsonObject();
		try {
			//JsonParser parser = new JsonParser();
			//reqJson = (JsonObject) parser.parse(request.getReader()); // parse our request to json
			Gson gson = new Gson();
			Business business = gson.fromJson(request.getReader(), Business.class);
			System.out.println(business);
		} catch (JsonParseException | ClassCastException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			respJson.addProperty("answer", "Something bad happened");
			try (PrintWriter out = response.getWriter()) {
				out.println(respJson.toString());
				out.flush();
			}
		}*/
		AppResponse res = new AppResponse();
		try {
			EmployeeService service = new EmployeeService();
			List<Employee> employees = service.readFromCSV("E:\\sample-data.csv");
			res.add("employees", employees);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
