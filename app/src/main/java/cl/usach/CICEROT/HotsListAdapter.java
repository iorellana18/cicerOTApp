package cl.usach.CICEROT;

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


public class HotsListAdapter extends BaseAdapter {


    Context context;
    String[] titulos;
    int[] imagenes;
    String[] descripciones;
    String[] likes;
    String[] guias;
    LayoutInflater inflater;

    public HotsListAdapter(Context context, String[] titulos, int[] imagenes, String[] likes, String[] guias, String[] descripciones) {
        this.context = context;
        this.titulos = titulos;
        this.imagenes = imagenes;
        this.likes = likes;
        this.guias = guias;
        this.descripciones = descripciones;
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
        TextView textLikes;
        TextView textGuides;
        TextView textDescription;


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_hots_style, parent, false);

        //Encuentra componentes
        txtTitle = (TextView) itemView.findViewById(R.id.textHotsList);
        Img = (ImageView) itemView.findViewById(R.id.iconHotsList);
        textLikes = (TextView) itemView.findViewById(R.id.hotsNumberOfLikes);
        textGuides = (TextView) itemView.findViewById(R.id.hotsGuideName);
        textDescription = (TextView) itemView.findViewById(R.id.hotsDescription);

        //Setea campos
        txtTitle.setText(titulos[position]);
        Img.setImageResource(imagenes[position]);
        textLikes.setText(likes[position]);
        textGuides.setText(guias[position]);
        textDescription.setText(descripciones[position]);

        return itemView;
    }
}