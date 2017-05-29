package android.kunitsa.com.androidcalculator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.kunitsa.com.androidcalculator.R;
import android.kunitsa.com.androidcalculator.adapters.RecyclerViewAdapter;
import android.kunitsa.com.androidcalculator.tools.HistoryKeeper;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        RecyclerView historyView = (RecyclerView) findViewById(R.id.history_view);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        historyView.setLayoutManager(manager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(HistoryKeeper.getList());
        historyView.setAdapter(adapter);

    }
}
