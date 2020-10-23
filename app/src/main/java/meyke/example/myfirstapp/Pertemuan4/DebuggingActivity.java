package meyke.example.myfirstapp.Pertemuan4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import meyke.example.myfirstapp.Adapter.MhsRecyclerAdapter;
import meyke.example.myfirstapp.Model.Mahasiswa;
import meyke.example.myfirstapp.R;

public class DebuggingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debugging);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclervLthn);
        MhsRecyclerAdapter mahasiswaRecyclerAdapter;

        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Argo","72110101","084646464646");
        Mahasiswa m2 = new Mahasiswa("Halim","72110101","084646464646");
        Mahasiswa m3 = new Mahasiswa("Jong Jek Siang","72110101","084646464646");
        Mahasiswa m4 = new Mahasiswa("Katon","72110101","084646464646");
        Mahasiswa m5 = new Mahasiswa("Yetli","72110101","084646464646");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        //List<Mahasiswa> mahasiswaListDebug = new ArrayList<Mahasiswa>();

        mahasiswaRecyclerAdapter = new MhsRecyclerAdapter(DebuggingActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(DebuggingActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);
    }
}
