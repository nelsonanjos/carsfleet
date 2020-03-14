package br.com.solutions.carsFleet.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.model.PeopleModel;

/**
 * Servlet implementation class ToFuelController
 */
@WebServlet("/PeopleController")
public class PeopleController extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response){
       
	PeopleModel users = new PeopleModel();
	
	 String name = request.getParameter("name");
	 String register = request.getParameter("register");
	 String cpf = request.getParameter("cpf");
	 String group = request.getParameter("group");
	
	 users.setName(name);
	 users.setRegister(register);
	 users.setCpf(cpf);
	 users.setGroup(group);
	 
	 System.out.println(users);
	}
}
