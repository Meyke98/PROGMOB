package meyke.example.myfirstapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import meyke.example.myfirstapp.Model.Mahasiswa;
import meyke.example.myfirstapp.R;

public class MhsCRUDRecyclerAdapter extends RecyclerView.Adapter<MhsCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Mahasiswa> mahasiswaList;

    public MhsCRUDRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaList = new ArrayList<>();
    }

    public MhsCRUDRecyclerAdapter(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
    }

    public List<Mahasiswa> getMahasiswaList() {
        return mahasiswaList;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
        this.mahasiswaList = mahasiswaList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_cardview,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Mahasiswa m = mahasiswaList.get(i);

        viewHolder.tvNama.setText(m.getNama());
        viewHolder.tvNim.setText(m.getNim());
        viewHolder.tvAlamat.setText(m.getAlamat());
        viewHolder.tvEmail.setText(m.getEmail());
        //viewHolder.tvNoTelp.setText(m.getNoTelp());
    }


    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvNim, tvAlamat, tvEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvAlamat = itemView.findViewById(R.id.tvAlamat);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            //tvNoTelp = itemView.findViewById(R.id.tvNoTelp);
        }
    }


}
