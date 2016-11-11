package cl.usach.CICEROT.Init;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cl.usach.CICEROT.R;

/**
 * Created by Ian on 29-10-2016.
 */
public class RegistroActivity extends Activity {

    TextView toLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        toLogin = (TextView) findViewById(R.id.RegistroClickeableText);
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
