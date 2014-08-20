package com.av.fantasy;

import org.junit.Test;

import com.av.fantasy.model.FanDuelScraper;

import junit.framework.TestCase;

public class FanDuelScraperTest extends TestCase {
	private static FanDuelScraper scraper;
	private static String url;


	@Test
	public static void testScrapeWebsite(){
		scraper = new FanDuelScraper();
		//baseball URL
		url = "https://www.fanduel.com/e/Game/10420?tableId=5126786&fromLobby=true";
		scraper.scrapeWebsite(url);
	}
}
