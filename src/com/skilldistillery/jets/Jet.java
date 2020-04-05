package com.skilldistillery.jets;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected int range;
	protected long price;

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public void fly() {
		if (this.range == 0 || this.speed == 0){
			System.out.println("\tThis aircraft is down for maintenance");
		} else{
			double flightTime = this.range / this.speed;
			System.out.printf("\tMax flight time: %.2f hours\n", flightTime);
		}
	}

	public double getSpeedInMach() {
		return 0;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}
}