package com.aa.fantasy.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JProgressBar;
import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.controller.FantasyController;
import com.aa.fantasy.view.components.AnalyzePane;
import com.aa.fantasy.view.components.BottomPanel;
import com.aa.fantasy.view.components.LeftSidePanel;
import com.aa.fantasy.view.components.MainFrame;
import com.aa.fantasy.view.components.PlayerTablePanel;
import com.aa.fantasy.view.components.RightLineupPanel;
import com.aa.fantasy.view.components.RightSidePanel;
import com.av.fantasy.model.GameMaster;

public class FantasyView {
	private MainFrame mainFrame;
	private LeftSidePanel leftPanel;
	private RightSidePanel rightPanel;
	private BottomPanel bottomPanel;
	private RightLineupPanel rightLineupPanel;
	private PlayerTablePanel playerTablePanel;
	private JDialog FanDuelDialog;
	private AnalyzePane aPane;

	public FantasyView(){
		createAndShowGUI();
	}

	private void createAndShowGUI() {
		mainFrame = new MainFrame();
		leftPanel = new LeftSidePanel();
		rightPanel = new RightSidePanel();
		mainFrame.getContentPane().add(leftPanel, BorderLayout.LINE_START); //One long panel running down the left side of the screen
		mainFrame.getContentPane().add(rightPanel, BorderLayout.CENTER);  //This panel consists of the top panel and the bottom panel
		bottomPanel = new BottomPanel();
		rightLineupPanel = new RightLineupPanel();
		FantasyApp.log.debug("Creating the table and model");
		playerTablePanel = new PlayerTablePanel();
		rightPanel.add(bottomPanel, BorderLayout.PAGE_END); //Add the Bottom Panel
		rightPanel.add(rightLineupPanel, BorderLayout.LINE_END); //Add the Right Lineup Panel
		rightPanel.add(playerTablePanel, BorderLayout.LINE_START); //Add the panel that contains the Player Table
		mainFrame.setVisible(true);

	}

	public void buttonActionListeners(ActionListener fantasyController) {
		bottomPanel.addAnalyzeButtonListener(fantasyController);
		bottomPanel.addPullDataButtonListener(fantasyController);
	}
	
	//Add the listeners that need to be notified of model state changes
	public void addMasterListeners(GameMaster model) {
		model.addPropertyChangeListener(playerTablePanel.getPGTableModel());
		model.addPropertyChangeListener(playerTablePanel.getSgmodel());
		model.addPropertyChangeListener(playerTablePanel.getSfmodel());
		model.addPropertyChangeListener(playerTablePanel.getPfmodel());
		model.addPropertyChangeListener(playerTablePanel.getCentermodel());
		
		
	}

	/*
	 * ---
	 * JDialog Popups
	 * These are pop up items that can be called from the controller
	 * ___
	 */
	
	/**
	 * Displays a pop up pane that allows the user to input a URL and pulsl down data from FanDuel
	 * @param fantasyController
	 * @return
	 */
	public void displayPullFantasyDataPane(FantasyController fantasyController){
		FanDuelDialog = new JDialog(mainFrame);
		aPane = new AnalyzePane();
		aPane.addControllerAsListener(fantasyController);
		FanDuelDialog.setContentPane(aPane);
		FanDuelDialog.pack();
		FanDuelDialog.setVisible(true);
	}

	public void removePullFantasyDataPane(FantasyController fantasyController) {
		aPane.removeControllerAsListener(fantasyController);
		FanDuelDialog.setVisible(false);
	}

	public AnalyzeProgressBar createAnalyzeProgressBar(int max) {
		AnalyzeProgressBar bar = new AnalyzeProgressBar(max, mainFrame);
		return bar;
	}


}
