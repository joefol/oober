/*
 * TaxiCompany.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class TaxiCompany.
 */
public class TaxiCompany implements ITaxiCompany {
    
    /** The name. */
    private String name;
    
    /** The total users. */
    private int totalUsers;
    
    /** The users. */
    private User [] users;
    
    /** The total vehicles. */
    private int totalVehicles;
    
    /** The vehicles. */
    private Vehicle [] vehicles;
    
    /** The total services. */
    private int totalServices;
    
    /** The user index. */
    private Map<Integer, Integer> userIndex;
    
    /** The application. */
    private ApplicationSimulator application;
    
    /** The rentals. */
    private RentalVehicle [] rentals;		// Since we added rentals, we need to have a totalRentals variable, as well as an array with all of them.
    
    /** The total rentals. */
    private int totalRentals;
    
    /**
     * Instantiates a new taxi company.
     *
     * @param name the name
     * @param totalUsers the total users
     * @param totalVehicles the total vehicles
     * @param totalRentals the total rentals
     */
    public TaxiCompany(String name, int totalUsers, int totalVehicles, int totalRentals){
        this.name = name;
        this.totalVehicles = totalVehicles;
        this.vehicles = new Vehicle[totalVehicles];
        this.totalUsers = 0;
        this.users = new User[totalUsers];
        this.totalServices = 0;
        this.userIndex = new HashMap<Integer, Integer>();
        this.application = null;
        this.totalRentals = totalRentals;
        this.rentals = new RentalVehicle[totalRentals];
        
        setupVehicles();
        setupRentals();
    }
    
    /**
     * Gets the name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Gets the total services.
     *
     * @return the total services
     */
    @Override
    public int getTotalServices() {
        return this.totalServices;
    }
    
    /**
     * Gets the available user for request.
     *
     * @return the available user for request
     */
    public int getAvailableUserForRequest() {        
        
        if (Functions.rand() % 2 == 0) {
            for (int i=0; i<this.totalUsers; i++) 
                if (!this.users[i].getService())
                    return this.users[i].getId();
        } else {
            for (int i=this.totalUsers-1; i>=0; i--)
                if (!this.users[i].getService())
                    return this.users[i].getId();
        }

        return -1;
    }

    /**
     * Request service.
     *
     * @param user the user
     * @return true, if successful
     */
    @Override
    public boolean requestService(int user) {
        int index = findFreeVehicle();	// This is one of the main changes of this version of the project. We call a modified version of findFreeVehicle().
        int index2 = findFreeRental();
        // we will create two indexes, one for the free vehicle and another for the free rental, then we will decide randomly whether the users take a rental or a taxi.
        
        int random = Functions.rand(9767);
        if (random % 2 == 0) {
        	if (index != -1) {
                Location origin, destination;
                
                do {
                    origin = this.getUser(user).getLocation();
                    destination = Functions.setRandomLocation(origin);
                    
                } while (Functions.distance(origin, this.vehicles[index].getLocation()) <= 2);
                
                // update the user status
                
                this.users[this.userIndex.get(user)].setService(true);
                this.users[this.userIndex.get(user)].setLocation(destination);
                
                // create a service with the user, the pickup and the drop-off location

                Service service = new Service(this.getUser(user), origin, destination);
                
                // assign the new service to the vehicle
                
                this.vehicles[index].pickService(service);            
                 
                this.application.notify("User " + user + " requests a service from " + service.toString() + ", the ride is assigned to " +
                                 this.vehicles[index].getClass().getSimpleName() + " " + this.vehicles[index].getId() + " at location " +
                                 this.vehicles[index].getLocation().toString());            
                
                // update the counter of services
                
                this.totalServices++;
                
                return true;
            }
            
            return false;
        }
        else {	// This section here is written to accommodate for rental vehicles, since 50% of the users take a rental vehicle.
        	if (index2 != -1) {
                Location origin, destination;
                
                do {
                    origin = this.rentals[index2].getLocation();			// the origin of the rental ride is the location of the available vehicle.		 
                    destination = Functions.setRandomLocation(origin);		// the destination is randomly generated.
                    
                } while (Functions.distance(origin, destination) <= 2);
                
                
                this.users[this.userIndex.get(user)].setService(true);                
                // create a service with the user, the pickup and the drop-off location
                
                Service service = new Service(this.getUser(user), origin, destination);
                
                // assign the new service to the vehicle
                
                this.rentals[index2].pickService(service);            
                 
                this.application.notify("User " + user + " rents a rental vehicle from " + service.toString() + ", he takes  " +
                                 this.rentals[index2].getClass().getSimpleName() + " " + this.rentals[index2].getId() + " at location " +
                                 this.rentals[index2].getLocation().toString());        	// we modified this, since the messages given must be different.    
                
                // update the counter of services
                
                this.totalServices++;
                
                return true;
            }
            
            return false;
        }
        
        
    }

