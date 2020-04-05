package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {

	AirField af;
	Scanner scanner;

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}

	public JetsApplication() {
		af = new AirField();
		scanner = new Scanner(System.in);
	}

	public void launch() {
		List<String[]> jetsInfo = parseJets();

		af.getJets().add(new FighterJet(jetsInfo.get(0)[0], Double.parseDouble(jetsInfo.get(0)[1]),
			Integer.parseInt(jetsInfo.get(0)[2]), Long.parseLong(jetsInfo.get(0)[3])));
		af.getJets().add(new FighterJet(jetsInfo.get(1)[0], Double.parseDouble(jetsInfo.get(1)[1]),
			Integer.parseInt(jetsInfo.get(1)[2]), Long.parseLong(jetsInfo.get(1)[3])));
		af.getJets().add(new CargoPlane(jetsInfo.get(2)[0], Double.parseDouble(jetsInfo.get(2)[1]),
			Integer.parseInt(jetsInfo.get(2)[2]), Long.parseLong(jetsInfo.get(2)[3])));
		af.getJets().add(new CargoPlane(jetsInfo.get(3)[0], Double.parseDouble(jetsInfo.get(3)[1]),
			Integer.parseInt(jetsInfo.get(3)[2]), Long.parseLong(jetsInfo.get(3)[3])));
		af.getJets().add(new JetImpl(jetsInfo.get(4)[0], Double.parseDouble(jetsInfo.get(4)[1]),
			Integer.parseInt(jetsInfo.get(4)[2]), Long.parseLong(jetsInfo.get(4)[3])));

		char choice = '0';
		while(choice != '9'){
			choice = dispayUserMenu();
			processChoice(choice);
		}
	}

	public char dispayUserMenu() {
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
		return scanner.next().charAt(0);
	}

	public void processChoice(char c){
		switch(c){
			case '1': listFleet();
				break;
			case '2': fly();
				break;
			case '3': viewFastestJet();
				break;
			case '4': viewLongestRange();
				break;
			case '5': loadAllCargo();
				break;
			case '6': dogfight();
				break;
			case '7': addJet();
				break;
			case '8': removeJet();
				break;
			case '9': scanner.close();
				break;
			default:
				System.out.println("Not a valid option\n\n");
		}
	}

	public List<String[]> parseJets() {
		List<String[]> jetsInfo = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader("jets.txt"))){
			String jet;

			while((jet = br.readLine()) != null) {
				String[] jetAttrs= jet.split(",");
				jetsInfo.add(jetAttrs);
			}

		} catch (IOException e) {
			System.err.println("Could not find file");
		}

		return jetsInfo;
	}

	public void listFleet() {
		List<Jet> jets = af.getJets();
		for(Jet jet: jets) {
			System.out.println(jet);
		}
	}

	public void fly() {
		for(Jet jet : af.getJets()){
			System.out.println(jet);
			jet.fly();
		}
	}

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

	public void loadAllCargo(){
		for(Jet jet : af.getJets()){
			if(jet instanceof CargoCarrier){
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void dogfight(){
		boolean initialJet = true;
		int combatants = 0;
		for(Jet jet : af.getJets()){
			if(jet instanceof CombatReady){
				((CombatReady) jet).fight(initialJet);
				combatants ++;
				initialJet = false;
			}
		}
		if (combatants == 1){
			System.out.println("Looks like there are no other combatants...");
		} else if (combatants == 0){
			System.out.println("No jets with combat capability");
		}
	}

	public void addJet(){
		try {
			System.out.print("Enter the jet model: ");
			String model = scanner.next();
			System.out.print("Enter the speed: ");
			double speed = scanner.nextDouble();
			System.out.print("Enter the range: ");
			int range = scanner.nextInt();
			System.out.print("Enter the price: ");
			long price = scanner.nextLong();

			af.getJets().add(new JetImpl(model, speed, range, price));
			System.out.println("\nJet added\n");
		} catch (InputMismatchException e){
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}

	public void removeJet(){
		List<Jet> jets = af.getJets();

		for(int i = 0; i < jets.size(); i++){
			System.out.println(i + 1 + ". " + jets.get(i));
		}

		System.out.print("\nSelect the number of the jet to delete: ");
		try{
			int choice = scanner.nextInt();
			if(choice < jets.size() + 1 && choice > 0){
				System.out.println("\n" + jets.get(choice - 1).getModel() + " deleted\n");
				jets.remove(choice - 1);
			} else{
				System.out.println("Not a valid choice");
			}

		} catch (InputMismatchException e){
			System.out.println("Invalid input");
			scanner.nextLine();
		}
	}
}
