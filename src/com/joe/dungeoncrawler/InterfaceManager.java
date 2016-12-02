package com.joe.dungeoncrawler;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.SimpleTheme;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;

final class InterfaceManager
{
    private final int GAME_WIDTH = 108;
    private final int GAME_HEIGHT = 26;

    private Panel eventLogPanel;
    private TextBox inputBox;

    // Using Lanterna (https://github.com/mabe02/lanterna)
    public void buildUI(Screen screen)
    {
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
        WindowKeyListener wkl = new WindowKeyListener(() -> cm.handleCommand(inputBox.getText()));
        window.addWindowListener(wkl);

        // Finally create and display the GUI.
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLACK));

        gui.addWindowAndWait(window);
    }

    protected void clearInputBox()
    {
        inputBox.setText("");
    }

    protected void addToEventLog(String event)
    {
        eventLogPanel.addComponent(new Label(event));
    }
}
