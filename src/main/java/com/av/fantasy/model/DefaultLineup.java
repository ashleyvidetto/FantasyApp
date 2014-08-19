package com.av.fantasy.model;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * The default lineup is 2 PGs, 2SGs, 2SFs, 2PFs, 1C
 * @author Ashley
 *
 */


public class DefaultLineup extends Lineup {
	private Player pointGuard1;
	private Player pointGuard2;
	private Player shootingGuard1;
	private Player shootingGuard2;
	private Player smallForward1;
	private Player smallForward2;
	private Player powerForward1;
	private Player powerForward2;
	private Player center;
	private int maxSalary;

	//Clones the given lineup and creates a new object with their values
	public DefaultLineup(DefaultLineup testlineup) {
		this.pointGuard1 = testlineup.getPointGuard1();
		this.pointGuard2 = testlineup.getPointGuard2();
		this.shootingGuard1 = testlineup.getShootingGuard1();
		this.shootingGuard2 = testlineup.getShootingGuard2();
		this.smallForward1 = testlineup.getSmallForward1();
		this.smallForward2 = testlineup.getSmallForward2();
		this.powerForward1 = testlineup.getPowerForward1();
		this.powerForward2 = testlineup.getPowerForward2();
		this.center = testlineup.getCenter();
	}

	public DefaultLineup() {
		// TODO Auto-generated constructor stub
	}

	public DefaultLineup(int maxSalary){
		this.maxSalary = maxSalary;
	}

	@Override
	public double generateTotalFantasyPoints() {
		double lineupFantasyTotal = pointGuard1.getFantasyPoints() + pointGuard2.getFantasyPoints() +
				shootingGuard1.getFantasyPoints() + shootingGuard2.getFantasyPoints() +
				smallForward1.getFantasyPoints() + smallForward2.getFantasyPoints() + powerForward1.getFantasyPoints() +
				powerForward2.getFantasyPoints() + center.getFantasyPoints();
		return lineupFantasyTotal;
	}

	public boolean exceedsCap(){
		if (getTotalSalary() > maxSalary){
			return true;
		}
		return false;
	}

	public int getTotalSalary(){
		int totalSalary = 0;
		Iterator<Player> players = getPlayers().iterator();
		while(players.hasNext()){
			totalSalary = totalSalary + players.next().getSalary();
		}
		return totalSalary;
	}

	public void removePointGuard1(){
		pointGuard1 = null;
	}
	public void removePointGuard2(){
		pointGuard2 = null;
	}
	public void removeShootingGuard1(){
		shootingGuard1 = null;
	}
	public void removeShootingGuard2(){
		shootingGuard2 = null;
	}
	public void removeSmallForward1(){
		smallForward1 = null;
	}
	public void removeSmallForward2(){
		smallForward2 = null;
	}
	public void removePowerForward1(){
		powerForward1 = null;
	}
	public void removePowerForward2(){
		powerForward2 = null;
	}
	public void removeCenter(){
		center = null;
	}

	private LinkedList<Player> getPlayers(){
		LinkedList<Player> players = new LinkedList<Player>();
		if(pointGuard1 != null){
			players.add(pointGuard1);
		}
		if(pointGuard2 != null){
			players.add(pointGuard2);
		}
		if(shootingGuard1 != null){
			players.add(shootingGuard1);
		}
		if(shootingGuard2 != null){
			players.add(shootingGuard2);
		}
		if(smallForward1 != null){
			players.add(smallForward1);
		}
		if(smallForward2 != null){
			players.add(smallForward2);
		}
		if(powerForward1 != null){
			players.add(powerForward1);
		}
		if(powerForward2 != null){
			players.add(powerForward2);
		}
		if(center != null){
			players.add(center);
		}
		return players;

	}


	//Getter, Setters, and toString()

	@Override
	public double getTotalFantasyPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Player getPointGuard1() {
		return pointGuard1;
	}

	public void setPointGuard1(Player pointGuard1) {
		this.pointGuard1 = pointGuard1;
	}

	public Player getPointGuard2() {
		return pointGuard2;
	}

	public void setPointGuard2(Player pointGuard2) {
		this.pointGuard2 = pointGuard2;
	}

	public Player getShootingGuard1() {
		return shootingGuard1;
	}

	public void setShootingGuard1(Player shootingGuard1) {
		this.shootingGuard1 = shootingGuard1;
	}

	public Player getShootingGuard2() {
		return shootingGuard2;
	}

	public void setShootingGuard2(Player shootingGuard2) {
		this.shootingGuard2 = shootingGuard2;
	}

	public Player getSmallForward1() {
		return smallForward1;
	}

	public void setSmallForward1(Player smallForward1) {
		this.smallForward1 = smallForward1;
	}

	public Player getSmallForward2() {
		return smallForward2;
	}

	public void setSmallForward2(Player smallForward2) {
		this.smallForward2 = smallForward2;
	}

	public Player getPowerForward1() {
		return powerForward1;
	}

	public void setPowerForward1(Player powerForward1) {
		this.powerForward1 = powerForward1;
	}

	public Player getPowerForward2() {
		return powerForward2;
	}

	public void setPowerForward2(Player powerForward2) {
		this.powerForward2 = powerForward2;
	}

	public Player getCenter() {
		return center;
	}

	public void setCenter(Player center) {
		this.center = center;
	}

	@Override
	public void setTotalFantasyPoints(double totalFantasyPoints) {
		// TODO Auto-generated method stub
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}


	//toString()
	public String toString(){
		String toString = "";
		if(pointGuard1 != null){
			toString = "PG: "+ pointGuard1.getName();
		}
		else {toString = toString+"PG: None  ";}
		if(pointGuard2 != null){
			toString = toString + "  PG: "+pointGuard2.getName();
		}
		else {toString = toString+"  PG: None  ";}

		if(shootingGuard1 != null){
			toString = toString + "  SG: "+shootingGuard1.getName();
		}
		else {toString = toString+"  SG: None  ";}
		if(shootingGuard2 != null){
			toString = toString + "  SG: "+shootingGuard2.getName();
		}
		else {toString = toString+"  SG: None  ";}
		if(smallForward1 != null){
			toString = toString + "  SF: "+smallForward1.getName();
		}
		else {toString =toString+ "  SF: None ";}
		if(smallForward2 != null){
			toString = toString + "  SF: "+smallForward2.getName();
		}
		else {toString = toString+"  SF: None ";}
		if(powerForward1 != null){
			toString = toString + "  PF: "+powerForward1.getName();
		}
		else {toString = toString+"  PF: None ";}
		if(powerForward2 != null){
			toString = toString + "  PF: "+powerForward2.getName();
		}
		else {toString = toString+ "  PF: None ";}
		if(center != null){
			toString = toString + "  C: "+center.getName();
		}
		else {toString = toString+ "  C: None";}
		return toString;
	}

}
