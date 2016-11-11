package cl.usach.CICEROT.Search;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import cl.usach.CICEROT.Init.RegistroActivity;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 03-11-2016.
 */



public class SearchActivity extends AppCompatActivity {

    ImageView back;
    EditText search;

    String[] ciudades ={
        "Santiago",
        "Miami",
        "La serena"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        back = (ImageView)findViewById(R.id.backIcon);
        search = (EditText)findViewById(R.id.SearchProfile);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        search.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {

                        ///Simula una busqueda
                        if(search.getText().toString().toLowerCase().equals("santiago") || search.getText().toString().toLowerCase().equals("la serena") || search.getText().toString().toLowerCase().equals("miami")) {
                            Intent intent = new Intent(SearchActivity.this, LugarActivity.class);
                            intent.putExtra("palabra", search.getText().toString().toLowerCase());
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(SearchActivity.this,NotFoundActivity.class);
                            startActivity(intent);
                        }

                        return true;
                    }
                return false;
            }
        });
    }
}