package com.skilldistillery.jets;

/*
 * Class type 2 Jet on the Airfield. Has Fighting Capability
 */
public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	/*
	 * User Story 7 Part 2 DogFight
	 */
	public void fight() {
		System.out.println(this.model + " is looking for a fight!");
	}
}