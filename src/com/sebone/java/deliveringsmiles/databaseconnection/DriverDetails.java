package com.sebone.java.deliveringsmiles.databaseconnection;

public class DriverDetails {
	   private int driverId;
       private String driverName;
       private String driverAddress;
       private int vehicleId;
       private String vehicleName;
       private int vehicleNo;
       private boolean driverstatus;
       
       public int getDriverId() {
               return driverId;
       }
       public void setDriverId(int driverId) {
               this.driverId = driverId;
       }
       public String getDriverName() {
               return driverName;
       }
       public void setDriverName(String driverName) {
               this.driverName = driverName;
       }
       public String getDriverAddress() {
               return driverAddress;
       }
       public void setDriverAddress(String driverAddress) {
               this.driverAddress = driverAddress;
       }
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public int getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public boolean isDriverstatus() {
		return driverstatus;
	}
	public void setDriverstatus(boolean driverstatus) {
		this.driverstatus = driverstatus;
	}
}
