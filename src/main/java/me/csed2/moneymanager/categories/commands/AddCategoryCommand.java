package me.csed2.moneymanager.categories.commands;

import me.csed2.moneymanager.cache.CachedList;
import me.csed2.moneymanager.categories.Category;
import me.csed2.moneymanager.main.App;

import java.util.Date;
import java.util.function.Function;

public class AddCategoryCommand implements Function<App, Boolean> {

    private final String name;
    private final int id;
    private final Date created;
    private final double budget;

    public AddCategoryCommand(String name, double budget) {
        this.name = name;
        this.id = App.getInstance().getCategoryCache().nextId();
        this.created = new Date();
        this.budget = budget;
    }

    @Override
    public Boolean apply(App app) {

        CachedList<Category> cache = app.getCategoryCache();

        Category category = new Category.Builder(name)
                .withId(id)
                .withCreationDate(created)
                .withBudget(budget)
                .build();

        cache.add(category);

        cache.save("categories.json");

        return true;
    }
}
