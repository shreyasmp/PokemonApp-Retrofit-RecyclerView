package shreyas.retrofit_pokemon.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import shreyas.retrofit_pokemon.R;

/**
 * Created by shreyasmp on 8/14/17.
 */

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.pokemon_detailed_toolbar);
        setSupportActionBar(toolbar);

        final Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material, null);
        upArrow.setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("POKEMON_NAME"));


        final ImageView pokemonFrontSprite = (ImageView) findViewById(R.id.pokemon_front_sprite);
        Picasso.with(this).load(intent.getExtras().getString("POKEMON_SPRITE")).into(pokemonFrontSprite);

        final TextView pokemonHeight = (TextView) findViewById(R.id.pokemon_height);
        pokemonHeight.setText("Height: "+String.valueOf(intent.getExtras().getInt("POKEMON_HEIGHT")));

        final TextView pokemonWeight = (TextView) findViewById(R.id.pokemon_weight);
        pokemonWeight.setText("Weight: "+String.valueOf(intent.getExtras().getInt("POKEMON_WEIGHT")));

        final TextView pokemonTypes = (TextView) findViewById(R.id.pokemon_types);
        pokemonTypes.setText("Types: "+ intent.getExtras().getString("POKEMON_TYPES"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
