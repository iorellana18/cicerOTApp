package cl.usach.CICEROT.Tours;

/**
 * Created by Ian on 07-11-2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cl.usach.CICEROT.R;


public class MyToursGridAdapter extends BaseAdapter {


    Context context;
    String[] titulos;
    int[] imagenes;
    LayoutInflater inflater;

    public MyToursGridAdapter(Context context, String[] titulos, int[] imagenes) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return titulos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {


        TextView txtTitle;
        ImageView Img;


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_tours_style, parent, false);

        //Encuentra componentes
        txtTitle = (TextView) itemView.findViewById(R.id.textAlbum);
        Img = (ImageView) itemView.findViewById(R.id.iconAlbum);

        //Setea campos
        txtTitle.setText(titulos[position]);
        Img.setImageResource(imagenes[position]);

        return itemView;
    }
}