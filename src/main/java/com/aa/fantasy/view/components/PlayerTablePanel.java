package com.aa.fantasy.view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.view.tableModels.CenterTableModel;
import com.aa.fantasy.view.tableModels.PFTableModel;
import com.aa.fantasy.view.tableModels.Pos1TableModel;
import com.aa.fantasy.view.tableModels.Pos2TableModel;
import com.aa.fantasy.view.tableModels.Pos3TableModel;
import com.aa.fantasy.view.tableModels.Pos4TableModel;
import com.aa.fantasy.view.tableModels.Pos5TableModel;
import com.aa.fantasy.view.tableModels.Pos6TableModel;
import com.aa.fantasy.view.tableModels.Pos7TableModel;
import com.aa.fantasy.view.tableModels.SFTableModel;
import com.aa.fantasy.view.tableModels.SGTableModel;
import com.av.fantasy.model.Lineup;
import com.av.fantasy.model.BasketballPlayer;



public class PlayerTablePanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JLabel posPlayers;
	private GridBagConstraints gbc2;
	private JTable playerTable1;
	private JTable playerTable2;
	private JTable playerTable3;
	private JTable playerTable4;
	private JTable playerTable5;
	private JTable playerTable6;
	private JTable playerTable7;
	private Pos1TableModel model1;
	private Pos2TableModel model2;
	private Pos3TableModel model3;
	private Pos4TableModel model4;
	private Pos5TableModel model5;
	private Pos6TableModel model6;
	private Pos7TableModel model7;
	ArrayList<JTable> tables;


	private String sport;


	public PlayerTablePanel(){
		super(new GridBagLayout());
		
		//Default sport is Baseball
		sport = "BASEBALL";
		
		//Populate the tables needed.
		populateTables();
		
		tabbedPane = new JTabbedPane();
		setPreferredSize(new Dimension(950, 650));
		setBackground(Color.WHITE);

		createTopLabel();
		createTabbedPane();

		//Add the label to the first row, first column
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.weightx = 1;
		gbc.weighty = 1;
		this.add(posPlayers, gbc);

		//Add the tabbedPane to the second row, first column
		gbc2 = new GridBagConstraints();
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc2.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc2.weightx = 1;
		gbc2.weighty = 1;
		this.add(tabbedPane, gbc2);

	}

	private void createTopLabel() {
		posPlayers = new JLabel("<html><b>Possible Players</b></html>");
	}
	
	private void populateTables(){
		model1 = new Pos1TableModel();
		model2 = new Pos2TableModel();
		model3 = new Pos3TableModel();
		model4 = new Pos4TableModel();
		model5 = new Pos5TableModel();
		playerTable1 = new JTable(model1);
		playerTable2 = new JTable(model2);
		playerTable3 = new JTable(model3);
		playerTable4 = new JTable(model4);
		playerTable5 = new JTable(model5);
		tables = new ArrayList<JTable>();
		tables.add(playerTable1);
		tables.add(playerTable2);
		tables.add(playerTable3);
		tables.add(playerTable4);
		tables.add(playerTable5);
	}

	//Helper method that created the tabbed pane on the main panel. The sport determines the different tabs on pane.
	private void createTabbedPane() {
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setPreferredSize(new Dimension(940, 550));

		//Based upon the sport - positions will hold the types of players. 
		ArrayList<String> positions = new ArrayList<String>();
		tabbedPane.removeAll();
		switch(sport.toUpperCase()){
		case "BASKETBALL":
			positions.add("Point Guards");
			positions.add("Shooting Guards");
			positions.add("Small Forwards");
			positions.add("Power Forwards");
			positions.add("Centers");
			break;
		case "BASEBALL":
			positions.add("Pitchers");
			positions.add("1st Basemen");
			positions.add("2nd Basemen");
			positions.add("Shortstops");
			positions.add("3rd Basemen");
			positions.add("Catchers");
			positions.add("Out Fielders");
			//Need seven tables so add two.
			model6 = new Pos6TableModel();
			model7 = new Pos7TableModel();
			playerTable6 = new JTable(model6);
			playerTable7 = new JTable(model7);
			tables.add(playerTable6);
			tables.add(playerTable7);
			break;
		case "FOOTBALL":
			positions.add("Quarterbacks");
			positions.add("Runningbacks");
			positions.add("Wide Receivers");
			positions.add("Tight Ends");
			positions.add("Kickers");
			positions.add("Defenses / ST");
			//Need six tables so add one.
			model6 = new Pos6TableModel();
			playerTable6 = new JTable(model6);
			tables.add(playerTable6);
			break;
		}


		//Create a scrolled pane for each position in the sport.
		Iterator<String> it = positions.iterator();
		Iterator<JTable> tableIT = tables.iterator();
		while(it.hasNext()){
			JScrollPane PlayerTable = new JScrollPane(tableIT.next());
			tabbedPane.addTab((String) it.next(), PlayerTable);
		}
	}


	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	//Getter and Setter Methods

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
		//if sport changes - we need to redraw the table panel
		createTabbedPane();
		this.add(tabbedPane, gbc2); // this should redraw the component since the sport changes
		this.revalidate();
	}

	public PropertyChangeListener getmodel1() {
		return model1;
	}
	public PropertyChangeListener getmodel2() {
		return model2;
	}
	public PropertyChangeListener getmodel3() {
		return model3;
	}
	public PropertyChangeListener getmodel4() {
		return model4;
	}
	public PropertyChangeListener getmodel5() {
		return model5;
	}
	public PropertyChangeListener getmodel6() {
		return model6;
	}
	public PropertyChangeListener getmodel7() {
		return model7;
	}
}
