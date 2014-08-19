package com.av.fantasy;

import junit.framework.TestCase;

import org.junit.Test;

import com.av.fantasy.model.Player;

public class PlayerTest extends TestCase {
private static Player p;
private static Player p2;
	
	@Test
	public static void testConstructor(){

	}

	@Test
	public static void testToString(){	
		p = new Player(); //should default to a player with no name and no points.
		p.setName("Josh Smith");
		p.setAveragePoints(20);
		p.setAverageRebounds(2);
		p.setAverageAssists(3.5);
		p.setAverageBlocks(0.7);
		p.setAverageSteals(2);
		p.setAverageTurnovers(2);
		p.setType(2);
		
		p2 = new Player("Josh Smith", 20, 2, 3.5, 0.7, 2, 2, 2, "ATL");
	
	System.out.println(p.toString());
	System.out.println(p2.toString()); //This should just print out a readable line
	}
	
	
}
