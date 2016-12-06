package cl.usach.CICEROT.Ofertas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import cl.usach.CICEROT.Perfil.PerfilActivity;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 08-11-2016.
 */
public class misOfertasFragment extends Fragment  {

    TextView titulo;
    ImageView imagen;
    TextView guia;
    TextView likes;
    TextView precio;
    TextView descripcion;
    TextView tomado;
    ImageView imagenGuia;
    TextView nombreGuia;
    public static final int Default_value=0;

    String[] veces = {
            "Tomado 0 veces",
            "Tomado 0 veces",
            "Tomado 0 veces",
            "Tomado 0 veces",
            "Tomado 0 veces",
            "Tomado 0 veces"
    };




    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_misofertas, container, false);

        imagen = (ImageView)view.findViewById(R.id.photoOferta);
        titulo = (TextView)view.findViewById(R.id.TituloOferta);
        precio = (TextView)view.findViewById(R.id.PrecioOferta);
        likes = (TextView)view.findViewById(R.id.LikesOferta);
        tomado = (TextView)view.findViewById(R.id.VecesOferta);
        descripcion = (TextView)view.findViewById(R.id.DescripcionOferta);

        String title = getActivity().getIntent().getStringExtra("titulo");
        String image = getActivity().getIntent().getStringExtra("imagen");
        final String megusta = getActivity().getIntent().getStringExtra("likes");
        String price = getActivity().getIntent().getStringExtra("precio");
        String description = getActivity().getIntent().getStringExtra("descripcion");
        final int position = getActivity().getIntent().getIntExtra("posicion", 0);

        imagen.setImageURI(Uri.fromFile(new File(image)));
        titulo.setText(title);
        precio.setText(price);
        likes.setText(megusta);
        tomado.setText(veces[position]);
        descripcion.setText(description);


        return view;
    }


}