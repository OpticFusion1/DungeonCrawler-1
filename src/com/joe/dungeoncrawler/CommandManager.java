package com.joe.dungeoncrawler;

/**
 * Receives and executes the commands that are input through the TextBox.
 */
final class CommandManager
{
    private InterfaceManager ui;

    public CommandManager(InterfaceManager ui)
    {
        this.ui = ui;
    }

    /**
     * This method is called by the UI's implementation of the CommandListenerInterface.
     * It handles the incoming commands from the TextBox input.
     * @param command The command to parse and execute.
     */
    protected void handleCommand(String command)
    {
        switch (command)
        {
            case "help":
                ui.addToEventLog("HELP STUFF");
                break;
            case "exit":
                System.exit(0);
                break;
            case "":
                break;
            default:
                ui.addToEventLog("Invalid Command: " + command);
                break;
        }

        // Clear the input TextBox once we've parsed the command.
        ui.clearInputBox();
    }
}
