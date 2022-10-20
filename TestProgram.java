/*
 * TestProgram.java
 * 
 * @author Claudio, Jerry, Francisco, Joe
 * @since 5-6-2022
 */
package oober;

/**
 * The Class TestProgram.
 */
public class TestProgram {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        final int TOTAL_USERS = 5;
        final int TOTAL_VEHICLES = 3;
        final int TOTAL_RENTALS = 4;	// We changed this, since we added the rental vehicles.
        
        TaxiCompany taxify = new TaxiCompany("Oober", TOTAL_USERS, TOTAL_VEHICLES, TOTAL_RENTALS);	// We changed this, since now we account for rentals.
        ApplicationSimulator app = new ApplicationSimulator(taxify);
        
        taxify.addApplication(app);

        taxify.addUser(1, "Papa Jorge", "Adams");
        taxify.addUser(2, "Joe", "Adams");
        taxify.addUser(3, "Jerry", "Adams");
        taxify.addUser(4, "Claudio", "Adams");
        taxify.addUser(5, "Francisco", "Adams");
        /*taxify.addUser(6, "Samia", "Adams");
        taxify.addUser(7, "Jaira", "Adams");
        taxify.addUser(8, "Joey", "Adams");
        taxify.addUser(9, "Chloe", "Adams");
        taxify.addUser(10, "Bruh", "Adams");
        taxify.addUser(11, "Alex", "Adams");
        taxify.addUser(12, "Mohammed", "Adams");
        taxify.addUser(13, "Colleen", "Adams");
        taxify.addUser(14, "Sheila", "Adams");
        taxify.addUser(15, "Eric", "James");
        taxify.addUser(16, "Joe", "Mama");
        taxify.addUser(17, "Hugh", "Mongus");
        taxify.addUser(18, "David", "Smith");
        taxify.addUser(19, "Venger", "Lord of Evil");
        taxify.addUser(20, "Elon", "Musk");*/

        // application simulator
        
        app.elonBuysYou();
        app.show();
        
        for (int i=1; i<=5; i++)
            app.userRequest();
        
        do {

            app.show();
            app.update();
            
            if (Functions.rand() % 4 == 0)
            	app.userRequest();
            
        } while (app.getTotalServices() != 0);
        
        app.showStatistics();
    }

}