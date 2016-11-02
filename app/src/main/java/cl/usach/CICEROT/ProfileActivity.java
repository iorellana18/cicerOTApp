package cl.usach.CICEROT;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Ian on 01-11-2016.
 */
public class ProfileActivity extends Activity {

    TextView Nombre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Nombre = (TextView) findViewById(R.id.ProfileName);

        String getNombre = getIntent().getStringExtra("nombre");

        Nombre.setText(getNombre);

    }
}
