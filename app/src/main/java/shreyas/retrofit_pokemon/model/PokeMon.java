package shreyas.retrofit_pokemon.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shreyasmp on 8/13/17.
 */

public class PokeMon {

    @SerializedName("url")
    private String url;


    @SerializedName("name")
    private String name;

    public PokeMon(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
