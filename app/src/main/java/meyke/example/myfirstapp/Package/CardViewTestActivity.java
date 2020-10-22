package meyke.example.myfirstapp.Package;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import meyke.example.myfirstapp.Adapter.MhsRecyclerAdapter;
import meyke.example.myfirstapp.Model.Mahasiswa;
import meyke.example.myfirstapp.R;

public class CardViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_test);

        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerCardView);
        MhsRecyclerAdapter mhsRecyclerAdapter;

        //Data Dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //Generate Data
        Mahasiswa m1 = new Mahasiswa("Kim Hanbin", "72170121", "085352447298");
        Mahasiswa m2 = new Mahasiswa("Bobby", "72170101", "085352447296");
        Mahasiswa m3 = new Mahasiswa("Jinhwan", "72170102", "085352447297");
        Mahasiswa m4 = new Mahasiswa("Chan", "72170103", "085352447299");
        Mahasiswa m5 = new Mahasiswa("Jokowidodo", "72170104", "085352447295");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);

        mhsRecyclerAdapter = new MhsRecyclerAdapter(CardViewTestActivity.this);
        mhsRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(CardViewTestActivity.this));
        rv.setAdapter(mhsRecyclerAdapter);
    }
}