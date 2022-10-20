/*
 * Taxi.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class Taxi.
 */
public class Taxi extends Vehicle {	/**
	 * Instantiates a new taxi.
	 *
	 * @param id the id
	 * @param company the company
	 * @param location the location
	 */
	// taxi is-a vehicle that costs twice the ride length.
	public Taxi(int id, TaxiCompany company, Location location) {
        super(id, company, location);
    }        
    
    /**
     * Calculate cost.
     *
     * @return the int
     */
    @Override
    public int calculateCost() {
        return super.calculateCost() * 2;
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Taxi    " + super.toString();
    }
}
