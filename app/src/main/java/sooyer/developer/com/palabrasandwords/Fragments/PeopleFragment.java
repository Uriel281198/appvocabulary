package sooyer.developer.com.palabrasandwords.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sooyer.developer.com.palabrasandwords.R;

public class PeopleFragment extends Fragment {


    public PeopleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_people, container, false);
        return v;
    }


}
