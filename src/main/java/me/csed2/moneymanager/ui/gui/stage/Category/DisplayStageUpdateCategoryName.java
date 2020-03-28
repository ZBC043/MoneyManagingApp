package me.csed2.moneymanager.ui.gui.stage.Category;

import me.csed2.moneymanager.categories.CategoryArgType;
import me.csed2.moneymanager.categories.commands.UpdateCategoryCommand;
import me.csed2.moneymanager.command.CommandDispatcher;
import me.csed2.moneymanager.ui.model.Stage;
import me.csed2.moneymanager.ui.gui.stage.DisplayStageMenu;

public class DisplayStageUpdateCategoryName extends DisplayStageMenu {

    public DisplayStageUpdateCategoryName(){
        super(300, 300, "Update Category Name", UPDATE_CATEGORY);
    }

    @Override
    protected void beginPhase() {

    }

    @Override
    protected void addStages() {
        addStage(new Stage<>(String.class, "What category would you like to change the name for?"));
        addStage(new Stage<>(String.class, "What would you like to change the name to?"));
    }

    @Override
    protected void exitPhase() {
        String categoryName = (String) stages.get(0).getResult();
        String result = (String) stages.get(1).getResult();

        if (CommandDispatcher.dispatchSync(new UpdateCategoryCommand<>(categoryName, CategoryArgType.NAME, result))) {
            showMessage("Successfully updated the name of this category!");
        } else {
            showMessage("Error: Unable to update this category!");
        }
        openPreviousMenu();
    }
}
