package cl.usach.CICEROT.Perfil;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.widget.ImageView;
import android.widget.TextView;

import cl.usach.CICEROT.R;

/**
 * Created by Ian on 08-11-2016.
 */
public class PerfilFragment extends Fragment  {


    ImageView fotoPortada;
    ImageView fotoPerfil;
    TextView nombre;
    TextView likes;
    TextView descripciones;



    int[] portadas = {
            R.drawable.portada1,
            R.drawable.portada2,
            R.drawable.portada3
    };

    String[] descripcionesPerfil = {
            "Buena persona, trabajador y aventurero",
            "Sólo hay una vida! hay que vivirla al extremo!",
            "Buscando mi siguiente victima, digo, cliente"
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        fotoPortada = (ImageView)view.findViewById(R.id.portadaPerfil);
        fotoPerfil = (ImageView)view.findViewById(R.id.fotoPerfil);
        nombre = (TextView)view.findViewById(R.id.nombrePerfil);
        likes = (TextView)view.findViewById(R.id.likesPerfil);
        descripciones = (TextView)view.findViewById(R.id.descripcionPerfil);

        int perfil = getActivity().getIntent().getIntExtra("foto",0);
        String nombrePerfil = getActivity().getIntent().getStringExtra("nombre");
        int position = getActivity().getIntent().getIntExtra("posicion", 0);
        String megusta = getActivity().getIntent().getStringExtra("like");

        fotoPortada.setImageResource(portadas[position]);
        fotoPerfil.setImageResource(perfil);
        nombre.setText(nombrePerfil);
        likes.setText(megusta);
        descripciones.setText(descripcionesPerfil[position]);
        return view;
    }


}