package cl.usach.CICEROT;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HotsActivity extends Fragment {
    ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_hots, container, false);
        list =(ListView)view.findViewById(R.id.listNotices);

        ArrayAdapter adapter =ArrayAdapter.createFromResource(getActivity(),
                R.array.Noticias, android.R.layout.simple_list_item_1);

        list.setAdapter(adapter);
        return view;
    }
}