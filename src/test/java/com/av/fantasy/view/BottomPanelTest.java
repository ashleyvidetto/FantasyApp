package com.av.fantasy.view;

import javax.swing.JFrame;

import com.aa.fantasy.view.components.BottomPanel;

public class BottomPanelTest{
private static JFrame testFrame;
private static BottomPanel bottompanel;

public static void main(String[] args){
	testBottomPanel();
}
private static void testBottomPanel(){
	
	testFrame = new JFrame();
	bottompanel = new BottomPanel();
	testFrame.add(bottompanel);
	testFrame.pack();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	testFrame.setVisible(true);
}
	
}
