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
	private ArrayList<Player> QBsPlaying;
	private ArrayList<Player> WRsPlaying;
	private ArrayList<Player> RBsPlaying;
	private ArrayList<Player> TEsPlaying;
	private ArrayList<Player> DSTPlaying;
	private ArrayList<Player> KickersPlaying;
	private ArrayList<Player> PitchersPlaying;
	private ArrayList<Player> FirstbasemenPlaying;
	private ArrayList<Player> ShortstopsPlaying;
	private ArrayList<Player> SecondBasemenPlaying;
	private ArrayList<Player> ThirdBasemenPlaying;
	private ArrayList<Player> CatchersPlaying;
	private ArrayList<Player> OFsPlaying;
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
		QBsPlaying = new ArrayList<Player>();
		WRsPlaying = new ArrayList<Player>();
		RBsPlaying = new ArrayList<Player>();
		TEsPlaying = new ArrayList<Player>();
		DSTPlaying = new ArrayList<Player>();
		KickersPlaying = new ArrayList<Player>();
		
		
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
					WRsPlaying.add(new Player(playerName, salary));
					break;
				case "RB":
					FantasyApp.log.debug("Adding RB");
					RBsPlaying.add(new Player(playerName, salary));
					break;
				case "TE":
					FantasyApp.log.debug("Adding TE");
					TEsPlaying.add(new Player(playerName, salary));
					break;
				case "QB":
					FantasyApp.log.debug("Adding QB");
					QBsPlaying.add(new Player(playerName, salary));
					break;
				case "K":
					FantasyApp.log.debug("Adding Kicker");
					KickersPlaying.add(new Player(playerName, salary));
					break;
				case "D":
					FantasyApp.log.debug("Adding Defense/ST");
					DSTPlaying.add(new Player(playerName, salary));
					break;
				}
				FantasyApp.log.debug("Position:  "+position+"  Name: "+playerName+"  Salary:  "+salary);
			}
		}
		FantasyApp.log.info("The website FanDuel was scraped sucessfully");	
	}

	private void scrapeBaseball() {
		PitchersPlaying = new ArrayList<Player>();
		SecondBasemenPlaying = new ArrayList<Player>();
		ShortstopsPlaying = new ArrayList<Player>();
		ThirdBasemenPlaying = new ArrayList<Player>();
		CatchersPlaying = new ArrayList<Player>();
		OFsPlaying = new ArrayList<Player>();
		FirstbasemenPlaying = new ArrayList<Player>();
		
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
					OFsPlaying.add(new Player(playerName, salary));
					break;
				case "C":
					FantasyApp.log.debug("Adding C");
					CatchersPlaying.add(new Player(playerName, salary));
					break;
				case "SS":
					FantasyApp.log.debug("Adding SS");
					ShortstopsPlaying.add(new Player(playerName, salary));
					break;
				case "3B":
					FantasyApp.log.debug("Adding 3B");
					ThirdBasemenPlaying.add(new Player(playerName, salary));
					break;
				case "2B":
					FantasyApp.log.debug("Adding 2B");
					SecondBasemenPlaying.add(new Player(playerName, salary));
					break;
				case "1B":
					FantasyApp.log.debug("Adding 1B");
					FirstbasemenPlaying.add(new Player(playerName, salary));
					break;
				case "P":
					FantasyApp.log.debug("Adding P");
					PitchersPlaying.add(new Player(playerName, salary));
					break;
				}
				FantasyApp.log.debug("Position:  "+position+"  Name: "+playerName+"  Salary:  "+salary);
			}
		}
		FantasyApp.log.info("The website FanDuel was scraped sucessfully");
		
	}

	private void scrapeBasketball() {
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
}
