package kassd;

public class PvSystem {
	
	//These are the variables that can only be changed in the method.
	private double dcRating = 0.0;
	private double derateFactor = 0.0;
	private double costPerKwh = 0.0;
	private String location;
	
	
	//this allows the setting of dcRating
	public void setDcRating(double dcRating){
		this.dcRating = dcRating;
	}
	
	//this allows the setting of derateFactor
	public void setDerateFactor(double derateFactor){
		this.derateFactor = derateFactor;
	}
	
	//this allows the setting of costPerKwh
	public void setCostPerKwh(double costPerKwh){
		this.costPerKwh = costPerKwh;
	}
	
	//this allows the setting of location
	public void setLocation(String location){
		this.location = location;
	}
	
	//this allows dcRating to be set to a number
	public double getDcRating(){
		return this.dcRating;
	}
	
	//this allows derateFactor to be set to a number
	public double getDerateFactor(){
		return this.derateFactor;
	}
	
	//this allows costPerKwh to be set to a number
	public double getCostPerKwh(){
		return this.costPerKwh;
	}
	
	//this allows for the location to be set
	public String getLocation(){
		return this.location;
	}
	
	//this does the calculatin for amount of power being used
	public double calculateAnnualKWH(){
		double yieldFactor = 0;
		double annualKWH = 0;
		//sets the yieldFactor for each of the cities 
		if (location.equalsIgnoreCase("EauClaire")){
			yieldFactor = 1.564;
		}else if (location.equalsIgnoreCase("Milwaukee")){
			yieldFactor = 1.594;
		}else if (location.equalsIgnoreCase("Phoenix")){
			yieldFactor = 2.100;
		}else if (location.equalsIgnoreCase("Seattle")){
			yieldFactor = 1.259;
		}
		annualKWH = dcRating * derateFactor * yieldFactor;
		return annualKWH;
	}
	
	//does the calculation to detrime the total cost of the annual energy
	public double calculateAnnualEnergyValue(){
		double cost;
		cost = calculateAnnualKWH() * costPerKwh;
		return cost;
	}
}

