/*
 * Vehicle.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

import java.util.ArrayList;
import java.util.List;

enum Status { FREE, PICKUP, SERVICE } 

/**
 * The Class Vehicle.
 */
public abstract class Vehicle implements IVehicle {
    
    /** The id. */
    private int id;
    
    /** The company. */
    private TaxiCompany company;
    
    /** The service. */
    private Service service;
    
    /** The status. */
    private Status status;
    
    /** The location. */
    private Location location;
    
    /** The destination. */
    private Location destination;
    
    /** The statistics. */
    private Statistics statistics;
    
    /** The drive. */
    private List<Location> drive;
        
    /**
     * Instantiates a new vehicle.
     *
     * @param id the id
     * @param company the company
     * @param location the location
     */
    public Vehicle(int id, TaxiCompany company, Location location) { 
        this.id = id;
        this.company = company;
        this.service = null;
        this.status = Status.FREE;
        this.location = location;        
        this.destination = Functions.setRandomLocation(this.location);
        this.statistics = new Statistics();
        this.drive = setDrivePathToDestination(this.location, this.destination);
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
    public void pickService(Service service) {	
        
        this.service = service;
        this.destination = service.getPickupLocation();
        this.drive = setDrivePathToDestination(this.location, this.destination);
        this.status = Status.PICKUP;
    }

    /**
     * Start service.
     */
    @Override
    public void startService() {	
        
        this.destination = this.service.getDropoffLocation();
        this.drive = setDrivePathToDestination(this.location, this.destination);
        this.status = Status.SERVICE;
    }

    /**
     * End service.
     */
    @Override
    public void endService() {	
        
        this.statistics.updateBilling(this.calculateCost());
        this.statistics.updateDistance(this.service.calculateDistance());
        this.statistics.updateServices();
        
        
        if (this.service.getStars() != 0) {
            this.statistics.updateStars(this.service.getStars());
            this.statistics.updateReviews();
        }
        
        this.service = null;
        this.destination = Functions.setRandomLocation(this.location);
        this.drive = setDrivePathToDestination(this.location, this.destination);
        this.status = Status.FREE;
    }

    /**
     * Notify arrival at pickup location.
     *
     * @param vehicle the vehicle
     */
    @Override
    public void notifyArrivalAtPickupLocation(Vehicle vehicle) {	
        this.company.arrivedAtPickupLocation(vehicle);
        this.startService();
    }
        
    /**
     * Notify arrival at dropoff location.
     */
    @Override
    public void notifyArrivalAtDropoffLocation() {	
        this.company.arrivedAtDropoffLocation(this);
        this.endService();
     }
        
    /**
     * Checks if is free.
     *
     * @return true, if is free
     */
    @Override
    public boolean isFree() {
        return (this.status == Status.FREE);
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
                this.drive = setDrivePathToDestination(this.location, this.destination);
            }
            else {

                Location origin = this.service.getPickupLocation();
                Location destination = this.service.getDropoffLocation();

                if (this.location.getX() == origin.getX() && this.location.getY() == origin.getY()) {

                    notifyArrivalAtPickupLocation(this);

                } else if (this.location.getX() == destination.getX() && this.location.getY() == destination.getY()) {

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
    public String toString() {	// This function is heavily modified and part of it rewritten, since we now calculate the amount of blocks away during pickup and service to show in console.
        return this.id + " at " + this.location + " driving to " + this.destination +
               ((this.status == Status.FREE) ? " is free with path " + showDrive(this.drive) : 
                ((this.status == Status.PICKUP) ? " to pickup user " + this.service.getUser().getId() + ", " + Functions.distance(this.location, this.destination) + 
						" block(s) away." : " in service " + Functions.distance(this.location, this.service.getDropoffLocation()) + " block(s) away"));
    }
    
    /**
     * Sets the drive path to destination.
     *
     * @param location the location
     * @param destination the destination
     * @return the list
     */
    private List<Location> setDrivePathToDestination(Location location, Location destination) {
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