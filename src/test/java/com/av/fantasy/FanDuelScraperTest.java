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
		url = "https://www.fanduel.com/e/Game/MLB_Salary_Cap_10427/View?chseat_id=38263532&chseatCode=CXFWHWXDF";
		scraper.scrapeWebsite(url);
	}
}
