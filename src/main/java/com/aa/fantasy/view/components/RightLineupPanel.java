/**
 * This UI Panel will be on the right side of the screen and display suggested lineups, as well as let the user select players they must have.
 */

package com.aa.fantasy.view.components;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RightLineupPanel extends JPanel {
	private JTabbedPane tabbedPane;
	private JPanel playerInfo;
	private JPanel lineup;

	public RightLineupPanel(){
		super();
		Border blackLine = BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK);
		this.setBorder(blackLine);
		this.setPreferredSize(new Dimension(350,750));
		addPanes();
		this.add(tabbedPane);
	}

	private void addPanes() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(350, 620));
		
		//Panel 1 - This will be a focus of a particular player
		playerInfo = createPlayerInfoPanel();
		tabbedPane.addTab("Players", playerInfo);

		//Panel 2 - This will contain an active lineup
		lineup = createLineupPanel();
		tabbedPane.addTab("My Lineup", lineup);
		
	}

	private JPanel createLineupPanel() {
		JPanel lp = new JPanel();
		lp.setPreferredSize(new Dimension(350,620));
		GridBagLayout gbl = new GridBagLayout();
		lp.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.weightx = 1;
		JLabel PG1 = new JLabel("Point Guard #1 :");
		gbc.gridx = 0;
		gbc.gridy = 0;
		lp.add(PG1, gbc);
		JLabel PG1Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 0;
		lp.add(PG1Value, gbc);
		JLabel PG2 = new JLabel("Point Guard #2 :");
		gbc.gridx = 0;
		gbc.gridy = 1;
		lp.add(PG2, gbc);
		JLabel PG2Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 1;
		lp.add(PG2Value, gbc);
		JLabel SG1 = new JLabel("Shooting Guard #1 :");
		gbc.gridx = 0;
		gbc.gridy = 2;
		lp.add(SG1, gbc);
		JLabel SG1Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 2;
		lp.add(SG1Value, gbc);
		JLabel SG2 = new JLabel("Shooting Guard #2 :");
		gbc.gridx = 0;
		gbc.gridy = 3;
		lp.add(SG2, gbc);
		JLabel SG2Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 3;
		lp.add(SG2Value, gbc);
		JLabel SF1 = new JLabel("Small Forward #1 :");
		gbc.gridx = 0;
		gbc.gridy = 4;
		lp.add(SF1, gbc);
		JLabel SF1Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 4;
		lp.add(SF1Value, gbc);
		JLabel SF2 = new JLabel("Small Forward #2 :");
		gbc.gridx = 0;
		gbc.gridy = 5;
		lp.add(SF2, gbc);
		JLabel SF2Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 5;
		lp.add(SF2Value, gbc);
		JLabel PF1 = new JLabel("Power Forward #1 :");
		gbc.gridx = 0;
		gbc.gridy = 6;
		lp.add(PF1, gbc);
		JLabel PF1Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 6;
		lp.add(PF1Value, gbc);
		JLabel PF2 = new JLabel("Power Forward #2 :");
		gbc.gridx = 0;
		gbc.gridy = 7;
		lp.add(PF2, gbc);
		JLabel PF2Value = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 7;
		lp.add(PF2Value, gbc);
		JLabel Center = new JLabel("Center :");
		gbc.gridx = 0;
		gbc.gridy = 8;
		lp.add(Center, gbc);
		JLabel CenterValue = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 8;
		lp.add(CenterValue, gbc);
		JLabel Salary = new JLabel("Salary");
		gbc.gridx = 0;
		gbc.gridy = 9;
		lp.add(Salary, gbc);
		JLabel SalaryValue = new JLabel("");
		gbc.gridx = 1;
		gbc.gridy = 9;
		lp.add(SalaryValue, gbc);
		return lp;
	}

	private JPanel createPlayerInfoPanel() {
		JPanel pp = new JPanel();
		pp.setPreferredSize(new Dimension(350,620));
		GridBagLayout gbl = new GridBagLayout();	
		pp.setLayout(gbl);
		
		
		//The first component will be the picture
		JPanel picture = new JPanel();
		picture.setPreferredSize(new Dimension(100,100));
		picture.setBackground(Color.WHITE);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		pp.add(picture, gbc);
		
		//The second component will be a label with the name of the player
		JLabel nameLabel = new JLabel("No Player Selected");
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.CENTER;
		pp.add(nameLabel, gbc2);
		
		//The third component is a Panel of averages
		JPanel averagesPanel = new JPanel();
		averagesPanel.setLayout(new BoxLayout(averagesPanel, BoxLayout.PAGE_AXIS));
		averagesPanel.add(new JLabel("Average PTS: "));
		averagesPanel.add(new JLabel("Average Rebounds: "));
		averagesPanel.add(new JLabel("Average Assists: "));
		averagesPanel.add(new JLabel("Average Steals: "));
		averagesPanel.add(new JLabel("Average Turnovers: "));
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		gbc3.anchor = GridBagConstraints.LINE_START;
		gbc3.weighty = .3;
		pp.add(averagesPanel, gbc3);
		
		//The fourth component is Notes
		JPanel notesPanel = new JPanel();
		notesPanel.setLayout(new BoxLayout(notesPanel, BoxLayout.PAGE_AXIS));
		JTextArea notesText = new JTextArea();
		JLabel notes = new JLabel("Notes: ");
		notesPanel.add(notes);
		notesPanel.add(notesText);
		notesPanel.setPreferredSize(new Dimension(250,100));
		GridBagConstraints gbc4 = new GridBagConstraints();
		gbc4.gridx = 0;
		gbc4.gridy = 3;
		gbc4.weighty = 0.6;
		gbc4.anchor = GridBagConstraints.PAGE_END;
		pp.add(notesPanel, gbc4);
		
		//The fifth component is an update button
		JButton update = new JButton("Update Player");
		GridBagConstraints gbc5 = new GridBagConstraints();
		gbc5.gridx = 0;
		gbc5.gridy = 4;
		gbc5.weighty = .1;
		gbc5.anchor = GridBagConstraints.PAGE_END;
		pp.add(update, gbc5);
		
		return pp;
		
	}



}
