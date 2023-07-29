package net.javaguides.registration.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.registration.dao.EmployeeDao;
import net.javaguides.registration.model.Employees;
import net.javaguides.registration.model.Skiils;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao empdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		this.empdao = new EmployeeDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			try {
				showNewForm(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case "/insert":
			try {
				insertEmployee(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deleteEmployee(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/update":
			try {
				updateEmployee(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		default:
			try {
				listemp(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}

	}

	private void listemp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employees> listemp = empdao.ListAllEmployee();
		request.setAttribute("listemp", listemp);
		System.out.println("hii " +listemp);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/emp-list.jsp");
		rd.forward(request, response);
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String joiningdate = request.getParameter("joiningdate");
		String[] stringArray = request.getParameterValues("skill");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringArray.length; i++) 
		{
			sb.append(stringArray[i]);
		}
		String str = Arrays.toString(stringArray);
		String finalskill = str.substring(1,str.length()-1);
		Employees emp = new Employees(id, firstname, gender, age, salary, joiningdate,finalskill);
		Skiils skill = new Skiils(id, finalskill, id);
		finalskill="";
		empdao.updateEmp(emp);
		empdao.updateSkill(skill);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employees existingemp = empdao.selectEmployee(id);
		System.out.println("exist " + existingemp);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/employee-update.jsp");
		request.setAttribute("emp", existingemp);
		rd.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/employee-form.jsp");
		rd.forward(request, response);
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		empdao.deleteEmployee(id);
		response.sendRedirect("list");
	}

	private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String gender = request.getParameter("gender");

		String[] stringArray = request.getParameterValues("skill");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stringArray.length; i++) 
		{
			sb.append(stringArray[i]);
		}
		String str = Arrays.toString(stringArray);
		String finalskill = str.substring(1,str.length()-1);
		String age = request.getParameter("age");
		String salary = request.getParameter("salary");
		String joiningdate = request.getParameter("joiningdate");
		
		Employees emp = new Employees(firstname, gender, age, salary, joiningdate,finalskill);
		Skiils skill1 = new Skiils(finalskill);
		System.out.println("details of employee while insert " + emp);
		empdao.insertEmp(emp);
		empdao.insertSkill(skill1);
		response.sendRedirect("list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
