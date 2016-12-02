package com.joe.dungeoncrawler;

final class CommandManager
{
    private InterfaceManager ui;

    public CommandManager(InterfaceManager ui)
    {
        this.ui = ui;
    }

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

        ui.clearInputBox();
    }
}
