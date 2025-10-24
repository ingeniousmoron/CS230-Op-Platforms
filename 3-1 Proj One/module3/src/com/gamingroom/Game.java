package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	//ArrayList of teams to be added to a game
	private List<Team> teams = new ArrayList<Team>();
	
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Team addTeam(String name) {
		//a local team instance
		Team team = null;
		//local variable for the iterator
		Iterator<Team> teamIterator = teams.iterator();
		
		//Use iterator to look for existing teams of the same name
		//if found, return the existing team
		while (teamIterator.hasNext()) {
			if (teamIterator.next().getName() == name) {
				team = teamIterator.next();
			}
		//Otherwise create a new team instance
			else {
				GameService service = GameService.getInstance();
				team = new Team(service.getNextTeamId(), name);
			}
		}
		
		return team;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
