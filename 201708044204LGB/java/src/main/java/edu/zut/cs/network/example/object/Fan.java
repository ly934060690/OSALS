package edu.zut.cs.network.example.object;

import edu.zut.cs.network.example.base.BaseObject;

/**
 * 
 * 
 * @author liuxiaoming*
 */
public class Fan extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2528273354647821458L;

	/**
	 * color of fan's leaves;
	 */
	String colour;

	Long id;
	/**
	 * radius of fan's leaves;
	 */
	double radius;
	/**
	 * speed of running;
	 */
	int speed;

	public String getColour() {
		return colour;
	}

	public Long getId() {
		return id;
	}

	public double getRadius() {
		return radius;
	}

	public int getSpeed() {
		return speed;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
