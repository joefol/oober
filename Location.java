/*
 * Location.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

/**
 * The Class Location.
 */
public class Location implements ILocation {	
	/** The x. */								// we use this class to be able to access a vehicles location. Locations are updated in the vehicle class every time our vehicle moves.
	private int x;
    
    /** The y. */
    private int y;

    /**
     * Instantiates a new location.
     *
     * @param x the x
     * @param y the y
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
       
    /**
     * Gets the x.
     *
     * @return the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public int getY() {
        return this.y;
    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }
}
