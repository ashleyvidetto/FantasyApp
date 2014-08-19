/**
 * This class contains the score information for players.
 */
package com.av.fantasy.model;

public class PointCalculator {
	
private static double fieldgoalValue = 1;
private static double reboundValue = 1.2;
private static double assistValue = 1.5;
private static double blockValue = 2;
private static double stealValue = 2;
private static double turnoverValue = -1;


/**
 * This method returns the total fantasy point value for the given stats. 
 * @param points - number of points to be calculated
 * @param rebounds - number of rebounds to be calculated
 * @param assists - number of assists to be calculated
 * @param blocks - number of blocks to be calculated
 * @param steals - number of steals to be calculated
 * @param turnovers - number of turnovers to be calculated
 * @return
 */
public static double getTotalFantasyPoints(double points, double rebounds, double assists, double blocks, double steals, double turnovers){
	double totalPoints = 0;
	totalPoints = (points*fieldgoalValue) + (rebounds*reboundValue) + (assists * assistValue) + 
			(blocks * blockValue) + (steals * stealValue) + (turnovers * turnoverValue);
	return totalPoints;
}
	
	

}
