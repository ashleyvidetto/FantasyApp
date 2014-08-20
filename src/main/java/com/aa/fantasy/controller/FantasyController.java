/**
 * @description This class serves as the controller between the model and the view. 
 */
package com.aa.fantasy.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JProgressBar;

import com.aa.fantasy.view.AnalyzeProgressBar;
import com.aa.fantasy.view.FantasyView;
import com.aa.fantasy.view.components.AnalyzePane;
import com.av.fantasy.model.GameMaster;

public class FantasyController implements ActionListener {
	private FantasyView view;
	private GameMaster model;


	public FantasyController(GameMaster model, FantasyView view){
		this.model = model;
		this.view = view;
		// Add the action listener from this class onto every object in the View
		view.buttonActionListeners(this);
		view.addMasterListeners(model);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//The pull in possible players from FanDuel button was pressed.
		if(e.getActionCommand().equals("pullFantasy")){
			view.displayPullFantasyDataPane(this);
		}
		if(e.getActionCommand().equals("back")){
			FantasyApp.log.debug("Back Button pressed - listener called.");
			view.removePullFantasyDataPane(this);
		}
		
		//Pull Players Button
		if(e.getActionCommand().equals("pullPlayers")){
			//e.getSource is the JButton - we need its parent container.
			FantasyApp.log.debug("Pull button pushed - listener called.");
			String FanDuelURL = ((AnalyzePane)(((JComponent)(e.getSource()))).getParent()).getFanDuelURL();
			model.getPlayersPlaying(FanDuelURL);
			view.removePullFantasyDataPane(this);
		}
		
		//Analyze Button Pressed
		if(e.getActionCommand().equals("analyze")){
			FantasyApp.log.debug("Analyze Button Pressed");
			//AnalyzeProgressBar progress = view.createAnalyzeProgressBar(model.getPGsPlaying().size());
			//create JAnalyzeBar
			model.analyzePossiblePlayers();
		}
	}
}
