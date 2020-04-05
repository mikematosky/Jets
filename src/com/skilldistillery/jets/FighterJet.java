package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight(boolean initiator) {
		if (initiator){
			System.out.println(this.model + " initiated a dogfight!");
		} else {
			System.out.println(this.model + " has entered the fight!");
		}
	}
}