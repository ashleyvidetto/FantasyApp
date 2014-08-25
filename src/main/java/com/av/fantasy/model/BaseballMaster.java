package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.view.AnalyzeProgressBar;

public class BaseballMaster extends GameMaster {
	private ArrayList<BasketballPlayer> pitchersPlaying;
	private ArrayList<BasketballPlayer> firstbasemenPlaying;
	private ArrayList<BasketballPlayer> secondbasemenPlaying;
	private ArrayList<BasketballPlayer> shortstopsPlaying;
	private ArrayList<BasketballPlayer> thirdbasemenPlaying;
	private ArrayList<BasketballPlayer> catchersPlaying;
	private ArrayList<BasketballPlayer> outfieldersPlaying;
	
	public BaseballMaster() {
		super();
		scraper = new FanDuelScraper("baseball");
		pitchersPlaying = new ArrayList<BasketballPlayer>();
		firstbasemenPlaying = new ArrayList<BasketballPlayer>();
		secondbasemenPlaying = new ArrayList<BasketballPlayer>();
		shortstopsPlaying = new ArrayList<BasketballPlayer>();
		thirdbasemenPlaying = new ArrayList<BasketballPlayer>();
		catchersPlaying = new ArrayList<BasketballPlayer>();
		outfieldersPlaying = new ArrayList<BasketballPlayer>();
		PossibleLineups = new ArrayList<Lineup>();
	}
	
	@Override
	public void getPlayersPlaying(String URL) {
		scraper.scrapeWebsite(URL,this);	
	}

	public void analyzePossiblePlayers() {
//		DefaultFormat f = new DefaultFormat();
//		LinkedList<Lineup> possibleLineups = f.generatePossibleLineups(pitchersPlaying, firstbasemenPlaying, secondbasemenPlaying, shortstopsPlaying, thirdbasemenPlaying);
//		FantasyApp.log.info("There are "+possibleLineups.size()+" possible lineups");
	}
	
	// Getter & Setter Methods
	public ArrayList<BasketballPlayer> getPitchersPlaying() {
		return pitchersPlaying;
	}

	public void setPitchersPlaying(ArrayList<BasketballPlayer> pitchersPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Pitchers Playing");
		ArrayList<BasketballPlayer> oldPitchersPlaying = this.pitchersPlaying;
		this.pitchersPlaying = pitchersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "Pitchers", oldPitchersPlaying, this.pitchersPlaying));
		
	}

	public ArrayList<BasketballPlayer> getFirstbasemenPlaying() {
		return firstbasemenPlaying;
	}

	public void setFirstbasemenPlaying(ArrayList<BasketballPlayer> firstbasemenPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Firstbasemen Playing");
		ArrayList<BasketballPlayer> oldPlaying = this.firstbasemenPlaying;
		this.firstbasemenPlaying = firstbasemenPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "first", oldPlaying, this.firstbasemenPlaying));
	}

	public ArrayList<BasketballPlayer> getSecondbasemenPlaying() {
		return secondbasemenPlaying;
	}

	public void setSecondbasemenPlaying(ArrayList<BasketballPlayer> secondbasemenPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Secondbasemen Playing");
		ArrayList<BasketballPlayer> oldPlaying = this.secondbasemenPlaying;
		this.secondbasemenPlaying = secondbasemenPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "2bs", oldPlaying, this.secondbasemenPlaying));
	}

	public ArrayList<BasketballPlayer> getShortstopsPlaying() {
		return shortstopsPlaying;
	}

	public void setShortstopsPlaying(ArrayList<BasketballPlayer> shortstopsPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Shortstops Playing");
		ArrayList<BasketballPlayer> oldPlaying = this.shortstopsPlaying;
		this.shortstopsPlaying = shortstopsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "SS", oldPlaying, this.shortstopsPlaying));
	}

	public ArrayList<BasketballPlayer> getThirdbasemenPlaying() {
		return thirdbasemenPlaying;
	}

	public void setThirdbasemenPlaying(ArrayList<BasketballPlayer> thirdbasemenPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of 3Bs Playing");
		ArrayList<BasketballPlayer> oldPlaying = this.thirdbasemenPlaying;
		this.thirdbasemenPlaying = thirdbasemenPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "3bs", oldPlaying, this.thirdbasemenPlaying));
	}

	public ArrayList<BasketballPlayer> getCatchersPlaying() {
		return catchersPlaying;
	}

	public void setCatchersPlaying(ArrayList<BasketballPlayer> catchersPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Catchers Playing");
		ArrayList<BasketballPlayer> oldPlaying = this.catchersPlaying;
		this.catchersPlaying = catchersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "catchers", oldPlaying, this.catchersPlaying));
	}

	public ArrayList<BasketballPlayer> getOutfieldersPlaying() {
		return outfieldersPlaying;
	}

	public void setOutfieldersPlaying(ArrayList<BasketballPlayer> outfieldersPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Outfielders Playing");
		ArrayList<BasketballPlayer> oldPlaying = this.outfieldersPlaying;
		this.outfieldersPlaying = outfieldersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "OFs", oldPlaying, this.outfieldersPlaying));
	}
	
}

	
