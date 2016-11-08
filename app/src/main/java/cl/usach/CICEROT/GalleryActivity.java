package cl.usach.CICEROT;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

public class GalleryActivity extends Fragment {
    GridView grid;
    GalleryGridAdapter adapter;
    int[] imagenes = {
            R.drawable.paisaje2,
            R.drawable.montana,
            R.drawable.ic_create_new_folder_black_48dp
    };


    String[] nombres = new String[]{
            "Vacaciones 2012",
            "Vacaciones 2013",
            "Nuevo"
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_gallery, container, false);
        grid =(GridView)view.findViewById(R.id.gridAlbum);

        adapter = new GalleryGridAdapter(getContext(), nombres, imagenes);
        grid.setAdapter(adapter);
        return view;
    }
}