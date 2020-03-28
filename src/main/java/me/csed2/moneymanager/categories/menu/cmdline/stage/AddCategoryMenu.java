package me.csed2.moneymanager.categories.menu.cmdline.stage;

import me.csed2.moneymanager.categories.commands.AddCategoryCommand;
import me.csed2.moneymanager.command.CommandDispatcher;
import me.csed2.moneymanager.ui.model.Stage;
import me.csed2.moneymanager.ui.model.StageMenu;

public class AddCategoryMenu extends StageMenu {


    /**
     * Constructor for CMDMenu. Responsible for adding the buttons to the list.
     *
     * @param previousMenu
     */
    public AddCategoryMenu(Menu previousMenu) {
        super("Add Category", previousMenu, image);
    }

    @Override
    public void addStages() {
        addStage(new Stage<>(String.class, "What is the name of the new category?"));
        addStage(new Stage<>(Integer.class, "What is the budget you would like to set for this category?"));
    }

    @Override
    public void exitPhase() {
        String name = (String) stages.get(0).getResult();
        Integer budget = (Integer) stages.get(1).getResult();

        if (CommandDispatcher.dispatchSync(new AddCategoryCommand(name, budget))) {
            System.out.println("Category successfully added!");
        }

        openPreviousMenu();
    }
}
