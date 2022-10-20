/*
 * IRentalVehicle.java
 *
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

import java.util.List;

/**
 * The Interface IRentalVehicle.
 */
public interface IRentalVehicle {
	
	/**
	 * Gets the id of the vehicle.
	 *
	 * @return the id
	 */
	public int getId();
	
	/**
	 * Gets the location of the vehicle.
	 *
	 * @return the location
	 */
	public Location getLocation();
	
	/**
	 * Gets the current destination of the vehicle.
	 *
	 * @return the destination
	 */
	public Location getDestination();
	
	/**
	 * Gets the service of the vehicle.
	 *
	 * @return the service
	 */
	public Service getService();
	
	/**
	 * Gets the total statistics of the vehicle.
	 *
	 * @return the statistics
	 */
	public Statistics getStatistics();
	
	/**
	 * Pick service.
	 *
	 * @param service the service
	 */
	public void pickService(Service service);
	
	/**
	 * End service.
	 */
	public void endService();
	
	/**
	 * Notify arrival at dropoff location.
	 */
	public void notifyArrivalAtDropoffLocation();
	
	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public boolean isAVAILABLE();
	
	/**
	 * Move.
	 */
	public void move();
	
	/**
	 * Calculate cost.
	 *
	 * @return the int
	 */
	public int calculateCost();
	
	/**
	 * Show drive.
	 *
	 * @param drive the drive
	 * @return the string
	 */
	public String showDrive(List<Location> drive);
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString();
}
