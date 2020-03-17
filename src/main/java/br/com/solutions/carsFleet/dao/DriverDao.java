package br.com.solutions.carsFleet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.solutions.carsFleet.model.DriverModel;

public class DriverDao {
	
	public static void create(DriverModel driver) {
		int i = 1;
		try {
			Connection con = ConnectionDao.getInstanec().getConnection();
			
			String query = "INSERT INTO driver "
									+ "(name, location, phone, cpf, habilitation, habilitationExpiration)"
									+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(i, driver.getName());
			i++;
			stmt.setString(i, driver.getLocation());
			i++;
			stmt.setString(i, driver.getPhone());
			i++;
			stmt.setString(i, driver.getCpf());
			i++;
			stmt.setString(i, driver.getHabilitation());
			i++;
			stmt.setString(i, driver.getHabilitationExpiration());
			
			stmt.execute();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList read() {
		ArrayList drivers = new ArrayList();
		DriverModel driver = null;
        try {
            Connection con = ConnectionDao.getInstanec().getConnection();
            String query = "SELECT * FROM driver WHERE 1";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	driver = new DriverModel();
            	driver.setId(rs.getString("id"));
            	driver.setName(rs.getString("name"));
            	driver.setLocation(rs.getString("location"));
            	driver.setPhone(rs.getString("phone"));
            	driver.setCpf(rs.getString("cpf"));
            	driver.setHabilitation(rs.getString("habilitation"));
            	driver.setHabilitationExpiration(rs.getString("habilitationExpiration"));
                drivers.add(driver);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return drivers;
    }
	
	public static DriverModel readUnit(String id) {
		DriverModel driver = null;
		try {
			Connection con = ConnectionDao.getInstanec().getConnection();
			String query = "SELECT * FROM driver WHERE id = ?";
			PreparedStatement stmt =  (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				driver = new DriverModel();
				driver.setName(rs.getString("name"));
				driver.setLocation(rs.getString("location"));
				driver.setPhone(rs.getString("phone"));
				driver.setCpf(rs.getString("cpf"));
				driver.setHabilitation(rs.getString("Habilitation"));
				driver.setHabilitationExpiration(rs.getString("habilitationExpiration"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return driver;
	}
	
	public static void update(DriverModel driver) {
        int i = 1;
		try {
            Connection con = ConnectionDao.getInstanec().getConnection();
            String query = "UPDATE driver SET"
            		+ " name = ?,  location= ?, phone = ?, cpf = ?, habilitation = ?, habilitationExpiration = ?"
            		+ " WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            
            stmt.setString(i, driver.getName());
            i++;
            stmt.setString(i, driver.getLocation());
            i++;
            stmt.setString(i, driver.getPhone());
            i++;
            stmt.setString(i, driver.getCpf());
            i++;
            stmt.setString(i, driver.getHabilitation());
            i++;
            stmt.setString(i, driver.getHabilitationExpiration());
            i++;
            stmt.setInt(i, Integer.parseInt(driver.getId()) );
            		
            stmt.execute();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
	
	public static void delete(String id) {
        try {
            Connection connection = ConnectionDao.getInstanec().getConnection();
            String query = "DELETE FROM driver WHERE id = ?" ;
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.execute();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
   
}
