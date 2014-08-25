/**
 * This class srapes the ESPN website to get player rater data.
 */
package com.av.fantasy.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.aa.fantasy.controller.FantasyApp;

public class PlayerRaterScraper {

	public PlayerRaterScraper(){
		scrapeCatchers();
	}

	private Document doc;

	private void scrapeCatchers(){
		//Get the 2014 Season PlayerRater for catchers
		try {
			doc = Jsoup.connect("http://games.espn.go.com/flb/playerrater?slotCategoryId=0").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Elements tables = doc.select(".playerTableTable"); //Select the Player table
		Elements tables2 = tables.select(".pncPlayerRow"); //All player rows in the table
		//FantasyApp.log.info(tables2.toString());
		String[] allPlayers = tables2.toString().split("</tr>");
		for(int i = 0;i < allPlayers.length;i++){ 
			String playerString = allPlayers[i];
			//Get the player's name
			int startOfName = playerString.indexOf("e\">")+3;
			int endOfName = playerString.indexOf("</a>");
			CharSequence name = playerString.subSequence(startOfName, endOfName);
			String playerName = name.toString();
			//Get the player's PlayerRating for the season
			int startOfPR = playerString.indexOf("dCell\">")+7;
			int endOfPR = playerString.lastIndexOf("</td>");
			CharSequence yearPRsec = playerString.subSequence(startOfPR, endOfPR);
			String yearPR = yearPRsec.toString();
			System.out.println("The player's name is: "+playerName);
			System.out.println("Yearly Player Rater: "+yearPR);
		}
	}	
}
