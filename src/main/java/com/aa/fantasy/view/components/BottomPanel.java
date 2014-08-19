package com.aa.fantasy.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.aa.fantasy.controller.FantasyController;

public class BottomPanel extends JPanel {
	private JButton analyzeLineup;
	private JButton pullFantasyButton;
	
	public BottomPanel(){
		super(new FlowLayout());
		this.setBackground(Color.WHITE);
		Border blackLine = BorderFactory.createMatteBorder(1, 0, 1, 0, Color.BLACK);
		this.setBorder(blackLine);
		addPullDataButton();
		addAnalyzeLineupButton();
		setPreferredSize(new Dimension(1300, 100));
	}

	public void addAnalyzeButtonListener(ActionListener listener){
		analyzeLineup.setActionCommand("analyze");
		analyzeLineup.addActionListener(listener);
	}

	public void addPullDataButtonListener(ActionListener listener){
		pullFantasyButton.setActionCommand("pullFantasy");
		pullFantasyButton.addActionListener(listener);
	}
	private void addAnalyzeLineupButton() {
		analyzeLineup = new JButton("Analyze Lineup");
		analyzeLineup.setPreferredSize(new Dimension(200,75));
		analyzeLineup.setSelected(false);
		analyzeLineup.setFocusable(false);
		this.add(analyzeLineup,BorderLayout.CENTER);	
	}

	private void addPullDataButton() {
		pullFantasyButton = new JButton("Get Today's Data from FanDuel");
		pullFantasyButton.setPreferredSize(new Dimension(300,75));
		pullFantasyButton.setSelected(false);
		pullFantasyButton.setFocusable(false);
		this.add(pullFantasyButton, BorderLayout.CENTER);
	}
}
