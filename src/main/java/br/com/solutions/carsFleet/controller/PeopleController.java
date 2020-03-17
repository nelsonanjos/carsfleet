package br.com.solutions.carsFleet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.solutions.carsFleet.dao.PeopleDao;
import br.com.solutions.carsFleet.model.PeopleModel;

/**
 * Servlet implementation class PeopleController
 */
@WebServlet("/PeopleController")
public class PeopleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service( HttpServletRequest request, HttpServletResponse response) {
		try {
			switch (request.getParameter("action")) {
			case "create":
				create(request);
				break;
			case "read":
				read(response);
				break;
			case "readUnit":
				readUnit(request, response);
				break;
			case "update":
				update(request);
				break;
			case "delete":
				delete(request);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
	}
	
	public void create(HttpServletRequest request) {
		PeopleModel people = new PeopleModel();
		
		 String name = request.getParameter("name");
		 String register = request.getParameter("register");
		 String cpf = request.getParameter("cpf");
	     String user = request.getParameter("user");
		 String password = request.getParameter("password");
		 String group = request.getParameter("group");
		 
		 
		 people.setName(name);
		 people.setRegister(register);
		 people.setCpf(cpf);
		 people.setUser(user);
		 people.setPassword(password);
		 people.setGroup(group);
		 
		 PeopleDao.create(people);
	}
	
	public void read(HttpServletResponse response) throws IOException {
		PrintWriter out  = response.getWriter();
		ArrayList peoples = PeopleDao.read();
			out.println("{\"peoples\":"+peoples+"}");			
	}
	
	public void readUnit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PeopleModel people = PeopleDao.readUnit(request.getParameter("id"));
		PrintWriter out  = response.getWriter();
		out.print("{\"name\":\""+people.getName()+"\"");			
		out.print(",\"register\":\""+people.getRegister()+"\"");			
		out.print(",\"cpf\":\""+people.getCpf()+"\"");			
		out.print(",\"user\":\""+people.getUser()+"\"");			
		out.print(",\"password\":\""+people.getPassword()+"\"");			
		out.print(",\"group\":\""+people.getGroup()+"\"}");			
	}
	
	public void update(HttpServletRequest request) {
		 PeopleModel people = new PeopleModel();
		
		 String id = request.getParameter("id");
		 String name = request.getParameter("name");
		 String register = request.getParameter("register");
		 String cpf = request.getParameter("cpf");
	     String user = request.getParameter("user");
		 String password = request.getParameter("password");
		 String group = request.getParameter("group");
		 
		 people.setId(id);
		 people.setName(name);
		 people.setRegister(register);
		 people.setCpf(cpf);
		 people.setUser(user);
		 people.setPassword(password);
		 people.setGroup(group);
		 
		 
		 PeopleDao.update(people);
	}
	
	public void delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		PeopleDao.delete(id);
	}
       
}
