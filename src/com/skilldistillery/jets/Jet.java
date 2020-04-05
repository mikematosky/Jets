package com.skilldistillery.jets;

public abstract class Jet {
	protected String model;
	protected double speed;
	protected int range;
	protected long price;

	public Jet(String _model, double _speed, int _range, long _price) {
		model = _model;
		speed = _speed;
		range = _range;
		price = _price;
	}

	public void fly() {
		if (range > 0 && speed > 0){
			double flightTime = (double)(range / speed);
			System.out.printf("  Max flight time: %.2f hours\n", flightTime);
		} else{
			System.out.println("00000 This aircraft cannot fly");
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