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
		FanDuelScraper scraper = new FanDuelScraper();
		pitchersPlaying = new ArrayList<Player>();
		firstbasemenPlaying = new ArrayList<Player>();
		secondbasemenPlaying = new ArrayList<Player>();
		shortstopsPlaying = new ArrayList<Player>();
		thirdbasemenPlaying = new ArrayList<Player>();
		PossibleLineups = new ArrayList<Lineup>();
	}
	
	public void analyzePossiblePlayers() {
		DefaultFormat f = new DefaultFormat();
		LinkedList<Lineup> possibleLineups = f.generatePossibleLineups(pitchersPlaying, firstbasemenPlaying, secondbasemenPlaying, shortstopsPlaying, thirdbasemenPlaying);
		FantasyApp.log.info("There are "+possibleLineups.size()+" possible lineups");
	}
	
	//Getter and Setter Methods
		public ArrayList<Player> getPGsPlaying() {
			return pitchersPlaying;
		}

		public void setPGsPlaying(ArrayList<Player> pGsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for PGs");
			ArrayList<Player> oldPGsPlaying = pitchersPlaying;
			pitchersPlaying = pGsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "PGsPlaying", oldPGsPlaying, pitchersPlaying));
		}

		public ArrayList<Player> getSGsPlaying() {
			return firstbasemenPlaying;
		}

		public void setSGsPlaying(ArrayList<Player> sGsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for SGs");
			ArrayList<Player> oldSGsPlaying = firstbasemenPlaying;
			firstbasemenPlaying = sGsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "SGsPlaying", oldSGsPlaying, firstbasemenPlaying));
		}

		public ArrayList<Player> getSFsPlaying() {
			return secondbasemenPlaying;
		}

		public void setSFsPlaying(ArrayList<Player> sFsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for SFs");
			ArrayList<Player> oldSFsPlaying = secondbasemenPlaying;
			secondbasemenPlaying = sFsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "SFsPlaying", oldSFsPlaying, secondbasemenPlaying));
		}

		public ArrayList<Player> getPFsPlaying() {
			return shortstopsPlaying;
		}

		public void setPFsPlaying(ArrayList<Player> pFsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for PFs");
			ArrayList<Player> oldPFsPlaying = shortstopsPlaying;
			shortstopsPlaying = pFsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "PFsPlaying", oldPFsPlaying, shortstopsPlaying));
		}

		public ArrayList<Player> getCentersPlaying() {
			return thirdbasemenPlaying;
		}

		public void setCentersPlaying(ArrayList<Player> centersPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for Centers");
			ArrayList<Player> oldCentersPlaying = thirdbasemenPlaying;
			thirdbasemenPlaying = centersPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "CentersPlaying", oldCentersPlaying, thirdbasemenPlaying));
		}

		public ArrayList<Lineup> getPossibleLineups() {
			return PossibleLineups;
		}

		public void setPossibleLineups(ArrayList<Lineup> possibleLineups) {
			PossibleLineups = possibleLineups;
		}

}		
