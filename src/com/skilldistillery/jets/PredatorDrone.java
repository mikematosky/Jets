package com.skilldistillery.jets;

/*
 * Class type 2 Jet on the Airfield. Has Fighting Capability
 */
public class PredatorDrone extends Jet implements CombatReady {

	public PredatorDrone(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	/*
	 * User Story 7 Part 2 DogFight
	 */
	public void fight() {
		System.out.println(this.model + " is locking onto a target!");
	}
}