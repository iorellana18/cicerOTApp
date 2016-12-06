package cl.usach.CICEROT.Tours;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import cl.usach.CICEROT.EDA.tours;
import cl.usach.CICEROT.Hots.HotsListAdapter;
import cl.usach.CICEROT.Init.RegistroActivity;
import cl.usach.CICEROT.Ofertas.OfertasActivity;
import cl.usach.CICEROT.Ofertas.misOfertasActivity;
import cl.usach.CICEROT.R;

public class MyToursActivity extends Fragment {
    GridView grid;
    MyToursGridAdapter adapter;


    ImageView icon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tours, container, false);
        grid =(GridView)view.findViewById(R.id.gridAlbum);
        icon = (ImageView)view.findViewById(R.id.NewIcon);

        final String nombre = getActivity().getIntent().getStringExtra("nombre");

        final String Name = getActivity().getIntent().getStringExtra("nombre");
        Firebase ref = new Firebase("https://chatito-eff08.firebaseio.com/tours");


        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                tours tour = new tours();
                int i = 0;
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    i++;
                }

                final String[] cadenaTitulo = new String[i];
                final String[] cadenaPrecio = new String[i];
                final String[] cadenaDescripcion = new String[i];
                final String[] paths = new String[i];
                final String[] cadenaGuias = new String[i];
                final String[] cadenaLikes = new String[i];
                i = 0;
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    tour = postSnapshot.getValue(tours.class);
                    cadenaTitulo[i] = tour.getTitulo();
                    cadenaDescripcion[i] = tour.getDescripcion();
                    cadenaPrecio[i] = tour.getPrecio();
                    cadenaGuias[i] = tour.getKey();
                    paths[i] = tour.getPath();
                    cadenaLikes[i] = tour.getLikes();
                    i++;
                }


                adapter = new MyToursGridAdapter(getContext(), cadenaTitulo, paths);


                grid.setAdapter(adapter);

                grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        Intent intent = new Intent(getActivity(), misOfertasActivity.class);
                        intent.putExtra("titulo", cadenaTitulo[position]);
                        intent.putExtra("imagen", paths[position]);
                        intent.putExtra("likes", cadenaLikes[position]);
                        intent.putExtra("descripcion", cadenaDescripcion[position]);
                        intent.putExtra("precio", cadenaPrecio[position]);
                        intent.putExtra("posicion", position);
                        startActivity(intent);


                    }
                });




            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateTour.class);
                intent.putExtra("nombre", nombre);
                System.out.println(nombre);
                startActivity(intent);
            }
        });


        return view;
    }
}