package com.av.fantasy.view;

import javax.swing.JFrame;

import com.aa.fantasy.view.components.RightSidePanel;

public class RightSidePanelTest{
	private static JFrame testFrame;
	private static RightSidePanel rightPanel;


	public static void main(String[] args){
		showRightSidePanel();
	}
	private static void showRightSidePanel(){
		testFrame = new JFrame(); 
		rightPanel = new RightSidePanel();
		testFrame.add(rightPanel);
		testFrame.pack();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setVisible(true);
	}

}