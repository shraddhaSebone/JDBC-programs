package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class DataBaseConnection {
       
	public static void main(String[] args) {
		DataBaseConnection dataBaseConnection =new DataBaseConnection();
		
		List<DriverDetails> driverDetailsList=dataBaseConnection.getDriverDeatils();
		
		for(DriverDetails driverDetails:driverDetailsList) {
			System.out.print("driver_Id " + driverDetails.getDriverId());
			System.out.print(" driver_Name " + driverDetails.getDriverName());	
			System.out.print(" driver_Address " + driverDetails.getDriverAddress());	
			System.out.println();
			}
	}
	public List<DriverDetails> getDriverDeatils(){
		List<DriverDetails> driverDetailsList = new ArrayList<DriverDetails>();
		
		   String DB_URL="jdbc:mysql://127.0.0.1:3306/driver_dilvery";
	       String user="root";
	       String password="shraddha@2710";
	       
	try {
		Connection con=DriverManager.getConnection(DB_URL,user,password );
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT * from registration_table;");
		
		while(rs.next()) {
			DriverDetails driverDetails=new DriverDetails();
			
			driverDetails.setDriverId(rs.getInt("driver_id"));
			driverDetails.setDriverName(rs.getString("driver_name"));
			driverDetails.setDriverAddress(rs.getString("driver_address"));
			
			driverDetailsList.add(driverDetails);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
    return driverDetailsList;
	}
}
