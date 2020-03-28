package br.com.solutions.carsFleet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.solutions.carsFleet.model.VehicleModel;

public class VehicleDao {
	
	private static ConnectionSingleton connectionSingleton;
	
	public static void create(VehicleModel vehicle) {
		int i = 1;
		try {
			Connection con = connectionSingleton.getInstanec().getConnection();
			
			String query = "INSERT INTO vehicle "
									+ "(vtype, plate, brand, price, state, color, vyear, licensingExpiration)"
									+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(i, vehicle.getType());
			i++;
			stmt.setString(i, vehicle.getPlate());
			i++;
			stmt.setString(i, vehicle.getBrand());
			i++;
			stmt.setString(i, vehicle.getPrice());
			i++;
			stmt.setString(i, vehicle.getState());
			i++;
			stmt.setString(i, vehicle.getColor());
			i++;
			stmt.setString(i, vehicle.getYear());
			i++;
			stmt.setString(i, vehicle.getLicensingExpiration());
			
			stmt.execute();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList read() {
		ArrayList vehicles = new ArrayList();
		VehicleModel vehicle = null;
        try {
            Connection con = connectionSingleton.getInstanec().getConnection();
            String query = "SELECT * FROM vehicle WHERE 1";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	vehicle = new VehicleModel();
            	vehicle.setId(rs.getString("id"));
            	vehicle.setType(rs.getString("vtype"));
            	vehicle.setPlate(rs.getString("plate"));
            	vehicle.setBrand(rs.getString("brand"));
            	vehicle.setPrice(rs.getString("price"));
            	vehicle.setState(rs.getString("state"));
            	vehicle.setColor(rs.getString("color"));
            	vehicle.setYear(rs.getString("vyear"));
            	vehicle.setLicensingExpiration(rs.getString("licensingExpiration"));
                vehicles.add(vehicle);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return vehicles;
    }
	
	public static VehicleModel readUnit(String id) {
		VehicleModel vehicle = null;
		try {
			Connection con = connectionSingleton.getInstanec().getConnection();
			String query = "SELECT * FROM vehicle WHERE id = ?";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				vehicle = new VehicleModel();
				vehicle.setType(rs.getString("vtype"));
				vehicle.setPlate(rs.getString("plate"));
				vehicle.setBrand(rs.getString("brand"));
				vehicle.setPrice(rs.getString("price"));
				vehicle.setState(rs.getString("state"));
				vehicle.setColor(rs.getString("color"));
				vehicle.setYear(rs.getString("vyear"));
				vehicle.setLicensingExpiration(rs.getString("licensingExpiration"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return vehicle;
	}
	
	public static void update(VehicleModel vehicle) {
        int i = 1;
		try {
            Connection con = connectionSingleton.getInstanec().getConnection();
            String query = "UPDATE vehicle SET"
            		+ " vtype = ?,  plate= ?, brand = ?, price = ?, state = ?, color = ?,"
            		+" vyear = ?, licensingExpiration = ?"
            		+ " WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            
            stmt.setString(i, vehicle.getType());
            i++;
            stmt.setString(i, vehicle.getPlate());
            i++;
            stmt.setString(i, vehicle.getBrand());
            i++;
            stmt.setString(i, vehicle.getPrice());
            i++;
            stmt.setString(i, vehicle.getState());
            i++;
            stmt.setString(i, vehicle.getColor());
            i++;
            stmt.setString(i, vehicle.getYear());
            i++;
            stmt.setString(i, vehicle.getLicensingExpiration());
            i++;
            stmt.setInt(i, Integer.parseInt(vehicle.getId()) );
            		
            stmt.execute();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
	
	public static void delete(String id) {
        try {
            Connection connection = connectionSingleton.getInstanec().getConnection();
            String query = "DELETE FROM vehicle WHERE id = ?" ;
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.execute();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
   
}
