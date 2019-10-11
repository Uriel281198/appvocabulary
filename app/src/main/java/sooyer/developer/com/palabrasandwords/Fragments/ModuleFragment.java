package sooyer.developer.com.palabrasandwords.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Adapters.ModuleAdapter;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.Models.Module;
import sooyer.developer.com.palabrasandwords.R;

public class ModuleFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Module> listmodule ;
    public ModuleFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_people, container, false);
        listmodule =  new ArrayList<>();
        recyclerView = v.findViewById(R.id.recyclermodule);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        full_list();
        ModuleAdapter adapter = new ModuleAdapter(getActivity(),listmodule);
        recyclerView.setAdapter(adapter);
        return v;
    }
    public void full_list(){
        listmodule.add( new Module ("MODULO 1",R.drawable.gradientcrojo,R.color.colorRojo));
        listmodule.add( new Module ("MODULO 2",R.drawable.gradientcazul,R.color.colorAzul));
        listmodule.add( new Module ("MODULO 3",R.drawable.gradientcmorado,R.color.colorMorado));
        listmodule.add( new Module ("MODULO 4",R.drawable.gradientcverde,R.color.colorVerde));
        listmodule.add( new Module ("MODULO 5",R.drawable.gradientcrojo,R.color.colorRojo));
        listmodule.add( new Module ("MODULO 6",R.drawable.gradientcazul,R.color.colorAzul));
        listmodule.add( new Module ("MODULO 7 ",R.drawable.gradientcgris,R.color.colorGris));
    }


}
