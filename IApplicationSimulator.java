/*
 * IApplicationSimulator.java
 * 
 * @autor Claudio, Jerry, Francisco, Joe
 * @since 5/6/2022
 */
package oober;

// TODO: Auto-generated Javadoc
/**
 * The Interface IApplicationSimulator.
 */
public interface IApplicationSimulator {
	
	/**
	 * User request.
	 */
	public void userRequest();
	
	/**
	 * Show.
	 */
	public void show();
	
	/**
	 * Update.
	 */
	public void update();
	
	/**
	 * Notify.
	 *
	 * @param message the message
	 */
	public void notify(String message);
	
	/**
	 * Gets the total services.
	 *
	 * @return the total services
	 */
	public int getTotalServices();
	
	/**
	 * Show statistics.
	 */
	public void showStatistics();
	
	/**
	 * Elon buys you.
	 */
	public void elonBuysYou();
}
