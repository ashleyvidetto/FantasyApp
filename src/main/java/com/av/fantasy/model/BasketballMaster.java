package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.view.AnalyzeProgressBar;

public class BasketballMaster extends GameMaster {
	private ArrayList<BasketballPlayer> PGsPlaying;
	private ArrayList<BasketballPlayer> SGsPlaying;
	private ArrayList<BasketballPlayer> SFsPlaying;
	private ArrayList<BasketballPlayer> PFsPlaying;
	private ArrayList<BasketballPlayer> CentersPlaying;
	
	public BasketballMaster() {
		super();
		scraper = new FanDuelScraper("basketball");
		PGsPlaying = new ArrayList<BasketballPlayer>();
		SGsPlaying = new ArrayList<BasketballPlayer>();
		SFsPlaying = new ArrayList<BasketballPlayer>();
		PFsPlaying = new ArrayList<BasketballPlayer>();
		CentersPlaying = new ArrayList<BasketballPlayer>();
		PossibleLineups = new ArrayList<Lineup>();
	}
	
	@Override
	public void getPlayersPlaying(String URL) {
		scraper.scrapeWebsite(URL,this);	
	}
	
	public void analyzePossiblePlayers() {
//		DefaultFormat f = new DefaultFormat();
//		LinkedList<Lineup> possibleLineups = f.generatePossibleLineups(PGsPlaying, SGsPlaying, SFsPlaying, PFsPlaying, CentersPlaying);
//		FantasyApp.log.info("There are "+possibleLineups.size()+" possible lineups");
	}
	
	//Getter and Setter Methods
		public ArrayList<BasketballPlayer> getPGsPlaying() {
			return PGsPlaying;
		}

		public void setPGsPlaying(ArrayList<BasketballPlayer> pGsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for PGs");
			ArrayList<BasketballPlayer> oldPGsPlaying = PGsPlaying;
			PGsPlaying = pGsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "pointguards", oldPGsPlaying, PGsPlaying));
		}

		public ArrayList<BasketballPlayer> getSGsPlaying() {
			return SGsPlaying;
		}

		public void setSGsPlaying(ArrayList<BasketballPlayer> sGsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for SGs");
			ArrayList<BasketballPlayer> oldSGsPlaying = SGsPlaying;
			SGsPlaying = sGsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "SGs", oldSGsPlaying, SGsPlaying));
		}

		public ArrayList<BasketballPlayer> getSFsPlaying() {
			return SFsPlaying;
		}

		public void setSFsPlaying(ArrayList<BasketballPlayer> sFsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for SFs");
			ArrayList<BasketballPlayer> oldSFsPlaying = SFsPlaying;
			SFsPlaying = sFsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "SFs", oldSFsPlaying, SFsPlaying));
		}

		public ArrayList<BasketballPlayer> getPFsPlaying() {
			return PFsPlaying;
		}

		public void setPFsPlaying(ArrayList<BasketballPlayer> pFsPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for PFs");
			ArrayList<BasketballPlayer> oldPFsPlaying = PFsPlaying;
			PFsPlaying = pFsPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "PFs", oldPFsPlaying, PFsPlaying));
		}

		public ArrayList<BasketballPlayer> getCentersPlaying() {
			return CentersPlaying;
		}

		public void setCentersPlaying(ArrayList<BasketballPlayer> centersPlaying) {
			FantasyApp.log.debug("Setting a new arraylist for Centers");
			ArrayList<BasketballPlayer> oldCentersPlaying = CentersPlaying;
			CentersPlaying = centersPlaying;
			pcs.firePropertyChange(new PropertyChangeEvent(this, "Centers", oldCentersPlaying, CentersPlaying));
		}

		public ArrayList<Lineup> getPossibleLineups() {
			return PossibleLineups;
		}

		public void setPossibleLineups(ArrayList<Lineup> possibleLineups) {
			PossibleLineups = possibleLineups;
		}
}		
