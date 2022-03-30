package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBaseConnectionPrepared {

	public static void main(String[] args) throws SQLException {
		DataBaseConnectionPrepared dataBaseConnectionPrepared = new DataBaseConnectionPrepared();
		
		List<DriverDetails> driverDetailsList=dataBaseConnectionPrepared.getDriverDeatils();
		
		for(DriverDetails driverDetails:driverDetailsList) {
			System.out.print("Vechile Id" + driverDetails.getVehicleId());
			System.out.print(" Vechile Name " + driverDetails.getVehicleName());	
			System.out.print(" Vehicle No " + driverDetails.getVehicleNo());	
			System.out.println("Driver Id"+driverDetails.getDriverId());
			}
}
	
		public List<DriverDetails> getDriverDeatils() throws SQLException{
			List<DriverDetails> driverDetailsList = new ArrayList<DriverDetails>();
			
			 String DB_URL="jdbc:mysql://127.0.0.1:3306/driver_dilvery";
		       String user="root";	
		       String password="shraddha@2710";
		       try {
				Connection con=DriverManager.getConnection(DB_URL,user,password );
				String sql = "INSERT INTO vehicle_table VALUES(?,?,?,?)";
				Scanner sc = new Scanner(System.in);
				PreparedStatement ps = con.prepareStatement(sql);
				while(true) {
				   System.out.println("Enter Vechile Id");
				   int vehicle_id = sc.nextInt();
				   System.out.println("Enter Vechile Name");
				   String vehicle_name = sc.next();
				   System.out.println("Enter Vehicle No");
				   int vehicle_no= sc.nextInt();
				   System.out.println("Enter driver Id");
				   int driver_id= sc.nextInt();

				   ps.setInt(1,vehicle_id);
				   ps.setString(2,vehicle_name);
				   ps.setInt(3,vehicle_no);
				   ps.setInt(4,driver_id );
				   ps.executeUpdate();
				   System.out.println("Insert ");
				   String option=sc.nextLine();		
				   if(option.equalsIgnoreCase("NO")) {
				   break;
				   }
		}
     }catch(SQLException e) {
			e.printStackTrace();
		 }finally {			 
			Connection con = null;
				con.close();
			}
			return driverDetailsList;
	     }
	}
