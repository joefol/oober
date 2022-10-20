/*
 * Functions.java
 * 
 * @autor Claudio, Jerry, Joe, Francisco
 * @since 5-6-2022
 */
package oober;

import java.util.Random;

/**
 * The Class Functions.
 */
public class Functions {
    
    /** The Constant width. */
    private static final int width = 20;		// This was changed, since we needed a bigger map to accommodate for more vehicles and rentals. This shows us the difference between the overall cost
    											// of taxis vs. rentals.
    /** The Constant height. */
    private static final int height = 20;    

    /**
     * Rand.
     *
     * @return the int
     */
    public static int rand() {
        Random random = new Random();
        
        return random.nextInt(9767);
    }
    
    /**
     * Rand.
     *
     * @param max the max
     * @return the int
     */
    public static int rand(int max) {
        Random random = new Random();

        return random.nextInt(9767) % max;
    }
    
    /**
     * Distance.
     *
     * @param a the a
     * @param b the b
     * @return the int
     */
    public static int distance(Location a, Location b) { //
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
    
    /**
     * Sets the random location.
     *
     * @return the location
     */
    public static Location setRandomLocation() {
        return new Location(rand(width), rand(height));
    }
    
    /**
     * Sets the random location.
     *
     * @param location the location
     * @return the location
     */
    public static Location setRandomLocation(Location location) {
        Location destination;
        
        do {
            
            destination = new Location(rand(width), rand(height));
            
        } while (distance(location, destination) < 3);  
            
        return destination;
    }
}