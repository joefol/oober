/*
 * ITaxiCompany.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

/**
 * The Interface ITaxiCompany.
 */
public interface ITaxiCompany {
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName();    
    
    /**
     * Gets the total services.
     *
     * @return the total services
     */
    public int getTotalServices();
    
    /**
     * Request service.
     *
     * @param user the user
     * @return true, if successful
     */
    public boolean requestService(int user);
    
    /**
     * Arrived at pickup location.
     *
     * @param vehicle the vehicle
     */
    public void arrivedAtPickupLocation(Vehicle vehicle);
    
    /**
     * Arrived at dropoff location.
     *
     * @param vehicle the vehicle
     */
    public void arrivedAtDropoffLocation(Vehicle vehicle);
    
    /**
     * Adds the user.
     *
     * @param id the id
     * @param firstName the first name
     * @param lastName the last name
     */
    public void addUser(int id, String firstName, String lastName);
    
    /**
     * Adds the application.
     *
     * @param application the application
     */
    public void addApplication(ApplicationSimulator application);
    
    /**
     * Notify application.
     *
     * @param message the message
     */
    public void notifyApplication(String message);
    
    /**
     * Gets the user.
     *
     * @param id the id
     * @return the user
     */
    public User getUser(int id);
    
    /**
     * Show.
     *
     * @return the string
     */
    public String show();
    
    /**
     * Show statistics.
     *
     * @return the string
     */
    public String showStatistics();
    
    /**
     * Update.
     */
    public void update();
	
	/**
	 * Arrived at pickup location.
	 *
	 * @param vehicle the vehicle
	 */
	void arrivedAtPickupLocation(RentalVehicle vehicle);
	
	/**
	 * Arrived at dropoff location.
	 *
	 * @param vehicle the vehicle
	 */
	void arrivedAtDropoffLocation(RentalVehicle vehicle);
	
}
