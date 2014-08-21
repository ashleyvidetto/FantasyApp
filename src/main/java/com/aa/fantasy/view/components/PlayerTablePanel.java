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
import com.aa.fantasy.view.tableModels.PlayerTableModel;
import com.aa.fantasy.view.tableModels.SFTableModel;
import com.aa.fantasy.view.tableModels.SGTableModel;
import com.av.fantasy.model.Lineup;
import com.av.fantasy.model.Player;



public class PlayerTablePanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JLabel posPlayers;
	private JTable pgTable;
	private JTable sgTable;
	private JTable pfTable;
	private JTable sfTable;
	private JTable centerTable;
	private PlayerTableModel table1;
	private PlayerTableModel table2;
	private SFTableModel table3;
	private PFTableModel table4;
	private CenterTableModel table5;
	private String sport;
	

	public PlayerTablePanel(){
		super(new GridBagLayout());
		
		//Default sport is Baseball
		sport = "BASEBALL";
		
		table1 = new PlayerTableModel();
		table2 = new PlayerTableModel();
		table3 = new SFTableModel();
		table4 = new PFTableModel();
		table5 = new CenterTableModel();
		pgTable = new JTable(new PlayerTableModel());
		sgTable = new JTable(new PlayerTableModel());
		pfTable = new JTable(new PlayerTableModel());
		sfTable = new JTable(new PlayerTableModel());
		centerTable = new JTable(new PlayerTableModel());
		
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
		GridBagConstraints gbc2 = new GridBagConstraints();
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

	//Helper method that created the tabbed pane on the main panel. The sport determines the different tabs on pane.
	private void createTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setPreferredSize(new Dimension(940, 550));
		
		//Based upon the sport - positions will hold the types of players. 
		ArrayList<String> positions = new ArrayList<String>();
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
			break;
		case "FOOTBALL":
			positions.add("Quarterbacks");
			positions.add("Runningbacks");
			positions.add("Wide Receivers");
			positions.add("Tight Ends");
			positions.add("Kickers");
			positions.add("Defenses / ST");
			break;
		}
		
		
		//Create a scrolled pane for each position in the sport.
		Iterator it = positions.iterator();
		while(it.hasNext()){
			JScrollPane PlayerTable = new JScrollPane(new JTable(new PlayerTableModel()));
			tabbedPane.addTab((String) it.next(), PlayerTable);
		}
		
//		//Panel 1 - This will be a table of possible point guards
//		
//		
//		//Panel 2 - This will be a table of possible shooting guards
//		JScrollPane SGTableScroll = new JScrollPane(sgTable);
//		tabbedPane.addTab("Shooting Guards", SGTableScroll);
//		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
//		
//		//Panel 3 - This will be a table of possible small forwards
//		JScrollPane SFTableScroll = new JScrollPane(sfTable);
//		tabbedPane.addTab("Small Forwards",SFTableScroll);
//		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
//
//		//Panel 4 - This will be a table of possible power forwards
//		JScrollPane PFTableScroll = new JScrollPane(pfTable);
//		tabbedPane.addTab("Power Forwards", PFTableScroll);
//		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
//		
//		//Panel 5 - This will be a table of possible centers
//		JScrollPane CenterTableScroll = new JScrollPane(centerTable);
//		tabbedPane.addTab("Centers", CenterTableScroll);
//		tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
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
	public JTable getPgTable() {
		return pgTable;
	}
	
	public PlayerTableModel getSgmodel() {
		return table2;
	}

	public void setSgmodel(PlayerTableModel sgmodel) {
		this.table2 = sgmodel;
	}

	public SFTableModel getSfmodel() {
		return table3;
	}

	public void setSfmodel(SFTableModel sfmodel) {
		this.table3 = sfmodel;
	}

	public PFTableModel getPfmodel() {
		return table4;
	}

	public void setPfmodel(PFTableModel pfmodel) {
		this.table4 = pfmodel;
	}

	public CenterTableModel getCentermodel() {
		return table5;
	}

	public void setCentermodel(CenterTableModel centermodel) {
		this.table5 = centermodel;
	}

	public PlayerTableModel getPGTableModel(){
		return table1;
	}

}
