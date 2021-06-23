package model;


public class Owner{

//Attributes
	private String name;
	private String id;
	private String phone;
	private String address;
	

	
	//Methods
	public Owner(String ownerName,String ownerId,String phone,String address){
		
		name=ownerName;
		id=ownerId;
		this.phone=phone;
		this.address=address;
 
	} 
	
	public String getName(){
		return name;
	}
	
	public String getId(){
		return id;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getAddress(){
		return address;
	}
}