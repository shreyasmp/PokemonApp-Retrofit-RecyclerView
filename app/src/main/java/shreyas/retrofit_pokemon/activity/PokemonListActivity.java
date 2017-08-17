package shreyas.retrofit_pokemon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.BuildConfig;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shreyas.retrofit_pokemon.R;
import shreyas.retrofit_pokemon.adapter.PokemonAdapter;
import shreyas.retrofit_pokemon.listener.ItemClickListener;
import shreyas.retrofit_pokemon.model.PokeMon;
import shreyas.retrofit_pokemon.model.PokeMonResponse;
import shreyas.retrofit_pokemon.model.PokemonDetailedResponse;
import shreyas.retrofit_pokemon.model.PokemonSprites;
import shreyas.retrofit_pokemon.model.PokemonTypeNames;
import shreyas.retrofit_pokemon.rest.APIClient;
import shreyas.retrofit_pokemon.rest.ApiInterface;

public class PokemonListActivity extends AppCompatActivity {

    private static final String TAG = PokemonListActivity.class.getSimpleName();

    private static final int LIMIT = 151;

    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.pokemon_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Retrofit-Pokemon");

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.pokemon_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        final ApiInterface apiService =
                APIClient.getClient().create(ApiInterface.class);

        Call<PokeMonResponse> call = apiService.getPokemonList(LIMIT);
        call.enqueue(new Callback<PokeMonResponse>() {
            @Override
            public void onResponse(Call<PokeMonResponse> call, Response<PokeMonResponse> response) {
                final List<PokeMon> pokeMonList = response.body().getResults();
                pokemonAdapter = new PokemonAdapter(pokeMonList, R.layout.list_item_pokemon, getApplicationContext());
                recyclerView.setAdapter(pokemonAdapter);
                pokemonAdapter.setOnItemClickListener(new ItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {

                        Call<PokemonDetailedResponse> detailedResponseCall = apiService.getPokemonDetails(position+1);
                        detailedResponseCall.enqueue(new Callback<PokemonDetailedResponse>() {
                            @Override
                            public void onResponse(Call<PokemonDetailedResponse> call, Response<PokemonDetailedResponse> response) {
                                final int height = response.body().getHeight();
                                final int weight = response.body().getWeight();
                                final PokemonSprites spritesList = response.body().getPokemonSprites();
                                final List<PokemonTypeNames> pokemonTypeNames = response.body().getTypeNames();

                                Intent intent = new Intent(PokemonListActivity.this, PokemonDetailActivity.class);
                                intent.putExtra("POKEMON_HEIGHT", height);
                                intent.putExtra("POKEMON_WEIGHT", weight);
                                intent.putExtra("POKEMON_SPRITE", spritesList.toString());
                                intent.putExtra("POKEMON_TYPES", pokemonTypeNames.toString());
                                intent.putExtra("POKEMON_NAME", pokeMonList.get(position).getName());
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<PokemonDetailedResponse> call, Throwable t) {
                                if(shreyas.retrofit_pokemon.BuildConfig.IS_LOGGING_ENABLED) {
                                    Log.e(TAG, "Error: " + t.toString());
                                }
                            }
                        });
                    }
                });
            }

            @Override
            public void onFailure(Call<PokeMonResponse> call, Throwable t) {
                if(shreyas.retrofit_pokemon.BuildConfig.IS_LOGGING_ENABLED) {
                    Log.e(TAG, "Error: " + t.toString());
                }
            }
        });
    }
}
