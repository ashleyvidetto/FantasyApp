package com.av.fantasy.view;

import javax.swing.JFrame;

import com.aa.fantasy.view.components.LeftSidePanel;

public class LeftSidePanelTest {

private static JFrame testFrame;
private static LeftSidePanel leftPanel;

public static void main(String[] args){
	showLeftSidePanel();
}

private static void showLeftSidePanel(){
	testFrame = new JFrame();
	leftPanel = new LeftSidePanel();
	testFrame.add(leftPanel);
	testFrame.pack();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	testFrame.setVisible(true);
}
	
	
	
}
