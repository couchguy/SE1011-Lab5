

package kassd;

import java.util.Scanner;

public class SolarTest1 {

	/**
	 * @author Dr. Mark Sebern
	 * 10-12-2010
	 * 
	 * Tests the PvSystem class by allowing the user to specify
	 * and do performance calculations for a photovoltaic system.
	 * 
	 * This program also compares a reference system to the one specified
	 * by the user.
	 */
	public static void main(String[] args) {
		
		// Set up scanner for keyboard input
		Scanner inScan = new Scanner(System.in);
		
		// Get the system information from the user and use it
		// to customize the PvSystem object.
		
		System.out.println("Enter data for your PV system:");
		
		System.out.print("DC rating (watts): ");
		double dcRating = inScan.nextDouble();
		
		System.out.print("Derate factor: ");
		double derateFactor = inScan.nextDouble();
		
		System.out.print("Location (no spaces): ");
		String location = inScan.next();
		
		System.out.print("Cost per KWH ($): ");
		double costPerKwh = inScan.nextDouble();
		
		// Create a PvSystem object to represent a solar photovoltaic system.
		PvSystem system1 = new PvSystem();
		
		// Configure the PvSystem object with the user data.
		system1.setDcRating(dcRating);
		system1.setDerateFactor(derateFactor);
		system1.setCostPerKwh(costPerKwh);
		system1.setLocation(location);

		// Create another PvSystem object to represent a reference system.
		PvSystem system2 = new PvSystem();
		
		// Configure the PvSystem object with the user data.
		system2.setDcRating(4000.0);
		system2.setDerateFactor(0.77);
		system2.setCostPerKwh(0.227);
		system2.setLocation("Milwaukee");

		// Display the PV system configurations and calculation results
		// (mixing formatting methods to demonstrate alternatives).
		System.out.println("\nPV system configuration and calculation results:");
		System.out.print ("DC rating (watts) = ");
		System.out.print (String.format("%9.0f ",system1.getDcRating()));
		System.out.println (String.format("%9.0f",system2.getDcRating()));
		
		System.out.printf ("Derate factor     = %9.3f %9.3f\n",
				system1.getDerateFactor(),
				system2.getDerateFactor());
		
		System.out.printf ("Cost per KWH      = $%8.3f $%8.3f\n",
				system1.getCostPerKwh(),
				system2.getCostPerKwh());
		
		System.out.printf ("Location          = %9s %9s\n", 
				system1.getLocation(),
				system2.getLocation());
		
		System.out.printf ("Annual value      = $%8.2f $%8.2f\n", 
				system1.calculateAnnualEnergyValue(),
				system2.calculateAnnualEnergyValue());
		
		System.out.println ("Annual KWH        = " + 
				String.format("%9.0f ",system1.calculateAnnualKWH()) +
				String.format("%9.0f",system2.calculateAnnualKWH()));
	}
}