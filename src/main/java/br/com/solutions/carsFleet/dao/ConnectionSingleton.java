package br.com.solutions.carsFleet.dao;

//PADRÃO DE PROJETO CRIACIONAL SIGLETON


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionSingleton {
	private String address = "localhost";
	private String port =  "3305";
	private String db = "carsFleet";
	private String USER = "root";
	private String PASS = "";

    private final String URL = "jdbc:mysql://" + address + ":" + port + "/" + db + "?useTimezone=true&serverTimezone=GMT"; //lerCaminhoDoSrv();
    private static ConnectionSingleton connectionDao;

    public static ConnectionSingleton getInstanec() {
        if (connectionDao == null) {
        	connectionDao = new ConnectionSingleton();
        }
        return connectionDao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection(URL, USER, PASS);
    }
}
