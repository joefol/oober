/*
 * IService.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

/**
 * The Interface IService.
 */
public interface IService {
	
	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser();	// when a new service is started, it is assigned to an user. we can get that user.
    
    /**
     * Gets the pickup location.
     *
     * @return the pickup location
     */
    public Location getPickupLocation();	// returns user given pick up and dropoff locations.
    
    /**
     * Gets the dropoff location.
     *
     * @return the dropoff location
     */
    public Location getDropoffLocation();
    
    /**
     * Gets the stars.
     *
     * @return the stars
     */
    public int getStars();	// if user rates, we can return them with this.
    
    /**
     * Sets the stars.
     *
     * @param stars the new stars
     */
    public void setStars(int stars);	// if user rates, we update the stars value here.
    
    /**
     * Calculate distance.
     *
     * @return the int
     */
    public int calculateDistance();	// counts blocks dropX - pickX + dropY - pickY.
    
    /**
     * To string.
     *
     * @return the string
     */
    public String toString();
}
