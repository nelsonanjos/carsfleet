package br.com.solutions.carsFleet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.solutions.carsFleet.model.PeopleModel;

public class PeopleDao {
	
	private static ConnectionSingleton connectionSingleton;
	
	public static void create(PeopleModel people) {
		int i = 1;
		try {
			Connection con = connectionSingleton.getInstanec().getConnection();
			
			String query = "INSERT INTO people"
									+ " (name, register, cpf, user, password, pgroup)"
									+ " VALUES (?,?,?,?,?,?)";

			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(i, people.getName());
			i++;
			stmt.setString(i, people.getRegister());
			i++;
			stmt.setString(i, people.getCpf());
			i++;
			stmt.setString(i, people.getUser());
			i++;
			stmt.setString(i, people.getPassword());
			i++;
			stmt.setString(i, people.getGroup());
			
			stmt.execute();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList read() {
		ArrayList peoples = new ArrayList();
		PeopleModel people = null;
        try {
            Connection con = connectionSingleton.getInstanec().getConnection();
            String query = "SELECT * FROM people WHERE 1";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	people = new PeopleModel();
            	people.setId(rs.getString("id"));
            	people.setName(rs.getString("name"));
            	people.setCpf(rs.getString("cpf"));
            	people.setUser(rs.getString("user"));
            	people.setPassword(rs.getString("password"));
            	people.setGroup(rs.getString("pgroup"));
            	peoples.add(people);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return peoples;
    }
	
	public static PeopleModel readUnit(String id) {
		PeopleModel people = null;
		try {
			Connection con = connectionSingleton.getInstanec().getConnection();
			String query = "SELECT * FROM people WHERE id = ?";
			PreparedStatement stmt =  (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				people = new PeopleModel();
				people.setName(rs.getString("name"));
				people.setRegister(rs.getString("register"));
				people.setCpf(rs.getString("cpf"));
				people.setUser(rs.getString("user"));
				people.setPassword(rs.getString("password"));
				people.setGroup(rs.getString("pgroup"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return people;
	}
	
	public static void update(PeopleModel people) {
        int i = 1;
		try {
            Connection con = connectionSingleton.getInstanec().getConnection();
            String query = "UPDATE people SET"
            		+ " name = ?,  register= ?, cpf = ?,  user = ?, password = ?, pgroup = ?"
            		+ " WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            
            stmt.setString(i, people.getName());
            i++;
            stmt.setString(i, people.getRegister());
            i++;
            stmt.setString(i, people.getCpf());
            i++;
            stmt.setString(i, people.getUser());
            i++;
            stmt.setString(i, people.getPassword());
            i++;
            stmt.setString(i, people.getGroup());
            i++;
            stmt.setInt(i, Integer.parseInt(people.getId()) );
            		
            stmt.execute();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
	
	public static void delete(String id) {
        try {
            Connection connection = connectionSingleton.getInstanec().getConnection();
            String query = "DELETE FROM people WHERE id = ?" ;
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.execute();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
   
}
