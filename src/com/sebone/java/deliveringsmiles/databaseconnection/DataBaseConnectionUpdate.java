package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBaseConnectionUpdate {

	public static void main(String[] args) throws SQLException {
		DataBaseConnectionUpdate dataBaseConnectionUpdate=new DataBaseConnectionUpdate();
		 List<DriverDetails> driverDetailsList=dataBaseConnectionUpdate.getDriverDeatils();
		 for(DriverDetails driverDetails:driverDetailsList) {
				System.out.print("driver Name" + driverDetails.getDriverName());
				System.out.print(" driver Status " + driverDetails.isDriverstatus());
		 }

		 }			
				public List<DriverDetails> getDriverDeatils() throws SQLException{
					List<DriverDetails> driverDetailsList = new ArrayList<DriverDetails>();
					
					 String DB_URL="jdbc:mysql://127.0.0.1:3306/driver_dilvery";
				       String user="root";	
				       String password="shraddha@2710";
				       try {
						Connection con=DriverManager.getConnection(DB_URL,user,password );
						String sql = "Update registration_table set driver_name=?,driver_status=? where driver_name=?";
						Scanner sc = new Scanner(System.in);
						PreparedStatement ps = con.prepareStatement(sql);
						while(true) {
						   System.out.println("Enter driver Name");
						   String driver_name = sc.next();
						   System.out.println("Enter driver Status");
						  boolean driver_status = sc.hasNextBoolean();

						   ps.setString(1,driver_name);
						   ps.setBoolean(2,driver_status);
						   ps.executeUpdate();
						   System.out.println("Update");
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

