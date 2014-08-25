package com.av.fantasy.model;

public abstract class Player {

	protected String name;
	protected String team;
	protected String notes;
	protected int salary;

	public Player() {

	}

	public Player(String name, String team) {
		this.name = name;
		this.team = team;
	}

	public Player(int salary) {
		this.salary = salary;
	}

	// Getter/Setter Methods


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Player(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public Player(String name) {
		this.name = name;
	}
}
