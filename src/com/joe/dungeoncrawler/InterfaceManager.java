package com.joe.dungeoncrawler;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;

/**
 * Handles anything to do with the lanterna UI, for example, building the
 * initial interface and adding events to the event log.
 */
final class InterfaceManager {
	private final int GAME_WIDTH = 108;
	private final int GAME_HEIGHT = 26;

	private Panel eventLogPanel;
	private TextBox inputBox;

	// Using Lanterna (https://github.com/mabe02/lanterna)

	/**
	 * Constructs the initial UI for the game, including Inventory, Map, Commands and Event Log panels.
	 * <p>
	 * Also adds a command input box at the bottom of the screen.
	 *
	 * @param screen The {@link com.googlecode.lanterna.screen.Screen Screen} on which the UI will be drawn.
	 */
	protected void buildUI(Screen screen) {
		// Creates a 'BasicWindow' which will hold all of our UI elements.
		BasicWindow window = new BasicWindow();
		window.setTheme(new SimpleTheme(TextColor.ANSI.WHITE, TextColor.ANSI.BLACK));

		// Inventory Panel at the left, taking up roughly 20% of the screen (horizontally).
		Panel invPanel = new Panel();
		invPanel.setLayoutManager(new GridLayout(1));
		invPanel.addComponent(new Label("Inventory"));
		invPanel.setPreferredSize(new TerminalSize(GAME_WIDTH / 5, (GAME_HEIGHT / 4) * 3));

		// Map Panel in the centre, taking up roughly 60% of the screen (horizontally).
		Panel mapPanel = new Panel();
		mapPanel.setLayoutManager(new GridLayout(1));
		mapPanel.addComponent(new Label("Map"));
		mapPanel.setPreferredSize(new TerminalSize((GAME_WIDTH / 5) * 3, (GAME_HEIGHT / 4) * 3));

		// Commands(?) Panel at the right, taking up roughly 20% of the screen (horizontally).
		Panel comPanel = new Panel();
		comPanel.setLayoutManager(new GridLayout(1));
		comPanel.addComponent(new Label("Commands"));
		comPanel.setPreferredSize(new TerminalSize(GAME_WIDTH / 5, (GAME_HEIGHT / 4) * 3));

		// Compile all 3 panels into a main panel.
		Panel mainPanel = new Panel();
		mainPanel.setLayoutManager(new GridLayout(3));
		mainPanel.addComponent(invPanel.withBorder(Borders.singleLine()));
		mainPanel.addComponent(mapPanel.withBorder(Borders.singleLine()));
		mainPanel.addComponent(comPanel.withBorder(Borders.singleLine()));

		// Event Log Panel at the bottom, spanning all 3 columns/cells.
		eventLogPanel = new Panel();
		eventLogPanel.setLayoutManager(new GridLayout(1));
		eventLogPanel.addComponent(new Label("Event Log"));
		eventLogPanel.setPreferredSize(new TerminalSize(GAME_WIDTH, GAME_HEIGHT / 4));
		eventLogPanel.setLayoutData(GridLayout.createHorizontallyFilledLayoutData(3));
		mainPanel.addComponent(eventLogPanel.withBorder(Borders.singleLine()));

		// Add the input text box at the very bottom, spanning all 3 columns/cells.
		inputBox = new TextBox(new TerminalSize(GAME_WIDTH, 1));
		inputBox.setLayoutData(GridLayout.createHorizontallyFilledLayoutData(3));
		mainPanel.addComponent(inputBox);

		// Add the main panel to the window.
		window.setComponent(mainPanel);

		// Create a listener for input commands.
		CommandManager cm = new CommandManager(this);
		// This uses a lambda expressions to construct a 'WindowKeyListener' with a 'CommandListenerInterface' and
		// assign the 'commandReceived' method on a single line.
		WindowKeyListener wkl = new WindowKeyListener(() -> cm.handleCommand(inputBox.getText()));
		window.addWindowListener(wkl);

		// Finally create the GUI object...
		MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));

		// ...and display it.
		gui.addWindowAndWait(window);
	}

	/**
	 * Sets the input {@link com.googlecode.lanterna.gui2.TextBox TextBox} to be the empty String, effectively clearing it.
	 */
	protected void clearInputBox() {
		inputBox.setText("");
	}

	/**
	 * Displays the given String in the Event Log panel at the bottom of the UI.
	 *
	 * @param event The String to display in the Event Log.
	 */
	protected void addToEventLog(String event) {
		eventLogPanel.addComponent(new Label(event));
	}
}
