/*
 * IUser.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

/**
 * The Interface IUser.
 */
public interface IUser {
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId();	
    
    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName();	
    
    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName();	
    
    /**
     * Gets the company.
     *
     * @return the company
     */
    public TaxiCompany getCompany();	
    
    /**
     * Gets the service.
     *
     * @return the service
     */
    public boolean getService();	
    
    /**
     * Sets the service.
     *
     * @param service the new service
     */
    public void setService(boolean service);	
    
    /**
     * Request service.
     */
    public void requestService();	
    
    /**
     * Rate service.
     *
     * @param service the service
     */
    public void rateService(Service service);	
    
    /**
     * To string.
     *
     * @return the string
     */
    public String toString();
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation();
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(Location location);
}
