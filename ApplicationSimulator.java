/*
 * ApplicationSimulator.java
 * 
 * @autor Claudio, Jerry, Joe, Francisco
 * @since 5-6-2022
 */
package oober;

/**
 * The Class ApplicationSimulator.
 */
public class ApplicationSimulator implements IApplicationSimulator {
    
    /** The company. */
    private TaxiCompany company;
    
    /**
     * Instantiates a new application simulator.
     *
     * @param company the company
     */
    public ApplicationSimulator(TaxiCompany company) {
        this.company = company;
    }
    
    /**
     * User request.
     */
    @Override
    public void userRequest() {
        int user = this.company.getAvailableUserForRequest();
        
        if (user != -1)
            this.company.requestService(user);
    }
    
    /**
     * Show.
     */
    @Override
    public void show() {
        System.out.println(this.company.show());
    }
    
    /**
     * Update.
     */
    @Override
    public void update() {
        this.company.update();
    }
    
    /**
     * Notify.
     *
     * @param message the message
     */
    @Override
    public void notify(String message) {
        System.out.println(message);
    }
    
    /**
     * Gets the total services.
     *
     * @return the total services
     */
    @Override
    public int getTotalServices() {
        return this.company.getTotalServices();
    }
    
    /**
     * Show statistics.
     */
    @Override
    public void showStatistics() {
        System.out.println(this.company.showStatistics());
    }
    
    /**
     * Elon buys you.
     */
    public void elonBuysYou() { // Maybe... just maybe...
    	int chance = Functions.rand(69);
    	
    	if (chance % 4 == 0) {
    		System.out.println("				â „â „â „â „â „â „â£€â£€â£€â£¤â£¶â£¿â£¿â£¶â£¶â£¶â£¤â£„â£ â£´â£¶â£¿â£¿â£¿â£¿â£¶â£¦â£„â „â „\n"
    				+ "â „â „â£ â£´â£¾â£¿â ¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¦\n"
    				+ "â¢ â ¾â£‹â£­â£„â¡€â „â „â ˆâ ™â »â£¿â£¿â¡¿â ›â ‹â ‰â ‰â ‰â ™â ›â ¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â¡Žâ£¾â¡Ÿâ¢»â£¿â£·â „â „â „â „â „â¡¼â£¡â£¾â£¿â£¿â£¦â „â „â „â „â „â ˆâ ›â¢¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â¡‡â¢¿â£·â£¾â£¿â Ÿâ „â „â „â „â¢°â �â£¿â£‡â£¸â£¿â£¿â „â „â „â „â „â „â „â£ â£¼â£¿â£¿â£¿â£¿\n"
    				+ "â¢¸â£¦â£­â£­â£„â£¤â£¤â£¤â£´â£¶â£¿â£§â¡˜â »â ›â ›â �â „â „â „â „â£€â£´â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â „â¢‰â£¹â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£·â£¶â£¦â£¶â£¶â£¶â£¶â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â¢°â¡¿â ›â ›â ›â ›â »â ¿â ¿â¢¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â ¸â¡‡â „â „â¢€â£€â£€â „â „â „â „â „â ‰â ‰â ›â ›â »â ¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â „â ˆâ£†â „â „â¢¿â£¿â£¿â£¿â£·â£¶â£¶â£¤â£¤â£€â£€â¡€â „â „â ‰â¢»â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â „â „â£¿â¡€â „â ¸â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â ‚â „â¢ â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â „â „â£¿â¡‡â „â „â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â¡¿â ƒâ „â¢€â£¼â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â „â „â£¿â¡‡â „â  â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â¡¿â ‹â „â „â£ â£¾â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿\n"
    				+ "â „â „â£¿â �â „â �â ›â ›â ›â ›â ‰â ‰â ‰â ‰â „â „â£ â£¾â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â¡¿\n"
    				+ "â „â „â »â£¦â£€â£€â£€â£€â£€â£€â£¤â£¤â£¤â£¤â£¶â£¾â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â£¿â¡¿â ‹â „");
    		System.out.println("\tCongratulations! Elon Musk bought OOBER for a total of 53 Billion Dollars. You are now rich and enslaved!");
    	}
    	else {
    		System.out.println("Taxify - Version 2.0 : by Jerry, Claudio, Joe, and Francisco.");
    	}		
   	}
}