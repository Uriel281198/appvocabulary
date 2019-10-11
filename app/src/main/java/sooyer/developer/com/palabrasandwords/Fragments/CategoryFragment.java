package sooyer.developer.com.palabrasandwords.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sooyer.developer.com.palabrasandwords.Adapters.CategoryAdapter;
import sooyer.developer.com.palabrasandwords.Models.Category;
import sooyer.developer.com.palabrasandwords.R;



public class CategoryFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Category> categoryAdapterList ;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        categoryAdapterList =  new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerCategory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),1));
        full_list();
        CategoryAdapter adapter = new CategoryAdapter(getActivity(),categoryAdapterList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    public void full_list(){
        categoryAdapterList.add( new Category("My Words",R.drawable.lista, 2,R.drawable.gradientcrojo,R.color.colorRojo));
        categoryAdapterList.add( new Category ("Irregular verbs",R.drawable.irre,101,R.drawable.gradientcazul,R.color.colorAzul));
        categoryAdapterList.add( new Category ("Home",R.drawable.home,24,R.drawable.gradientcmorado,R.color.colorMorado));
        categoryAdapterList.add( new Category ("Dining Room",R.drawable.dinning,18,R.drawable.gradientcverde,R.color.colorVerde));
        categoryAdapterList.add( new Category ("Kitchen",R.drawable.kitchen,35,R.drawable.gradientcrojo,R.color.colorRojo));
        categoryAdapterList.add( new Category ("ADVERBSOFTIME",R.drawable.time,30,R.drawable.gradientcazul,R.color.colorAzul));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
        categoryAdapterList.add( new Category ("CLOTHES",R.drawable.t_shirt,40,R.drawable.gradientcgris,R.color.colorGris));
    }


}
