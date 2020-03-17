package me.csed2.moneymanager.cache;

import com.google.gson.reflect.TypeToken;
import me.csed2.moneymanager.categories.Category;
import me.csed2.moneymanager.transactions.Transaction;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CacheTypeFactory {

    public static Type getType(Class<? extends Cacheable> klass) {
        if (klass == Transaction.class) {
            return new TypeToken<ArrayList<Transaction>>(){}.getType();
        } else if (klass == Category.class) {
            return new TypeToken<ArrayList<Category>>(){}.getType();
        } else {
            return null;
        }
    }
}
