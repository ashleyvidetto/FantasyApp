package com.av.fantasy.view;

import javax.swing.JFrame;

import com.aa.fantasy.view.components.PlayerTablePanel;

public class PlayerTablePanelTest{
	private static JFrame testFrame;
	private static PlayerTablePanel playerPanel;

	public static void main(String[] args){
		showPlayerTablePanel();
	}
	private static void showPlayerTablePanel(){

		testFrame = new JFrame();
		playerPanel = new PlayerTablePanel();
		testFrame.getContentPane().add(playerPanel);
		testFrame.pack();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setVisible(true);
	}

}