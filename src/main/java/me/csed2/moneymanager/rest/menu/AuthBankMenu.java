package me.csed2.moneymanager.rest.menu;

import me.csed2.moneymanager.rest.monzo.menu.MonzoMenu;
import me.csed2.moneymanager.ui.Button;
import me.csed2.moneymanager.ui.cmdline.CMDMenu;

public class AuthBankMenu extends CMDMenu {

    public AuthBankMenu(Menu parent) {
        super("Auth Bank", parent);
    }

    @Override
    protected void addButtons() {
        addButton(new Button("Monzo", user -> user.openMenu(new MonzoMenu(this))));
    }
}
