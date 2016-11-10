package cl.usach.CICEROT.Ofertas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import cl.usach.CICEROT.Perfil.PerfilActivity;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 08-11-2016.
 */
public class OfertasFragment extends Fragment  {

    TextView titulo;
    ImageView imagen;
    TextView guia;
    TextView likes;
    TextView precio;
    TextView descripcion;
    TextView tomado;
    ImageView imagenGuia;
    TextView nombreGuia;
    public static final int Default_value=0;

    String[] veces = {
            "Tomado 13 veces",
            "Tomado 24 veces",
            "Tomado 6 veces"
    };

    String[] longDescripcion = new String[]{
            "Una noche llena de sorpresas, disfruta de los mejores restaurantes y locales nocturnos, fdghsfhfivcncfhfhjsadfasdvfasvfasvs",
            "Relajate este verano 1313, ",
            "Desafía tus miedos"
    };

    int[] fotosGuia = {
            R.drawable.ian,
            R.drawable.elitos,
            R.drawable.ic_person_black_48dp
    };

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_oferta, container, false);

        imagen = (ImageView)view.findViewById(R.id.photoOferta);
        titulo = (TextView)view.findViewById(R.id.TituloOferta);
        precio = (TextView)view.findViewById(R.id.PrecioOferta);
        likes = (TextView)view.findViewById(R.id.LikesOferta);
        tomado = (TextView)view.findViewById(R.id.VecesOferta);
        descripcion = (TextView)view.findViewById(R.id.DescripcionOferta);
        imagenGuia = (ImageView)view.findViewById(R.id.PerfilOferta);
        nombreGuia = (TextView)view.findViewById(R.id.nombreGuiaOferta);

        String title = getActivity().getIntent().getStringExtra("titulo");
        int image = getActivity().getIntent().getIntExtra("imagen", Default_value);
        final String megusta = getActivity().getIntent().getStringExtra("likes");
        String price = getActivity().getIntent().getStringExtra("precio");
        String description = getActivity().getIntent().getStringExtra("descripcion");
        final int position = getActivity().getIntent().getIntExtra("posicion", 0);
        final String guide = getActivity().getIntent().getStringExtra("guia");

        imagen.setImageResource(image);
        titulo.setText(title);
        precio.setText(price);
        likes.setText(megusta);
        tomado.setText(veces[position]);
        descripcion.setText(longDescripcion[position]);
        imagenGuia.setImageResource(fotosGuia[position]);
        nombreGuia.setText(guide);

        nombreGuia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PerfilActivity.class);
                intent.putExtra("foto",fotosGuia[position]);
                intent.putExtra("nombre",guide);
                intent.putExtra("posicion",position);
                intent.putExtra("like",megusta);
                startActivity(intent);
            }
        });
        return view;
    }


}