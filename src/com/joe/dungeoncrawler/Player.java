package com.joe.dungeoncrawler;

import java.math.*;

/**
 * Player class that will allow for leveling up, modification of stats
 * experience and other player activities. inventory may also be included here
 * alongside items and gold stats
 */
public final class Player {

	private String name; // Player Name (Lowercase only)
	private ClassesEnum playerClass;

	private int str = 5; // Player stats
	private int dex = 5;
	private int agi = 5;
	private int wis = 5;
	private int end = 5;
	private int cha = 5;
	private int luk = 5;

	private int lvl = 1; // Other player unique variables (e.g. gold, exp)
	private static final int BASE_REQ = 100;
	private int exp = 0;
	private int gold = 0;


	public Player(String name, ClassesEnum playerClass) {
		if (name != null && name.length() >= 1) { // name cannot be null or less than 1 character
			this.name = name.toLowerCase();
		}
		this.playerClass = playerClass;
	}

	/**
	 * Calculates total exp needed to level (used in levelUp method).
	 * @return The amount of experience required to level up to the next level.
	 */
	private int calcExpToLevel() {
		int reqExp = 0;
		for (int i = 1; i < this.getLvl(); i++) {
			reqExp = (int) Math.floor((reqExp + BASE_REQ * Math.pow(3, i)));
		}
		return reqExp;
	}

	/**
	 * Level up the player if they fit requirements.
	 * @return True if the player was levelled up, false if the player does not have enough experience to level up.
	 */
	public boolean levelUp() {
		if (this.exp >= calcExpToLevel()) {
			this.exp = this.exp - calcExpToLevel();
			lvl++;
			return true;
		} else {
			return false;
		}
	}

	public String getName() { // START OF GETTERS
		return name;
	}

	public ClassesEnum getPlayerClass() {
		return playerClass;
	}

	public int getStr() {
		return str;
	}

	public int getDex() {
		return dex;
	}

	public int getAgi() {
		return agi;
	}

	public int getWis() {
		return wis;
	}

	public int getEnd() {
		return end;
	}

	public int getCha() {
		return cha;
	}

	public int getLuk() {
		return luk;
	}

	public int getLvl() {
		return lvl;
	}

	public static int getBaseReq() {
		return BASE_REQ;
	}

	public int getExp() {
		return exp;
	}

	public int getGold() { // END OF GETTERS
		return gold;
	}
}
