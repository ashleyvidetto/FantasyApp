package com.av.fantasy.view;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.aa.fantasy.view.components.AnalyzePane;

public class AnalyzePaneTest {
	
	public static void main(String[] args){
		testAnalyzePopup();
	}

	private static void testAnalyzePopup() {
		JDialog testDialog = new JDialog();
		JPanel testAnalyzePane = new AnalyzePane();
		testDialog.setContentPane(testAnalyzePane);
		testDialog.pack();
		testDialog.setVisible(true);
		
	}

}
