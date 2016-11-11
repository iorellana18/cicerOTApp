package cl.usach.CICEROT.Search;

/**
 * Created by Ian on 06-11-2016.
 */

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import cl.usach.CICEROT.R;

public class SearchListFragment extends ListFragment implements OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Lugares, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        if(position==0) {
            Intent intent = new Intent(getActivity(), LugarActivity.class);
            intent.putExtra("palabra", "santiago");
            startActivity(intent);
        }else if(position==1){
            Intent intent = new Intent(getActivity(), LugarActivity.class);
            intent.putExtra("palabra", "miami");
            startActivity(intent);
        }    else if(position==2){
            Intent intent = new Intent(getActivity(), LugarActivity.class);
            intent.putExtra("palabra", "la serena");
            startActivity(intent);
        }
    }
}