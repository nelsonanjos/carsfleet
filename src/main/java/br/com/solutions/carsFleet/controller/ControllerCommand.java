package br.com.solutions.carsFleet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ControllerCommand {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
