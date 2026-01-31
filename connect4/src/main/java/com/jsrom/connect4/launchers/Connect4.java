package com.jsrom.connect4.launchers;

import java.util.Map;

import com.jsrom.connect4.controllers.core.Logic;
import com.jsrom.connect4.views.View;
import com.jsrom.connect4.views.console.ConsoleView;

public class Connect4 {

    protected Logic logic; // la configura la subclase
    protected View view;
    private Map<String, View> viewsMap;
    protected String usageMsg = "Usage: java ...Connect4 <view: console> ";

    protected Connect4() {
        this.viewsMap = Map.of("console", new ConsoleView());
    }

    protected void play(String[] config) {
        this.configure(config);
        this.playGames();
    }

    protected void configure(String[] config) {
        if (config.length == 0) {
            System.out.println(this.usageMsg);
            System.exit(1);
        }
        this.view = this.viewsMap.get(config[0]);
        if (this.view == null) {
            System.out.println("Unknown view: " + config[0]);
            System.exit(1);
        }
    }

    protected void playGames() {
        do {
            if (this.logic.getController() != null) {
                this.logic.getController().accept(this.view);
            }
        } while (this.logic.getController() != null);
    }

}
