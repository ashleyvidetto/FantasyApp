package com.av.fantasy.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import com.aa.fantasy.view.AnalyzeProgressBar;

public abstract class GameMaster {

	protected ArrayList<Lineup> PossibleLineups;
	protected FanDuelScraper scraper;
	protected PropertyChangeSupport pcs; 

	public GameMaster(){
		pcs = new PropertyChangeSupport(this);
		PossibleLineups = new ArrayList<Lineup>();
	}

	public abstract void getPlayersPlaying(String URL);

	public abstract void analyzePossiblePlayers();


	//Property Change Support Methods
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}





}
