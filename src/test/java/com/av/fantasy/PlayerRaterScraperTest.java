package com.av.fantasy;

import junit.framework.TestCase;

import org.junit.Test;

import com.av.fantasy.model.PlayerRaterScraper;

public class PlayerRaterScraperTest extends TestCase {
	private static PlayerRaterScraper scraper;


	@Test
	public static void testScrapeWebsite(){
		scraper = new PlayerRaterScraper();
	}
}
