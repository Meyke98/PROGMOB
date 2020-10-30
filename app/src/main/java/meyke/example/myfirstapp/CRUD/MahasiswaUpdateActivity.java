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

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);

        final EditText UpdtNimAwal = (EditText)findViewById(R.id.UpdtNimAwal);
        final EditText UpdtNama = (EditText)findViewById(R.id.UpdtNama);
        final EditText UpdtNim = (EditText)findViewById(R.id.UpdtNim);
        final EditText UpdtAlamat = (EditText)findViewById(R.id.UpdtAlamat);
        final EditText UpdtEmail = (EditText)findViewById(R.id.UpdtEmail);

        Button btnUpdate = (Button)findViewById(R.id.btnUpdate);
        pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Loading...");
                pd.show();


                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> dlt = service.delete_mhs(
                        UpdtNimAwal.getText().toString(),
                        "72170121"
                );

                GetDataService services = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = services.update_mhs(
                        UpdtNama.getText().toString(),
                        UpdtNim.getText().toString(),
                        UpdtAlamat.getText().toString(),
                        UpdtEmail.getText().toString(),
                        "Boleh dikosongkan",
                        "72170121"
                );

                dlt.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        Toast.makeText(MahasiswaUpdateActivity.this, "Update berhasil!",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Error!",
                                Toast.LENGTH_LONG).show();
                    }
                });

                Call<DefaultResult> add = service.add_mhs(
                        UpdtNama.getText().toString(),
                        UpdtNim.getText().toString(),
                        UpdtAlamat.getText().toString(),
                        UpdtEmail.getText().toString(),
                        "Boleh dikosongkan!", "72170121"
                );

                add.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Update berhasil!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "Error!", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}