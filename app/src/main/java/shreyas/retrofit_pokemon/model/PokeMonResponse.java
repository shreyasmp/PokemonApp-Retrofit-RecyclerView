package shreyas.retrofit_pokemon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shreyasmp on 8/13/17.
 */

public class PokeMonResponse {

    @SerializedName("count")
    private int count;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<PokeMon> results;

    @SerializedName("next")
    private String next;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokeMon> getResults() {
        return results;
    }

    public void setResults(List<PokeMon> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
