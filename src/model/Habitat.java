package model;

public abstract class Habitat {
	
	//Attributes
	private String idHabitat;
	private double large;
	private double width;
	
	//relations
	private Type type;
	private Pet guest;
	
	public Habitat(String id, double large, double width, String type) {
		idHabitat=id;
		this.large=large;
		this.width=width;
		this.type=Type.valueOf(type);
		guest=null;
	}
	/**
	*This method allows get the Id information of habitat
	*@version 1.0
	*@return the ID of the habitat.
	*/
	public String getIdHabitat() {
		return idHabitat;
	}
	/**
	*This method allows change the id of the habitat for a new ID.
	*@version 1.0
	*pre:  the new ID can't be null
	*@param idHabitat the new ID for the Habitat
	*/
	public void setIdHabitat(String idHabitat) {
		this.idHabitat = idHabitat;
	}
	/**
	*This method allows get the large information of habitat
	*@version 1.0
	*@return the large of the habitat.
	*/
	public double getLarge() {
		return large;
	}
	/**
	*This method allows change the large of the habitat for a new large.
	*@version 1.0
	*pre:  the new large can't be 0 
	*@param large is the new large in cm of the habitat
	*/
	public void setLarge(double large) {
		this.large = large;
	}
	
	/**
	*This method allows get the width information of habitat
	*@version 1.0
	*@return the width of the habitat.
	*/
	public double getWidth() {
		return width;
	}
	
	/**
	*This method allows change the width of the habitat for a new width.
	*@version 1.0
	*pre:  the new width can't be 0 
	*@param width is the new width in cm of the habitat
	*/
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	*This method allows get the type information of habitat
	*@version 1.0
	*@return the type of the habitat.
	*/
	public Type getType() {
		return type;
	}
	
	/**
	*This method allows change the type of the habitat for a new type.
	*@version 1.0
	*pre:  the new type can't be null 
	*@param type is the new type for the habitat.
	*/
	public void setType(Type type) {
		this.type = type;
	}

	/**
	*This method allows get the information of pet into habitat
	*@version 1.0
	*@return the pet into the habitat.
	*/
	public Pet getGuest() {
		return guest;
	}
	
	/**
	*This method allows change the pet into the habitat for a new pet or null.
	*@version 1.0
	*@param guest is the new pet into the habitat.
	*/
	public void setGuest(Pet guest) {
		this.guest = guest;
	}
	
	/**
	*This method shows all the information of the habitat 
	*@version 1.0
	*@return Information about the habitat.
	*/
	public String toString() {
		String message="";
		if(guest!=null) {
			message="the large is: "+large+"cm, width is: "+width+"cm, in the habitat is "+guest.getPetName()+" and it is "+type;
		}
		else {
			message="the large is: "+large+"cm, width is: "+width+"cm, the habitat is "+type;	
		}
		return message;
	}
	
	/**
	*This method returns one character to denotes the type of habitat. 
	*@version 1.0
	*@return A character of type from the habitat.
	*/
	public char showIdType() {
		char idType='V';
		switch(type) {
		
		case SICK:
			idType='E';
		break;
		
		case HEALTHY:
			idType='S';
		break;
		
		case EMPTY:
			idType='V';
		break;
		}
		return idType;
	}
	
}
