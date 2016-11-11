package cl.usach.CICEROT.Search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import cl.usach.CICEROT.Hots.HotsListAdapter;
import cl.usach.CICEROT.Ofertas.OfertasActivity;
import cl.usach.CICEROT.R;

/**
 * Created by Ian on 08-11-2016.
 */
public class LugarActivity extends AppCompatActivity {

    ImageView back;
    ListView lista;
    HotsListAdapter adapter;

    int[] imagen1 = {
            R.drawable.stgo
    };
    int[] imagen2 = {
            R.drawable.playa

    };
    int[] imagen3 = {
            R.drawable.montana
    };


    String[] likes = {
            "213 Likes"
    };

    String[] titulo1 = new String[]{
            "Santiago de Noche"
    };

    String[] titulo2 = new String[]{

            "Paseo por la playa",
    };

    String[] titulo3 = new String[]{
            "Sube la montaña"
    };

    String[] precios = new String[]{
            "$51.990"
    };

    String[] guia1 = new String[]{
            "Ian Orellana"
    };
    String[] guia2 = new String[]{
            "Elías González"
    };
    String[] guia3 = new String[]{
            "Juan Perez"
    };


    String[] descripcion1 = new String[]{
            "Una noche llena de sorpresas"
    };

    String[] descripcion2 = new String[]{
            "Relajate este verano 1313"
    };

    String[] descripcion3 = new String[]{
            "Desafía tus miedos"
    };

    int[] fotoGuia1 = {
            R.drawable.ian
    };
    int[] fotoGuia2 = {
            R.drawable.elitos
    };
    int[] fotoGuia3 = {
            R.drawable.juan
    };
    String titulo;
    int imagenes;
    String guias;
    String descripcion;
    int fotoGuia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_busqueda);
        back = (ImageView)findViewById(R.id.backIcon);
        lista = (ListView)findViewById(R.id.list);

        String Titulo = getIntent().getStringExtra("palabra");

        //Utiliza mismo adaptador que hots
        if(Titulo.equals("santiago")) {
            adapter = new HotsListAdapter(LugarActivity.this, titulo1, imagen1, likes, guia1, descripcion1, precios);
            lista.setAdapter(adapter);
            titulo=titulo1[0];
            imagenes=imagen1[0];
            guias=guia1[0];
            descripcion=descripcion1[0];
            fotoGuia=fotoGuia1[0];
        }else if(Titulo.equals("miami")){
            adapter = new HotsListAdapter(LugarActivity.this, titulo2, imagen2, likes, guia2, descripcion2, precios);
            lista.setAdapter(adapter);
            titulo=titulo2[0];
            imagenes=imagen2[0];
            guias=guia2[0];
            descripcion=descripcion2[0];
            fotoGuia=fotoGuia2[0];
        }else if(Titulo.equals("la serena")){
            adapter = new HotsListAdapter(LugarActivity.this, titulo3, imagen3, likes, guia3, descripcion3, precios);
            lista.setAdapter(adapter);
            titulo=titulo3[0];
            imagenes=imagen3[0];
            guias=guia3[0];
            descripcion=descripcion3[0];
            fotoGuia=fotoGuia3[0];
        }
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(LugarActivity.this,OfertasActivity.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("imagen",imagenes);
                intent.putExtra("likes",likes[position]);
                intent.putExtra("guia",guias);
                intent.putExtra("descripcion",descripcion);
                intent.putExtra("precio",precios[position]);
                intent.putExtra("posicion",position);
                intent.putExtra("fotosGuia",fotoGuia);
                startActivity(intent);




            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}