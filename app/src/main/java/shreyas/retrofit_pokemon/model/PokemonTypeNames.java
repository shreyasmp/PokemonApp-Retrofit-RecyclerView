package shreyas.retrofit_pokemon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shreyasmp on 8/15/17.
 */

public class PokemonTypeNames {


    @SerializedName("type")
    private PokemonSubType pokemonSubType;

    public PokemonSubType getPokemonSubType() {
        return pokemonSubType;
    }

    public void setPokemonSubType(PokemonSubType pokemonSubType) {
        this.pokemonSubType = pokemonSubType;
    }

    @Override
    public String toString() {
        return ""+pokemonSubType;
    }
}
