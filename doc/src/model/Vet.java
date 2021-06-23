package model;


public class Vet{

	//Attributes
	private String name;
	private String lastName;
	private String idVet;
	private String register;
	private String stats;
	private int numConsult;
	 
	//Relations
	private Pet consultation;
	
	//Methods
	public Vet(String name,String lastName,String idVet,String register,String stats){
		
		this.name=name;
		this.lastName=lastName;
		this.idVet=idVet;
		this.register=register;
		this.stats=stats;
		numConsult=0;
		consultation=null;
		
	}
	
	public String getName(){
		return name;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getIdVet(){
		return idVet;
	}
	
	public String getRegister(){
		return register;
	}
	
	public String getStats(){
		return stats;
	}
	
	public int getNumCosult(){
		return numConsult;
	}
	
	public Pet getConsultation(){
		return consultation;
	}
	
	public  void setStats(String stats){
		this.stats=stats;
	}
	
	public void setConsultation(Pet obj){
		consultation=obj;
	}
	
	public void countNumConsult(){
		numConsult++;
	}
}
	
	
