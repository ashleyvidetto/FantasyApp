package com.av.fantasy.view;

import javax.swing.JFrame;

import com.aa.fantasy.view.components.RightLineupPanel;

public class RightLineupPanelTest{
	private static JFrame testFrame;
	private static RightLineupPanel rightpanel;

	public static void main(String[] args){
		testRightLineupPanel();
	}
	private static void testRightLineupPanel(){

		testFrame = new JFrame();
		rightpanel = new RightLineupPanel();
		testFrame.add(rightpanel);
		testFrame.pack();
		testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		testFrame.setVisible(true);
	}

}