package model;

public class Pet{

//Attributes
	private String specie;
	private String petName;
	private int yearsOld;
	private String breed;
	private Priority priorit;
	private String symptoms;
	private Status stats;
	private  int days;
	
	//Relations
	private Owner ownerShip;
	private Vet doctor;
	private Habitat residency;
	
	//Methods
	public Pet(String specie,String petName,int yearsOld,String breed,int priority,String symptoms,String ownerName,String ownerId,String phone,String address){
		
		this.specie=specie;
		this.petName=petName;
		this.yearsOld=yearsOld;
		this.breed=breed;
		this.symptoms=symptoms;
		ownerShip=new Owner(ownerName,ownerId,phone,address);
		doctor=null;
		stats=Status.WAIT;
		residency=null;
		switch(priority){
			
				case 1:
					priorit=Priority.PRIORITY1;
				break;
					
				case 2:
					priorit=Priority.PRIORITY2;
				break;
			
				case 3:
					priorit=Priority.PRIORITY3;
				break;
				
				case 4: 
					priorit=Priority.PRIORITY4;
				break;
				
				case 5
				:
					priorit=Priority.PRIORITY5;
				break;
		}
	}
	
	public Pet(String specie, String petName, int yearsOld, String breed, String ownerName, String ownerId, String phone, String address, int days) {
		this.specie=specie;
		this.petName=petName;
		this.yearsOld=yearsOld;
		this.breed=breed;
		this.days=days;
		ownerShip=new Owner(ownerName,ownerId,phone,address);
	}
	
	public String getSpecie(){
		return specie;
	}
	
	public String getPetName(){
		return petName;
	}
	
	public int getYearsOld(){
		return yearsOld;
	}
	
	public String getBreed(){
		return breed;
	}
	
	public Priority getPriority(){
		return priorit;
	}
	
	public String getSymptoms(){
		return symptoms;
	}
	
	public Status getStatus(){
		return stats;
	}
	
	public Owner getOwner(){
		return ownerShip;
	}
	public Vet getDoctor(){
		return doctor;
	}
	
	public void setStatus(String status){
		switch(status){
			
				case "WAIT":
					stats=Status.WAIT;
				break;
					
				case "CONSULT":
					stats=Status.CONSULT;
				break;
			
				case "HOSPITALIZATION":
					stats=Status.HOSPITALIZATION;
				break;
				
				case "EXIT": 
					stats=Status.EXIT;
				break;
				
				case "EXIT_WITHOUT_ATTENTION":
					stats=Status.EXIT_WITHOUT_ATTENTION;
				break;
		}
	}
	
	public void setDoctor(Vet obj){
		doctor=obj;
	}
	
	public String enterIntoConsult(Vet obj){
		String message="";
		doctor=obj;
		message="The vet "+doctor.getName()+" with id "+doctor.getIdVet()+" will treat "+specie+": "+petName;
		stats=Status.CONSULT;
		return message;
	}

	public Habitat getResidency() {
		return residency;
	}

	public void setResidency(Habitat residency) {
		this.residency = residency;
	}
	
	public String showResidency() {
		String message="";
		message="The pet is in the petStore on habitat  with ID: "+residency.getIdHabitat()+" and it is "+residency.getType();
		return message;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	

}