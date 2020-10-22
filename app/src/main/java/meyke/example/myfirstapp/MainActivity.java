package meyke.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import meyke.example.myfirstapp.Package.CardViewTestActivity;
import meyke.example.myfirstapp.Package.ListActivity;
import meyke.example.myfirstapp.Package.RecyclerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtView = (TextView)findViewById(R.id.mainActivityTextView);
        Button myBtn = (Button)findViewById(R.id.button1);
        final EditText myEditText = (EditText)findViewById(R.id.editText1);
        Button btnHelp = (Button)findViewById(R.id.btnHelp);
        Button btnTracker = (Button)findViewById(R.id.btnTracker);

        Button btnList = (Button)findViewById(R.id.btnListView);
        Button btnRecycler = (Button)findViewById(R.id.btnRecyclerView);
        Button btnCard = (Button)findViewById(R.id.btnCardView);

        txtView.setText(R.string.text_hello_world);
        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("COBA KLIKKK",myEditText.getText().toString());
                txtView.setText(myEditText.getText().toString());
            }
        });
        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrackerActivity.class);
                Bundle b = new Bundle();

                b.putString("Tracker_string", myEditText.getText().toString());
                intent.putExtras(b);

                startActivity(intent);
            }
        });
        btnTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TrackerActivity2.class);
                startActivity(intent);
            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }
        });
        btnCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CardViewTestActivity.class);
                startActivity(intent);
            }
        });
    }
}