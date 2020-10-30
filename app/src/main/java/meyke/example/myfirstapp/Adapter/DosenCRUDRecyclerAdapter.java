package meyke.example.myfirstapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import meyke.example.myfirstapp.DosenCRUD.DosenUpdateActivity;
import meyke.example.myfirstapp.Model.Dosen;
import meyke.example.myfirstapp.R;

public class DosenCRUDRecyclerAdapter extends AppCompatActivity<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;

    public DosenCRUDRecyclerAdapter(Context context){
        this.context = context;
        dosenList = new ArrayList<>();
    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList){
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    private void notifyDataSetChanged() {
    }


    /*@Override
    public int getItemCount() {
        return dosenList.size();
    }*/

    @NonNull
    @Override
    public DosenCRUDRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_dosen,parent,false);
        return new DosenCRUDRecyclerAdapter.ViewHolder(v,parent.getContext());

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen d = dosenList.get(position);

        holder.txtNamaDosen.setText(d.getNama());
        holder.txtNidn.setText(d.getNidn());
        holder.txtAlamat.setText(d.getAlamat());
        holder.txtEmail.setText(d.getEmail());
        holder.txtGelar.setText(d.getGelar());
        holder.d = d;

    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaDosen, txtNidn, txtAlamat, txtEmail, txtGelar, rvGetDosenAll;
        Dosen d;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            txtNamaDosen = itemView.findViewById(R.id.txtNama);
            txtNidn = itemView.findViewById(R.id.txtNidn);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtGelar = itemView.findViewById(R.id.txtGelar);
            rvGetDosenAll = itemView.findViewById(R.id.rvGetDosenAll);
            itemView.setOnClickListener(new  View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent UpInput =new Intent(context, DosenUpdateActivity.class);
                    UpInput.putExtra("nama",d.getNama());
                    UpInput.putExtra("nidn",d.getNidn());
                    UpInput.putExtra("alamat",d.getAlamat());
                    UpInput.putExtra("email",d.getEmail());
                    UpInput.putExtra("gelar",d.getGelar());
                    context.startActivity(UpInput);
                }
            });
        }
    }
}

