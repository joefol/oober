/*
 * RentalVehicle.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;
// This class is new, since it is the parent class for rental cars.
import java.util.ArrayList;
import java.util.List;

enum Status2 { AVAILABLE, INUSE }	// This was added, since Rental Vehicles do not have 3 statuses, only two.

/**
 * The Class RentalVehicle.
 */
public abstract class RentalVehicle implements IRentalVehicle {
	
	/** The id. */
	private int id;
    
    /** The company. */
    private TaxiCompany company;
    
    /** The service. */
    private Service service;
    
    /** The status. */
    private Status2 status;
    
    /** The location. */
    private Location location;
    
    /** The destination. */
    private Location destination;
    
    /** The statistics. */
    private Statistics statistics;
    
    /** The drive. */
    private List<Location> drive;
        
    /**
     * Instantiates a new rental vehicle.
     *
     * @param id the id
     * @param company the company
     * @param location the location
     */
    public RentalVehicle(int id, TaxiCompany company, Location location) { 
        this.id = id;
        this.company = company;
        this.service = null;
        this.status = Status2.AVAILABLE;
        this.location = location;        
        this.destination = Functions.setRandomLocation(this.location);	// We couldn't make the rentals stationary, since we encountered multiple errors with the move() function that we coldnt fix.
        this.statistics = new Statistics();
        this.drive = setUserPathToDestination(this.location, this.destination);
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
     * Gets the location.
     *
     * @return the location
     */
    @Override
    public Location getLocation() {
        return this.location;
    }

    /**
     * Gets the destination.
     *
     * @return the destination
     */
    @Override
    public Location getDestination() {
        return this.destination;
    }
    
    /**
     * Gets the service.
     *
     * @return the service
     */
    @Override
    public Service getService() {
        return this.service;
    }
    
    /**
     * Gets the statistics.
     *
     * @return the statistics
     */
    @Override
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    /**
     * Pick service.
     *
     * @param service the service
     */
    @Override
    public void pickService(Service service) {	// This function is very important, since rental vehicles do not go to the user, but instead they are picked up by the user immediately.
        
        this.service = service;
        this.destination = service.getDropoffLocation();	// Rentals vehicles do not have a designated "start service" function, since we don't require them to move to the user.
        this.drive = setUserPathToDestination(this.location, this.destination);	
        this.status = Status2.INUSE;
    }

    /**
     * End service.
     */
    @Override
    public void endService() {	
        
        this.statistics.updateBilling(this.calculateCost());
        this.statistics.updateDistance(this.service.calculateDistance());
        this.statistics.updateServices();

        this.service = null;
        this.destination = Functions.setRandomLocation(this.location);	// Since we cannot make rentals be stationary after the user stops using them, they will get a user path to a random location.
        this.drive = setUserPathToDestination(this.location, this.destination);
        this.status = Status2.AVAILABLE;
    }

    /**
     * Notify arrival at dropoff location.
     */
    @Override
    public void notifyArrivalAtDropoffLocation() {	
        this.company.arrivedAtDropoffLocation(this);
        this.endService();
     }
      
    // This was changed, since we do not notify upon arrival at pickup location.
    
    /**
     * Checks if is available.
     *
     * @return true, if is available
     */
    @Override
    public boolean isAVAILABLE() {
        return (this.status == Status2.AVAILABLE);
    }   
    
    /**
     * Move.
     */
    @Override
    public void move() {
    	
    	this.location = this.drive.get(0);        
    	this.drive.remove(0);
    	    
        if (this.drive.isEmpty()) {
            if (this.service == null) {
                
                this.destination = Functions.setRandomLocation(this.location);
                this.drive = setUserPathToDestination(this.location, this.destination);
            }
        else {
            
            @SuppressWarnings("unused")
			Location origin = this.service.getPickupLocation();
            Location destination = this.service.getDropoffLocation();	// This was changed. Since Scooters and Rental Cars do not need notification for Arrive at Pickup.

            if (this.location.getX() == destination.getX() && this.location.getY() == destination.getY()) {

                notifyArrivalAtDropoffLocation();
             }        
            }
        }
    }
    
    /**
     * Calculate cost.
     *
     * @return the int
     */
    @Override
    public int calculateCost() {
        return this.service.calculateDistance();
    }

    /**
     * Show drive.
     *
     * @param drive the drive
     * @return the string
     */
    @Override
    public String showDrive(List<Location> drive) {
        String s = "";
       
           for (Location l : drive)
               s = s + l.toString() + " ";
       
           return s;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return this.getId() +
               ((this.status == Status2.AVAILABLE) ? " is AVAILABLE at " + this.location : 
                /*((this.status == Status2.RESERVED) ? " is waiting for user " +*/ " in use by User " + this.service.getUser().getId() + " is at " + this.location + " going to " + this.destination);
    }
    
    /**
     * Sets the user path to destination.
     *
     * @param location the location
     * @param destination the destination
     * @return the list
     */
    private List<Location> setUserPathToDestination(Location location, Location destination) {

    	List<Location> drive = new ArrayList<Location>();
	        
	    int x1 = location.getX();
	    int y1 = location.getY();
	        
	    int x2 = destination.getX();
	    int y2 = destination.getY();
	        
	    int dx = Math.abs(x1 - x2);
	    int dy = Math.abs(y1 - y2);
	       
	    for (int i=1; i<=dx; i++) {
	        x1 = (x1 < x2) ? x1 + 1 : x1 - 1;
	
	        drive.add(new Location(x1, y1));
	    }
	        
	    for (int i=1; i<=dy; i++) {
	        y1 = (y1 < y2) ? y1 + 1 : y1 - 1;
	            
	        drive.add(new Location(x1, y1));
	    }
	        
	    return drive;
    	
    }       
	
}
