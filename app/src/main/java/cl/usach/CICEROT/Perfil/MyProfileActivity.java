package cl.usach.CICEROT.Perfil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cl.usach.CICEROT.R;

public class MyProfileActivity extends Fragment {

    TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_miperfil, container, false);

        name = (TextView)view.findViewById(R.id.miNombre);

        name.setText(getActivity().getIntent().getStringExtra("nombre"));

        return view;

    }



}

