package meyke.example.myfirstapp.Package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import meyke.example.myfirstapp.R;

public class ListActivity extends AppCompatActivity {

    String[] items={"lisa", "jiwon", "jennie", "rose", "jiso",
            "yoona", "taeyeon", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "etiam", "vel", "erat",
            "jessica", "yuri", "hyoyeon", "tifanny", "soyoung", "seohyun", "sunny"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView = (ListView)findViewById(R.id.ListviewLthn);
        Spinner sp = (Spinner)findViewById(R.id.spinnerLthn);


        listView.setAdapter(new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_list_item_1,items));
        ArrayAdapter<String> aa = new ArrayAdapter<String>(ListActivity.this,android.R.layout.simple_spinner_dropdown_item,items);
        sp.setAdapter(aa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Anda memilih: " + items[position],Toast.LENGTH_LONG).show();
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Anda memilih: " + items[position],Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ListActivity.this, "Anda tidak memilih: ",Toast.LENGTH_LONG).show();
            }
        });
    }
}