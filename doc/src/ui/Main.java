package ui;

import java.util.Scanner;
import model.PetCare;

public class Main{
	
	private static Scanner sn=new Scanner(System.in);
	private static PetCare veterinary=new PetCare("veterinary");
	
	public static void main (String[] args){
		
		int i=0;
		int b=0;
		int selection=0;
		while (i==0){ 
			
			while (b==0){
				System.out.println("\n Please select any service: \n");
				System.out.println("1: Veterinary emergency ");
				System.out.println("2: Pet store \n");
				selection=sn.nextInt();
				sn.nextLine();
				if (selection>2){
					System.out.println("The opcion it's wrong, please try again ");
				}
				else{  
					b=1;
				}
			}
			int option=menu(selection);
			
			switch(option){
			
				case 1:
					if(selection==1) {
						enterVet();
					}
					else if(selection==2) {
						addPetInPetStore();
					}
				break;
					
				case 2:
					if(selection==1) {
						deleteVet();
					}
					else if(selection==2) {
						searchPetInPetStore();
					}
				break;
			
				case 3:
					if(selection==1) {
						enterPet();
					}
					else if(selection==2) {
						System.out.println(veterinary.generateMap());
					}
				break;
				
				case 4:
					if(selection==1) {
						exitPet();
					}
					else if(selection==2) {
						showHabitatInformation();
					}
				break;
			
				case 5:
					if(selection==1) {
						availableVeterinary();
					}
					else if(selection==2) {
						System.out.println(veterinary.generateStadisticInformation());
					}
				break;
				
				case 6:
					startConsult();
				break;
				
				case 7:
					finishConsult();
				break;
				
				case 8:
					int number=checkPets();
					System.out.println("The number of unattended pets are : "+number);
				break;
				
				case 9:
					int close=checkPets();
					String petUnattended=exitWithoutAttention();
					if(close>0){
						System.out.println("it can't generate the daily close, there are pets waiting for attention yet.");
					}
					else{
						System.out.println("\n All the pets have been treated");
						showGreatestNumberConsult();
						showNumPetsPriority();
						System.out.println(petUnattended);
						deletePet();
						System.out.println("\n You have exited of program.");	
						i=1;
					}
				break;
			}
			if(i==0) {
				System.out.println("\n Do you want switch of service (yes ; no).");
				String answer=sn.next();
				if(answer.equalsIgnoreCase("yes")) {
					b=0;
				}
				else {
					b=1;
				}
			}
		}
	}
	
	/**
	*-This method shows the options and allows select one .
	* @version 2.0
	* pre: the parameter has a value between 1 or 2
	* post When the parameter is 1 the return has to be a value between 1 and 9, but if the parameter it´s 2 the return has to be a value between 1 and 5
	* @param centerSelection is the value selected by user to show one menu.
	* @return select is option selected by the user.
	*/
	public static int menu(int centerSelection) {
		int select=0;
		int b=0;
		
		if(centerSelection==1) {
			System.out.println("\n Please select any option: \n");
			System.out.println("1: Add a new veterinary");
			System.out.println("2: Delete a Veterinary");
			System.out.println("3: Register a pet and it owner");
			System.out.println("4: Exit without attention (pet)");
			System.out.println("5: Show the name of available veterinaries ");
			System.out.println("6: Start a consult ");
			System.out.println("7: Finish a consult");
			System.out.println("8: Show how many pets haven't been treated");
			System.out.println("9: Generate the daily close ");
			while (b==0){
				select=sn.nextInt();
				sn.nextLine();
				if (select>9){
					System.out.println("The opcion it's wrong, please try again ");
				}
				else{  
					b=1;
				}
			}
		}
		else if(centerSelection==2) {
			System.out.println("\n Please select any option: \n");
			System.out.println("1: Add a pet for PetStore");
			System.out.println("2: Search a pet into PetStore");
			System.out.println("3: Show the map of PetStore ");
			System.out.println("4: Show habitat's information (with it id) ");
			System.out.println("5: Generate and show stadistic information ");
			while (b==0){
				select=sn.nextInt();
				sn.nextLine();
				if (select>5){
					System.out.println("The opcion it's wrong, please try again ");
				}
				else{  
					b=1;
				}
			}
		}
		return select;
	}
	
