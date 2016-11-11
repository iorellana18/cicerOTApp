package cl.usach.CICEROT.Hots;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import cl.usach.CICEROT.Ofertas.OfertasActivity;
import cl.usach.CICEROT.R;

public class HotsActivity extends Fragment {
    ListView list;
    HotsListAdapter adapter;
    int[] imagenes = {
            R.drawable.stgo,
            R.drawable.playa,
            R.drawable.montana
    };

    String[] likes = {
            "213 Likes",
            "123 Likes",
            "65 Likes"
    };

    String[] titulo = new String[]{
            "Santiago de Noche",
            "Paseo por la playa",
            "Sube la montaña",
    };

    String[] precios = new String[]{
            "$51.990",
            "$40.000",
            "$17.850",
    };

    String[] guias = new String[]{
            "Ian Orellana",
            "Elías González",
            "Juan Perez",
    };
    String[] descripcion = new String[]{
            "Una noche llena de sorpresas",
            "Relajate este verano 1313",
            "Desafía tus miedos",
    };

    int[] fotosGuia = {
            R.drawable.ian,
            R.drawable.elitos,
            R.drawable.juan
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hots, container, false);
        list =(ListView)view.findViewById(R.id.listNotices);

        adapter = new HotsListAdapter(getContext(), titulo, imagenes,likes,guias,descripcion,precios);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(),OfertasActivity.class);
                intent.putExtra("titulo",titulo[position]);
                intent.putExtra("imagen",imagenes[position]);
                intent.putExtra("likes",likes[position]);
                intent.putExtra("guia",guias[position]);
                intent.putExtra("descripcion",descripcion[position]);
                intent.putExtra("precio",precios[position]);
                intent.putExtra("posicion",position);
                intent.putExtra("fotosGuia",fotosGuia[position]);
                startActivity(intent);




            }
        });
        return view;
    }
}