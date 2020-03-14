package me.csed2.moneymanager.ui.gui.stage;

import me.csed2.moneymanager.categories.commands.AddCategoryCommand;
import me.csed2.moneymanager.command.CommandDispatcher;
import me.csed2.moneymanager.transactions.Transaction;
import me.csed2.moneymanager.ui.cmdline.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DisplayStageAddCategory extends DisplayStageMenu{

    public DisplayStageAddCategory(){
        super(300, 300, "Add Category", CATEGORY);
    }

    @Override
    public void addStages() {
        addStage(new Stage<>(String.class, "What is the name of the new category?"));
        addStage(new Stage<>(Integer.class, "What is the budget you would like to set for this category?"));
    }

    public void beginPhase(){

    }

    @Override
    public void exitPhase() {
        String name = (String) stages.get(0).getResult();
        Integer budget = (Integer) stages.get(1).getResult();
        List<Transaction> transactions = new ArrayList<>();

        /*
        if (CommandDispatcher.getInstance().dispatchSync(new AddCategoryCommand(name, budget, transactions))) {
            System.out.println("Category successfully added!");
        }
         */
        System.out.println(currentMenu);
        openPreviousMenu();
        System.out.println(currentMenu);
    }
}