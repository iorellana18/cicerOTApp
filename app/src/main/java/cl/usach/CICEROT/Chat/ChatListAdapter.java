package cl.usach.CICEROT.Chat;

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


public class ChatListAdapter extends BaseAdapter {

    Context context;
    String[] nombres;
    int[] imagenes;
    LayoutInflater inflater;

    public ChatListAdapter(Context context, String[] nombres, int[] imagenes) {
        this.context = context;
        this.nombres = nombres;
        this.imagenes = imagenes;
    }

    @Override
    public int getCount() {
        return nombres.length;
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


        TextView txtName;
        ImageView Img;


        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.activity_chat_style, parent, false);

        //Encuentra componentes
        txtName = (TextView) itemView.findViewById(R.id.textMailList);
        Img = (ImageView) itemView.findViewById(R.id.iconMailList);

        //Setea campos
        txtName.setText(nombres[position]);
        Img.setImageResource(imagenes[position]);

        return itemView;
    }
}