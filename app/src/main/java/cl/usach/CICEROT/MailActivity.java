package cl.usach.CICEROT;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MailActivity extends Fragment {
    ListView list;
    MailListAdapter adapter;
    int[] imagenes = {
            R.mipmap.ic_person_black_48dp,
            R.mipmap.ic_person_black_48dp,
            R.mipmap.ic_person_black_48dp
    };


    String[] nombres = new String[]{
            "Ian Orellana",
            "Elías González",
            "Guía Asesino777",
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mail, container, false);
        list =(ListView)view.findViewById(R.id.listContacts);

        adapter = new MailListAdapter(getContext(), nombres, imagenes);
        list.setAdapter(adapter);
        return view;
    }
}