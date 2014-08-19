package com.av.fantasy.view;

import javax.swing.JFrame;

import com.aa.fantasy.view.AnalyzeProgressBar;

public class AnalyzeProgressBarTest {

private static JFrame testFrame;
private static AnalyzeProgressBar bar;

public static void main(String[] args){
	showLeftSidePanel();
}

private static void showLeftSidePanel(){
	testFrame = new JFrame();
	bar = new AnalyzeProgressBar(10, testFrame);
	testFrame.pack();
	testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	testFrame.setVisible(true);
}
	

}
