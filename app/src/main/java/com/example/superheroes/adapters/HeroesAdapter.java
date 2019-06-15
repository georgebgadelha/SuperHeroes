package com.example.superheroes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.superheroes.R;
import com.example.superheroes.model.Hero;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.NotaViewHolder> {

    private final List<Hero> heroes;
    private final Context context;
    private OnItemClickListener onItemClickListener;

    public HeroesAdapter(Context context, List<Hero> heroes) {
        this.heroes = heroes;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public HeroesAdapter.NotaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View createdView = LayoutInflater.from(context).inflate(R.layout.item_superhero, viewGroup, false);
        return new NotaViewHolder(createdView);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.NotaViewHolder viewHolder, int position) {
        Hero hero = heroes.get(position);
        viewHolder.attach(hero);
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
        notifyDataSetChanged();
    }

    class NotaViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        //        private final TextView description;
        private final ImageView image;
        private Hero hero;

        NotaViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.superheroes_item_title);
            image = itemView.findViewById(R.id.superheroes_item_image);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onItemClickListener.onItemClick(hero);
//                }
//            });
        }

        void attach(Hero hero) {
            this.hero = hero;
            fillFields(hero);
        }

        private void fillFields(Hero hero) {
            title.setText(hero.getName());
//            description.setText(hero.getDescription());
            Picasso.get().load(hero.getImagemUrl()).into(image);
        }
    }
}