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
		try {
			doc = Jsoup.connect("http://games.espn.go.com/flb/playerrater?slotCategoryId=0").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FantasyApp.log.info(doc.toString());
		//Elements tables = doc.select(".playertablePlayerName");
		//FantasyApp.log.info(tables.toString());
	}	
}
