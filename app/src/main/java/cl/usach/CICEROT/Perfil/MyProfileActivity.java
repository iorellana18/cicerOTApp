package cl.usach.CICEROT.Perfil;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;

import cl.usach.CICEROT.Init.Test;
import cl.usach.CICEROT.R;

public class MyProfileActivity extends Fragment {

    TextView name;
    TextView editar;
    ImageView imagen;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_miperfil, container, false);


        name = (TextView)view.findViewById(R.id.miNombre);
        editar = (TextView)view.findViewById(R.id.editText);
        imagen = (ImageView)view.findViewById(R.id.miFoto);

        String link = getActivity().getIntent().getStringExtra("link");
        Bitmap bitmap = BitmapFactory.decodeFile(link);
        imagen.setImageBitmap(bitmap);

        name.setText(getActivity().getIntent().getStringExtra("nombre"));
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Test.class);
                intent.putExtra("imagen",getActivity().getIntent().getStringExtra("link"));
                startActivity(intent);
            }
        });

        return view;

    }



}

