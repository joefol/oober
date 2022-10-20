/*
 * Car.java
 * 
 * @autor Claudio, Jerry, Joe, Francisco
 * @since 5-6-2022
 */
package oober;

/**
 * The Class Car.
 */
public class Car extends RentalVehicle {
	
	/**
	 * Instantiates a new car.
	 *
	 * @param id the id
	 * @param company the company
	 * @param location the initial location of the car
	 */
	public Car(int id, TaxiCompany company, Location location) {
        super(id, company, location);
    }        
    
    /**
     * Calculate cost.
     *
     * @return the int
     */
    @Override
    public int calculateCost() {
        return (int) (super.calculateCost() + 3.5);	// Initial cost for Rental Cars is 3.5 eur.
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Car    " + super.toString();
    }
}