    /**
     * Arrived at pickup location.
     *
     * @param vehicle the vehicle
     */
    @Override
    public void arrivedAtPickupLocation(Vehicle vehicle) {
        // a vehicle arrives at the pickup location
        
        this.application.notify(String.format("%-8s",vehicle.getClass().getSimpleName()) + vehicle.getId() + " loads user " + vehicle.getService().getUser().getId());        
    }
    
    /**
     * Arrived at pickup location.
     *
     * @param vehicle the vehicle
     */
    @Override
    public void arrivedAtPickupLocation(RentalVehicle vehicle) {	// This functions is left unused.
        // a vehicle arrives at the pickup location
        
        this.application.notify(String.format("%-8s", "User " + vehicle.getService().getUser().getId()+ " gets in to rental " + vehicle.getClass().getSimpleName() + " " + vehicle.getId()));        
    }
    
    /**
     * Arrived at dropoff location.
     *
     * @param vehicle the vehicle
     */
    @Override
    public void arrivedAtDropoffLocation(Vehicle vehicle) {
        
        Service service = vehicle.getService();       
        int user = service.getUser().getId();
       
        this.users[this.userIndex.get(user)].rateService(service);
        this.users[this.userIndex.get(user)].setService(false);
        this.users[this.userIndex.get(user)].setLocation(vehicle.getLocation());	// This is another change to the code, as when the user is dropped off, we must also update its location.
        
        this.totalServices--;        
        this.application.notify(String.format("%-8s",vehicle.getClass().getSimpleName()) + vehicle.getId() + " drops off user " + user);         
    }
    
    /**
     * Arrived at dropoff location.
     *
     * @param vehicle the vehicle
     */
    @Override
    public void arrivedAtDropoffLocation(RentalVehicle vehicle) {
        // A Rental Vehicle arrives at the drop-off location, 
        
        Service service = vehicle.getService();       
        int user = service.getUser().getId();
       
        this.users[this.userIndex.get(user)].setService(false);
        this.users[this.userIndex.get(user)].setLocation(vehicle.getLocation());	// This is another change to the code, as when the user is dropped off, we must also update its location.
        
        this.totalServices--;        
        this.application.notify(String.format("%-8s", "User " + vehicle.getService().getUser().getId() + " gets off rental " + vehicle.getClass().getSimpleName() + " " + vehicle.getId()));        
    }

    /**
     * Setup vehicles.
     */
    private void setupVehicles() {        
        for (int i=0; i<this.totalVehicles; i++) {   
            if (Functions.rand() % 2 == 0)
                this.vehicles[i] = new Taxi(i+1, this, Functions.setRandomLocation());
            else
                this.vehicles[i] = new Shuttle(i+1, this, Functions.setRandomLocation());
        }
    }
    
    /**
     * Setup rentals.
     */
    private void setupRentals() {
        // This function creates new rentals at the start of the code at random positions.
        
        for (int i=0; i<this.totalRentals; i++) {   
            if (Functions.rand() % 2 == 0)
                this.rentals[i] = new Car(i+1, this, Functions.setRandomLocation());
            else
                this.rentals[i] = new Scooter(i+1, this, Functions.setRandomLocation());
        }
    }
    
    // For both of these methods, the main issue came with us not being able to reliably return the index value of -1 when there is not an available car for the user.
    // The function findClosestFreeVehicle(user) will go through the vehicles[] array and find the distance between the vehicle and the user until the end of the array, keeping the 
    // minimum value of the distance, as well as the index position of the vehicle that is close. That index is what it returns so we can assign a service to it.
    
    /* private int findClosestFreeVehicle(int user) {
    	int tempPos = 0; int minDistance = Functions.distance(this.vehicles[0].getLocation(), this.getUser(user).getLocation()); int index = 0;
    	for (int i = 0; i < this.vehicles.length; i++) {
    		if (this.vehicles[i].isFree()) {
    			tempPos = i;
    			int distance = Functions.distance(this.vehicles[i].getLocation(), this.getUser(user).getLocation());
    			if (distance < minDistance)
    				minDistance = distance;
    				index = tempPos;
    		}
    	}
    	return index;
    } */
    
    /* private int findClosestFreeVehicle(int user) {
    	int tempPos = 0; int minDistance = Functions.distance(this.vehicles[0].getLocation(), this.getUser(user).getLocation()); int index = 0;
    	Map<Vehicle><Integer> freeVehicles = new ArrayList<Vehicle>();
    																		
    	for (int i = 0; i < this.vehicles.length; i++) {					
    		if (this.vehicles[i].isFree()) {
    			freeVehicles.add(this.vehicles[i]);
    		}
    	}
    	
    	for (int i = 0; i < this.vehicles.length; i++) {
    		 
    			tempPos = i;
    			int distance = Functions.distance(this.vehicles[i].getLocation(), this.getUser(user).getLocation());
    			if (distance < minDistance)
    				minDistance = distance;
    				index = tempPos;
    		
    	}
    	return index;
    }*/	
    
