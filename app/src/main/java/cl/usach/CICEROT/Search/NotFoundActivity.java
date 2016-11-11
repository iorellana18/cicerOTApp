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



public class NotFoundActivity extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notfound);

        back = (ImageView)findViewById(R.id.backIcon);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}