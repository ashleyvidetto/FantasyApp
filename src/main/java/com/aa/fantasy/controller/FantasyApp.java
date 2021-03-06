
/**
 * Main method class for Fantasy App.
 * Creates the User Interface and adds listeners for the rest of the program properties
 */

package com.aa.fantasy.controller;
import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

import com.av.fantasy.dao.FantasyFactory;


public class FantasyApp{
	
public static Logger log = Logger.getLogger(FantasyApp.class.getName());

	public static void main(String[] args){
		RollingFileAppender newAppender = new RollingFileAppender();
		log.addAppender(newAppender);
		new FantasyFactory().build();
	}
	

}
