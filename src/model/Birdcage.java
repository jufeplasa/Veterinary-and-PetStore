package model;

public class Birdcage extends Habitat {
	
	//attributes
	private double height;
	private String kind;
	
	
	public Birdcage (double height, String kind, String id, double large, double width, String type) {
		super(id, large, width, type);
		this.setHeight(height);
		this.setKind(kind);
	}

	public Birdcage (int i) {
		super("50085"+i, 47.5, 70.6, "EMPTY");
		height=86.7;
		kind="hanging";
	}
	
	/**
	*This method get the height in the habitat.
	*@version 1.0
	*@return the height in the habitat.
	*/
	public double getHeight() {
		return height;
	}

	/**
	*This method allows change height the of habitat.
	*@version 1.0
	*@param height is the new height for the habitat.
	*/
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	*This method get the kind of animal can stay in the habitat.
	*@version 1.0
	*@return the kind of animal can stay in the habitat.
	*/
	public String getKind() {
		return kind;
	}
	
	/**
	*This method allows the kind of animal can stay in the habitat.
	*@version 1.0
	*@param kind is the new kind of bird for the habitat.
	*/
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	/**
	*This method shows all the information of the habitat 
	*@version 1.0
	*@return Information about the habitat.
	*/
	public String toString() {
		String message="";
		message=super.toString()+", the bird cage is type of "+kind+" and it has "+height+"cm of height" ;
		return message;
	}
}