    /**
     * Find free vehicle.
     *
     * @return the int
     */
    private int findFreeVehicle() {	// This is the main drawback of our implementation, since we were not able to implement the find closest vehicle to user in our project on time. See above for
    								// our commented trials on doing it.
        
        if (Functions.rand() % 2 == 0) {
            for (int i=0; i<this.totalVehicles; i++)
                if (this.vehicles[i].isFree())
                    return i;
        } else {
            for (int i=this.totalVehicles-1; i>=0; i--) 
                if (this.vehicles[i].isFree())
                    return i;
        }
       
        return -1;
    }
    
    /**
     * Find free rental.
     *
     * @return the int
     */
    private int findFreeRental() {		// Rental vehicles do not need any kind of find closest vehicle, since the service starts by setting the users location to directly where the rental is.
        
        if (Functions.rand() % 2 == 0) {
            for (int i=0; i<this.totalRentals; i++)
                if (this.rentals[i].isAVAILABLE())
                    return i;
        } else {
            for (int i=this.totalRentals-1; i>=0; i--) 
                if (this.rentals[i].isAVAILABLE())
                    return i;
        }
       
        return -1;
    }
    
    /**
     * Adds the user.
     *
     * @param id the id
     * @param firstName the first name
     * @param lastName the last name
     */
    @Override
    public void addUser(int id, String firstName, String lastName) {
        this.userIndex.put(id, this.totalUsers);
        this.users[this.totalUsers++] = new User(id, firstName, lastName, this);
    }    
    
    /**
     * Adds the application.
     *
     * @param application the application
     */
    @Override
    public void addApplication(ApplicationSimulator application) {
        this.application = application;
    }
    
    /**
     * Notify application.
     *
     * @param message the message
     */
    @Override
    public void notifyApplication(String message) {
        this.application.notify(message);
    }
    
    /**
     * Gets the user.
     *
     * @param id the id
     * @return the user
     */
    @Override
    public User getUser(int id) {
        for (int i=0; i<this.totalUsers; i++)        
            if (this.users[i].getId() == id)
                return this.users[i];
        
        return null;
    }
    
    /**
     * Show.
     *
     * @return the string
     */
    @Override
    public String show() {
        String s = "\n" + this.getName() + " Status Update: \n";
        for (int i=0; i<this.totalVehicles; i++) {
            s = s + "\n" + this.vehicles[i].toString();
        }   
        for (int i=0; i<this.totalRentals; i++) {
            s = s + "\n" + this.rentals[i].toString();
        }   
        
        return s;
    }
    
    /**
     * Show statistics.
     *
     * @return the string
     */
    @Override
    public String showStatistics() {
        String s = "\n" + this.getName() + " Statistics of Services and Rentals: \n";
        
        for (int i=0; i<this.totalVehicles; i++) {
            s = s + "\n" + 
                String.format("%-8s", this.vehicles[i].getClass().getSimpleName()) + this.vehicles[i].getId() + " " +
                String.format("%2s", this.vehicles[i].getStatistics().getServices()) + " services " + 
                String.format("%3s", this.vehicles[i].getStatistics().getDistance()) + " total km. " +
                String.format("%3s", this.vehicles[i].getStatistics().getBilling()) + " total eur. " +
                String.format("%2s", this.vehicles[i].getStatistics().getReviews()) + " reviews " +
                String.format("%-4s", this.vehicles[i].getStatistics().getStars()) + " total stars";
        }
        
        for (int i=0; i<this.totalRentals; i++) {	// Rental cars also take into account statistics, but they do not take reviews and stars into account.
            s = s + "\n" + 
                String.format("%-8s", this.rentals[i].getClass().getSimpleName()) + this.rentals[i].getId() + " " +
                String.format("%2s", this.rentals[i].getStatistics().getServices()) + " services " + 
                String.format("%3s", this.rentals[i].getStatistics().getDistance()) + " total km. " +
                String.format("%3s", this.rentals[i].getStatistics().getBilling()) + " total eur. ";
        }
                
        return s;        
    }
    
    /**
     * Update.
     */
    @Override
    public void update() {	// We modified this function, since each update must make the rentals and vehicles move. 
        for (int i=0; i<this.totalVehicles; i++) {
            this.vehicles[i].move();
        }
        for (int i=0; i<this.totalRentals; i++) {
            this.rentals[i].move();	// this here is the reason as to why we couldn't figure out a way to leave the scooters stationary while also moving the ones in service.
        }
    }    
}