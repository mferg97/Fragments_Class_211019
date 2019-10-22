package com.example.fragments_class;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements

        FragmentOne.OnFragmentInteractionListener

{

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentOne fragment = FragmentOne.newInstance();
        fragmentTransaction.add(R.id.FragmentOne, fragment);
        fragmentTransaction.commit();
    }
        @Override
        public void onFragmentInteraction (String text, int ColorId){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentTwo fragment = FragmentTwo.newInstance(text, ColorId);
        fragmentTransaction.replace(R.id.FragmentTwo, fragment);
        fragmentTransaction.commit();

    }

}
