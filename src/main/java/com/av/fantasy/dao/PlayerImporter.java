package com.av.fantasy.dao;

/**
 * Takes a .csv file and stores all the players into the database
 */
import java.io.InputStream;
import java.util.Scanner;

import com.av.fantasy.model.BasketballPlayer;

public class PlayerImporter {
	//This will be the csvFile for all Players
	private static PlayerDAO pDAO;


	/**
	 * Parses the default CSV file into players to store in the DB.
	 */
	public static void importPlayers(){
		pDAO = new PlayerDAO();
		InputStream stream = PlayerImporter.class.getResourceAsStream("/Players.csv");
		Scanner s = new Scanner(stream);
		//use comma as separator
		s.useDelimiter("\n");
		while(s.hasNext()){
			createPlayer(s.next());
		}
		s.close();


	}

	/**
	 * Helper method for importing players
	 * @param line a comma delimeted stat line of the player
	 */
	private static void createPlayer(String line){
		String[] stat = line.split(",");	//Separate the line by commas
		String playerName = stat[1];
		//Try to retrieve this player from the database
		//If the player does not exist in the database create a new player
		BasketballPlayer playerToUpdate = pDAO.getPlayerByName(playerName);
		Boolean playerExists = true;
		if(playerToUpdate == null){
			playerExists = false;
		}
		if(playerExists == false){
			System.out.println("Player already existed...");
			playerToUpdate = new BasketballPlayer();
			playerToUpdate.setName(playerName);
			playerToUpdate.setType(getPlayerType(stat[2]));
			playerToUpdate.setTeam(stat[4]);
		}
		Double rebounds = Double.parseDouble(stat[22]);
		playerToUpdate.setAverageRebounds(rebounds);
		Double assists = Double.parseDouble(stat[23]);
		playerToUpdate.setAverageAssists(assists);
		Double steals = Double.parseDouble(stat[24]);
		playerToUpdate.setAverageSteals(steals);
		Double blocks = Double.parseDouble(stat[25]);
		playerToUpdate.setAverageBlocks(blocks);
		Double turnovers = Double.parseDouble(stat[26]);
		playerToUpdate.setAverageTurnovers(turnovers);
		Double points = Double.parseDouble(stat[28]);
		playerToUpdate.setAveragePoints(points);
		if (playerExists == true){
			pDAO.updatePlayer(playerToUpdate);
		}
		else{
			pDAO.save(playerToUpdate);
		}
	}

	/**
	 * Helper method that converts the string value of position into its integer equivalent
	 * @return int that represents the type of the player
	 */
	private static int getPlayerType(String position) {
		// TODO Auto-generated method stub
		switch(position){
		case "SG":
			return 2;
		case "PG":
			return 1;
		case "SF":
			return 3;
		case "PF":
			return 4;
		case "C":
			return 5;
		}
		return 0;
	}
}
