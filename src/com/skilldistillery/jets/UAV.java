package com.skilldistillery.jets;

/*
 * UAV Class. Vanilla jet. No cargo or fighting capabilities. 
 * Honestly, identical to the JetImpl class, but maybe room for 
 * future capability for support or surveilance operations.
 */
public class UAV extends Jet {

	public UAV(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	
}