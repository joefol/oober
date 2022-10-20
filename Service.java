/*
 * Service.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class Service.
 */
public class Service implements IService {	/** The user. */
	// service is used when an user requests a taxi (taxi becomes in service).
	private User user;
    
    /** The pickup. */
    private Location pickup;
    
    /** The dropoff. */
    private Location dropoff;
    
    /** The stars. */
    private int stars;
    
    /**
     * Instantiates a new service.
     *
     * @param user the user
     * @param pickup the pickup
     * @param dropoff the dropoff
     */
    public Service(User user, Location pickup, Location dropoff) {
        this.user = user;
        this.pickup = pickup;
        this.dropoff = dropoff;        
    }
    
    /**
     * Gets the user.
     *
     * @return the user
     */
    @Override
    public User getUser() {
        return this.user;
    }
    
    /**
     * Gets the stars.
     *
     * @return the stars
     */
    @Override
    public int getStars() {
        return this.stars;
    }
    
    /**
     * Sets the stars.
     *
     * @param stars the new stars
     */
    @Override
    public void setStars(int stars) {
    	this.stars = stars;
    }
    
    /**
     * Gets the pickup location.
     *
     * @return the pickup location
     */
    @Override
    public Location getPickupLocation() {
        return this.pickup;
    }
    
    /**
     * Gets the dropoff location.
     *
     * @return the dropoff location
     */
    @Override
    public Location getDropoffLocation() {
        return this.dropoff;
    }
    
    /**
     * Calculate distance.
     *
     * @return the int
     */
    @Override
    public int calculateDistance() {
        return Math.abs(this.pickup.getX() - this.dropoff.getX()) + Math.abs(this.pickup.getY() - this.dropoff.getY());
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return this.getPickupLocation().toString() + " to " + this.getDropoffLocation().toString();
    }
}