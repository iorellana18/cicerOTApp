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
            R.drawable.ic_library_add_black_48dp
    };


    String[] nombres = new String[]{
            "Paseo en la nieve",
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