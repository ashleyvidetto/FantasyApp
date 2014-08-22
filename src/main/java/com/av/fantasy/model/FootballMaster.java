package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import com.aa.fantasy.controller.FantasyApp;

public class FootballMaster extends GameMaster {
	private ArrayList<Player> WRsPlaying;
	private ArrayList<Player> QBsPlaying;
	private ArrayList<Player> RBsPlaying;
	private ArrayList<Player> TEsPlaying;
	private ArrayList<Player> KickersPlaying;
	private ArrayList<Player> DSTPlaying;
	
	public FootballMaster() {
		super();
		scraper = new FanDuelScraper("football");
		WRsPlaying = new ArrayList<Player>();
		QBsPlaying = new ArrayList<Player>();
		RBsPlaying = new ArrayList<Player>();
		TEsPlaying = new ArrayList<Player>();
		KickersPlaying = new ArrayList<Player>();
		DSTPlaying = new ArrayList<Player>();
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
	public ArrayList<Player> getWRsPlaying() {
		return WRsPlaying;
	}

	public void setWRsPlaying(ArrayList<Player> wRsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for WRs");
		ArrayList<Player> oldPlayers = WRsPlaying;
		WRsPlaying = wRsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "WRs", oldPlayers, WRsPlaying));
	}

	public ArrayList<Player> getQBsPlaying() {
		return QBsPlaying;
	}

	public void setQBsPlaying(ArrayList<Player> qBsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for QBs");
		ArrayList<Player> oldPlaying = QBsPlaying;
		QBsPlaying = qBsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "QBs", oldPlaying, QBsPlaying));
	}

	public ArrayList<Player> getRBsPlaying() {
		return RBsPlaying;
	}

	public void setRBsPlaying(ArrayList<Player> rBsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for RBs");
		ArrayList<Player> oldPlaying = RBsPlaying;
		RBsPlaying = rBsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "RBs", oldPlaying, RBsPlaying));
	}

	public ArrayList<Player> getTEsPlaying() {
		return TEsPlaying;
	}

	public void setTEsPlaying(ArrayList<Player> tEsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for TE's");
		ArrayList<Player> oldPlaying = TEsPlaying;
		TEsPlaying = tEsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "TEs", oldPlaying, TEsPlaying));
	}

	public ArrayList<Player> getKickersPlaying() {
		return KickersPlaying;
	}

	public void setKickersPlaying(ArrayList<Player> kickersPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for Kickers playing");
		ArrayList<Player> oldPlaying = KickersPlaying;
		KickersPlaying = kickersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "kickers", oldPlaying, KickersPlaying));
	}

	public ArrayList<Player> getDSTPlaying() {
		return DSTPlaying;
	}

	public void setDSTPlaying(ArrayList<Player> dSTPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for Defense");
		ArrayList<Player> oldPlaying = DSTPlaying;
		DSTPlaying = dSTPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "defense", oldPlaying, DSTPlaying));
	}	
	
}
	
