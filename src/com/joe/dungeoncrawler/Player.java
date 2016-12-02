/**
 * Player class that will allow for leveling up, modification of stats
 * experience and other player activities. inventory may also be included here
 * alongside items and gold stats
 */
package com.joe.dungeoncrawler;
import java.math.*;

public class Player {
	
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

	
	public Player(String name, ClassesEnum playerClass ){
		if(name != null && name.length() >= 1){ // name cannot be null or less than 1 character
			this.name = name.toLowerCase();
		}
		this.playerClass = playerClass;
	}
	private int calcExpToLevel(Player player){ // Calculates total exp needed to level (used in levelUp method)
		int reqExp = 0;
		for(int i = 1; i<player.getLvl(); i++){
			reqExp = (int) Math.floor((reqExp + BASE_REQ * Math.pow(3, i)));
		}
		return reqExp;
	}
	public boolean levelUp(Player player) { // Level up the player if they fit requirements. Returns true if successful or false if unsuccessful.
		if(player.exp >= calcExpToLevel(player)){
			player.exp = player.exp - calcExpToLevel(player);
			lvl++;
			return true;
		}else{
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
