package cl.usach.CICEROT.Perfil;

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
public class PerfilActivity extends AppCompatActivity {

    ImageView back;
    TextView searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        back = (ImageView)findViewById(R.id.backIconPerfil);
        searchBar = (TextView)findViewById(R.id.SearchPerfil);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}