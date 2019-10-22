package com.example.fragments_class;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


public class FragmentOne extends Fragment {


  private EditText editText;
  private ImageView ViewCircle;
  private int ColorId = android.R.color.black;
  private OnFragmentInteractionListener mListener;
  private Button copyText;


    public FragmentOne() {

    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    private void changeColor() {
        ViewCircle.setColorFilter(ContextCompat.getColor(getContext(), ColorId));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment_one, container, false);

        editText = rootView.findViewById(R.id.editText);
        copyText = rootView.findViewById(R.id.copyText);
        ViewCircle = rootView.findViewById(R.id.ViewCircle);


        copyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(ColorId);
            }
        });

        Button colorOne = rootView.findViewById(R.id.colorOne);
        Button colorTwo = rootView.findViewById(R.id.colorTwo);

        colorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorId = android.R.color.holo_blue_dark;
                changeColor();
            }
        });

        colorTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorId = android.R.color.holo_red_dark;
                changeColor();
            }
        });

        return rootView;
    }

    private void onButtonPressed(int ColorId) {
        if (mListener != null) {
            mListener.onFragmentInteraction(editText.getText().toString(), ColorId);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String text, int ColorId);
    }
}
