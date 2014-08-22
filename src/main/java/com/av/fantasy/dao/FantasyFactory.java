package com.av.fantasy.dao;

import com.aa.fantasy.controller.FantasyController;
import com.aa.fantasy.view.FantasyView;
import com.av.fantasy.model.BaseballMaster;
import com.av.fantasy.model.BasketballMaster;
import com.av.fantasy.model.GameMaster;

public class FantasyFactory {
private GameMaster master;

	public void build(){
		master = new BaseballMaster(); //model is created
		FantasyView view = new FantasyView();
		new FantasyController(master, view);
	}
}
