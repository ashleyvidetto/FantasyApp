package com.aa.fantasy.view.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.aa.fantasy.controller.FantasyController;

public class LeftSidePanel extends JPanel {
private FantasyController controller;

	public LeftSidePanel(){
		super();
		this.setBackground(Color.WHITE);
		Border blackLine = BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK);
		this.setBorder(blackLine);
		this.setPreferredSize(new Dimension(150,750));
	}
	
}
