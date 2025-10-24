package com.gamingroom;

public class Entity {
	long id;
	String name;
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 * Constructor changed from private to protected to allow child classes.
	 */
	protected Entity() {
	}
	
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * To be overridden. Will return an error message if called directly.
	 */
	public String toString() {
		return "FIXME: override toString method";
	}

}
