package com.av.fantasy.dao;

import com.aa.fantasy.controller.FantasyController;
import com.aa.fantasy.view.FantasyView;
import com.av.fantasy.model.FanDuelScraper;
import com.av.fantasy.model.GameMaster;

public class FantasyFactory {


	public void build(){
		FanDuelScraper scraper = new FanDuelScraper();
		GameMaster master = new GameMaster(scraper); //model is created
		FantasyView view = new FantasyView();
		new FantasyController(master, view);
	}
}
