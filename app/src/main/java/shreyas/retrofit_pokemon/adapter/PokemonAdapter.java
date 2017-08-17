package shreyas.retrofit_pokemon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import shreyas.retrofit_pokemon.R;
import shreyas.retrofit_pokemon.listener.ItemClickListener;
import shreyas.retrofit_pokemon.model.PokeMon;

/**
 * Created by shreyasmp on 8/13/17.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private static final String TAG = PokemonAdapter.class.getSimpleName();

    private List<PokeMon> pokemons;
    private  int rowLayout;
    private Context context;
    private ItemClickListener itemClickListener;

    public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout pokemonListLayout;
        TextView pokemonName;

        public PokemonViewHolder(View v) {
            super(v);
            pokemonListLayout = (LinearLayout) v.findViewById(R.id.pokemon_layout);
            pokemonName = (TextView) v.findViewById(R.id.pokemon_name);
            pokemonName.setTag(pokemonName);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }

    public PokemonAdapter(List<PokeMon> pokemons, int rowLayout, Context context){
        this.pokemons = pokemons;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, final int position) {
        holder.pokemonName.setText(pokemons.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void setOnItemClickListener(final ItemClickListener
                                       itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
