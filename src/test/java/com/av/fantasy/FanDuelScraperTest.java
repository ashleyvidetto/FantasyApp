package com.av.fantasy;

import org.junit.Test;

import com.av.fantasy.model.FanDuelScraper;

import junit.framework.TestCase;

public class FanDuelScraperTest extends TestCase {
	private static FanDuelScraper scraper;
	private static String url;


	@Test
	public static void testScrapeWebsite(){
		scraper = new FanDuelScraper("baseball");
		//baseball URL
		url = "http://games.espn.go.com/flb/playerrater?slotCategoryId=0";
		scraper.scrapeWebsite(url);
	}
}
