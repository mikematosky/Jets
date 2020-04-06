package com.skilldistillery.jets;

public class SuperGuppy extends Jet implements CargoCarrier{

	public SuperGuppy(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	/*
	 * User Story 8 Part 1- collect cargo
	 */
	public void loadCargo() {
		System.out.println(this.model+ " has gulped up its cargo!");//looks like I need a this. for this line because of super()
	}
}