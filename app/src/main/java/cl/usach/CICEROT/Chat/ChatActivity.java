package cl.usach.CICEROT.Chat;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import cl.usach.CICEROT.R;

public class ChatActivity extends Fragment {
    ListView list;
    ChatListAdapter adapter;
    int[] imagenes = {
            R.drawable.ian,
            R.drawable.elitos,
            R.drawable.juan
    };


    String[] nombres = new String[]{
            "Ian Orellana",
            "Elías González",
            "Juan Perez",
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        list =(ListView)view.findViewById(R.id.listContacts);

        adapter = new ChatListAdapter(getContext(), nombres, imagenes);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}