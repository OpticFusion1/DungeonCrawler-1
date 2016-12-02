package com.joe.dungeoncrawler;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.*;

/**
 * Main Driver class of the game.
 */
public final class Main
{
    // Right now, this throws a bunch of horrible exceptions but we'll handle them appropriately eventually.
    public static void main(String[] args) throws Exception
    {
        // Create a terminal window of the required size.
        Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(122, 32)).createTerminal();

        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Build and display the UI.
        InterfaceManager ui = new InterfaceManager();
        ui.buildUI(screen);
    }

}
