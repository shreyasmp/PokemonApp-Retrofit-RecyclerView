package shreyas.retrofit_pokemon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shreyasmp on 8/15/17.
 */

public class PokemonSprites {

    @SerializedName("front_default")
    private String frontDefault;

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    @Override
    public String toString() {
        return ""+ frontDefault;
    }
}
