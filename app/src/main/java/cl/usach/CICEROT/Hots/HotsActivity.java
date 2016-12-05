package cl.usach.CICEROT.Hots;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
import cl.usach.CICEROT.Init.Usuario;
import cl.usach.CICEROT.Main.Adapter;
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

    private String[] titulo2;


    public void setTitulo2(String[] titulo2){
        this.titulo2=titulo2;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_hots, container, false);
        list =(ListView)view.findViewById(R.id.listNotices);
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

                String[] cadenaTitulo = new String[i];
                String[] cadenaPrecio = new String[i];
                String[] cadenaDescripcion = new String[i];
                Bitmap[] bitmap = new Bitmap[i];
                String[] cadenaGuias = new String[i];
                String[] links = new String[i];
                i = 0;
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    tour = postSnapshot.getValue(tours.class);
                    cadenaTitulo[i] = tour.getTitulo();
                    cadenaDescripcion[i] = tour.getDescripcion();
                    cadenaPrecio[i] = tour.getPrecio();
                    cadenaGuias[i] = tour.getKey();
                        FirebaseStorage storage = FirebaseStorage.getInstance();
                        StorageReference storageRef = storage.getReferenceFromUrl("gs://chatito-eff08.appspot.com").child("perfil/"+tour.getKey().toLowerCase()+tour.getTitulo().toLowerCase()+".jpg");

                        try {
                            final File localFile = File.createTempFile("images", "jpg");
                            storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                    System.out.println(localFile.getAbsolutePath());
                                    //links[i]=localFile.getAbsolutePath();
                                            ///Obtiene la fottooooooooo
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception exception) {
                                }
                            });
                        } catch (IOException e ) {
                            System.out.println(e);
                        }





                    i++;
                }





                adapter = new HotsListAdapter(getContext(), cadenaTitulo, imagenes, likes, cadenaGuias, cadenaDescripcion, cadenaPrecio);
                list.setAdapter(adapter);


                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        Intent intent = new Intent(getActivity(), OfertasActivity.class);
                        intent.putExtra("titulo", titulo[position]);
                        intent.putExtra("imagen", imagenes[position]);
                        intent.putExtra("likes", likes[position]);
                        intent.putExtra("guia", guias[position]);
                        intent.putExtra("descripcion", descripcion[position]);
                        intent.putExtra("precio", precios[position]);
                        intent.putExtra("posicion", position);
                        intent.putExtra("fotosGuia", fotosGuia[position]);
                        startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        ;

        return view;
    }
}