package com.example.superheroes.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superheroes.R;
import com.example.superheroes.adapters.HeroesAdapter;
import com.example.superheroes.dao.HeroDAO;
import com.example.superheroes.model.Hero;

import java.util.List;

public class FragmentSuperheroes extends Fragment {

    private HeroDAO heroDAO = new HeroDAO();
    private Context context;

    public FragmentSuperheroes(Context context) {
        super();
        this.context = context;
        heroDAO.insere(new Hero("Superman", "SupermanDescription", "https://cdn.shopify.com/s/files/1/0257/6087/products/296407e150e67bb62292b71a1f6c3bff.png?v=1557444711"),
                new Hero("Wonderwoman", "WonderwomanDescription", "https://cdn.shopify.com/s/files/1/0257/6087/products/51e3ca99cb6e5ab5f40dfd43b35d90f8.png?v=1557444716"),
                new Hero("Flash", "FlashDescription", "https://cdn.shopify.com/s/files/1/0008/1274/4765/products/FlashIcon_Art_Master_front_Single_Front_f8ea4007-b0e3-4086-9cb7-b9e866e893d6.png?v=1552641882"));

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_superheroes, container, false);
        RecyclerView heroesList = view.findViewById(R.id.superheroes_recycler_view);
        heroesList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        List<Hero> allHeroes = heroDAO.todos();
        heroesList.setAdapter(new HeroesAdapter(context, allHeroes));

        return view;
    }
}