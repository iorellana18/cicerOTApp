package cl.usach.CICEROT.Ofertas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cl.usach.CICEROT.R;
import cl.usach.CICEROT.Search.SearchActivity;

/**
 * Created by Ian on 08-11-2016.
 */
public class OfertasActivity extends AppCompatActivity {

    ImageView back;
    TextView searchBar;
    ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofertas);
        back = (ImageView)findViewById(R.id.backIcon);
        searchBar = (TextView)findViewById(R.id.SearchProfile);
        add = (ImageView)findViewById(R.id.plusIcon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OfertasActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(OfertasActivity.this, "Contacto guardado",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}