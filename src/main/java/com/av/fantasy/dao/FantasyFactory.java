package com.av.fantasy.dao;

import com.aa.fantasy.controller.FantasyController;
import com.aa.fantasy.view.FantasyView;
import com.av.fantasy.model.BasketballMaster;
import com.av.fantasy.model.FanDuelScraper;
import com.av.fantasy.model.GameMaster;

public class FantasyFactory {
private GameMaster master;

	public void build(){
		//Right now let's default to basketball. 
		FanDuelScraper scraper = new FanDuelScraper();
		master = new BasketballMaster(scraper); //model is created
		FantasyView view = new FantasyView();
		new FantasyController(master, view);
	}
}
