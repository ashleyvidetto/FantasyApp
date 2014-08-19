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
		url = "https://www.fanduel.com/e/Game/NBA_Salary_Cap_9591/View?chseat_id=30647333&chseatCode=DLTYGPM";
		scraper.scrapeWebsite(url);
	}
}
