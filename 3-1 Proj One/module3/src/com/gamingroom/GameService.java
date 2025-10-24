package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	
	/*
	 * Hold the next player identifier
	 */
	private static long nextPlayerId = 1;
	
	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;
	
	/**
	 * Instance of a GameService object
	 */
	private static GameService service;
	
	
	/**
	 * Private constructor for GameService, intentionally left empty
	 */
	private GameService() {
	}
	
	public static GameService getInstance() {
		if (service == null) {
			service = new GameService();
		}
		
		return service;
		
	}
	
	/**
	 * The singleton design pattern ensures that only one instance of
	 * a class exists in memory and is externally accessible. This design
	 * pattern uses two classes, the singleton itself and some kind of
	 * driver. The singleton uses a private static instance variable, 
	 * a private constructor, and a public static getInstance method.
	 * The getInstance method must check for an existing instance before
	 * calling the constructor. This is good for secure systems where only
	 * one version of an object can exist at the same time.
	 */


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		
		// call getGame method with name parameter to check if the name already exists
		if (getGame(name) != null) {
			game = getGame(name);
		}
		
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		// local variable for the iterator
		Iterator<Game> gameIterator = games.iterator();

		// Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		while (gameIterator.hasNext()) {
			if (gameIterator.next().getId() == id) {
				game = gameIterator.next();
			}
		}
		

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		// local variable for the iterator
		Iterator<Game> gameIterator = games.iterator();

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		while (gameIterator.hasNext()) {
			if (gameIterator.next().getName() == name) {
				game = gameIterator.next();
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	//
	
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
	
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
