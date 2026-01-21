package com.jsrom.connect4.views.console.shared;

import com.jsrom.connect4.controllers.core.AcceptorController;

import com.jsrom.utils.models.menu.Option;

public abstract class MenuOption extends Option {

    protected AcceptorController acceptorController;

    public MenuOption(AcceptorController acceptorController, String tittle) {
        super(tittle);
        this.acceptorController = acceptorController;
    }

}
