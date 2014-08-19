package com.aa.fantasy.view;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.ProgressMonitor;

import com.aa.fantasy.controller.FantasyApp;

public class AnalyzeProgressBar extends ProgressMonitor implements PropertyChangeListener {

	public AnalyzeProgressBar(int max, JFrame mainFrame){
		super(mainFrame, "Analyzing Possible Lineups...", "", 0, max);
		FantasyApp.log.debug("Creating the progress monitor...");
		setProgress(0);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("progress")){//If the PGs Playing changes
			FantasyApp.log.debug("AnalyzeProgressBar knows that the progess has changed");
			this.setProgress((int) evt.getNewValue());
		}

	}
}
