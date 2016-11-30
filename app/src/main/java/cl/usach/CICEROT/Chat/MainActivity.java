package cl.usach.CICEROT.Chat;


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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import cl.usach.CICEROT.R;

public class MainActivity extends ActionBarActivity implements View.OnClickListener,MessageSource.MessagesCallbacks{
public static final String USER_EXTRA = "USER";
public static final String TAG = "ChatActivity";
private ArrayList<Message> mMessages;
private MessagesAdapter mAdapter;
private String mRecipient;
private ListView mListView;
private Date mLastMessageDate = new Date();
private String mConvoId;
private MessageSource.MessagesListener mListener;

    ImageView iv;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainchat);
        mRecipient = "Rohit";
        mListView = (ListView)findViewById(R.id.message_list);
        mMessages = new ArrayList<>();
        mAdapter = new MessagesAdapter(mMessages);
        mListView.setAdapter(mAdapter);

        setTitle(mRecipient);
        if (getSupportActionBar() != null){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Button sendMessage = (Button)findViewById(R.id.send_message);
        sendMessage.setOnClickListener(this);
        String[] ids = {"Barun","-", "Rohit"};
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
        if (message.getmSender().equals("Barun")){
            if (sdk >= Build.VERSION_CODES.BASE) {
                nameView.setBackground(getDrawable(R.color.colorPrimaryDark));
//                iv.setImageResource(R.drawable.ian);
            } else{
                nameView.setBackgroundDrawable(getDrawable(R.drawable.blue_mail));
            }
            layoutParams.gravity = Gravity.RIGHT;
        }else{
            if (sdk >= Build.VERSION_CODES.BASE) {
                nameView.setBackground(getDrawable(R.drawable.ic_chat_black_48dp));

            } else{
                nameView.setBackgroundDrawable(getDrawable(R.drawable.blue_folder));
            }
            layoutParams.gravity = Gravity.LEFT;

        }
        nameView.setLayoutParams(layoutParams);
        return convertView;
    }
}
}