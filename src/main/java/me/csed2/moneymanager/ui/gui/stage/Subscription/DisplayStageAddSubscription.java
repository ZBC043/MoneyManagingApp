package me.csed2.moneymanager.ui.gui.stage.Subscription;

import me.csed2.moneymanager.categories.CategoryCache;
import me.csed2.moneymanager.command.CommandDispatcher;
import me.csed2.moneymanager.subscriptions.commands.AddSubscriptionCommand;
import me.csed2.moneymanager.ui.cmdline.stage.Stage;
import me.csed2.moneymanager.ui.gui.DisplayMenu;
import me.csed2.moneymanager.ui.gui.stage.DisplayStageMenu;

public class DisplayStageAddSubscription extends DisplayStageMenu {


    public DisplayStageAddSubscription(){
        super(300, 300, "Add Subscription", CATEGORY);
    }

    @Override
    protected void beginPhase() {

    }

    @Override
    protected void addStages() {
        addStage(new Stage<>(String.class, "What is the name of the category you'd like to add the subscription to?")
                .withExecutionPhase(() -> CategoryCache.getInstance().printNames()));

        addStage(new Stage<>(String.class, "What is the name of the subscription?"));
        addStage(new Stage<>(Integer.class, "How much was spent at this subscription?"));
        addStage(new Stage<>(String.class, "Where did you spend this money?"));
        addStage(new Stage<>(String.class, "Do you have any notes about this subscription?", "(Please split all notes you have with a comma)"));
    }

    @Override
    protected void exitPhase() {
        String categoryName = (String) stages.get(0).getResult();
        String name = (String) stages.get(1).getResult();
        Integer amount = (Integer) stages.get(2).getResult();
        String vendor = (String) stages.get(3).getResult();
        String[] notes = ((String) stages.get(4).getResult()).split(",");

        if (CommandDispatcher.getInstance().dispatchSync(new AddSubscriptionCommand(categoryName, name, amount, vendor, notes))) {
            showMessage("Subscription successfully added!");
        } else {
            showMessage("Error: Unable to add subscription!");
        }
        openPreviousMenu();
    }
}