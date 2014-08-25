package com.av.fantasy;

import org.junit.Test;

import com.av.fantasy.dao.PlayerDAO;
import com.av.fantasy.model.BasketballPlayer;

import junit.framework.TestCase;

public class PlayerDAOTest extends TestCase {
private static PlayerDAO p;
private static BasketballPlayer testPlayer;

@Test
public static void testSave(){
	p = new PlayerDAO();
	testPlayer = new BasketballPlayer("Test Insert", 20, 2, 3.5, 0.7, 2, 2, 2, "ATL");
	p.save(testPlayer);
	p.remove(testPlayer);
}

@Test
public static void testRemove(){
	p = new PlayerDAO();
	testPlayer = new BasketballPlayer("Test Remove", 20, 2, 3.5, 0.7, 2, 2, 2, "ATL");
	p.save(testPlayer);
	System.out.println(p.remove(testPlayer).toString()+" was REMOVED");	
}

@Test
public static void testUpdatePlayer(){
	p = new PlayerDAO();
	testPlayer = new BasketballPlayer("Test Update", 20, 2, 3.5, 0.7, 2, 2, 2, "ATL");
	p.save(testPlayer);
	//This player should have two average assists
	assertEquals(3.5, testPlayer.getAverageAssists());
	testPlayer.setAverageAssists(5.0);
	testPlayer = p.updatePlayer(testPlayer);
	//This player should now have five assists
	assertEquals(5.0,testPlayer.getAverageAssists()); 
	p.remove(testPlayer);
	}

@Test
public static void testGetPlayerByName(){
	p = new PlayerDAO();
	testPlayer = new BasketballPlayer("PlayerToTest", 20, 2, 3.5, 0.7, 2, 2, 2, "ATL");
	p.save(testPlayer);
	BasketballPlayer searchedPlayer = p.getPlayerByName("PlayerToTest");
	assertEquals(testPlayer.getAveragePoints(), searchedPlayer.getAveragePoints());
	p.remove(testPlayer);
	}

}
