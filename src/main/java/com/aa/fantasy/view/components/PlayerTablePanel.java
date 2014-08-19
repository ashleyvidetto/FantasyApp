package com.aa.fantasy.view.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import com.aa.fantasy.controller.FantasyApp;
import com.aa.fantasy.view.tableModels.CenterTableModel;
import com.aa.fantasy.view.tableModels.PFTableModel;
import com.aa.fantasy.view.tableModels.PGTableModel;
import com.aa.fantasy.view.tableModels.SFTableModel;
import com.aa.fantasy.view.tableModels.SGTableModel;



public class PlayerTablePanel extends JPanel {

	private JTabbedPane tabbedPane;
	private JLabel posPlayers;
	private JTable pgTable;
	private JTable sgTable;
	private JTable pfTable;
	private JTable sfTable;
	private JTable centerTable;
	private PGTableModel pgmodel;
	private SGTableModel sgmodel;
	private SFTableModel sfmodel;
	private PFTableModel pfmodel;
	private CenterTableModel centermodel;
	

	public PlayerTablePanel(){
		super(new GridBagLayout());
		pgmodel = new PGTableModel();
		sgmodel = new SGTableModel();
		sfmodel = new SFTableModel();
		pfmodel = new PFTableModel();
		centermodel = new CenterTableModel();
		pgTable = new JTable(pgmodel);
		sgTable = new JTable(sgmodel);
		pfTable = new JTable(pfmodel);
		sfTable = new JTable(sfmodel);
		centerTable = new JTable(centermodel);
		
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

	private void createTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setPreferredSize(new Dimension(940, 550));
		
		
		//Panel 1 - This will be a table of possible point guards
		JScrollPane PGTable = new JScrollPane(pgTable);
		tabbedPane.addTab("Point Guards", PGTable);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		//Panel 2 - This will be a table of possible shooting guards
		JScrollPane SGTableScroll = new JScrollPane(sgTable);
		tabbedPane.addTab("Shooting Guards", SGTableScroll);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		//Panel 3 - This will be a table of possible small forwards
		JScrollPane SFTableScroll = new JScrollPane(sfTable);
		tabbedPane.addTab("Small Forwards",SFTableScroll);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		//Panel 4 - This will be a table of possible power forwards
		JScrollPane PFTableScroll = new JScrollPane(pfTable);
		tabbedPane.addTab("Power Forwards", PFTableScroll);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		
		//Panel 5 - This will be a table of possible centers
		JScrollPane CenterTableScroll = new JScrollPane(centerTable);
		tabbedPane.addTab("Centers", CenterTableScroll);
		tabbedPane.setMnemonicAt(4, KeyEvent.VK_5);
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
	
	public SGTableModel getSgmodel() {
		return sgmodel;
	}

	public void setSgmodel(SGTableModel sgmodel) {
		this.sgmodel = sgmodel;
	}

	public SFTableModel getSfmodel() {
		return sfmodel;
	}

	public void setSfmodel(SFTableModel sfmodel) {
		this.sfmodel = sfmodel;
	}

	public PFTableModel getPfmodel() {
		return pfmodel;
	}

	public void setPfmodel(PFTableModel pfmodel) {
		this.pfmodel = pfmodel;
	}

	public CenterTableModel getCentermodel() {
		return centermodel;
	}

	public void setCentermodel(CenterTableModel centermodel) {
		this.centermodel = centermodel;
	}

	public PGTableModel getPGTableModel(){
		return pgmodel;
	}

}
