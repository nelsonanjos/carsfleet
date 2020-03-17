package br.com.solutions.carsFleet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import br.com.solutions.carsFleet.model.TimelineModel;

public class TimelineDao {
	
	public static void create(TimelineModel timeline) {
		int i = 1;
		try {
			Connection con = ConnectionDao.getInstanec().getConnection();
			
			String query = "INSERT INTO timeline "
									+ "(date, vehicle, driver, startKm, finishKm, fail, maintenance)"
									+ "VALUES (?,"
									+ "(SELECT id FROM vehicle WHERE plate = ?),"
									+ "(SELECT id FROM driver WHERE cpf = ?),?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
			stmt.setString(i, timeline.getDate());
			i++;
			stmt.setString(i, timeline.getVehicle());
			i++;
			stmt.setString(i, timeline.getDriver());
			i++;
			stmt.setString(i, timeline.getStartKm());
			i++;
			stmt.setString(i, timeline.getFinishKm());
			i++;
			stmt.setString(i, timeline.getFail());
			i++;
			stmt.setString(i, timeline.getMaintenance());
			
			stmt.execute();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList read() {
		ArrayList timelines = new ArrayList();
		TimelineModel timeline = null;
        try {
            Connection con = ConnectionDao.getInstanec().getConnection();
            String query = "SELECT * FROM timeline, vehicle, driver"
            					+ " WHERE"
            					+ " timeline.vehicle = vehicle.id and timeline.driver = driver.id";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            	timeline = new TimelineModel();
            	timeline.setId(rs.getString("id"));
            	timeline.setDate(rs.getString("date"));
            	timeline.setVehicle(rs.getString("plate"));
            	timeline.setDriver(rs.getString("name"));
            	timeline.setStartKm(rs.getString("startKm"));
            	timeline.setFinishKm(rs.getString("finishKm"));
            	timeline.setFail(rs.getString("fail"));
            	timeline.setMaintenance(rs.getString("maintenance"));
            	timelines.add(timeline);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return timelines;
    }
	
	public static TimelineModel readUnit(String id) {
		TimelineModel timeline = null;
		try {
			Connection con = ConnectionDao.getInstanec().getConnection();
			String query = "SELECT * FROM timeline, vehicle, driver"
								+ " WHERE"
									+ " timeline.id = ? and  timeline.vehicle = vehicle.id and timeline.driver = driver.id";
			
			PreparedStatement stmt =  (PreparedStatement) con.prepareStatement(query);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				timeline = new TimelineModel();
				timeline.setDate(rs.getString("date"));
				timeline.setVehicle(rs.getString("plate"));
				timeline.setDriver(rs.getString("cpf"));
				timeline.setStartKm(rs.getString("startKm"));
				timeline.setFinishKm(rs.getString("finishKm"));
				timeline.setFail(rs.getString("fail"));
				timeline.setMaintenance(rs.getString("maintenance"));
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return timeline;
	}
	
	public static void update(TimelineModel timeline) {
        int i = 1;
		try {
            Connection con = ConnectionDao.getInstanec().getConnection();
            String query = "UPDATE timeline SET"
            							+ " date = ?,"
            							+ " vehicle = (SELECT id FROM vehicle WHERE  plate = ?),"
            							+ " driver = (SELECT id FROM driver WHERE cpf = ?),"
            							+ " startKm = ?, finishKm = ?, fail = ?, maintenance = ?"
            					+ " WHERE id = ?";
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
            
            stmt.setString(i, timeline.getDate());
            i++;
            stmt.setString(i, timeline.getVehicle());
            i++;
            stmt.setString(i, timeline.getDriver());
            i++;
            stmt.setString(i, timeline.getStartKm());
            i++;
            stmt.setString(i, timeline.getFinishKm());
            i++;
            stmt.setString(i, timeline.getFail());
            i++;
            stmt.setString(i, timeline.getMaintenance());
            i++;
            stmt.setString(i, timeline.getId());
            		
            stmt.execute();
            con.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
	
	public static void delete(String id) {
        try {
            Connection connection = ConnectionDao.getInstanec().getConnection();
            String query = "DELETE FROM timeline WHERE id = ?" ;
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(query);
            stmt.setString(1, id);
            stmt.execute();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
   
}
