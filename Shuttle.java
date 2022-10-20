/*
 * Shuttle.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class Shuttle.
 */
public class Shuttle extends Vehicle {	/**
	 * Instantiates a new shuttle.
	 *
	 * @param id the id
	 * @param company the company
	 * @param location the location
	 */
	// shuttle is-a vehicle that costs 1.5 times the ride length.
	public Shuttle(int id, TaxiCompany company, Location location) {
        super(id, company, location);
    }        
    
    /**
     * Calculate cost.
     *
     * @return the int
     */
    @Override
    public int calculateCost() {
        return (int) (super.calculateCost() * 1.5);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Shuttle " + super.toString();
    }
}
