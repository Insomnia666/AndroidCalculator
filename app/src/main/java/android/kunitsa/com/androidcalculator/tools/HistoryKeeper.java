package android.kunitsa.com.androidcalculator.tools;

import java.util.ArrayList;
import java.util.List;

public class HistoryKeeper {

    private static List<HistoryItem> items = new ArrayList<>();

    public static void addItem(HistoryItem item) {
        items.add(item);
    }

    public static List<HistoryItem> getList() {
        return items;
    }

}
