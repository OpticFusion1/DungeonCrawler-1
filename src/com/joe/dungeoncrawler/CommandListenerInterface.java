package com.joe.dungeoncrawler;

/**
 * Interface for letting CommandManager know that there is a command ready to be executed.
 */
interface CommandListenerInterface {
	void commandReceived();
}
