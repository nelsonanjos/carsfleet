package br.com.solutions.carsFleet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.solutions.carsFleet.model.ToFuelModel;

public class ToFuelDao {
	
	private static ConnectionSingleton connectionSingleton;
	
	public static void create(ToFuelModel toFuel) {
		int i = 1;
		try {
			Connection con = connectionSingleton.getInstanec().getConnection();
			
			String query = "INSERT INTO toFuel"
									+ " (fuelStation, vehicle, driver, date, liters, price, vehicleKm)"
									+ " VALUES (?,"
									+ " (SELECT id FROM vehicle WHERE plate = ?),"
									+ " (SELECT id FROM driver WHERE cpf = ?),"
									+ " ?, ?, ?, ?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			
			
			stmt.setString(i, toFuel.getFuelStation());
			i++;
			stmt.setString(i, toFuel.getVehicle());
			i++;
			stmt.setString(i, toFuel.getDriver());
			i++;
			stmt.setString(i, toFuel.getDate());
			i++;
			stmt.setString(i, toFuel.getLiters());
			i++;
			stmt.setString(i, toFuel.getPrice());
			i++;
			stmt.setString(i, toFuel.getVehicleKm());
			
			stmt.execute();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList read() {
		ArrayList toFuels = new ArrayList();
		ToFuelModel toFuel = null;
        try {
            Connection con = connectionSingleton.getInstanec().getConnection();
            String query = "SELECT "
            							+ "toFuel.id, toFuel.date, vehicle.plate, driver.name, toFuel.liters, toFuel.price  "
            					+ "FROM "
            							+ "toFuel, vehicle, driver "
            					+ "WHERE "
            							+ "toFuel.vehicle = vehicle.id and toFuel.driver = driver.id";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
            	toFuel = new ToFuelModel();
            	toFuel.setId(rs.getString("id"));
            	toFuel.setDate(rs.getString("date"));
            	toFuel.setVehicle(rs.getString("plate"));            	
            	toFuel.setDriver(rs.getString("name"));
            	toFuel.setLiters(rs.getString("liters"));
            	toFuel.setPrice(rs.getString("price"));
            	toFuels.add(toFuel);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return toFuels;
    }
	
	public static ToFuelModel readUnit(String id) {
		ToFuelModel toFuel = null;
		try {
			Connection con = connectionSingleton.getInstanec().getConnection();
			String query = "SELECT "
										+ "*"
								+ " FROM "
										+ "toFuel, vehicle, driver "
								+ "WHERE "
										+ "toFuel.id=? and toFuel.vehicle = vehicle.id and toFuel.driver = driver.id";
			PreparedStatement stmt =  (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				toFuel = new ToFuelModel();
				toFuel.setDate(rs.getString("date"));
				toFuel.setVehicle(rs.getString("plate"));
				toFuel.setDriver(rs.getString("cpf"));
				toFuel.setFuelStation(rs.getString("fuelStation"));
				toFuel.setLiters(rs.getString("liters"));
				toFuel.setPrice(rs.getString("price"));
				toFuel.setVehicleKm(rs.getString("vehicleKm"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return toFuel;
	}
	
	public static void update(ToFuelModel toFuel) {
        int i = 1;
		try {
            Connection con = connectionSingleton.getInstanec().getConnection();
            String query = "UPDATE toFuel SET"
            		+ " date = ?,  vehicle= (SELECT id FROM vehicle WHERE plate = ?), driver = (SELECT id FROM driver WHERE cpf = ?),  fuelStation = ?, liters = ?, price = ?, vehicleKm = ?"
            		+ " WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            
            stmt.setString(i, toFuel.getDate());
            i++;
            stmt.setString(i, toFuel.getVehicle());
            i++;
            stmt.setString(i, toFuel.getDriver());
            i++;
            stmt.setString(i, toFuel.getFuelStation());
            i++;
            stmt.setString(i, toFuel.getLiters());
            i++;
            stmt.setString(i, toFuel.getPrice());
            i++;
            stmt.setString(i, toFuel.getVehicleKm());
            i++;
            stmt.setString(i, toFuel.getId());
            		
            stmt.execute();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
	
	public static void delete(String id) {
        try {
            Connection connection = connectionSingleton.getInstanec().getConnection();
            String query = "DELETE FROM toFuel WHERE id = ?" ;
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.execute();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
   
}
