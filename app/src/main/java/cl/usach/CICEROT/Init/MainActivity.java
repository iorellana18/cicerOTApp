package cl.usach.CICEROT.Init;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
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
