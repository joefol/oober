/*
 * IVehicle.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

import java.util.List;

/**
 * The Interface IVehicle.
 */
public interface IVehicle {
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId();
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation();	// returns the vehicles location.
	
	/**
	 * Gets the destination.
	 *
	 * @return the destination
	 */
	public Location getDestination();	// returns the current vehicles destination. 
	
	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	public Service getService();	// returns the service object.
	
	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 */
	public Statistics getStatistics();	// returns statistics of ride.
	
	/**
	 * Pick service.
	 *
	 * @param service the service
	 */
	public void pickService(Service service);	// when a vehicle chooses an user.
	
	/**
	 * Start service.
	 */
	public void startService();	// user gets on the vehicle.
	
	/**
	 * End service.
	 */
	public void endService();	// user gets off the vehicle.
	
	/**
	 * Notify arrival at pickup location.
	 *
	 * @param vehicle the vehicle
	 */
	public void notifyArrivalAtPickupLocation(Vehicle vehicle);
	
	/**
	 * Notify arrival at dropoff location.
	 */
	public void notifyArrivalAtDropoffLocation();
	
	/**
	 * Move.
	 */
	public void move();	// simulates vehicle movements.
	
	/**
	 * Calculate cost.
	 *
	 * @return the int
	 */
	public int calculateCost();
	
	/**
	 * Checks if is free.
	 *
	 * @return true, if is free
	 */
	public boolean isFree();
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString();
	
	/**
	 * Show drive.
	 *
	 * @param drive the drive
	 * @return the string
	 */
	public String showDrive(List<Location> drive);
}
