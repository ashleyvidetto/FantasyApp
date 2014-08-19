package com.aa.fantasy.view.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.aa.fantasy.controller.FantasyController;

public class RightSidePanel extends JPanel {
	public RightSidePanel(){
		super(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(1300, 750));
	}

}
