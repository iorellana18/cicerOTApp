package cl.usach.CICEROT.Init;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import java.util.HashMap;

import cl.usach.CICEROT.Main.Adapter;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 24-10-2016.
 */
public class LoginActivity extends Activity{

    private static final Firebase sRef = new Firebase("https://chatito-eff08.firebaseio.com");
 /*   public static void findUser(Usuario user){
        HashMap<String, String> msg = new HashMap<>();
        msg.put("nombre", user.getNombre());
        msg.put("apellido", user.getApellido());
        msg.put("correo", user.getCorreo());
        msg.put("contraseña", user.getContraseña());
        sRef.push().setValue(msg);

        sRef.orderByChild('age').startAt(25).on('child_added',...)
    }
*/
    TextView toRegistro;
    Button Login;
    EditText Name;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toRegistro = (TextView) findViewById(R.id.LoginClickeableText);
        Login = (Button) findViewById(R.id.LoginButton);
        Name = (EditText) findViewById(R.id.EmailText);

        toRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase ref = new Firebase("https://chatito-eff08.firebaseio.com/users");


                ref.addValueEventListener(new ValueEventListener() {
                    private String snap;
                    public void setSnap(String snap){
                        this.snap=snap;
                    }
                    public String getSnap(){
                        return snap;
                    }
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        boolean flag=false;
                        Usuario user=new Usuario();
                        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                            user = postSnapshot.getValue(Usuario.class);
                            if(user.getCorreo().matches(Name.getText().toString())) {
                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            ProgressDialog.show(LoginActivity.this, "Cargando perfil", "Por favor, espere un momento...");
                            FirebaseStorage storage = FirebaseStorage.getInstance();
                            StorageReference storageRef = storage.getReferenceFromUrl("gs://chatito-eff08.appspot.com").child("perfil/"+user.getNombre().toLowerCase()+".jpg");
                            final String nombre = user.getNombre();
                            try {
                                final File localFile = File.createTempFile("images", "jpg");
                                storageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                    @Override
                                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                                        System.out.println(localFile.getAbsolutePath());
                                        // imagen.setImageBitmap(bitmap);
                                        Intent intent = new Intent(LoginActivity.this, Adapter.class);
                                        intent.putExtra("link",localFile.getAbsolutePath());
                                        intent.putExtra("nombre", nombre);
                                        startActivity(intent);
                                        finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception exception) {
                                    }
                                });
                            } catch (IOException e ) {
                                System.out.println(e);
                            }




                        }else{
                            Toast.makeText(getApplicationContext(),"Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });

                //Intent intent = new Intent(LoginActivity.this, Adapter.class);
               // Toast.makeText(getApplicationContext(),de, Toast.LENGTH_SHORT).show();
                //intent.putExtra("nombre",Name.getText().toString());
                //startActivity(intent);
            }
        });
    }
}
