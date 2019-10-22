package com.example.fragments_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class FragmentTwo extends Fragment {

    private ImageView Pastelito;
    private TextView textView;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private int mParam2;

    public FragmentTwo() {
        // Required empty public constructor
    }


    public static FragmentTwo newInstance(String param1, int param2) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        textView = rootView.findViewById(R.id.textView);
        Pastelito = rootView.findViewById(R.id.Pastelito);
        Pastelito.setColorFilter(ContextCompat.getColor(getContext(), mParam2));
        textView.setText(mParam1);
        return rootView;

    }

}