	/**
	*-This method ask for vet's data for create a new veterinarian.
	*-@version 1.0
	*post post: Show a message to notify the veterinarian has been created.
	*/
	public static void enterVet(){
	
		String name=" ";
		String lastName="";
		String idVet="";
		String register="";
		String message="";
		
		System.out.println("Enter the name of the vet");
		name=sn.nextLine();
		
		System.out.println("Enter the lastname of the vet");
		lastName=sn.nextLine();
		
		System.out.println("Enter id of the vet?");
		idVet=sn.nextLine();
		
		System.out.println("Enter the register of the vet");
		register=sn.nextLine();
		
		message=veterinary.addVet(name,lastName,idVet,register,"AVAILABLE");
		System.out.println(message);
	}
	
	/**
	*This method allows enter the ID of one veterinarian  to delete it.
	*@version 1.0
	*post post: Show a message to notify the veterinary has been deleted.
	*/
	public static void deleteVet(){
		String id="";
		String message="";
		
		System.out.println("Enter the veterinary's id to delete it");
		id=sn.nextLine();
		message=veterinary.delete(id);
		System.out.println(message);
	}
	
	/**
	*This method allows enter for pet's data for create a new pet with it owner
	*@version 1.0
	*post Show a message to notify the pet has been created.
	*/
	public static void enterPet(){
		
		String specie="";
		String petName="";
		int yearsOld=0;
		String breed="";
		int priority=0;
		String symptoms="";
		String ownerId="";
		String ownerName="";
		String phone="";
		String address="";
		String message="";
		
		System.out.println("Enter the specie of the pet");
		specie=sn.nextLine();
		
		System.out.println("Enter the name of the pet");
		petName=sn.nextLine();
		
		System.out.println("How years old is the pet?");
		yearsOld=sn.nextInt();
		sn.nextLine();
		
		System.out.println("Enter the breed of the pet");
		breed=sn.nextLine();
		
		System.out.println("Enter the priority of the pet(1,2,3,4,5)");
		priority=sn.nextInt();
		sn.nextLine();
		
		System.out.println("Enter the symptoms of the pet");
		symptoms=sn.nextLine();
		
		System.out.println("Enter the name of the owner");
		ownerName=sn.nextLine();
		
		System.out.println("Enter the ID of the owner");
		ownerId=sn.nextLine();
		
		System.out.println("Enter the phone of the owner");
		phone=sn.nextLine();
		
		System.out.println("Enter the address of the owner");
		address=sn.nextLine();

		message=veterinary.addPet(specie,petName,yearsOld,breed,priority,symptoms,ownerName,ownerId,phone,address);
		System.out.println(message);
	}
	
	/**
	*This method allows enter any pet's data to exit of Pet care.
	*@version 1.0
	*post: Show a message to notify the pet has exit from pet care.
	*/
	public static void exitPet(){
		String message="";
		String namePet="";
		String idOwner="";
		
		System.out.println("Enter the name of the pet that will leave.");
		namePet=sn.nextLine();
		
		System.out.println("Enter the owner's id of the Pet ");
		idOwner=sn.nextLine();
		
		message=veterinary.exitForNotAttentionPet(namePet,idOwner);
		System.out.println(message);
	}
	
	/**
	*This method shows all the employees that are available.
	*@version 1.0
	*/
	public static void availableVeterinary(){
		String message="";
		message=veterinary.vetAvailable();
		System.out.println(message);
	}
	
	/**
	*This method allows enter the vet's Id to stars the consult.
	*@version 1.0
	*/
	
	public static void startConsult(){
		String idVet="";
		String message="";
		System.out.println("Enter the id of the veterinary who starts consult");
		idVet=sn.nextLine();
		message=veterinary.startAttention(idVet);
		System.out.println(message);
	}
	
