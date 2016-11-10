package cl.usach.CICEROT.Tours;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import cl.usach.CICEROT.Ofertas.misOfertasActivity;
import cl.usach.CICEROT.R;

public class MyToursActivity extends Fragment {
    GridView grid;
    MyToursGridAdapter adapter;
    int[] imagenes = {
            R.drawable.paisaje2,
            R.drawable.paisaje3
    };

    String[] likes = {
            "3 likes",
            "12 likes"
    };


    String[] nombres = new String[]{
            "Paseo en la nieve",
            "Playa milagrosa"
    };

    String[] descripcion = new String[]{
            "El mejor guía de la zona",
            "El mejor guía de la zona"
    };

    String[] precios = new String[]{
            "$39.990",
            "$28.000"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tours, container, false);
        grid =(GridView)view.findViewById(R.id.gridAlbum);

        adapter = new MyToursGridAdapter(getContext(), nombres, imagenes);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(), misOfertasActivity.class);
                intent.putExtra("titulo", nombres[position]);
                intent.putExtra("imagen", imagenes[position]);
                intent.putExtra("likes", likes[position]);
                intent.putExtra("descripcion", descripcion[position]);
                intent.putExtra("precio", precios[position]);
                intent.putExtra("posicion", position);
                startActivity(intent);


            }
        });
        return view;
    }
}