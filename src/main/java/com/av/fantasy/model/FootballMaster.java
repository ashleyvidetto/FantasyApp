package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import com.aa.fantasy.controller.FantasyApp;

public class FootballMaster extends GameMaster {
	private ArrayList<BasketballPlayer> WRsPlaying;
	private ArrayList<BasketballPlayer> QBsPlaying;
	private ArrayList<BasketballPlayer> RBsPlaying;
	private ArrayList<BasketballPlayer> TEsPlaying;
	private ArrayList<BasketballPlayer> KickersPlaying;
	private ArrayList<BasketballPlayer> DSTPlaying;
	
	public FootballMaster() {
		super();
		scraper = new FanDuelScraper("football");
		WRsPlaying = new ArrayList<BasketballPlayer>();
		QBsPlaying = new ArrayList<BasketballPlayer>();
		RBsPlaying = new ArrayList<BasketballPlayer>();
		TEsPlaying = new ArrayList<BasketballPlayer>();
		KickersPlaying = new ArrayList<BasketballPlayer>();
		DSTPlaying = new ArrayList<BasketballPlayer>();
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
	
	// Getter and Setter Methods
	public ArrayList<BasketballPlayer> getWRsPlaying() {
		return WRsPlaying;
	}

	public void setWRsPlaying(ArrayList<BasketballPlayer> wRsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for WRs");
		ArrayList<BasketballPlayer> oldPlayers = WRsPlaying;
		WRsPlaying = wRsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "WRs", oldPlayers, WRsPlaying));
	}

	public ArrayList<BasketballPlayer> getQBsPlaying() {
		return QBsPlaying;
	}

	public void setQBsPlaying(ArrayList<BasketballPlayer> qBsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for QBs");
		ArrayList<BasketballPlayer> oldPlaying = QBsPlaying;
		QBsPlaying = qBsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "QBs", oldPlaying, QBsPlaying));
	}

	public ArrayList<BasketballPlayer> getRBsPlaying() {
		return RBsPlaying;
	}

	public void setRBsPlaying(ArrayList<BasketballPlayer> rBsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for RBs");
		ArrayList<BasketballPlayer> oldPlaying = RBsPlaying;
		RBsPlaying = rBsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "RBs", oldPlaying, RBsPlaying));
	}

	public ArrayList<BasketballPlayer> getTEsPlaying() {
		return TEsPlaying;
	}

	public void setTEsPlaying(ArrayList<BasketballPlayer> tEsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for TE's");
		ArrayList<BasketballPlayer> oldPlaying = TEsPlaying;
		TEsPlaying = tEsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "TEs", oldPlaying, TEsPlaying));
	}

	public ArrayList<BasketballPlayer> getKickersPlaying() {
		return KickersPlaying;
	}

	public void setKickersPlaying(ArrayList<BasketballPlayer> kickersPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for Kickers playing");
		ArrayList<BasketballPlayer> oldPlaying = KickersPlaying;
		KickersPlaying = kickersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "kickers", oldPlaying, KickersPlaying));
	}

	public ArrayList<BasketballPlayer> getDSTPlaying() {
		return DSTPlaying;
	}

	public void setDSTPlaying(ArrayList<BasketballPlayer> dSTPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for Defense");
		ArrayList<BasketballPlayer> oldPlaying = DSTPlaying;
		DSTPlaying = dSTPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "defense", oldPlaying, DSTPlaying));
	}	
	
}
	
