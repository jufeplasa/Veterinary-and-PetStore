package model;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class PetCare{
	
	public static final int TOTALVETS=7;
	public static final int NUMLINE=6;
	public static final int NUMCOLUMN=5;
	
	//Relations
	private Vet[] employee;
	private ArrayList<Pet> patient;
	private Habitat[][] habitat;
	
	//Methods
	public PetCare(String horario){
		employee=new Vet[TOTALVETS];
		patient=new ArrayList<Pet>();
		habitat=new Habitat[NUMLINE][NUMCOLUMN];
		for(int i=0;i<habitat.length; i++) {
			for(int j=0;j<habitat[0].length;j++) {
				if(i<3) {
					if(j<3) {
						habitat[i][j]=new Crate(i+j);
					}
					else if((j==3||j==4)&&i<2) {
						habitat[i][j]=new Aquarium(i+j);
					}
					else if((j==3||j==4)&&i==2) {
						habitat[i][j]=new Corral(i+j);
					}
				}
				else if(i<6) {
					if(j<3) {
						habitat[i][j]=new House(i+j);
					}
					else if((j==3||j==4)&&i==3) {
						habitat[i][j]=new Corral(i+j);
					}
					else if((j==3||j==4)&&i<6) {
						habitat[i][j]=new Birdcage(i+j);
					}
				}
			}
		}
	}
	
	/**
	*This method allows get an object habitat.
	*@version 1.0
	*@return habitat is an object with a habitat's information.
	*/
	
	public Habitat[][] getHabitat() {
		return habitat;
	}
	
	public void setHabitat(Habitat[][] habitat) {
		this.habitat = habitat;
	}
	
	/**
	*This method search a veterinarian into pet care with a id.
	*@version 1.0
	*pre:  the parameter has to be a String also it can't be null
	*post the return can be an object of type Vet or null.
	*@param id it's the id of veterinarian to search in pet care.
	*@return An object of type Vet.
	*/
	public Vet searchIdVet(String id){
		Vet find=null;
		boolean continuar=true;
		for(int i=0;i<TOTALVETS&&continuar;i++){
			if(employee[i]!=null && employee[i].getIdVet().equalsIgnoreCase(id)){
				find=employee[i];
				continuar=false;
			}
		}
		return find;
	}
	
	/**
	*This method create a new veterinarian with the parameters enter by the user.
	*@version 1.0
	*pre:  the parameters can't be null
	*post the message have to notify if the veterinarian was created or there is an error.
	*@param name the name of the veterinarian 
	*@param lastName the veterinarian's last name
	*@param idVet the identification of veterinarian 
	*@param register It's the professional register of veterinarian
	*@param stats the status of veterinarian 
	*@return a message to notify the veterinarian was created.
	*/
	public String addVet(String name,String lastName,String idVet,String register,String stats){
		Vet sameId=searchIdVet(idVet);
		String message="";
		boolean continuar=true;
		if(sameId!=null){
			message=" Error. The veterinary already exist";
		}
		else{
			for(int i=0;i<TOTALVETS && continuar ;i++){
				if(employee[i]==null){
					employee[i]=new Vet(name,lastName,idVet,register,stats);
					continuar=false;
					message="the vet has been ingresed successfully.";
				}
			}
			if(continuar){
				message="Error. the limit of veterinaries is full.";
			}
		}
		return message;
	}
	
	/**
	*This method deleted one veterinarian when it is already exist
	*@version 1.0
	*pre:  the parameters can't be null
	*post the message have to notify if veterinarian was deleted or there is an error.
	*@param id it's the parameter to delete the veterinarian with that id.
	*@return a message to notify the veterinarian was deleted
	*/
	public String delete(String id){
		String message="";
		boolean continuar=true;
		for(int i=0;i<patient.size()&&continuar;i++){
			if(patient.get(i)!=null){
				message="The veterinary can't be delete it, due to there are pets registered";
				continuar=false;
			}
		}
		if(continuar){
			for(int i=0;i<TOTALVETS&&continuar;i++){
				if(employee[i]!=null && employee[i].getIdVet().equalsIgnoreCase(id)){
					employee[i]=null;
					continuar=false;
					message="the vet has been deleted successfully.";
				}
			}	
		}
		return message;
	}
	
	/**
	*This method search a pet  into pet care 
	*@version 1.0
	*pre:  the parameters can't be null
	*post the return can be a object null or with information
	*@param name the name of the pet
	*@param id the identification of the owner.
 	*@return An object of type Pet. 
	*/
	public Pet searchNamePet(String name, String id){
		Pet find=null;
		for(int i=0;i<patient.size();i++){	
			if(patient.get(i)!=null && patient.get(i).getPetName().equalsIgnoreCase(name)&&patient.get(i).getOwner().getId().equalsIgnoreCase(id)){
				find=patient.get(i);
			}
		}
		return find;
	}
	
	/**
	*This method creates a pet into pet care
	*@version 1.0
	*pre:  the parameters of type String can't be null.
	*pre:  the priority can't be 0 or more than 5.
	*post the message have to notify if the pet was created or there is an error.
	*@param specie it's the specie of the pet 
	*@param petName the name of the pet. 
	*@param yearsOld it's the age of the pet
	*@param breed it's a group of the specie, where the pet belongs there.
	*@param priority it's a number to know the emergency for the pet
	*@param symptoms to know what happens with the pet.
	*@param ownerName the name of the owner
	*@param ownerId the identification of the owner
	*@param phone the phone number of the owner
	*@param address the address of the owner
	*@return A message to notify the pet was created.
	*/
	public String addPet(String specie,String petName,int yearsOld,String breed,int priority,String symptoms,String ownerName,String ownerId,String phone,String address){
		Pet samePet=searchNamePet(petName,ownerId);
		String message="";
		if(samePet!=null){
			message=" Error. The pet has been ingresed with the same owner";
		}
		else{
			patient.add(new Pet(specie,petName,yearsOld,breed,priority,symptoms,ownerName,ownerId,phone,address));
			message="The pet has been ingresed successfully.";
		}
		return message;
	}
	
	/**
	*This method is for the pet when exit with out attention so, switch it status to "EXIT_WITHOUT_ATTENTION"
	*@version 1.0
	*pre:  the parameters belong to a pet is already in the petCare 
	*post if the status of the pet is "WAIT" the pet can "EXIT_WITHOUT_ATTENTION", else it can't exit.
	*@param namePet name of the pet that will exit with out attention
	*@param idOwner Id of the owner.
	*@return A message to notify the has exited 
	*/
	public String exitForNotAttentionPet(String namePet, String idOwner){
		String message="";
		Status status=Status.WAIT;
		Pet findPet=searchNamePet(namePet,idOwner);
		if(findPet==null){
			message="Error. The pet hasn't entered to the center";
		}
		else{	
			if(findPet.getStatus()==status){
				findPet.setStatus("EXIT_WITHOUT_ATTENTION");
				message="The pet has "+findPet.getStatus();	
			}
			else{
				message="The pet can't leave of the center, because it status is: "+findPet.getStatus()+"\n";
			}
			
		}
		return message;
	}
	
	/**
	*This method search all the veterinarians that are available and then shows them.
	*@version 1.0
	*@return A message with all the veterinarians that are available 
	*/
	public String vetAvailable(){
		String message="";	
		int b=0;
		for(int i=0;i<TOTALVETS;i++){
			if(employee[i]!=null&&employee[i].getStats().equalsIgnoreCase("AVAILABLE")){
				message+="The vet "+employee[i].getName()+" with ID "+employee[i].getIdVet()+" is "+employee[i].getStats()+"\n";
				b++;
			}
		}
		if(b==0){
			message="There aren't veterinaries registered.";
		}
		return message;
	}
	
	/**
	*This method search the pet first pet with the priority most important to star the consult with it.
	*@version 2.0
	*@return An a object of kind Pet, with the pet with priority most important at the moment.
	*/
	public Pet nextPatient(){
		Pet find=null;
		boolean continuar=true;
		for(int i=0;i<patient.size() && continuar;i++){
			if(patient.get(i)!=null&&(patient.get(i).getStatus()==Status.WAIT)&&patient.get(i).getPriority()==Priority.PRIORITY1){
				continuar=false;
				find=patient.get(i);
			}
		}
		if(find==null){
			for(int i=0;i<patient.size() && continuar;i++){
				if(patient.get(i)!=null&&(patient.get(i).getStatus()==Status.WAIT)&&patient.get(i).getPriority()==Priority.PRIORITY2){
					continuar=false;
					find=patient.get(i);
				}
			}
		}
		if(find==null){
			for(int i=0;i<patient.size() && continuar;i++){
				if(patient.get(i)!=null&&(patient.get(i).getStatus()==Status.WAIT)&&patient.get(i).getPriority()==Priority.PRIORITY3){
					continuar=false;
					find=patient.get(i);
				}
			}
		}
		if(find==null){
			for(int i=0;i<patient.size() && continuar;i++){
				if(patient.get(i)!=null&&(patient.get(i).getStatus()==Status.WAIT)&&patient.get(i).getPriority()==Priority.PRIORITY4){
					continuar=false;
					find=patient.get(i);
				}
			}
		}
		if(find==null){
			for(int i=0;i<patient.size() && continuar;i++){
				if(patient.get(i)!=null&&(patient.get(i).getStatus()==Status.WAIT)&&patient.get(i).getPriority()==Priority.PRIORITY5){
					continuar=false;
					find=patient.get(i);
				}
			}
		}
		return find;
	}
	
	/**
	*This method allow that the veterinarian starts attention for a pet.
	*@version 1.0
	*pre:  the id belong to a veterinarian who already exist, also it can't be null
	*post for star attention also in pet care must be pet registered 
	*@param id is the ID for the veterinarian who starts the consult
	*@return A message notify the veterinarian is treating a pet
	*/
	public String startAttention(String id){
		String message="";
		Vet findVet=searchIdVet(id);
		Pet findPet=nextPatient();
		
		if(findVet==null){
			message="Error. There isn't registered a veterinary with that ID \n";
		}
		else{
			if((findVet.getStats().equalsIgnoreCase("CONSULT"))){
				message="Error. The vet is in "+findVet.getStats();
			}
			else{
				if(findPet==null){
					message="Error. There aren't pets registered";
				}
				else{
					findVet.setStats("CONSULT");
					findVet.setConsultation(findPet);
					findVet.countNumConsult();
					message=findPet.enterIntoConsult(findVet);
				}
			}
		}
		return message;
	}
	
	/**
	*This method finishes the consult and send the pet to a habitat if it is hospitalized 
	*@version 2.0
	*pre:  the parameters can't be null, the id must belongs to a veterinarian who exist
	*pre:  the parameter "obv" must be "EXIT" or "HOSPITALIZATION"
	*post if the obv is "HOSPITALIZATION" a habitat will be assigned 
	*@param id the identification of veterinarian who it's going to finish the consult.
	*@param obv the status of the pet, after the consult 
	*@return A message to notify the status of the pet and the habitat where it'll stay and the veterinarian is available now. 
	*/
	public String finishAttention(String id,String obv){
		String message="";
		Habitat findHabitat;
		Vet findVet=searchIdVet(id);
		if(findVet==null){
			message="Error. There isn't registered a veterinary with that ID  \n";
		}
		else if((findVet.getStats().equalsIgnoreCase("AVAILABLE"))){
			message="Error. eThe veterinary is already "+findVet.getStats();
		}
		else{
			Pet findPet=searchNamePet(findVet.getConsultation().getPetName(), findVet.getConsultation().getOwner().getId());
			if(obv.equalsIgnoreCase("exit")){
				findPet.setStatus("EXIT");
				findVet.setStats("AVAILABLE");
				findVet.setConsultation(null);
				message="The consult has finished, "+findPet.getPetName()+" has "+findPet.getStatus();
			}
			else if(obv.equalsIgnoreCase("hospitalization")){
				findPet.setStatus("HOSPITALIZATION");
				findVet.setStats("AVAILABLE");
				findVet.setConsultation(null);
				message="The consult has finished, "+findPet.getPetName()+" has "+findPet.getStatus()+"\n";
				findHabitat=searchHabitat(findPet.getSpecie());
				if(findHabitat==null) {
					message+="Error there aren't habitats for that specie of pet";
				}
				else {
					findPet.setResidency(findHabitat);
					findHabitat.setGuest(findPet);
					findHabitat.setType(Type.SICK);
					message+="the pet is in the Habitat with ID: "+findHabitat.getIdHabitat()+"\n";
				}
			}
			message+="the vet "+findVet.getName()+" is "+findVet.getStats();
		}
		
		return message;
	}
	
	/**
	*This method counts the unattended Patients in pet care 
	*@version 1.0
	*@return the number of unattended Patients in pet care
	*/
	public int countUnattendedPatients(){
		int unattendedPet=0;
		for(int i=0;i<patient.size();i++){
			if(patient.get(i)!=null && patient.get(i).getStatus()==Status.WAIT){
				unattendedPet++;
			}
		}
		return unattendedPet;
	}
	
	/**
	*This method deletes all the pets 
	*@version 1.0
	*@return Notify that all the pets registered was deleted
	*/
	public String deleteAttendedPatients(){
		String message="";
		for(int i=0;i<patient.size();i++){
			if(patient.get(i)!=null){
				patient.remove(i);
				message="All the pets have been deleted";
			}
		}
		return message;
	}
	
	/**
	*This method counts the number of attended pets per priority.
	*@version 1.0
	*@return a message with the number of attended pets per priority
	*/
	public String countPetsPriority(){
		String message="";
		for(int i=1;i<6;i++){
			int count=0;
			for(int j=0;j<patient.size();j++){
				if(i==1&&patient.get(j)!=null&&patient.get(j).getPriority()==Priority.PRIORITY1 && patient.get(j).getStatus()!=Status.EXIT_WITHOUT_ATTENTION){
					count++;
				}
				else if(i==2&&patient.get(j)!=null&&patient.get(j).getPriority()==Priority.PRIORITY2 && patient.get(j).getStatus()!=Status.EXIT_WITHOUT_ATTENTION){
					count++;
				}
				else if(i==3&&patient.get(j)!=null&&patient.get(j).getPriority()==Priority.PRIORITY3 && patient.get(j).getStatus()!=Status.EXIT_WITHOUT_ATTENTION){
					count++;
				}
				else if(i==4&&patient.get(j)!=null&&patient.get(j).getPriority()==Priority.PRIORITY4 && patient.get(j).getStatus()!=Status.EXIT_WITHOUT_ATTENTION){
					count++;
				}
				else if(i==5&&patient.get(j)!=null&&patient.get(j).getPriority()==Priority.PRIORITY5 && patient.get(j).getStatus()!=Status.EXIT_WITHOUT_ATTENTION){
					count++;
				}
			}
			message+="For priority"+i+" have been attended: "+count+" pets \n";
		}
		return message;
	}
	
	/**
	*This method search the veterinarian with the highest number of consult.
	*@version 1.0
	*@return Notify the veterinarian with highest number of consult into pet care
	*/
	public String countGreatesConsult(){
		String message="";
		int temporal=0;
		for(int i=0;i<TOTALVETS;i++){
			if(employee[i]!=null&&employee[i].getNumCosult()>temporal){
				temporal=employee[i].getNumCosult();
				message="The vet with greatest number of consultations is: "+employee[i].getName()+" with id: "+employee[i].getIdVet();
			}
		}
		return message;
	}
	
	/**
	*This method calculates the percentage of pet that "EXIT_WITHOUT_ATTENTION"
	*@version 1.0
	*post the variable registeredPet has to be more than 0.
	*@return the percentage of patients that exit without attention.
	*/
	public String findPercentage(){
		String message="";
		int registeredPet=0;
		int unattendedPet=0;
		double porcentaje=0;
		for(int i=0;i<patient.size();i++){
			if(patient.get(i)!=null){
				registeredPet++;
				if(patient.get(i).getStatus()==Status.EXIT_WITHOUT_ATTENTION){
					unattendedPet++;
				}
			}
			
		}
		if(registeredPet>0){
			porcentaje=(unattendedPet/registeredPet)*100;
			message="The % of unattended pets is: "+porcentaje+"%";
		}
		return message;
	}
	
	/**
	*This method search a habitat that is available for the pet
	*@version 1.0
	*pre:  the parameter has to belong one kind of habitat 
	*post if it find any available habitat the object is that habitat, else the object is null.  
	*@param specie the specie of the pet to assign a habitat
	*@return an object of kind Habitat
	*/
	public Habitat searchHabitat(String specie) {
		Habitat find=null;
		boolean conti=true;
		for(int i=0;i<NUMLINE&&conti;i++) {
			for(int j=0;j<NUMCOLUMN&&conti;j++) {
				if((specie.equalsIgnoreCase("cat"))&&(habitat[i][j] instanceof Crate)&&(habitat[i][j].getType()==Type.EMPTY)) {
					find=habitat[i][j];
					conti=false;
				}
				else if((specie.equalsIgnoreCase("dog"))&&(habitat[i][j] instanceof House)&&(habitat[i][j].getType()==Type.EMPTY)) {
					find=habitat[i][j];
					conti=false;
				}
				else if((specie.equalsIgnoreCase("bird"))&&(habitat[i][j] instanceof Birdcage)&&(habitat[i][j].getType()==Type.EMPTY)) {
					find=habitat[i][j];
					conti=false;
				}
				else if((specie.equalsIgnoreCase("bunny"))&&(habitat[i][j] instanceof Corral)&&(habitat[i][j].getType()==Type.EMPTY)) {
					find=habitat[i][j];
					conti=false;
				}
				else if((specie.equalsIgnoreCase("reptile"))&&(habitat[i][j] instanceof Aquarium)&&(habitat[i][j].getType()==Type.EMPTY)) {
					find=habitat[i][j];
					conti=false;
				}
			}
		}
		return find;
	}
	
	/**
	*This method creates a new pet for pet store 
	*@version 1.0
	*pre:  the parameters can't belongs to a pet that already exist.
	*pre:  the parameter specie has to be for one of kind habitats
	*post if the pet was already exist show an error, else show that the pet is created
	*@param specie it's the specie of the pet 
	*@param petName the name of the pet. 
	*@param yearsOld it's the age of the pet
	*@param breed it's a group of the specie, where the pet belongs there.
	*@param ownerName the name of the owner
	*@param ownerId the identification of the owner
	*@param phone the phone number of the owner
	*@param address the address of the owner
	*@param days the time that pet will stay in the habitat.
	*@return A message to notify the pet was created.
	*/
	public String addPet(String specie, String petName, int yearsOld, String breed, String ownerName, String ownerId, String phone, String address, int days) {
		String message="";
		Pet findPet=searchNamePet(petName,ownerId);
		Habitat findHabitat=searchHabitat(specie);
		if(findPet!=null) {
			message="Error. the pet is already exist";
		}
		else if(findHabitat==null) {
			message="Error there aren't habitats for that specie of pet";
		}
		else {
			patient.add(new Pet(specie, petName, yearsOld, breed, ownerName, ownerId, phone, address, days));
			patient.get(patient.size()-1).setResidency(findHabitat);
			findHabitat.setGuest(patient.get(patient.size()-1));
			findHabitat.setType(Type.HEALTHY);
			message="The pet will stay "+days+" days in habitat with ID: "+findHabitat.getIdHabitat();
		}
		return message;
	}
	
	/**
	*This method search the pet in the pet store 
	*@version 1.0
	*pre:  the parameters has to be information about pet that already exist
	*post: if the pet exist show information, else show an error.
	*@param petName the name of the pet
	*@param ownerId the Id of the owner.
	*@return A message with the information about the pet and it residency into habitat.
	*/
	public String findPetInPetStore(String petName, String ownerId) {
		String message="";
		Pet findPet=searchNamePet(petName,ownerId);
		if(findPet==null) {
			message="Error. the Pet doesn't exist.";
		}
		else if(findPet.getResidency()==null) {
			message="The Pet isn't on a habitat. ";
		}
		else {
			message=findPet.showResidency();
		}
		return message;
	}
	
	/**
	*This method generates a map of the habitats.
	*@version 1.0
	*@return A map of the habitats with in type, in Pet Store .
	*/
	public String generateMap() {
		String map="";
		int a =1;
		int b =1;
		int c =1;
		int d =1;
		int e =1;
		for(int i=0;i<habitat.length; i++) {
			for(int j=0;j<habitat[0].length;j++) {
				if(i<3) {
					if(j<3) {
						map+=" G"+a+habitat[i][j].showIdType()+" -";
						a++;
					}
					else if((j==3||j==4)&&i<2) {
						if(j==3) {
							map+=" R"+b+habitat[i][j].showIdType()+" -";
							b++;
						}
						else if(j==4) {
							map+=" R"+b+habitat[i][j].showIdType()+" \n";
							b++;
						}
					}
					else if((j==3||j==4)&&i==2) {
						if(j==3) {
							map+=" C"+c+habitat[i][j].showIdType()+" -";
							c++;
						}
						else if(j==4) {
							map+=" C"+c+habitat[i][j].showIdType()+" \n";
							c++;
						}
					}
				}
				else if(i<6) {
					if(j<3) {
						map+=" D"+d+habitat[i][j].showIdType()+" -";
						d++;
					}
					else if((j==3||j==4)&&i==3) {
						if(j==3) {
							map+=" C"+c+habitat[i][j].showIdType()+" -";
							c++;
						}
						else if(j==4) {
							map+=" C"+c+habitat[i][j].showIdType()+" \n";
							c++;
						}
					}
					else if((j==3||j==4)&&i<6) {
						if(j==3) {
							map+=" A"+e+habitat[i][j].showIdType()+" -";
							e++;
						}
						else if(j==4) {
							map+=" A"+e+habitat[i][j].showIdType()+" \n";
							e++;
						}
					}
				}
			}
		}
		return map;
	}
	
	/**
	*This method method search and shows all the habitat's Id 
	*@version 1.0
	*@return A message with all the habitat's Id 
	*/
	public String showIdHabitat() {
		String message="";
		int a=1;
		for(int i=0;i<habitat.length; i++) {
			for(int j=0;j<habitat[0].length;j++) {
				message+=a+" : "+habitat[i][j].getIdHabitat()+"\n";
				a++;
			}
		}
		return message;
	}
	
	/**
	*This method 
	*@version 1.0
	*pre:  the id belongs to habitat that exist.
	*post the message shows the information or an error.
	*@param id of the habitat 
	*@return A message with all the information about the habitat
	*/
	public String searchHabitatInformation(String id){
		String message="";
		boolean conti=true;
		for(int i=0;i<habitat.length&&conti; i++) {
			for(int j=0;j<habitat[0].length&&conti;j++) {
				if(habitat[i][j].getIdHabitat().equalsIgnoreCase(id)&&habitat[i][j].getType()==Type.EMPTY) {
					message=habitat[i][j].toString();
					conti=false;
				}
				else if (habitat[i][j].getIdHabitat().equalsIgnoreCase(id)) {
					message+=habitat[i][j].toString()+"\n";
					
					conti=false;
				}
			}
		}
		if(conti) {
			message="Error there aren't a habitat with that id";
		}
		return message;
	}
	
	/**
	*This method calculates percentage of habitats that aren't "EMPTY" per kind habitat.
	*@version 1.0
	*pre:  the parameter should be "cat","dog", "reptile", "bird" or "bunny" 
	*post the result can be 0 or more than 0. 
	*post the variable "total" can't be 0. 
	*@param specie it's the specie for the kind of habitat 
	*@return A percentage of habitats that aren't "EMPTY" per kind habitat.
	*/
	public double calculatePercentagePerHabitat(String specie) {
		double result=0;
		double a=0;
		int total=0;
		for(int i=0;i<habitat.length; i++) {
			for(int j=0;j<habitat[0].length;j++) {
				if(specie.equalsIgnoreCase("cat")&&habitat[i][j] instanceof Crate &&habitat[i][j].getType()!=Type.EMPTY) {
					a++;
					total=9;
				}
				else if(specie.equalsIgnoreCase("dog")&&habitat[i][j] instanceof House &&habitat[i][j].getType()!=Type.EMPTY) {
					a++;
					total=9;
				}
				else if(specie.equalsIgnoreCase("reptile")&&habitat[i][j] instanceof Aquarium &&habitat[i][j].getType()!=Type.EMPTY) {
					a++;
					total=4;
				}
				else if(specie.equalsIgnoreCase("bird")&&habitat[i][j] instanceof Birdcage &&habitat[i][j].getType()!=Type.EMPTY) {
					a++;
					total=4;
				}
				else if(specie.equalsIgnoreCase("bunny")&&habitat[i][j] instanceof Corral &&habitat[i][j].getType()!=Type.EMPTY) {
					a++;
					total=4;
				}
			}	
		}
		if(total>0) {
		result=(a/total)*100;	
		}
		else {
			result=0;
		}
		return result;
	}
	
	/**
	*This method calculates the percentage of all the habitats that aren't "EMPTY" 
	*@version 1.0
	*post the result can be 0 or more than 0. 
	*@return A percentage of habitats that aren't "EMPTY" 
	*/
	public double calculatePercentageGeneral() {
		double result=0;
		double a=0;
		for(int i=0;i<habitat.length; i++) {
			for(int j=0;j<habitat[0].length;j++) {
				if(habitat[i][j].getType()!=Type.EMPTY) {
					a++;
				}
			}	
		}
		result+=(a/30)*100;
		return result;
	}
	
	/**
	*This method calculates a percentage of the habitats have their type "HEALTHY" or "SICK"
	*@version 1.0
	*pre:  the parameter can be "HEALTHY" or "SICK" but it can't be "EMPTY".
	*post the result can be 0 or more than 0. 
	*@param status is the type of the habitat 
	*@return A percentage of habitats that it type is "HEALTHY" or "SICK"
	*/
	public double calculatePercentagePerType(Type status ) {
		double result=0;
		double a=0;
		for(int i=0;i<habitat.length; i++) {
			for(int j=0;j<habitat[0].length;j++) {
				if(habitat[i][j].getType()==status) {
					a++;
				}
			}	
		}
		result=(a/30)*100;
		return result;
	}
	
	/**
	*This method generates a message of stadistic information for Pet store, where this method calls other methods to get the information.
	*@version 1.0
	*post the message shows at least 2 decimals in the result
	*@return A message with stadistic information about the habitats
	*/
	public String generateStadisticInformation() {
		String message="";
		DecimalFormat df = new DecimalFormat("0.00");// this object is for limit the decimals in the results.
		double percentageCrate=calculatePercentagePerHabitat("cat");
		double percentageHouse=calculatePercentagePerHabitat("dog");
		double percentageAquarium=calculatePercentagePerHabitat("reptile");
		double percentageCorral=calculatePercentagePerHabitat("bunny");
		double percentageBirdcage=calculatePercentagePerHabitat("bird");
		double generalPercentage=calculatePercentageGeneral();
		double percentageForHealthy=calculatePercentagePerType(Type.HEALTHY);
		double percentageForSick=calculatePercentagePerType(Type.SICK);
		message+="The percentage occupation of crate are: "+df.format(percentageCrate)+"% \n";
		message+="The percentage occupation of house are: "+df.format(percentageHouse)+"% \n";
		message+="The percentage occupation of aquarium are: "+df.format(percentageAquarium)+"% \n";
		message+="The percentage occupation of corral are: "+df.format(percentageCorral)+"% \n";
		message+="The percentage occupation of birdcage are: "+df.format(percentageBirdcage)+"% \n";
		message+="\n The general percentage of occupation "+df.format(generalPercentage)+"% \n";
		message+="The percentage occupation of with healthy pets are : "+df.format(percentageForHealthy)+"% \n";
		message+="The percentage occupation of with sick pets are :"+df.format(percentageForSick)+"% \n";
		return message;
	}

	
}