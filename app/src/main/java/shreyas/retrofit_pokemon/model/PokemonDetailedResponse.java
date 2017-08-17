package shreyas.retrofit_pokemon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shreyasmp on 8/15/17.
 */

public class PokemonDetailedResponse {

    @SerializedName("name")
    private String name;

    @SerializedName("weight")
    private int weight;

    @SerializedName("height")
    private int height;

    @SerializedName("id")
    private int pokemonID;

    @SerializedName("sprites")
    private PokemonSprites pokemonSprites;

    @SerializedName("types")
    List<PokemonTypeNames> typeNames;

    public int getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public PokemonSprites getPokemonSprites() {
        return pokemonSprites;
    }

    public void setPokemonSprites(PokemonSprites pokemonSprites) {
        this.pokemonSprites = pokemonSprites;
    }

    public List<PokemonTypeNames> getTypeNames() {
        return typeNames;
    }

    public void setTypeNames(List<PokemonTypeNames> typeNames) {
        this.typeNames = typeNames;
    }

}
