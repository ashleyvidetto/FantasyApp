package com.aa.fantasy.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.aa.fantasy.controller.FantasyController;

public class FanDuelButtonListener implements ActionListener {

	private String FanDuelURL; //The URL page to scrape
	private FantasyController controller;

	public FanDuelButtonListener(FantasyController controller){
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FanDuelURL = "";
		JPanel analyzePane = new JPanel();
		analyzePane.add(new JLabel("Insert the FanDuel URL Match String to pull data: "));
		JTextField urlTextField = new JTextField(60);
		analyzePane.add(urlTextField);
		Object[] options = {"Back", "Use this URL!"};
		int result = JOptionPane.showOptionDialog(null, analyzePane, "Pull down player data", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
		if (result == JOptionPane.NO_OPTION){
			FanDuelURL = urlTextField.getText();
		}	
	}
}
