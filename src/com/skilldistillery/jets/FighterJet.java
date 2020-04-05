package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	/*
	 * User Story 7 Part 2 DogFight
	 */
	public void fight() {
		System.out.println(this.model + " started a dogfight!");
	}
}