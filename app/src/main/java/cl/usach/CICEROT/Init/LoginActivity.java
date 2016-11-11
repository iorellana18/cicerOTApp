package cl.usach.CICEROT.Init;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cl.usach.CICEROT.Main.Adapter;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 24-10-2016.
 */
public class LoginActivity extends Activity{

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
                Intent intent = new Intent(LoginActivity.this, Adapter.class);

                intent.putExtra("nombre",Name.getText().toString());
                startActivity(intent);
            }
        });
    }
}
