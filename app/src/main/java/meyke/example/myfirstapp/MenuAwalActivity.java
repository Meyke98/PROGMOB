package meyke.example.myfirstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import meyke.example.myfirstapp.Adapter.MenuAwalAdapter;
import meyke.example.myfirstapp.CRUD.MainMhsActivity;
import meyke.example.myfirstapp.DosenCRUD.MainDosenActivity;
import meyke.example.myfirstapp.MatkulCRUD.MainMatkulActivity;

public class MenuAwalActivity extends AppCompatActivity {

    GridView gridView;
    String[] namaIcon = {"Menu Mahasiswa","Menu Dosen","Menu Matakuliah"};
    int[] nomerIcon = {R.drawable.lips,R.drawable.dosen,R.drawable.krs};
    String isLogin="";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menulogout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        SharedPreferences pref = MenuAwalActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        String isLogin = pref.getString("isLogin", "0");
        editor.putString("isLogin", "0");
        editor.commit();
        Intent intent = new Intent(MenuAwalActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_awal);


        androidx.appcompat.widget.Toolbar logoutToolbar = (Toolbar)findViewById(R.id.toolbarLogout);
        setSupportActionBar(logoutToolbar);

        gridView = findViewById(R.id.gridView);
        MenuAwalAdapter MenuAdapter = new MenuAwalAdapter(MenuAwalActivity.this, namaIcon, nomerIcon);
        gridView.setAdapter(MenuAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(),"Anda Memilih Menu "+namaIcon[position],Toast.LENGTH_SHORT).show();
                if("Menu Mahasiswa".equals(namaIcon[position])){
                    Intent intentmhs =new Intent(MenuAwalActivity.this, MainMhsActivity.class);
                    startActivity(intentmhs);
                } else if ("Menu Dosen".equals(namaIcon[position])){
                    Intent intentdosen = new Intent(MenuAwalActivity.this, MainDosenActivity.class);
                    startActivity(intentdosen);
                } else if ("Menu Matakuliah".equals(namaIcon[position])) {
                    Intent intentmatkul = new Intent(MenuAwalActivity.this, MainMatkulActivity.class);
                    startActivity(intentmatkul);
                }
            }
        });

    }
}