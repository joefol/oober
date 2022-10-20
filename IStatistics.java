/*
 * IStatistics.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

/**
 * The Interface IStatistics.
 */
public interface IStatistics {
	
	/**
	 * Gets the services.
	 *
	 * @return the services
	 */
	public int getServices();
    
    /**
     * Gets the reviews.
     *
     * @return the reviews
     */
    public int getReviews();
    
    /**
     * Gets the stars.
     *
     * @return the stars
     */
    public double getStars();
    
    /**
     * Gets the distance.
     *
     * @return the distance
     */
    public int getDistance();
    
    /**
     * Gets the billing.
     *
     * @return the billing
     */
    public int getBilling();
    
    /**
     * Update services.
     */
    public void updateServices();
    
    /**
     * Update reviews.
     */
    public void updateReviews();
    
    /**
     * Update stars.
     *
     * @param stars the stars
     */
    public void updateStars(int stars);
    
    /**
     * Update distance.
     *
     * @param distance the distance
     */
    public void updateDistance(int distance);
    
    /**
     * Update billing.
     *
     * @param billing the billing
     */
    public void updateBilling(int billing);
}
