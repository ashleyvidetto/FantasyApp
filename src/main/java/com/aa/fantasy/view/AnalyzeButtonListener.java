package com.aa.fantasy.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.aa.fantasy.controller.FantasyController;

public class AnalyzeButtonListener implements ActionListener {
	private JPanel panel;
	private FantasyController fantasyController;
	public AnalyzeButtonListener(JPanel panel, FantasyController fantasyController) {
		this.panel = panel;
		this.fantasyController = fantasyController;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane analyzePane = new JOptionPane();
		analyzePane.setWantsInput(false);
		analyzePane.setMessage("Analyze Lineups Pressed!");
		analyzePane.setIcon(null);
		JDialog dialog = analyzePane.createDialog(panel, "Alert");
		dialog.show();
	}

}
