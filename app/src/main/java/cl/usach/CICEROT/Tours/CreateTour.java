package cl.usach.CICEROT.Tours;


import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.client.Firebase;

import java.util.HashMap;

import cl.usach.CICEROT.EDA.tours;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 24-10-2016.
 */
public class CreateTour extends Activity {

    Button siguiente;
    Button examinar;
    ImageView Img;
    EditText titulo;
    EditText precio;
    EditText descripcion;
    private static final int SELECT_PICTURE = 100;
    private static final Firebase sRef = new Firebase("https://chatito-eff08.firebaseio.com/tours");
    private static final Firebase asocia = new Firebase("https://chatito-eff08.firebaseio.com/asocia");
    ImageView back;
    private int numTours=0;
    private boolean fotoSubida = false;
    private String tituloFoto="";

    public static void asocia(String titulo, String nombre){
        HashMap<String, String> msg = new HashMap<>();
        msg.put("titulo", titulo);
        msg.put("nombre", nombre);
        asocia.push().setValue(msg);
    }




    public void setTituloFoto(String tituloFoto){
        this.tituloFoto=tituloFoto;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tour);

        back = (ImageView )findViewById(R.id.backIcon);
        siguiente = (Button)findViewById(R.id.crearTour);
        //Img = (ImageView)findViewById(R.id.paisaje);
        titulo = (EditText)findViewById(R.id.nombreEditText);
        precio = (EditText)findViewById(R.id.Precio);
        descripcion = (EditText)findViewById(R.id.Descripcion);
       // examinar = (Button)findViewById(R.id.examinar);

        final String nombre = getIntent().getStringExtra("nombre");



        setTituloFoto(titulo.getText().toString());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       // examinar.setOnClickListener(this);


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titulo.getText().toString() != null && precio.getText().toString() != null && descripcion.getText().toString() != null ) {
                    //tours tour = new tours(titulo.getText().toString(), precio.getText().toString(), descripcion.getText().toString(), nombre.toLowerCase());
                    //saveTour(tour);
                    // asocia(titulo.getText().toString(),nombre); //asocia usuario con tour
                    Intent intent = new Intent(CreateTour.this,ImageTour.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("titulo",titulo.getText().toString());
                    intent.putExtra("precio",precio.getText().toString());
                    intent.putExtra("descripcion",descripcion.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });


    }





}
