/**
 * Player class - this abstract class contains the basic instantiations of a player
 */
package com.av.fantasy.model;

public class BasketballPlayer extends Player{

	private double averagePoints;
	private double averageRebounds;
	private double averageAssists;
	private double averageBlocks;
	private double averageSteals;
	private double averageTurnovers;
	/*
	 * This is a percentage that modifies the players average points based
	 * upon circumstances: home/away, hot streak, schedule, hunches, etc;
	 */
	double Modifier; 

	/*
	 * This is the type of player:
	 * 1 = PointGuard
	 * 2 = ShootingGuard
	 * 3 = SmallForward
	 * 4 = PowerForward
	 * 5 = Center
	 */
	int Type; //This is the type of player the person is. 


	/**
	 * Default Constructor
	 */
	public BasketballPlayer(){
		super();

	}

	/**
	 * Constructor 
	 * @param averagePoints - the average points the player scores per game
	 * @param averageRebounds - the average number of rebounds the player gets per game
	 * @param averageAssists - the average number of assists the player gets per game
	 * @param averageBlocks - the average number of blocks the player gets per game
	 * @param averageSteals - the average number of steals the player gets per game
	 * @param averageTurnovers - the average number of turnovers the player gets per game
	 * @param Salary - the cost of the player in salary cap leagues
	 * @param Type - the eligible position of the player (1-5)
	 */
	public BasketballPlayer(double averagePoints, double averageRebounds, double averageAssists, double averageBlocks, double averageSteals, double averageTurnovers, int Salary, int Type){
		super(Salary);
		this.averagePoints = averagePoints;
		this.averageRebounds = averageRebounds;
		this.averageAssists = averageAssists;
		this.averageBlocks = averageBlocks;
		this.averageSteals = averageSteals;
		this.averageTurnovers = averageTurnovers;
		this.Type = Type;
	}
	/**
	 * Constructor 
	 * @param averagePoints - the average points the player scores per game
	 * @param averageRebounds - the average number of rebounds the player gets per game
	 * @param averageAssists - the average number of assists the player gets per game
	 * @param averageBlocks - the average number of blocks the player gets per game
	 * @param averageSteals - the average number of steals the player gets per game
	 * @param averageTurnovers - the average number of turnovers the player gets per game
	 * @param Type - the eligible position of the player (1-5)
	 */
	public BasketballPlayer(String name, double averagePoints, double averageRebounds, double averageAssists, double averageBlocks, double averageSteals, double averageTurnovers, int Type, String Team){
		super(name, Team);
		this.name = name;
		this.averagePoints = averagePoints;
		this.averageRebounds = averageRebounds;
		this.averageAssists = averageAssists;
		this.averageBlocks = averageBlocks;
		this.averageSteals = averageSteals;
		this.averageTurnovers = averageTurnovers;
		this.Type = Type;
		this.team = Team;
	}

	/**
	 * Constructor that takes in the players name and salary.
	 * @param string - name of the player
	 * @param int - fantasy salary of the player
	 */
	public BasketballPlayer(String name, int salary) {
		super(name,salary);
	}

	public BasketballPlayer(String name) {
		super(name);
	}

	//toString()
	public String toString(){
		return name + " plays for "+team+" and averages "+averagePoints+" points, "+averageRebounds+" rebounds, "
				+averageAssists+" assists, "+averageBlocks+" blocks, "+averageSteals+" steals, and "
				+averageTurnovers+ " turnovers per game.";
	}

	/**
	 * Calculates the fantasy points
	 * @return
	 */
	public double getFantasyPoints() {
		//Need to Calculate predicted values somewhere here
		//Use a predictor class to modify this value.
		return PointCalculator.getTotalFantasyPoints(averagePoints, averageRebounds, averageAssists, averageBlocks,
				averageSteals, averageTurnovers);
	}


	//Getter and Setter Methods
	public double getAveragePoints() {
		return averagePoints;
	}
	public void setAveragePoints(double averagePoint) {
		this.averagePoints = averagePoint;
	}
	public double getAverageRebounds() {
		return averageRebounds;
	}
	public void setAverageRebounds(double averageRebounds) {
		this.averageRebounds = averageRebounds;
	}
	public double getAverageAssists() {
		return averageAssists;
	}
	public void setAverageAssists(double averageAssists) {
		this.averageAssists = averageAssists;
	}
	public double getAverageBlocks() {
		return averageBlocks;
	}
	public void setAverageBlocks(double averageBlocks) {
		this.averageBlocks = averageBlocks;
	}
	public double getAverageSteals() {
		return averageSteals;
	}
	public void setAverageSteals(double averageSteals) {
		this.averageSteals = averageSteals;
	}
	public double getAverageTurnovers() {
		return averageTurnovers;
	}
	public void setAverageTurnovers(double averageTurnovers) {
		this.averageTurnovers = averageTurnovers;
	}

	public double getModifier() {
		return Modifier;
	}
	public void setModifier(double modifier) {
		Modifier = modifier;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}

}
