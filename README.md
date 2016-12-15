# DungeonCrawler
A basic java game with text input 
------------------------------------
## Plans:
* Add a map style area for town
* Add a randomly generated dungeon (size)
* Navigate via arrow keys or **n/e/s/w inputs (TBD)**
* randomly generated stats? **for chosen class? (TBD)**
* randomly generated enemies (based on dungeon level? or PC level?)
* equipment shop (maybe not rng)
* cash rewards from chests? / gear / bosses
* each dungeon floor has a boss encounter
* level up - can choose 3 stats?


	Example stats
| STR 	| 5 	|
| DEX 	| 5 	|
| AGI 	| 5 	|
| INT 	| 5 	|
| WIS 	| 5 	|
| END 	| 5 	|
| CHA 	| 5 	|
| LUCK 	| 5 	|

## Instructions:
To launch the game on Windows, simply double click the DungeonCrawler.jar.

The game has not yet been tested on other operating systems.

## Dependencies:
Uses [lanterna](https://github.com/mabe02/lanterna) 3.0.0-beta3 for UI.

On Windows and other graphical operating systems, this uses a JFrame wrapper
terminal for the game.

## Commands:

save[slotfile]			  -		  saves the game state to the slotfile parameter
load[slotfile]			  -		  Loads the game state to the slotfile parameter
quit					  -		  Quit the program
n e s w					  - 	  MovementNorth east south west respectively
Talk [NPC]  			  - 	  Talk to NPC's / Shop
inv			 			  -	      list contents of player inventory
examine[Item/NPC]		  -		  provides information (description/stats) about item/npc
look				      -		  provides information about current room
Take[Item]				  -		  Adds item to backpack
Pickup[Item]		  	  -  	  Same as Take
Equip[Item]				  -	  	  Equip an item, can be either on floor (takes item first) or in backpack
equipment[]				  -		  Lists all items currently equipped
use[Item]use[Object]	  -		  Use a consumable item (scroll/potion/quest item) or Use an object in room (i.e. Lever)
open[Door]				  -		  Open an openable object e.g. door/trapdoor/chest	
put[object | Room/Object] -		  Place an item on an object (table/chest) or on the floor in a room
