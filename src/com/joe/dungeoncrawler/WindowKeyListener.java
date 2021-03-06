package com.joe.dungeoncrawler;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowListener;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Concrete implementation of {@link com.googlecode.lanterna.gui2.WindowListener WindowListener} interface
 * used soley for detecting whether the Enter key has been pressed so we know when to execute a command.
 */
final class WindowKeyListener implements WindowListener {
	// This listener allows us to indirectly tell our CommandManager class to grab
	// the command in the TextBox and execute it.
	private CommandListenerInterface listener;

	public WindowKeyListener(CommandListenerInterface listener) {
		this.listener = listener;
	}

	@Override
	public void onInput(Window window, KeyStroke keyStroke, AtomicBoolean atomicBoolean) {
		if (keyStroke.getKeyType() == KeyType.Enter) {
			// Trigger event
			listener.commandReceived();
		}
	}

	@Override
	public void onResized(Window window, TerminalSize terminalSize, TerminalSize terminalSize1) {
		// Unnecessary.
	}

	@Override
	public void onMoved(Window window, TerminalPosition terminalPosition, TerminalPosition terminalPosition1) {
		// Unnecessary.
	}

	@Override
	public void onUnhandledInput(Window window, KeyStroke keyStroke, AtomicBoolean atomicBoolean) {
		// Unnecessary.
	}
}
