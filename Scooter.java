/*
 * Scooter.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class Scooter.
 */
public class Scooter extends RentalVehicle {
	
	/**
	 * Instantiates a new scooter.
	 *
	 * @param id the id
	 * @param company the company
	 * @param location the location
	 */
	public Scooter(int id, TaxiCompany company, Location location) {
        super(id, company, location);
    }        
    
    /**
     * Calculate cost.
     *
     * @return the int
     */
    @Override
    public int calculateCost() {
        return (int) (super.calculateCost() * 0.25 + 2);	// Initial cost for Scooter rentals is 2 eur.
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Scooter    " + super.toString();
    }
}
