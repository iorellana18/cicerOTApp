package cl.usach.CICEROT.Chat;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import cl.usach.CICEROT.Init.Usuario;
import cl.usach.CICEROT.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener,MessageSource.MessagesCallbacks{
private ArrayList<Message> mMessages;
private MessagesAdapter mAdapter;
private String mRecipient;
private ListView mListView;
private Date mLastMessageDate = new Date();
private String mConvoId;
private MessageSource.MessagesListener mListener;
    TextView nombre;
    ImageView imagen;
    Usuario user;
    ImageView backIcon;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainchat);
        mRecipient = "Titulo";
        mListView = (ListView)findViewById(R.id.message_list);
        mMessages = new ArrayList<>();
        mAdapter = new MessagesAdapter(mMessages);
        mListView.setAdapter(mAdapter);
        nombre = (TextView)findViewById(R.id.nombre);
        imagen = (ImageView)findViewById(R.id.iconMailList);
        backIcon = (ImageView)findViewById(R.id.backIcon);

        nombre.setText(getIntent().getStringExtra("nombre"));
        imagen.setImageResource(getIntent().getIntExtra("foto", 0));

    mListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_NORMAL);
    mListView.setStackFromBottom(true);

    backIcon.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });


    setTitle(mRecipient);
        if (getSupportActionBar() != null){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Button sendMessage = (Button)findViewById(R.id.send_message);
        sendMessage.setOnClickListener(this);

        String[] ids = {"Yo","-", nombre.getText().toString()};
        Arrays.sort(ids);
        mConvoId = ids[0]+ids[1]+ids[2];
        mListener = MessageSource.addMessagesListener(mConvoId, this);
        }

public void onClick(View v) {
        EditText newMessageView = (EditText)findViewById(R.id.new_message);
        String newMessage = newMessageView.getText().toString();
        newMessageView.setText("");
        Message msg = new Message();
        msg.setmDate(new Date());
        msg.setMtext(newMessage);
        msg.setmSender("Rohit");
        MessageSource.saveMessage(msg, mConvoId);
        }

@Override
public void onMessageAdded(Message message) {
        mMessages.add(message);
        mAdapter.notifyDataSetChanged();
        }
@Override
protected void onDestroy() {
        super.onDestroy();
        MessageSource.stop(mListener);
        }

private class MessagesAdapter extends ArrayAdapter<Message> {
    MessagesAdapter(ArrayList<Message> messages){
        super(MainActivity.this, R.layout.item, R.id.msg, messages);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = super.getView(position, convertView, parent);
        Message message = getItem(position);
        TextView nameView = (TextView)convertView.findViewById(R.id.msg);
        nameView.setText(message.getMtext());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)nameView.getLayoutParams();
        int sdk = Build.VERSION.SDK_INT;
        if (message.getmSender().equals("Yo")){
            if(message.getMtext().length()<20) {
                nameView.setBackground(getDrawable(R.drawable.chat2));
                nameView.setTextColor(Color.WHITE);
            }else{
                nameView.setBackground(getDrawable(R.drawable.chat2grande));
                nameView.setPadding(70, 20, 50, 50);
                nameView.setTextColor(Color.WHITE);

            }

            layoutParams.gravity = Gravity.LEFT;
        }else{
            if (message.getMtext().length()<20) {
                nameView.setBackground(getDrawable(R.drawable.chat1));
                nameView.setTextColor(Color.BLACK);

            } else{
                nameView.setBackground(getDrawable(R.drawable.chat1grande));
                nameView.setPadding(70, 20, 50, 50);
                nameView.setTextColor(Color.BLACK);
            }
            layoutParams.gravity = Gravity.RIGHT;

        }
        nameView.setLayoutParams(layoutParams);
        return convertView;
    }
}
}