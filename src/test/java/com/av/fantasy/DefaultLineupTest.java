package com.av.fantasy;

import org.junit.Before;
import org.junit.Test;

import com.av.fantasy.model.DefaultLineup;
import com.av.fantasy.model.BasketballPlayer;

import junit.framework.TestCase;


public class DefaultLineupTest extends TestCase {
	private static BasketballPlayer testP1;
	private static BasketballPlayer testP2;
	private static BasketballPlayer testP3;
	private static BasketballPlayer testP4;
	private static BasketballPlayer testP5;
	private static BasketballPlayer testP6;
	private static BasketballPlayer testP7;
	private static BasketballPlayer testP8;
	private static BasketballPlayer testP9;
	private static BasketballPlayer testP10;
	private static BasketballPlayer testP11;
	private static DefaultLineup  lineup;

	@Test
	public static void testToString(){
		generateData();
		System.out.println(lineup.toString());
	}

	@Test
	public static void testExceedsCap(){
		generateData();
		assertTrue(lineup.exceedsCap()); //This should be true since the value of the default lineup is 82000;
		lineup.setPointGuard1(testP5); 
		assertTrue(lineup.exceedsCap()); //This should be true since now the value is 74000;
		lineup.setPointGuard2(testP5);
		assertTrue(lineup.exceedsCap()); //This should be true since now the value is 67000;
		lineup.setSmallForward1(testP10);
		assertFalse(lineup.exceedsCap()); //This should be false since now the value is exactly 60000;
		lineup.removeCenter();
		assertFalse(lineup.exceedsCap()); //This should be false since without the center the value is now 50200;
	}	

	/**
	 * Helper method to generate test data.
	 */
	private static void generateData(){
		testP1 = new BasketballPlayer("Michael Jordan", 13000);
		testP2 = new BasketballPlayer("Kobe Bryant", 12000);
		testP3 = new BasketballPlayer("Kevin Durant", 11000);
		testP4 = new BasketballPlayer("Carmelo Anthony", 9000);
		testP5 = new BasketballPlayer("Tony Allen", 5000);
		testP6 = new BasketballPlayer("Brandon Jennings", 8500);
		testP7 = new BasketballPlayer("Rajon Rondo", 7300);
		testP8 = new BasketballPlayer("Deron Williams", 6400);
		testP9 = new BasketballPlayer("Al Jefferson", 9800);
		testP10 = new BasketballPlayer("Dwight Howard", 300);
		testP11 = new BasketballPlayer("Al Horford", 8200);
		lineup = new DefaultLineup(60000);
		lineup.setPointGuard1(testP1);
		lineup.setPointGuard2(testP2);
		lineup.setPowerForward1(testP3);
		lineup.setPowerForward2(testP4);
		lineup.setShootingGuard1(testP5);
		lineup.setShootingGuard2(testP6);
		lineup.setSmallForward1(testP7);
		lineup.setSmallForward2(testP8);
		lineup.setCenter(testP9);
	}
}
