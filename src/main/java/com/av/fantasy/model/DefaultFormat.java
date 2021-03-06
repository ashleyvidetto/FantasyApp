package com.av.fantasy.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JProgressBar;

import org.apache.log4j.Logger;

import com.aa.fantasy.controller.FantasyApp;

public class DefaultFormat extends Format {

	private int maxSalary = 60000; //60,000 is the maximum salary in the deafult format
	private int generateProgress;
	private PropertyChangeSupport pcs; 

	public DefaultFormat(){
		pcs = new PropertyChangeSupport(this);
	}
	/**
	 * Generates possible lineups for the default format: 2PGs, 2SGs, 2SFs, 2PFs, 1C
	 * Note this is a very CPU comprehensive process due to the sheer number of possibilities.
	 * @param posPointGuards pool of possible point guards to pull from
	 * @param posShootingGuards pool of possible point guards to pull from
	 * @param posSmallForwards pool of possible point guards to pull from
	 * @param posPowerForwards pool of possible point guards to pull from
	 * @param posCenters pool of possible point guards to pull from
	 */
	@SuppressWarnings("unchecked")
	public LinkedList<Lineup> generatePossibleLineups(ArrayList<BasketballPlayer> posPGs, ArrayList<BasketballPlayer> posSGs, ArrayList<BasketballPlayer> posSFs, ArrayList<BasketballPlayer> posPFs, ArrayList<BasketballPlayer> posCs){
		FantasyApp.log.info("Beginning to analyze lineups...");
		//Convert the ArrayList to LinkedList for performance improvement
		LinkedList<BasketballPlayer> posPointGuards = convertToLinkedList(posPGs);
		LinkedList<BasketballPlayer> posShootingGuards = convertToLinkedList(posSGs);
		LinkedList<BasketballPlayer> posSmallForwards = convertToLinkedList(posSFs);
		LinkedList<BasketballPlayer> posPowerForwards = convertToLinkedList(posPFs);
		LinkedList<BasketballPlayer> posCenters = convertToLinkedList(posCs);

		//This list will hold all possible lineup values
		LinkedList<Lineup> possibleLineups = new LinkedList<Lineup>();
		DefaultLineup testlineup = new DefaultLineup(maxSalary);

		//We always need the Player2 iterator to be one after the Player1 iterator
		@SuppressWarnings("unchecked")
		LinkedList<BasketballPlayer> posPointGuards2 = (LinkedList<BasketballPlayer>) posPointGuards.clone();
		Iterator<BasketballPlayer> pguard1 = posPointGuards.iterator();
		int progress = 1;
		while(pguard1.hasNext()){
			testlineup.setPointGuard1(pguard1.next());
			posPointGuards2.remove(); //remove the first player (this is lineup.player1)
			//declare pGuard2 iterator and go to next player
			Iterator<BasketballPlayer> pguard2 = posPointGuards2.iterator();
			//After each PG increment the progress bar by a point - for 20 PGS this would be 1/20th. This correctly splits the task.
			setGenerateProgress(progress);
			progress++;
			while(pguard2.hasNext()){
				testlineup.setPointGuard2(pguard2.next());
				Iterator<BasketballPlayer> sguard1 = posShootingGuards.iterator();
				LinkedList<BasketballPlayer> posShootingGuards2 = (LinkedList<BasketballPlayer>) posShootingGuards.clone();
				while(sguard1.hasNext()){
					testlineup.setShootingGuard1(sguard1.next());
					posShootingGuards2.remove();
					Iterator<BasketballPlayer> sguard2 = posShootingGuards2.iterator();
					while(sguard2.hasNext()){
						testlineup.setShootingGuard2(sguard2.next());
						Iterator<BasketballPlayer> sforward1 = posSmallForwards.iterator();
						LinkedList<BasketballPlayer> posSmallForwards2 = (LinkedList<BasketballPlayer>) posSmallForwards.clone();
						while(sforward1.hasNext()){
							testlineup.setSmallForward1(sforward1.next());
							if(testlineup.exceedsCap()){
								testlineup.removeSmallForward1();
								continue;
							}
							posSmallForwards2.remove();
							Iterator<BasketballPlayer> sforward2 = posSmallForwards2.iterator();
							while(sforward2.hasNext()){
								testlineup.setSmallForward2(sforward2.next());
								if(testlineup.exceedsCap()){
									testlineup.removeSmallForward2();
									continue;
								}
								Iterator<BasketballPlayer> pforward1 = posPowerForwards.iterator();
								LinkedList<BasketballPlayer> posPowerForwards2 = (LinkedList<BasketballPlayer>) posPowerForwards.clone();
								while(pforward1.hasNext()){
									testlineup.setPowerForward1(pforward1.next());
									if(testlineup.exceedsCap()){
										testlineup.removePowerForward1();
										continue;
									}
									posPowerForwards2.remove();
									Iterator<BasketballPlayer> pforward2 = posPowerForwards2.iterator();
									while(pforward2.hasNext()){
										testlineup.setPowerForward2(pforward2.next());
										if(testlineup.exceedsCap()){
											testlineup.removePowerForward2();
											continue;
										}
										Iterator<BasketballPlayer> center = posCenters.iterator();
										while(center.hasNext()){
											testlineup.setCenter(center.next());
											if(!testlineup.exceedsCap()){ //only add the lineup as possible if it does not exceed the cap
												possibleLineups.add(new DefaultLineup(testlineup));
											}
											testlineup.removeCenter(); //remove the center
										}
										testlineup.removePowerForward2();
									}
									testlineup.removePowerForward1();
								}
								testlineup.removeSmallForward2();
							}
							testlineup.removeSmallForward1();
						}
					}
				}
			}
		}
		FantasyApp.log.info("Possible Lineups Calculated");
		return possibleLineups;
	}

	private LinkedList<BasketballPlayer> convertToLinkedList(ArrayList<BasketballPlayer> arrayList) {
		LinkedList<BasketballPlayer> myList = new LinkedList<BasketballPlayer>();
		Iterator<BasketballPlayer> it = arrayList.iterator();
		while(it.hasNext()){
			myList.add(it.next());
		}
		FantasyApp.log.debug(myList.toString());
		return myList;
	}

	//Property Change Support
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}

	//Getters and Setters
	public int getGenerateProgress() {
		return generateProgress;
	}

	public void setGenerateProgress(int generateProgress) {
		FantasyApp.log.debug("Setting a new progress value of "+generateProgress);
		int oldValue = this.generateProgress;
		this.generateProgress = generateProgress;
		pcs.firePropertyChange(new PropertyChangeEvent(this, "progress", oldValue, this.generateProgress));
	}

}


