/**
 * This class scans the FanDuel website to determine the players playing today and their salary.
 */
package com.av.fantasy.model;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.aa.fantasy.controller.FantasyApp;

public class FanDuelScraper {

	private ArrayList<Player> PGsPlaying;
	private ArrayList<Player> SGsPlaying;
	private ArrayList<Player> SFsPlaying;
	private ArrayList<Player> PFsPlaying;
	private ArrayList<Player> CentersPlaying;


	public FanDuelScraper(){
		PGsPlaying = new ArrayList<Player>();
		SGsPlaying = new ArrayList<Player>();
		SFsPlaying = new ArrayList<Player>();
		PFsPlaying = new ArrayList<Player>();
		CentersPlaying = new ArrayList<Player>();
	}

	private Document doc;

	public void scrapeWebsite(String url){
		//TODO: Need to validate the URL
		try {
			doc = Jsoup.connect(url).get(); //Returns a document for the the Website given
		} catch (IOException e) {
			e.printStackTrace();
		}
		PGsPlaying = new ArrayList<Player>();
		SGsPlaying = new ArrayList<Player>();
		SFsPlaying = new ArrayList<Player>();
		PFsPlaying = new ArrayList<Player>();
		CentersPlaying = new ArrayList<Player>();

		Elements script = doc.select("script");
		Element playerScript = script.get(1);
		String playerInfo = playerScript.data();
		String[] semiColon = playerInfo.split("\\{");
		String players = semiColon[14];
		String [] playerStrings = players.split("\\[");
		//For every player in the HTML Document, divide into commas to get the Name and Salary attributes;
		//Add that player to the ArrayList based upon their type.
		int lastInteger = (playerStrings.length - 1);

		for(int i = 0;i < playerStrings.length;i++){ 
			//Need to not include the first or last
			if(i != 0 && i != lastInteger){
				String[] playerData = playerStrings[i].split(",");
				String position = playerData[0].replaceAll("^\"|\"$", ""); //Remove the quotes from the position
				String playerName = playerData[1].replaceAll("^\"|\"$", ""); //Remove the quotes from the name
				int salary = Integer.parseInt(playerData[5].replaceAll("^\"|\"$",""));
				switch(position.toUpperCase()){
				case "SG":
					FantasyApp.log.debug("Adding SG");
					SGsPlaying.add(new Player(playerName, salary));
					break;
				case "PG":
					FantasyApp.log.debug("Adding PG");
					PGsPlaying.add(new Player(playerName, salary));
					break;
				case "SF":
					FantasyApp.log.debug("Adding SF");
					SFsPlaying.add(new Player(playerName, salary));
					break;
				case "PF":
					FantasyApp.log.debug("Adding PF");
					PFsPlaying.add(new Player(playerName, salary));
					break;
				case "C":
					FantasyApp.log.debug("Adding Center");
					CentersPlaying.add(new Player(playerName, salary));
					break;
				}
				FantasyApp.log.debug("Position:  "+position+"  Name: "+playerName+"  Salary:  "+salary);
			}
		}
		FantasyApp.log.info("The website FanDuel was scraped sucessfully");
	}
	
//Getters for the players
	
	public ArrayList<Player> getPGsPlaying() {
		return PGsPlaying;
	}

	public ArrayList<Player> getSGsPlaying() {
		return SGsPlaying;
	}

	public ArrayList<Player> getSFsPlaying() {
		return SFsPlaying;
	}

	public ArrayList<Player> getPFsPlaying() {
		return PFsPlaying;
	}

	public ArrayList<Player> getCentersPlaying() {
		return CentersPlaying;
	}

	public void scrapeWebsite(String uRL, GameMaster gameMaster) {
		scrapeWebsite(uRL);
		gameMaster.setPGsPlaying(PGsPlaying);
		gameMaster.setSGsPlaying(SGsPlaying);
		gameMaster.setPFsPlaying(PFsPlaying);
		gameMaster.setSFsPlaying(SFsPlaying);
		gameMaster.setCentersPlaying(CentersPlaying);
	}
}
