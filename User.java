/*
 * User.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class User.
 */
public class User implements IUser {
    
    /** The id. */
    private int id;
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The company. */
    private TaxiCompany company;
    
    /** The service. */
    private boolean service;
    
    /** The location. */
    private Location location;
    
    /**
     * Instantiates a new user.
     *
     * @param id the id
     * @param firstName the first name
     * @param lastName the last name
     * @param company the company
     */
    public User(int id, String firstName, String lastName, TaxiCompany company) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.service = false;
        this.location = Functions.setRandomLocation();	// New.
    }
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    @Override
    public String getFirstName() {
        return this.firstName;
    }
    
    /**
     * Gets the last name.
     *
     * @return the last name
     */
    @Override
    public String getLastName() {
        return this.lastName;
    }
    
    /**
     * Gets the company.
     *
     * @return the company
     */
    @Override
    public TaxiCompany getCompany() {
        return this.company;
    }
    
    /**
     * Gets the location.
     *
     * @return the location
     */
    public Location getLocation() {	// New.
    	return this.location;
    }
    
    /**
     * Sets the location.
     *
     * @param location the new location
     */
    public void setLocation(Location location) {	// New.
    	this.location = location;
    }
    
    /**
     * Gets the service.
     *
     * @return the service
     */
    @Override
    public boolean getService() {
        return this.service;
    }
    
    /**
     * Sets the service.
     *
     * @param service the new service
     */
    @Override
    public void setService(boolean service) {
        this.service = service;
    }
    
    /**
     * Request service.
     */
    @Override
    public void requestService() {
        this.company.requestService(this.id);
    }
    
    /**
     * Rate service.
     *
     * @param service the service
     */
    @Override
    public void rateService(Service service) {
        // users rate around 50% of the services (1 to 5 stars)
        
        if (Functions.rand() % 2 == 0)
            service.setStars(Functions.rand(5) + 1);
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return this.getId() + " " + String.format("%-20s",this.getFirstName() + " " + this.getLastName());
    }
}