package me.csed2.moneymanager.subscriptions.commands;

import me.csed2.moneymanager.categories.Category;
import me.csed2.moneymanager.categories.CategoryCache;
import me.csed2.moneymanager.command.ICommand;
import me.csed2.moneymanager.subscriptions.Subscription;
import me.csed2.moneymanager.subscriptions.SubscriptionCache;

import java.util.ArrayList;
import java.util.List;

public class ListSubscriptionsCommand implements ICommand<List<Subscription>> {

    private final String categoryName;

    public ListSubscriptionsCommand(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public List<Subscription> execute() {
        CategoryCache cache = CategoryCache.getInstance();
        List<Subscription> subscriptions = new ArrayList<>();

        if (categoryName.equalsIgnoreCase("ALL")) {
            subscriptions = SubscriptionCache.getInstance().asList();
        } else {
            Category category = cache.readByName(categoryName);
            if (category != null) {
                subscriptions = SubscriptionCache.getInstance().readByCategory(categoryName);
            }
        }
        return subscriptions;
    }
}