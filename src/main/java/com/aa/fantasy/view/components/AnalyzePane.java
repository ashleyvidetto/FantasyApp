package com.aa.fantasy.view.components;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.aa.fantasy.controller.FantasyController;

public class AnalyzePane extends JPanel {
	private JLabel label;
	private JTextField urlTextField;
	private JButton getPlayers;
	private JButton back;
	
	public AnalyzePane(){
		super();
		label = new JLabel("Insert the FanDuel URL Match String to pull data: ");
		urlTextField = new JTextField(60);
		getPlayers = new JButton("Get Today's Players");
		back = new JButton("Back");

		//add the components to the panel
		add(label);
		add(urlTextField);
		add(getPlayers);
		add(back);
	}

	public void addControllerAsListener(ActionListener listener) {
		getPlayers.setActionCommand("pullPlayers");
		back.setActionCommand("back");
		getPlayers.addActionListener(listener);
		back.addActionListener(listener);
	}
	
	public void removeControllerAsListener(ActionListener listener){
//		getPlayers.removeActionListener(listener);
//		back.removeActionListener(listener);
	}
	
	public String getFanDuelURL(){
		return urlTextField.getText();
	}
}
