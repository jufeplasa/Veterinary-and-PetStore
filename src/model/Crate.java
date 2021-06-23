package model;

public class Crate extends Habitat  {
	//Attributes
	private double height;
	private double weight;
	public Crate(double height, double weight, String id, double large, double width, String type) {
		super(id, large, width, type);
		this.height=height;
		this.weight=weight;
	}
	
	public Crate(int i) {
		super("10012"+i, 70, 40,"EMPTY");
		height=50;
		weight=90.5;
	}
	
	/**
	*This method get the height of the habitat 
	*@version 1.0
	*@return the height of the crate .
	*/
	public double getHeight() {
		return height;
	}
	
	/**
	*This method allows change the height of the habitat.
	*@version 1.0
	*@param height is the new height for the Crate.
	*/
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	*This method get the weight of the habitat 
	*@version 1.0
	*@return the weight of the crate .
	*/
	public double getWeight() {
		return weight;
	}
	
	/**
	*This method allows change the weight of the habitat.
	*@version 1.0
	*@param weight is the new weight for the Crate.
	*/
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	/**
	*This method shows all the information of the habitat 
	*@version 1.0
	*@return Information about the habitat.
	*/
	public String toString() {
		String message="";
		message=super.toString()+", also the crate has "+height+"cm of height and supports "+weight+"kg of weight";
		return message;
	}
}
