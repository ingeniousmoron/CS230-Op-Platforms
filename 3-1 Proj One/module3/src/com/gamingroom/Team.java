package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	//ArrayList of players to be added to a team
	private List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player addPlayer(String name) {		
		// a local player instance
		Player player = null;
		//local variable for the iterator
		Iterator<Player> playerIterator = players.iterator();
		
		//Use iterator to look for existing player with the same name
		//if found, return existing player
		while (playerIterator.hasNext()) {
			if (playerIterator.next().getName() == name) {
				player = playerIterator.next();
			}
		//otherwise create a new player instance
			else {
				GameService service = GameService.getInstance();				
				player = new Player(service.getNextPlayerId(), name);
			}
		}
		
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
