package br.com.solutions.carsFleet.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionDao {
    String caminho = "localhost";
    String porta =  "3305";
    String nome = "carsFleet";
    String usuario = "root";
    String senha = "";

    private final String URL = "jdbc:mysql://" + caminho + ":" + porta + "/" + nome + "?useTimezone=true&serverTimezone=GMT"; //lerCaminhoDoSrv();
    private final String USER = usuario;
    private final String PASS = senha;
    private static ConnectionDao connectionDao;

    public static ConnectionDao getInstanec() {
        if (connectionDao == null) {
        	connectionDao = new ConnectionDao();
        }
        return connectionDao;
    }

    public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection(URL, USER, PASS);
    }
}
