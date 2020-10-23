package meyke.example.myfirstapp.CRUD;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import meyke.example.myfirstapp.Model.DefaultResult;
import meyke.example.myfirstapp.Network.GetDataService;
import meyke.example.myfirstapp.Network.RetrofitClientInstance;
import meyke.example.myfirstapp.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_add);

        EditText editTextNama = (EditText)findViewById(R.id.editTextNama);
        EditText editTextNim = (EditText)findViewById(R.id.editTextNim);
        EditText editTextAlamat = (EditText)findViewById(R.id.editTextAlamat);
        EditText editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        Button btnSimpan = (Button)findViewById(R.id.btnSimpan);
        pd = new ProgressDialog(MahasiswaAddActivity.this);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Just Wait!");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mhs(
                        editTextNama.getText().toString(),
                        editTextNim.getText().toString(),
                        editTextAlamat.getText().toString(),
                        editTextEmail.getText().toString(),
                        "Anda Dapat Mengosongkan nya",
                        "72170121"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "Berhasil Disimpan!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this, "Gagal", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}