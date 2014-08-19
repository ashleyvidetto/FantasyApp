package com.av.fantasy;

import org.junit.Test;

import com.av.fantasy.model.PointCalculator;

import junit.framework.TestCase;


public class PointCalculatorTest extends TestCase {
	
@Test
public static void testGetTotalPoints(){

//A score of 30 points and 2 rebounds should have a value of 32.4.
double intendedValue = 32.4;
double testValue = PointCalculator.getTotalFantasyPoints(30, 2, 0, 0, 0, 0);
assertEquals(intendedValue, testValue);
//A score of 22 points, 4 rebounds, 3 assists, 2 blocks, and 2 turnovers should be 33.3
intendedValue = 33.3;
testValue = PointCalculator.getTotalFantasyPoints(22, 4, 3, 2, 0, 2);
assertEquals(intendedValue, testValue);
//A score of 9 points, 10 rebounds, 1 assist, 0 blocks, 3 steals, and 1 turnover should be 27.5
intendedValue = 27.5;
testValue = PointCalculator.getTotalFantasyPoints(9, 10, 1, 0, 3, 1);
assertEquals(intendedValue, testValue);
}
	
}
