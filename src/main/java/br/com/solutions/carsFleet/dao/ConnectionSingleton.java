package br.com.solutions.carsFleet.dao;

//PADRÃO DE PROJETO CRIACIONAL SIGLETON


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionSingleton {
    String caminho = "localhost";
    String porta =  "3305";
    String nome = "carsFleet";
    String usuario = "root";
    String senha = "";

    private final String URL = "jdbc:mysql://" + caminho + ":" + porta + "/" + nome + "?useTimezone=true&serverTimezone=GMT"; //lerCaminhoDoSrv();
    private final String USER = usuario;
    private final String PASS = senha;
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
