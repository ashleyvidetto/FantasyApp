package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.view.AnalyzeProgressBar;

public class BaseballMaster extends GameMaster {
	private ArrayList<Player> pitchersPlaying;
	private ArrayList<Player> firstbasemenPlaying;
	private ArrayList<Player> secondbasemenPlaying;
	private ArrayList<Player> shortstopsPlaying;
	private ArrayList<Player> thirdbasemenPlaying;
	private ArrayList<Player> catchersPlaying;
	private ArrayList<Player> outfieldersPlaying;
	
	public BaseballMaster() {
		super();
		scraper = new FanDuelScraper("baseball");
		pitchersPlaying = new ArrayList<Player>();
		firstbasemenPlaying = new ArrayList<Player>();
		secondbasemenPlaying = new ArrayList<Player>();
		shortstopsPlaying = new ArrayList<Player>();
		thirdbasemenPlaying = new ArrayList<Player>();
		catchersPlaying = new ArrayList<Player>();
		outfieldersPlaying = new ArrayList<Player>();
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
	public ArrayList<Player> getPitchersPlaying() {
		return pitchersPlaying;
	}

	public void setPitchersPlaying(ArrayList<Player> pitchersPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Pitchers Playing");
		ArrayList<Player> oldPitchersPlaying = this.pitchersPlaying;
		this.pitchersPlaying = pitchersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "Pitchers", oldPitchersPlaying, this.pitchersPlaying));
		
	}

	public ArrayList<Player> getFirstbasemenPlaying() {
		return firstbasemenPlaying;
	}

	public void setFirstbasemenPlaying(ArrayList<Player> firstbasemenPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Firstbasemen Playing");
		ArrayList<Player> oldPlaying = this.firstbasemenPlaying;
		this.firstbasemenPlaying = firstbasemenPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "first", oldPlaying, this.firstbasemenPlaying));
	}

	public ArrayList<Player> getSecondbasemenPlaying() {
		return secondbasemenPlaying;
	}

	public void setSecondbasemenPlaying(ArrayList<Player> secondbasemenPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Secondbasemen Playing");
		ArrayList<Player> oldPlaying = this.secondbasemenPlaying;
		this.secondbasemenPlaying = secondbasemenPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "2bs", oldPlaying, this.secondbasemenPlaying));
	}

	public ArrayList<Player> getShortstopsPlaying() {
		return shortstopsPlaying;
	}

	public void setShortstopsPlaying(ArrayList<Player> shortstopsPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Shortstops Playing");
		ArrayList<Player> oldPlaying = this.shortstopsPlaying;
		this.shortstopsPlaying = shortstopsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "SS", oldPlaying, this.shortstopsPlaying));
	}

	public ArrayList<Player> getThirdbasemenPlaying() {
		return thirdbasemenPlaying;
	}

	public void setThirdbasemenPlaying(ArrayList<Player> thirdbasemenPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of 3Bs Playing");
		ArrayList<Player> oldPlaying = this.thirdbasemenPlaying;
		this.thirdbasemenPlaying = thirdbasemenPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "3bs", oldPlaying, this.thirdbasemenPlaying));
	}

	public ArrayList<Player> getCatchersPlaying() {
		return catchersPlaying;
	}

	public void setCatchersPlaying(ArrayList<Player> catchersPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Catchers Playing");
		ArrayList<Player> oldPlaying = this.catchersPlaying;
		this.catchersPlaying = catchersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "catchers", oldPlaying, this.catchersPlaying));
	}

	public ArrayList<Player> getOutfieldersPlaying() {
		return outfieldersPlaying;
	}

	public void setOutfieldersPlaying(ArrayList<Player> outfieldersPlaying) {
		FantasyApp.log.debug("BaseballMaster has a new set of Outfielders Playing");
		ArrayList<Player> oldPlaying = this.outfieldersPlaying;
		this.outfieldersPlaying = outfieldersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "OFs", oldPlaying, this.outfieldersPlaying));
	}
	
}

	
