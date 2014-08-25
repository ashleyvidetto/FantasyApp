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

	private ArrayList<BasketballPlayer> PGsPlaying;
	private ArrayList<BasketballPlayer> SGsPlaying;
	private ArrayList<BasketballPlayer> SFsPlaying;
	private ArrayList<BasketballPlayer> PFsPlaying;
	private ArrayList<BasketballPlayer> CentersPlaying;
	private ArrayList<BasketballPlayer> QBsPlaying;
	private ArrayList<BasketballPlayer> WRsPlaying;
	private ArrayList<BasketballPlayer> RBsPlaying;
	private ArrayList<BasketballPlayer> TEsPlaying;
	private ArrayList<BasketballPlayer> DSTPlaying;
	private ArrayList<BasketballPlayer> KickersPlaying;
	private ArrayList<BasketballPlayer> PitchersPlaying;
	private ArrayList<BasketballPlayer> FirstbasemenPlaying;
	private ArrayList<BasketballPlayer> ShortstopsPlaying;
	private ArrayList<BasketballPlayer> SecondBasemenPlaying;
	private ArrayList<BasketballPlayer> ThirdBasemenPlaying;
	private ArrayList<BasketballPlayer> CatchersPlaying;
	private ArrayList<BasketballPlayer> OFsPlaying;
	private String sport;


	public FanDuelScraper(String sport){
		this.sport = sport;
	}

	private Document doc;

	public void scrapeWebsite(String url){
		try {
			doc = Jsoup.connect(url).get(); //Returns a document for the the Website given
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch(sport.toUpperCase()){
		case "BASKETBALL":
			scrapeBasketball();
			break;
		case "FOOTBALL":
			scrapeFootball();
			break;
		case "BASEBALL":
			scrapeBaseball();
			break;
		}
		

	}
	

	
	private void scrapeFootball() {
		QBsPlaying = new ArrayList<BasketballPlayer>();
		WRsPlaying = new ArrayList<BasketballPlayer>();
		RBsPlaying = new ArrayList<BasketballPlayer>();
		TEsPlaying = new ArrayList<BasketballPlayer>();
		DSTPlaying = new ArrayList<BasketballPlayer>();
		KickersPlaying = new ArrayList<BasketballPlayer>();
		
		
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
				case "WR":
					FantasyApp.log.debug("Adding WR");
					WRsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "RB":
					FantasyApp.log.debug("Adding RB");
					RBsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "TE":
					FantasyApp.log.debug("Adding TE");
					TEsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "QB":
					FantasyApp.log.debug("Adding QB");
					QBsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "K":
					FantasyApp.log.debug("Adding Kicker");
					KickersPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "D":
					FantasyApp.log.debug("Adding Defense/ST");
					DSTPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				}
				FantasyApp.log.debug("Position:  "+position+"  Name: "+playerName+"  Salary:  "+salary);
			}
		}
		FantasyApp.log.info("The website FanDuel was scraped sucessfully");	
	}

	private void scrapeBaseball() {
		PitchersPlaying = new ArrayList<BasketballPlayer>();
		SecondBasemenPlaying = new ArrayList<BasketballPlayer>();
		ShortstopsPlaying = new ArrayList<BasketballPlayer>();
		ThirdBasemenPlaying = new ArrayList<BasketballPlayer>();
		CatchersPlaying = new ArrayList<BasketballPlayer>();
		OFsPlaying = new ArrayList<BasketballPlayer>();
		FirstbasemenPlaying = new ArrayList<BasketballPlayer>();
		
		Elements script = doc.select("script");
		FantasyApp.log.info(doc.toString());
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
				case "OF":
					FantasyApp.log.debug("Adding OF");
					OFsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "C":
					FantasyApp.log.debug("Adding C");
					CatchersPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "SS":
					FantasyApp.log.debug("Adding SS");
					ShortstopsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "3B":
					FantasyApp.log.debug("Adding 3B");
					ThirdBasemenPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "2B":
					FantasyApp.log.debug("Adding 2B");
					SecondBasemenPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "1B":
					FantasyApp.log.debug("Adding 1B");
					FirstbasemenPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "P":
					FantasyApp.log.debug("Adding P");
					PitchersPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				}
				FantasyApp.log.debug("Position:  "+position+"  Name: "+playerName+"  Salary:  "+salary);
			}
		}
		FantasyApp.log.info("The website FanDuel was scraped sucessfully");
		
	}

	private void scrapeBasketball() {
		PGsPlaying = new ArrayList<BasketballPlayer>();
		SGsPlaying = new ArrayList<BasketballPlayer>();
		SFsPlaying = new ArrayList<BasketballPlayer>();
		PFsPlaying = new ArrayList<BasketballPlayer>();
		CentersPlaying = new ArrayList<BasketballPlayer>();
		
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
					SGsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "PG":
					FantasyApp.log.debug("Adding PG");
					PGsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "SF":
					FantasyApp.log.debug("Adding SF");
					SFsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "PF":
					FantasyApp.log.debug("Adding PF");
					PFsPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				case "C":
					FantasyApp.log.debug("Adding Center");
					CentersPlaying.add(new BasketballPlayer(playerName, salary));
					break;
				}
				FantasyApp.log.debug("Position:  "+position+"  Name: "+playerName+"  Salary:  "+salary);
			}
		}
		FantasyApp.log.info("The website FanDuel was scraped sucessfully");
		
	}

	public void scrapeWebsite(String uRL, GameMaster gameMaster) {
		scrapeWebsite(uRL);
		switch(sport.toUpperCase()){
		case "BASKETBALL":
			((BasketballMaster) gameMaster).setPGsPlaying(PGsPlaying);
			((BasketballMaster) gameMaster).setSGsPlaying(SGsPlaying);
			((BasketballMaster) gameMaster).setPFsPlaying(PFsPlaying);
			((BasketballMaster) gameMaster).setSFsPlaying(SFsPlaying);
			((BasketballMaster) gameMaster).setCentersPlaying(CentersPlaying);
			break;
		case "FOOTBALL":
			((FootballMaster) gameMaster).setQBsPlaying(QBsPlaying);
			((FootballMaster) gameMaster).setWRsPlaying(WRsPlaying);
			((FootballMaster) gameMaster).setTEsPlaying(TEsPlaying);
			((FootballMaster) gameMaster).setRBsPlaying(RBsPlaying);
			((FootballMaster) gameMaster).setKickersPlaying(KickersPlaying);
			((FootballMaster) gameMaster).setDSTPlaying(DSTPlaying);
			break;
		case "BASEBALL":
			((BaseballMaster) gameMaster).setPitchersPlaying(PitchersPlaying);
			((BaseballMaster) gameMaster).setFirstbasemenPlaying(FirstbasemenPlaying);
			((BaseballMaster) gameMaster).setSecondbasemenPlaying(SecondBasemenPlaying);
			((BaseballMaster) gameMaster).setShortstopsPlaying(ShortstopsPlaying);
			((BaseballMaster) gameMaster).setThirdbasemenPlaying(ThirdBasemenPlaying);
			((BaseballMaster) gameMaster).setCatchersPlaying(CatchersPlaying);
			((BaseballMaster) gameMaster).setOutfieldersPlaying(OFsPlaying);
			break;
		}

	}
	
	//Getters for the players
	public ArrayList<BasketballPlayer> getPGsPlaying() {
		return PGsPlaying;
	}

	public ArrayList<BasketballPlayer> getSGsPlaying() {
		return SGsPlaying;
	}

	public ArrayList<BasketballPlayer> getSFsPlaying() {
		return SFsPlaying;
	}

	public ArrayList<BasketballPlayer> getPFsPlaying() {
		return PFsPlaying;
	}

	public ArrayList<BasketballPlayer> getCentersPlaying() {
		return CentersPlaying;
	}
}
