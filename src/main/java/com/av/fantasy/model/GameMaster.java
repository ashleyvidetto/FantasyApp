package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JProgressBar;

import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.view.AnalyzeProgressBar;

public class GameMaster {
	private ArrayList<Player> PGsPlaying;
	private ArrayList<Player> SGsPlaying;
	private ArrayList<Player> SFsPlaying;
	private ArrayList<Player> PFsPlaying;
	private ArrayList<Player> CentersPlaying;
	private ArrayList<Lineup> PossibleLineups;
	private FanDuelScraper scraper;
	private PropertyChangeSupport pcs; 

	public GameMaster(FanDuelScraper scraper){

		this.scraper = scraper;
		pcs = new PropertyChangeSupport(this);
		PGsPlaying = new ArrayList<Player>();
		SGsPlaying = new ArrayList<Player>();
		SFsPlaying = new ArrayList<Player>();
		PFsPlaying = new ArrayList<Player>();
		CentersPlaying = new ArrayList<Player>();
		PossibleLineups = new ArrayList<Lineup>();
	}

	public void getPlayersPlaying(String URL){
		scraper.scrapeWebsite(URL,this);
	}

	public void analyzePossiblePlayers(AnalyzeProgressBar progress) {
		DefaultFormat f = new DefaultFormat();
		f.addPropertyChangeListener(progress);
		LinkedList<Lineup> possibleLineups = f.generatePossibleLineups(PGsPlaying, SGsPlaying, SFsPlaying, PFsPlaying, CentersPlaying);
		FantasyApp.log.info("There are "+possibleLineups.size()+" possible lineups");
	}







	//Property Change Support Methods
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}



	//Getter and Setter Methods
	public ArrayList<Player> getPGsPlaying() {
		return PGsPlaying;
	}

	public void setPGsPlaying(ArrayList<Player> pGsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for PGs");
		ArrayList<Player> oldPGsPlaying = PGsPlaying;
		PGsPlaying = pGsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "PGsPlaying", oldPGsPlaying, PGsPlaying));
	}

	public ArrayList<Player> getSGsPlaying() {
		return SGsPlaying;
	}

	public void setSGsPlaying(ArrayList<Player> sGsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for SGs");
		ArrayList<Player> oldSGsPlaying = SGsPlaying;
		SGsPlaying = sGsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "SGsPlaying", oldSGsPlaying, SGsPlaying));
	}

	public ArrayList<Player> getSFsPlaying() {
		return SFsPlaying;
	}

	public void setSFsPlaying(ArrayList<Player> sFsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for SFs");
		ArrayList<Player> oldSFsPlaying = SFsPlaying;
		SFsPlaying = sFsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "SFsPlaying", oldSFsPlaying, SFsPlaying));
	}

	public ArrayList<Player> getPFsPlaying() {
		return PFsPlaying;
	}

	public void setPFsPlaying(ArrayList<Player> pFsPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for PFs");
		ArrayList<Player> oldPFsPlaying = PFsPlaying;
		PFsPlaying = pFsPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "PFsPlaying", oldPFsPlaying, PFsPlaying));
	}

	public ArrayList<Player> getCentersPlaying() {
		return CentersPlaying;
	}

	public void setCentersPlaying(ArrayList<Player> centersPlaying) {
		FantasyApp.log.debug("Setting a new arraylist for Centers");
		ArrayList<Player> oldCentersPlaying = CentersPlaying;
		CentersPlaying = centersPlaying;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "CentersPlaying", oldCentersPlaying, CentersPlaying));
	}

	public ArrayList<Lineup> getPossibleLineups() {
		return PossibleLineups;
	}

	public void setPossibleLineups(ArrayList<Lineup> possibleLineups) {
		PossibleLineups = possibleLineups;
	}

}
