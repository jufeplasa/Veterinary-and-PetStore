package model;

public class Aquarium extends Habitat {
	
	//attributes
	public static final String AB="ANFIBIUS";
	public static final String TA="TERRA";
	private String kind;
	private String material;
	
	public Aquarium (String kind, String material, String id, double large, double width, String type) {
		super(id, large, width, type);
		this.setKind(kind);
		this.setMaterial(material);
	}
	
	public Aquarium (int i) {
		super("40014"+i, 90.45, 70.26,"EMPTY");
		kind=TA;
		material="sand";
	}

	/**
	*This method get the kind of animal is the aquarium for.
	*@version 1.0
	*@return for what kind of reptile is the aquarium .
	*/
	public String getKind() {
		return kind;
	}

	/**
	*This method allows change the kind of animal is the aquarium for.
	*@version 1.0
	*@param kind is the kind of animal for the habitat.
	*/
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	*This method get the material of the aquarium is made.
	*@version 1.0
	*@return the material of the habitat .
	*/
	public String getMaterial() {
		return material;
	}

	/**
	*This method allows change the material of habitat.
	*@version 1.0
	*@param material is the new material for the habitat.
	*/
	public void setMaterial(String material) {
		this.material = material;
	}
	
	/**
	*This method shows all the information of the habitat 
	*@version 1.0
	*@return Information about the habitat.
	*/
	public String toString() {
		String message="";
		message=super.toString()+", this aquarium is for"+kind+" and the material is : "+material;
		return message;
	}
}
