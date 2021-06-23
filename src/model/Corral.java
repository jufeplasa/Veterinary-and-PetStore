package model;

public class Corral extends Habitat {
	
	//attributes
	private String plant;
	private int numPlant;
	
	public Corral (String plant, int numPlant, String id, double large, double width, String type) {
		super(id, large, width, type);
		this.plant=plant;
		this.numPlant=numPlant;
	}
	
	public Corral (int i) {
		super("30078"+i, 100, 80, "EMPTY");
		plant="carrot";
		numPlant=5;
	}

	/**
	*This method get the plant in the corral.
	*@version 1.0
	*@return the plant in the corral .
	*/
	public String getPlant() {
		return plant;
	}

	/**
	*This method allows change the plant for the corral.
	*@version 1.0
	*@param plant is new plant for the corral.
	*/
	public void setPlant(String plant) {
		this.plant = plant;
	}

	/**
	*This method get the number of plant in the corral.
	*@version 1.0
	*@return number of plant in the corral .
	*/
	public int getNumPlant() {
		return numPlant;
	}

	/**
	*This method allows change the number of plant for the corral.
	*@version 1.0
	*@param numPlant is new number of plant for the corral.
	*/
	public void setNumPlant(int numPlant) {
		this.numPlant = numPlant;
	}
	
	/**
	*This method shows all the information of the habitat 
	*@version 1.0
	*@return Information about the habitat.
	*/
	public String toString() {
		String message="";
		message=super.toString()+", in the corral there are "+numPlant+" of "+plant;
		return message;
	}
}
