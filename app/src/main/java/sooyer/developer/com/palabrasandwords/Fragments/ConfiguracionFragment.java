package sooyer.developer.com.palabrasandwords.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import sooyer.developer.com.palabrasandwords.Activities.HomeActivity;
import sooyer.developer.com.palabrasandwords.Activities.MainActivity;
import sooyer.developer.com.palabrasandwords.R;

import static sooyer.developer.com.palabrasandwords.Common.Common.colorTheme;

public class ConfiguracionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button btn,btnblue,btnverde;

    public ConfiguracionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_configuracion, container, false);

        btn = view.findViewById(R.id.btn_fragment);
        btnblue = view.findViewById(R.id.btn_fragme);
        btnverde = view.findViewById(R.id.btn_fragme2);
        btnblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restarApp(2);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restarApp(1);
            }
        });
        btnverde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restarApp(3);
            }
        });

        return view;
    }

    public void restarApp (int color){
        Intent i = new Intent(getContext(),HomeActivity.class);
        saveData(color);
        i.putExtra("color",color);
        saveData(color);
        startActivity(i);
        getActivity().finish();
    }

    public void saveData(int color){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("color_selected",color);
        editor.commit();
        getActivity().finish();
    }







}
