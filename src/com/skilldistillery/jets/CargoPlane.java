package com.skilldistillery.jets;

/*
 * Class type 1 of Jet on the Airfield has Cargo Capacity
 */
public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	/*
	 * User Story 8 Part 1- collect cargo
	 */
	public void loadCargo() {
		System.out.println(this.model+ " has loaded its cargo!");//looks like I need a this. for this line because of super()
	}
}