package cl.usach.CICEROT.Hots;

/**
 * Created by Ian on 07-11-2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import cl.usach.CICEROT.R;


public class HotsListAdapter extends BaseAdapter {


    Context context;
    String[] titulos;
    int[] imagenes;
    String[] descripciones;
    String[] likes;
    String[] guias;
    String[] precios;
    LayoutInflater inflater;
    Bitmap[] bits;

    public HotsListAdapter(Context context, String[] titulos, Bitmap[] bits, String[] likes, String[] guias, String[] descripciones, String[] precios) {
        this.context = context;
        this.titulos = titulos;
        this.likes = likes;
        this.guias = guias;
        this.descripciones = descripciones;
        this.precios = precios;
        this.bits = bits;
        this.imagenes = null;
    }

    public HotsListAdapter(Context context, String[] titulos, int[] imagenes, String[] likes, String[] guias, String[] descripciones, String[] precios) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
        this.likes = likes;
        this.guias = guias;
        this.descripciones = descripciones;
        this.precios = precios;
        this.bits = null;
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
        TextView textLikes;
        TextView textGuides;
        TextView textDescription;
        TextView textPrices;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_hots_style, parent, false);

        //Encuentra componentes
        txtTitle = (TextView) itemView.findViewById(R.id.textHotsList);
        ImageView Img = (ImageView) itemView.findViewById(R.id.iconHotsList);
        textLikes = (TextView) itemView.findViewById(R.id.hotsNumberOfLikes);
        textGuides = (TextView) itemView.findViewById(R.id.hotsGuideName);
        textDescription = (TextView) itemView.findViewById(R.id.hotsDescription);
        textPrices = (TextView) itemView.findViewById(R.id.hotsPrice);

        //Setea campos






        txtTitle.setText(titulos[position]);
        if(imagenes==null) {
            Img.setImageBitmap(bits[position]);
        }else{
            Img.setImageResource(imagenes[position]);
        }
        textLikes.setText(likes[position]);
        textGuides.setText(guias[position]);
        textDescription.setText(descripciones[position]);
        textPrices.setText(precios[position]);



        return itemView;
    }
}