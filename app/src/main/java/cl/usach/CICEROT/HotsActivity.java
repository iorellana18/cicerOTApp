package cl.usach.CICEROT;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
            "Guia asesino777",
    };
    String[] descripcion = new String[]{
            "Una noche llena de sorpresas",
            "Relajate este verano 1313",
            "Desafía tus miedos",
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_hots, container, false);
        list =(ListView)view.findViewById(R.id.listNotices);

        adapter = new HotsListAdapter(getContext(), titulo, imagenes,likes,guias,descripcion,precios);
        list.setAdapter(adapter);
        return view;
    }
}