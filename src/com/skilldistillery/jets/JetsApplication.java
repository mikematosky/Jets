package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	//General Global variables
	private AirField af; //We need an airfield object
	private Scanner scan = new Scanner(System.in);// scan for the program
	
	/*
	 * User Story number1, Class with a main
	 */
	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
	}

	public JetsApplication() {
		af = new AirField();
	}

	/*
	 * User Story 4 Part 2: Populate the local fleet
	 * 
	 * TODO make this more flexible instead of hard coding.
	 */
	public void launch() {
		List<String[]> fleet = parseJets();//parse jets has the input

		for (int i= 0; i< fleet.size(); i++ ) {
			if(fleet.get(i)[0].startsWith("Fighter")) {
				af.getJets().add(new FighterJet(fleet.get(0)[0], 
						Double.parseDouble(fleet.get(i)[1]), Integer.parseInt(fleet.get(i)[2]), 
						Long.parseLong(fleet.get(i)[3])));
			}
			else if (fleet.get(i)[0].startsWith("Cargo")){
				af.getJets().add(new CargoPlane(fleet.get(i)[0], 
						Double.parseDouble(fleet.get(i)[1]), Integer.parseInt(fleet.get(2)[2]), 
						Long.parseLong(fleet.get(i)[3])));
			}
			else if (fleet.get(i)[0].startsWith("Predator")){
				af.getJets().add(new PredatorDrone(fleet.get(i)[0], 
						Double.parseDouble(fleet.get(i)[1]), Integer.parseInt(fleet.get(2)[2]), 
						Long.parseLong(fleet.get(i)[3])));
			}
			else if (fleet.get(i)[0].startsWith("Super")) {
				af.getJets().add(new SuperGuppy(fleet.get(i)[0], 
						Double.parseDouble(fleet.get(i)[1]), Integer.parseInt(fleet.get(2)[2]), 
						Long.parseLong(fleet.get(i)[3])));
			}
			else if (fleet.get(i)[0].startsWith("UAV")) {
				af.getJets().add(new UAV(fleet.get(i)[0], 
						Double.parseDouble(fleet.get(i)[1]), Integer.parseInt(fleet.get(2)[2]), 
						Long.parseLong(fleet.get(i)[3])));
			}
			else {
				af.getJets().add(new JetImpl(fleet.get(0)[0], 
						Double.parseDouble(fleet.get(i)[1]), Integer.parseInt(fleet.get(i)[2]), 
						Long.parseLong(fleet.get(i)[3])));
			}
		}
		
		char choice = '0';
		//MenuInteraction
		while(choice != '9'){
			choice = printMenu();
			processChoice(choice);
		}
	}

	/*
	 * Menu Chunk
	 * 
	 * -Print Menu
	 * -Process Choices
	 */
	public char printMenu() {
		System.out.println("\n1. List Fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all cargo jets");
		System.out.println("6. Dogfight");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit\n");
		System.out.print("Choice: ");
		return scan.next().charAt(0);
	}

	public void processChoice(char c){
		switch(c){
			case '1': 
				listFleet();
				break;
			case '2': 
				flyAll();
				break;
			case '3': 
				viewFastestJet();
				break;
			case '4': 
				viewLongestRange();
				break;
			case '5': 
				loadAllCargo();
				break;
			case '6': 
				dogfight();
				break;
			case '7': 
				addJet();
				break;
			case '8': 
				removeJet();
				break;
			case '9': 
				scan.close();
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Not a valid option\n\n");
		}
	}
	
	/*
	 * User Story 5 print out fleets if more than 4 planes.
	 */
	public void listFleet() {
		List<Jet> jets = af.getJets();
		
		if(jets.size() > 4) {
			for(Jet jet: jets) {
				System.out.println(jet);			
			}
		}
		else {
			System.out.println("Not enough planes");
		}
	}



	/*
	 * User Story 6- Fly All Jets
	 */
	public void flyAll() {
		for(Jet jet : af.getJets()){
			System.out.println(jet);
			jet.fly();
		}
	}

	/*
	 * User Story 7 Part 1- Find Fastest Jet
	 */
	public void viewFastestJet() {
		Jet fastest = null;
		for(Jet jet: af.getJets()){
			if (fastest == null) {
				fastest = jet;
			} else if (jet.getSpeed() > fastest.getSpeed()){
				fastest = jet;
			}
		}
		System.out.println("Fastest: " + fastest);
	}

	/*
	 * User Story 7 Part 2- Find the Longest Lasting Jet
	 */
	public void viewLongestRange() {
		Jet longestRange = null;
		for(Jet jet: af.getJets()) {
			if(longestRange == null) {
				longestRange = jet;
			} else if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println("Longest Range: " + longestRange);
	}

	/*
	 * User Story 8 Part 1- LoadCargo
	 */
	public void loadAllCargo(){
		for(Jet jet : af.getJets()){
			if(jet instanceof CargoCarrier){
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	/*
	 * User Story 8 Part 2- DogFight!
	 */
	public void dogfight(){
		//boolean initialJet = true;
		int fighters = 0;// how many fighters
		for(Jet jet : af.getJets()){
			if(jet instanceof CombatReady){
				((CombatReady) jet).fight();
				fighters ++;
			}
		}
		if (fighters == 1){
			System.out.println("This is SPARTA!!!");
		} 
		else if (fighters == 0){
			System.out.println("No jets with combat capability");
		}
		else {
			System.out.println(fighters+ " fighters have entered the fight");
		}
	}

	/*
	 * User Story 9- Add a Jet
	 * 
	 * User adds a jet to the AirField with loaded constructor
	 * 
	 * TODO dummyproof Parse strings for actual planes. I'm actually
	 * going to leave this because the project was stressful enough.
	 * There is no requirement for making the user capable of adding a combat
	 * or cargo jet.
	 */
	public void addJet(){
		try {
			System.out.print("Enter the jet model: ");
			String model = scan.next();
			System.out.print("Enter the speed: ");
			double speed = scan.nextDouble();
			System.out.print("Enter the range: ");
			int range = scan.nextInt();
			System.out.print("Enter the price: ");
			long price = scan.nextLong();
			
			if(model.startsWith("Fighter")) {
				af.getJets().add(new FighterJet(model, speed, range, price));
			}
			else if (model.startsWith("Cargo")){
				af.getJets().add(new CargoPlane(model, speed, range, price));
			}
			else if (model.startsWith("Predator")){
				af.getJets().add(new PredatorDrone(model, speed, range, price));
			}
			else if (model.startsWith("SuperGuppy")) {
				af.getJets().add(new SuperGuppy(model, speed, range, price));
			}
			else if (model.startsWith("UAV")) {
				af.getJets().add(new UAV(model, speed, range, price));
			}
			else {//Anything random they put in for model defaults to a Jet class
				af.getJets().add(new JetImpl(model, speed, range, price));
			}

		} catch (InputMismatchException e){
			System.out.println("Invalid input");
			scan.nextLine();
		}
	}

	/*
	 * User Story 10- Remove a Jet
	 * 
	 * 
	 */
	public void removeJet(){
		List<Jet> jets = af.getJets();

		//List jets by number
		for(int i = 0; i < jets.size(); i++){
			System.out.println(i + 1 + ". " + jets.get(i));
		}

		System.out.print("\nSelect the number of the jet to delete: ");
		try{
			int choice = scan.nextInt();
			//needs to match an index of an actual jet
			if(choice < jets.size() + 1 && choice > 0){
				System.out.println("\n" + jets.get(choice - 1).getModel() + " deleted\n");
				jets.remove(choice - 1);
			} else{
				System.out.println("Not a valid choice");
			}

		} catch (InputMismatchException e){
			System.out.println("Invalid input");
			scan.nextLine();
		}
	}
	/*
	 * User Story 4 Part 1: Read the jets info from a text file.  
	 */
	public List<String[]> parseJets() {
		//new list to hold String Arrays to input plane data into
		List<String[]> fleet = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader("jets.txt"))){
			String jet;
			
			while((jet = reader.readLine()) != null) {
				String[] jetAttrs= jet.split(",");//separate by ',' create an array to hold data
				fleet.add(jetAttrs);//Add this array to the fleet List
			}
			
		} catch (IOException e) {
			System.err.println("Could not find file");//I hate seeing this
		}
		
		return fleet;
	}
}
