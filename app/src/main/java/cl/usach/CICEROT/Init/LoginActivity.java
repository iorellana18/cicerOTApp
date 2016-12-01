package cl.usach.CICEROT.Init;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

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

                // Get a reference to our posts
                Firebase ref = new Firebase("https://chatito-eff08.firebaseio.com/users");

                // Attach an listener to read the data at our posts reference

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
                            Intent intent = new Intent(LoginActivity.this, Adapter.class);
                            intent.putExtra("nombre",user.getNombre());
                            startActivity(intent);
                            finish();
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
