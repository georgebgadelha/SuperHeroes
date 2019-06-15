package com.example.superheroes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.superheroes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentHome extends Fragment {

    View homeFabView;
    private Context context;

    public FragmentHome(final Context context) {
        this.context = context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FloatingActionButton homeFab = view.findViewById(R.id.home_fab);
        homeFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "TESTING FAB WITH TOAST", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}