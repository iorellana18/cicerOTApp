package cl.usach.CICEROT.Init;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

import cl.usach.CICEROT.Main.Adapter;
import cl.usach.CICEROT.Perfil.trueOrFalse;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 24-10-2016.
 */

public class MainActivity extends Activity {

    Button registroBoton;
    Button loginBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        registroBoton = (Button) findViewById(R.id.WelcomeRegistro);
        loginBoton = (Button) findViewById(R.id.WelcomeLogin);

        loginBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageRef = storage.getReferenceFromUrl("gs://chatito-eff08.appspot.com").child("ian.jpg");

                try {
                    final File localFile = File.createTempFile("images", "jpg");
                    storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                            System.out.println(localFile.getAbsolutePath());
                           // imagen.setImageBitmap(bitmap);
                            Intent intent = new Intent(MainActivity.this, Adapter.class);
                            intent.putExtra("link",localFile.getAbsolutePath());
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception exception) {
                        }
                    });
                } catch (IOException e ) {
                    System.out.println(e);
                }

            }
        });

        registroBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

    }

}
