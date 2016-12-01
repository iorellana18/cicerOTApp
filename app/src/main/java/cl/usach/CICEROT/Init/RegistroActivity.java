package cl.usach.CICEROT.Init;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;

import cl.usach.CICEROT.Main.Adapter;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 29-10-2016.
 */
public class RegistroActivity extends Activity {
    private static final Firebase sRef = new Firebase("https://chatito-eff08.firebaseio.com/users");
    TextView toLogin;
    EditText nombre;
    EditText apellido;
    EditText email;
    EditText contraseña;
    EditText confirma;
    Button toMain;


    public static void saveUser(Usuario user){
        HashMap<String, String> msg = new HashMap<>();
        msg.put("nombre", user.getNombre());
        msg.put("apellido", user.getApellido());
        msg.put("correo", user.getCorreo());
        msg.put("contraseña", user.getContraseña());
        sRef.push().setValue(msg);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        toLogin = (TextView) findViewById(R.id.RegistroClickeableText);
        toMain = (Button)findViewById(R.id.RegistroBoton);
        nombre = (EditText) findViewById(R.id.nombreEditText);
        apellido = (EditText) findViewById(R.id.apellidoEditText);
        email = (EditText) findViewById(R.id.RegistroCorreo);
        contraseña = (EditText) findViewById(R.id.RegistroContraseña);
        confirma = (EditText) findViewById(R.id.RegistroConfirmaContraseña);






        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(nombre.getText().toString().matches("") || apellido.getText().toString().matches("") || confirma.getText().toString().matches("") || contraseña.getText().toString().matches("") || email.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Debe rellenar todos los campos", Toast.LENGTH_SHORT).show();
                }else{

                    Usuario user = new Usuario(nombre.getText().toString(),apellido.getText().toString(),email.getText().toString(),contraseña.getText().toString());
                    saveUser(user);
                    Intent intent = new Intent(RegistroActivity.this, Adapter.class);

                    intent.putExtra("nombre",user.getNombre());
                    startActivity(intent);
                }
            }
        });

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
