package com.qts.business.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qts.business.common.AppResponse;
import com.qts.business.service.EmployeeService;
import com.qts.business.vo.Employee;

/**
 * Servlet implementation class ServletDate
 */
@WebServlet("/ServletDate")
public class ServletDate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*JSONObject reqJson;
		JSONObject respJson = new JSONObject();

		try {
			// get Reader from request
			Reader reqReader = req.getReader();
			JSONParser parser = new JSONParser();
			// parse our request to json
			reqJson = (JSONObject) parser.parse(reqReader);
		} catch (ParseException | ClassCastException ex) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			respJson.put("answer", "Something bad happened");
			try (PrintWriter out = resp.getWriter()) {
				out.println(respJson.toJSONString());
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
		
		doGet(request, response);
	}

}
