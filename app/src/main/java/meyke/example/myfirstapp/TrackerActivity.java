package meyke.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TrackerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        TextView txtTrackerActivity = (TextView)findViewById(R.id.textViewTrackerAct);

        Bundle b = getIntent().getExtras();
        String textTracker = b.getString("Tracker_string");
        txtTrackerActivity.setText(textTracker);
    }
}