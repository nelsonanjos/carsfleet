package br.com.solutions.carsFleet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.solutions.carsFleet.model.ToFuelModel;

public class ToFuelDao {
	
	public static void create(ToFuelModel toFuel) {
		int i = 1;
		try {
			Connection con = ConnectionDao.getInstanec().getConnection();
			
			String query = "INSERT INTO toFuel "
									+ "(date, vehicle, driver, fuelStation, liters, price, vehicleKm)"
									+ "VALUES (?,?,?,?,?,?,?)";
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
            Connection con = ConnectionDao.getInstanec().getConnection();
            String query = "SELECT * FROM toFuel WHERE 1";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	toFuel = new ToFuelModel();
            	toFuel.setId(rs.getString("id"));
            	toFuel.setDate(rs.getString("date"));
            	toFuel.setDriver(rs.getString("driver"));
            	toFuel.setFuelStation(rs.getString("fuelStation"));
            	toFuel.setLiters(rs.getString("liters"));
            	toFuel.setPrice(rs.getString("price"));
            	toFuel.setVehicleKm(rs.getString("vehicleKm"));
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
			Connection con = ConnectionDao.getInstanec().getConnection();
			String query = "SELECT * FROM toFuel WHERE id = ?";
			PreparedStatement stmt =  (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				toFuel = new ToFuelModel();
				toFuel.setDate(rs.getString("date"));
				toFuel.setVehicle(rs.getString("vehicle"));
				toFuel.setDriver(rs.getString("driver"));
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
            Connection con = ConnectionDao.getInstanec().getConnection();
            String query = "UPDATE toFuel SET"
            		+ " date = ?,  vehicle= ?, driver = ?,  fuelStation = ?, liters = ?, price = ?, vehicleKm = ?"
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
            Connection connection = ConnectionDao.getInstanec().getConnection();
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
