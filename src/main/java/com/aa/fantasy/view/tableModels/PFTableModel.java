package com.aa.fantasy.view.tableModels;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.table.AbstractTableModel;

import com.aa.fantasy.controller.FantasyApp;
import com.av.fantasy.model.BasketballPlayer;

public class PFTableModel extends AbstractTableModel implements PropertyChangeListener {
	private String[] columns = {"Name","Team","Salary","Notes"};
	private Object[][] data;
	private ArrayList<BasketballPlayer> playerList; //This lists contains the players that should be displayed

	public PFTableModel(){
		super();
		playerList = new ArrayList<BasketballPlayer>();
		BasketballPlayer testPlayer = new BasketballPlayer ("Test Player", 5000);
		playerList.add(testPlayer);
	}

	@Override
	public int getRowCount() {
		return playerList.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex){
		case 0: 
			return playerList.get(rowIndex).getName();
		case 1:
			return playerList.get(rowIndex).getTeam();
		case 2:
			return playerList.get(rowIndex).getSalary();
		case 3:
			return playerList.get(rowIndex).getNotes();
		default: return "No Value";
		}
	}

	public String getColumnName(int Col){
		return columns[Col];
	}

	public void setValueAt(Object value, int row, int col) {
		switch(col){
		case 0:
			playerList.get(row).setName((String) value);
		case 1:
			playerList.get(row).setTeam((String)value);
		case 2:
			playerList.get(row).setSalary((int) value);
		case 3:
			playerList.get(row).setNotes((String) value);
		}
		fireTableCellUpdated(row, col);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		FantasyApp.log.debug("PFTableModel is aware that a property has changed");
		if(evt.getPropertyName().equals("PFsPlaying")){
			playerList = (ArrayList<BasketballPlayer>) evt.getNewValue();
			fireTableDataChanged();
		}
	}
}
