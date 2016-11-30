package cl.usach.CICEROT.Chat;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Ian on 29-11-2016.
 */
public class ChatLife extends Application {
    private static final String TAG = "ChatLife";

    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
