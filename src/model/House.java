package model;

public class House extends Habitat {
	
	//Attributes
	private int toys;
	
	public House(int toys, String id, double large, double width, String type) {
		super(id, large, width, type);
		this.setToys(toys);
	}
	
	public House(int i) {
		super("20045"+i, 80, 50, "EMPTY");
		toys=3;
	}
	
	/**
	*This method get the number of toys
	*@version 1.0
	*@return number of toys .
	*/
	public int getToys() {
		return toys;
	}

	/**
	*This method allows change the number of toys in the habitat.
	*@version 1.0
	*@param toys is the number of toys in the habitat.
	*/
	public void setToys(int toys) {
		this.toys = toys;
	}
	
	/**
	*This method shows all the information of the habitat 
	*@version 1.0
	*@return Information about the habitat.
	*/
	public String toString() {
		String message="";
		message=super.toString()+", the house for dogs has "+toys+" toys for the pet";
		return message;
	}
	
}
