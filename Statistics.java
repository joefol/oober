/*
 * Statistics.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class Statistics.
 */
public class Statistics implements IStatistics {
	
	/** The services. */
	private int services;
    
    /** The ratings. */
    private int ratings;
    
    /** The stars. */
    private int stars;
    
    /** The distance. */
    private int distance;
    
    /** The billing. */
    private int billing;
    
    /**
     * Instantiates a new statistics.
     */
    public Statistics() {
        this.services = 0;
        this.ratings = 0;
        this.stars = 0;
        this.distance = 0;
        this.billing = 0;
    }
    
    /**
     * Gets the services.
     *
     * @return the services
     */
    @Override
    public int getServices() {
        return this.services;
    }
    
    /**
     * Gets the reviews.
     *
     * @return the reviews
     */
    @Override
    public int getReviews() {
        return this.ratings;
    }
    
    /**
     * Gets the stars.
     *
     * @return the stars
     */
    @Override
    public double getStars() {
        double stars = (double) this.stars / (double) this.ratings;
        
        return Math.round(stars*100.0)/100.0;
    }
    
    /**
     * Gets the distance.
     *
     * @return the distance
     */
    @Override
    public int getDistance() {
        return this.distance;
    }
    
    /**
     * Gets the billing.
     *
     * @return the billing
     */
    @Override
    public int getBilling() {
        return this.billing;
    }
    
    /**
     * Update services.
     */
    @Override
    public void updateServices() {
        this.services++;
    }
    
    /**
     * Update reviews.
     */
    @Override
    public void updateReviews() {
        this.ratings++;
    }
    
    /**
     * Update stars.
     *
     * @param stars the stars
     */
    @Override
    public void updateStars(int stars) {
        this.stars = this.stars + stars;
    }
    
    /**
     * Update distance.
     *
     * @param distance the distance
     */
    @Override
    public void updateDistance(int distance) {
        this.distance = this.distance + distance;
    }
    
    /**
     * Update billing.
     *
     * @param billing the billing
     */
    @Override
    public void updateBilling(int billing) {
        this.billing = this.billing + billing;
    }   
}
