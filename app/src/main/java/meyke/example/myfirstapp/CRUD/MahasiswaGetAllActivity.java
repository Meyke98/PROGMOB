package meyke.example.myfirstapp.CRUD;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import meyke.example.myfirstapp.Adapter.MhsCRUDRecyclerAdapter;
import meyke.example.myfirstapp.Model.Mahasiswa;
import meyke.example.myfirstapp.Network.GetDataService;
import meyke.example.myfirstapp.Network.RetrofitClientInstance;
import meyke.example.myfirstapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaGetAllActivity extends AppCompatActivity {

    RecyclerView rvMhs;
    MhsCRUDRecyclerAdapter mhsAdapter;
    ProgressDialog pd;
    List<Mahasiswa> mahasiswaList;
    private RetrofitClientInstance GetDataService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_get_all);

        rvMhs = (RecyclerView)findViewById(R.id.rvGetMhsAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Tolong Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Mahasiswa>> call = service.getMahasiswa("72170121");

        call.enqueue(new Callback<List<Mahasiswa>>() {
            @Override
            public void onResponse(Call<List<Mahasiswa>> call, Response<List<Mahasiswa>> response) {
                pd.dismiss();
                mahasiswaList = response.body();
                mhsAdapter = new MhsCRUDRecyclerAdapter(mahasiswaList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MahasiswaGetAllActivity.this);
                rvMhs.setLayoutManager(layoutManager);
                rvMhs.setAdapter(mhsAdapter);
            }

            @Override
            public void onFailure(Call<List<Mahasiswa>> call, Throwable t) {
                Toast.makeText(MahasiswaGetAllActivity.this, "ERROR!", Toast.LENGTH_LONG);
            }
        });
    }
}