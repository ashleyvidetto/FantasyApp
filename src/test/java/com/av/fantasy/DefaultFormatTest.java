package com.av.fantasy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import junit.framework.TestCase;

import org.junit.Test;

import com.av.fantasy.model.DefaultFormat;
import com.av.fantasy.model.DefaultLineup;
import com.av.fantasy.model.Lineup;
import com.av.fantasy.model.BasketballPlayer;

public class DefaultFormatTest extends TestCase {

	private static ArrayList<BasketballPlayer> posPointGuards;
	private static ArrayList<BasketballPlayer> posShootingGuards;
	private static ArrayList<BasketballPlayer> posSmallForwards;
	private static ArrayList<BasketballPlayer> posPowerForwards;
	private static ArrayList<BasketballPlayer> posCenters;


	//GeneratePossibleLineups will take in all our possible players. 
	//This means five lists of players.
	@Test
	public static void testGeneratePossibleLineups(){
		generateTestData();
		DefaultFormat d = new DefaultFormat();
		LinkedList<Lineup> possibleLineups = d.generatePossibleLineups(posPointGuards, posShootingGuards, posSmallForwards, posPowerForwards, posCenters);
//		Iterator<Lineup> lineups = possibleLineups.iterator();
//		while(lineups.hasNext()){
//			DefaultLineup lineup = (DefaultLineup) lineups.next();
//			System.out.println(lineup.toString());
//			System.out.println("Salary is "+ lineup.getTotalSalary());
//		}
		System.out.println("There are "+possibleLineups.size()+" possible lineups");
		long possiblePlayerArrangements = posPointGuards.size() * (posPointGuards.size() - 1) * posShootingGuards.size() * (posShootingGuards.size() - 1) * posSmallForwards.size() * (posSmallForwards.size() - 1) * posPowerForwards.size() * (posPowerForwards.size() -1) * posCenters.size();
		System.out.println("There were "+possiblePlayerArrangements+" possible player arrangements");
	}




	private static void generateTestData() {
		generatePointGuards();
		generateShootingGuards();
		generateSmallForwards();
		generatePowerForwards();
		generateCenters();
	}


	private static void generatePointGuards() {
		posPointGuards = new ArrayList<BasketballPlayer>();
		//posPointGuards.add(new Player("Stephen Curry", 10000));
		//posPointGuards.add(new Player("Brandon Jennings", 8900));
		posPointGuards.add(new BasketballPlayer("Ty Lawson", 8900));
		posPointGuards.add(new BasketballPlayer("Isah Thomas", 8800));
		posPointGuards.add(new BasketballPlayer("Rajon Rondo", 8200));
		posPointGuards.add(new BasketballPlayer("Deron Williams", 8200));
		posPointGuards.add(new BasketballPlayer("PG #7", 8100));
		posPointGuards.add(new BasketballPlayer("PG #8", 8100));
		posPointGuards.add(new BasketballPlayer("PG #9", 8000));
		posPointGuards.add(new BasketballPlayer("PG #10", 7900));
		posPointGuards.add(new BasketballPlayer("PG #11", 7500));
		posPointGuards.add(new BasketballPlayer("PG #12", 7500));
		posPointGuards.add(new BasketballPlayer("PG #13", 7200));
		posPointGuards.add(new BasketballPlayer("PG #14", 7200));
		posPointGuards.add(new BasketballPlayer("PG #15", 7100));
		posPointGuards.add(new BasketballPlayer("PG #16", 7000));
		posPointGuards.add(new BasketballPlayer("PG #17", 6500));
	}

	private static void generateShootingGuards() {
		posShootingGuards = new ArrayList<BasketballPlayer>();
		//posShootingGuards.add(new Player("DeMar DeRozan", 9700));
		//posShootingGuards.add(new Player("Dwyane Wade", 7900));
		posShootingGuards.add(new BasketballPlayer("Monta Ellis", 7900));
		posShootingGuards.add(new BasketballPlayer("Brad Beal", 7500));
		posShootingGuards.add(new BasketballPlayer("Klay Thompson", 7100));
		posShootingGuards.add(new BasketballPlayer("Tony Allen", 6700));
		posShootingGuards.add(new BasketballPlayer("SG #7", 6600));
		posShootingGuards.add(new BasketballPlayer("SG #8", 6500));
		posShootingGuards.add(new BasketballPlayer("SG #9", 6400));
		posShootingGuards.add(new BasketballPlayer("SG #10", 6400));
		posShootingGuards.add(new BasketballPlayer("SG #11", 6300));
		posShootingGuards.add(new BasketballPlayer("SG #12", 6100));
		posShootingGuards.add(new BasketballPlayer("SG #13", 6000));
		posShootingGuards.add(new BasketballPlayer("SG #14", 6000));
		posShootingGuards.add(new BasketballPlayer("SG #15", 5900));
		posShootingGuards.add(new BasketballPlayer("SG #16", 5700));
		posShootingGuards.add(new BasketballPlayer("SG #17", 5600));
	}

