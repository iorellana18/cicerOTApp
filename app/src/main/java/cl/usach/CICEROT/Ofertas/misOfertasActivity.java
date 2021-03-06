package cl.usach.CICEROT.Ofertas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cl.usach.CICEROT.R;
import cl.usach.CICEROT.Search.SearchActivity;

/**
 * Created by Ian on 08-11-2016.
 */
public class misOfertasActivity extends AppCompatActivity {

    ImageView back;
    TextView searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_misofertas);
        back = (ImageView)findViewById(R.id.backIcon);
        searchBar = (TextView)findViewById(R.id.SearchProfile);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(misOfertasActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}