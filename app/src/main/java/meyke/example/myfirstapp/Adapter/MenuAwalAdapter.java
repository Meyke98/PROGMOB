package meyke.example.myfirstapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import meyke.example.myfirstapp.R;

public class MenuAwalAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] namaIcon;
    private int[] nomerIcon;

    public MenuAwalAdapter(Context context, String[]namaIcon,int[]nomerIcon){
        this.context = context;
        this.namaIcon = namaIcon;
        this.nomerIcon = nomerIcon;
    }


    @Override
    public int getCount() {
        return namaIcon.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView==null){
            convertView=inflater.inflate(R.layout.row_item,null);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        TextView textView = convertView.findViewById(R.id.text_view);

        imageView.setImageResource(nomerIcon[position]);
        textView.setText(namaIcon[position]);
        return convertView;
    }
}