	private static void generateCenters() {
		posCenters = new ArrayList<BasketballPlayer>();
		posCenters.add(new BasketballPlayer("Al Jefferson", 10100));
		posCenters.add(new BasketballPlayer("Dwight Howard", 10100));
		posCenters.add(new BasketballPlayer("Al Horford", 9600));
		posCenters.add(new BasketballPlayer("Chris Bosh", 8700));
		posCenters.add(new BasketballPlayer("Larry Sanders", 8200));
		posCenters.add(new BasketballPlayer("Center 6", 7900));
		posCenters.add(new BasketballPlayer("Center 7", 7800));
		posCenters.add(new BasketballPlayer("Center 8", 7500));
		posCenters.add(new BasketballPlayer("Center 9", 7400));
		posCenters.add(new BasketballPlayer("Center 10", 7300));
	}

	private static void generatePowerForwards() {
		posPowerForwards = new ArrayList<BasketballPlayer>();
		//posPowerForwards.add(new Player("Kevin Love", 11200));
		//posPowerForwards.add(new Player("Lamarcus Aldridge", 11000));
		posPowerForwards.add(new BasketballPlayer("Anthony Davis", 10000));
		posPowerForwards.add(new BasketballPlayer("David Lee", 9500));
		posPowerForwards.add(new BasketballPlayer("Jared Sullinger", 8500));
		posPowerForwards.add(new BasketballPlayer("Kenneth Faried", 8300));
		posPowerForwards.add(new BasketballPlayer("PF 7", 8100));
		posPowerForwards.add(new BasketballPlayer("PF 8", 7800));
		posPowerForwards.add(new BasketballPlayer("PF 9", 7700));
		posPowerForwards.add(new BasketballPlayer("PF 10", 7600));
		posPowerForwards.add(new BasketballPlayer("PF 11", 7300));
		posPowerForwards.add(new BasketballPlayer("PF 12", 7100));
		posPowerForwards.add(new BasketballPlayer("PF 13", 7000));
		posPowerForwards.add(new BasketballPlayer("PF 14", 6800));
		posPowerForwards.add(new BasketballPlayer("PF 15", 6800));
		posPowerForwards.add(new BasketballPlayer("PF 16", 6500));
		posPowerForwards.add(new BasketballPlayer("PF 17", 6500));

	}

	private static void generateSmallForwards() {
		posSmallForwards = new ArrayList<BasketballPlayer>();
		//posSmallForwards.add(new Player("LeBron James", 10000));
		//posSmallForwards.add(new Player("Paul George", 8300));
		posSmallForwards.add(new BasketballPlayer("Chandler Parsons", 7700));
		posSmallForwards.add(new BasketballPlayer("Trevor Ariza", 7300));
		posSmallForwards.add(new BasketballPlayer("Evan Turner", 6900));
		posSmallForwards.add(new BasketballPlayer("Luol Deng", 6600));
		posSmallForwards.add(new BasketballPlayer("SF 7", 6300));
		posSmallForwards.add(new BasketballPlayer("SF 8", 6100));
		posSmallForwards.add(new BasketballPlayer("SF 9", 6100));
		posSmallForwards.add(new BasketballPlayer("SF 10", 6000));
		posSmallForwards.add(new BasketballPlayer("SF 11", 5800));
		posSmallForwards.add(new BasketballPlayer("SF 12", 5800));
		posSmallForwards.add(new BasketballPlayer("SF 13", 5800));
		posSmallForwards.add(new BasketballPlayer("SF 14", 5600));
		posSmallForwards.add(new BasketballPlayer("SF 15", 5600));
		posSmallForwards.add(new BasketballPlayer("SF 16", 5600));
		posSmallForwards.add(new BasketballPlayer("SF 17", 5400));
	}

}
