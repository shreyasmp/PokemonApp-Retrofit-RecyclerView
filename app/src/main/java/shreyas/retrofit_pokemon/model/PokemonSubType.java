package shreyas.retrofit_pokemon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shreyasmp on 8/16/17.
 */

public class PokemonSubType {

    @SerializedName("name")
    private String name;

    @Override
    public String toString() {
        return ""+ name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
