package cl.usach.CICEROT.Tours;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cl.usach.CICEROT.Main.Adapter;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 24-10-2016.
 */
public class CreateTour extends Activity{

Button crear;
ImageView search;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);

        search = (ImageView )findViewById(R.id.backIcon);
        crear = (Button)findViewById(R.id.crearTour);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(CreateTour.this, "Por implementar", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


    }
}