	/**
	*This method allows enter the vet's Id to finishes the consult.
	*@version 1.0 
	*/
	public static void finishConsult(){
		String idVet="";
		String observation="";
		String message="";
		System.out.println("Enter the id of the veterinary who finishes consult");
		idVet=sn.nextLine();
		System.out.println("Enter the clinical condition (exit , hospitalization)");
		observation=sn.nextLine();
		message=veterinary.finishAttention(idVet,observation);
		System.out.println(message);
	}
	
	/**
	*This method shows the number of unattended pets.
	*@version 1.0 
	*@return the number of pet that aren't attended yet.
	*/
	public static int checkPets(){
		int num=0;
		num=veterinary.countUnattendedPatients();
		return num;
	}
	
	/**
	*This method shows the number of attended pets per priority.
	*@version 1.0
	*/
	public static void showNumPetsPriority(){
		String message="";
		message=veterinary.countPetsPriority();
		System.out.println("\n"+message);
	}
	
	/**
	*This method shows the veterinarian with the highest number of consultations
	*@version 1.0
	*/
	public static void showGreatestNumberConsult(){
		String message="";
		message=veterinary.countGreatesConsult();
		System.out.println("\n"+message);
	} 
	
	/**
	*This method shows the percentage of pets that exit without attention.
	*@version 1.0 
	*@return A message with the statistic information about patients with exit without attention.
	*/
	public static String exitWithoutAttention(){
		String message="";
		message=veterinary.findPercentage();
		return message;
	}
	
	/**
	*This method notifies that all the pets form center have been deleted.
	*@version 1.0
	*/
	public static void deletePet(){
		String message="";
		message=veterinary.deleteAttendedPatients();
		System.out.println(message);
	}
	
	/**
	*This method allows enter for pet's data for create a new pet with it owner for pet store
	*@version 1.0
	*post Show a message to notify the pet has been created.
	*/
	public static void addPetInPetStore() {
		String specie="";
		String petName="";
		int yearsOld=0;
		String breed="";
		String ownerId="";
		String ownerName="";
		String phone="";
		String address="";
		int days=0;
		String message="";
		
		System.out.println("Enter the specie of the pet");
		specie=sn.nextLine();
		
		System.out.println("Enter the name of the pet");
		petName=sn.nextLine();
		
		System.out.println("How years old is the pet?");
		yearsOld=sn.nextInt();
		sn.nextLine();
		
		System.out.println("Enter the breed of the pet");
		breed=sn.nextLine();
		
		System.out.println("Enter the name of the owner");
		ownerName=sn.nextLine();
		
		System.out.println("Enter the ID of the owner");
		ownerId=sn.nextLine();
		
		System.out.println("Enter the phone of the owner");
		phone=sn.nextLine();
		
		System.out.println("Enter the address of the owner");
		address=sn.nextLine();
		
		System.out.println("How many days the pet will stay in the pet Store?");
		days=sn.nextInt();
		sn.nextLine();
		
		message=veterinary.addPet(specie,petName,yearsOld,breed,ownerName,ownerId,phone,address,days);
		System.out.println(message);
	}
	
	/**
	*This method allows enter any pet's data to search it in pet store
	*@version 1.0
	*post  Show a message with the name of the pet and ID's habitat.
	*/
	public static void searchPetInPetStore() {
		String petName="";
		String ownerId="";
		String message="";
		
		System.out.println("Enter the name of the pet");
		petName=sn.next();
		
		System.out.println("Enter the ID of the owner");
		ownerId=sn.next();
		
		message=veterinary.findPetInPetStore(petName,ownerId);
		System.out.println(message);
	}
	
	/**
	*This method allows enter ID's habitat to search it
	*@version 1.0
	*post Show a message with habitat's information.
	*/
	public static void showHabitatInformation() {
		String message="";
		String answer="";
		System.out.println("Do you want see the Habitat's ID? (yes , no)");
		answer=sn.next();
		if(answer.equalsIgnoreCase("yes")) {
			message=veterinary.showIdHabitat();
			System.out.println(message);
		}
		System.out.println("Please, enter any Habitat's ID to watch it information ");
		answer=sn.next();
		message=veterinary.searchHabitatInformation(answer);
		System.out.println(message);
	}
}