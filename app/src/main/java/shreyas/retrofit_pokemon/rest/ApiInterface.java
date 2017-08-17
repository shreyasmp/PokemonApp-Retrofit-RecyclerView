package shreyas.retrofit_pokemon.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import shreyas.retrofit_pokemon.model.PokeMonResponse;
import shreyas.retrofit_pokemon.model.PokemonDetailedResponse;

/**
 * Created by shreyasmp on 8/13/17.
 */

public interface ApiInterface {

    @GET("pokemon/")
    Call<PokeMonResponse> getPokemonList(@Query("limit") int limit);

    @GET("pokemon/{id}/")
    Call<PokemonDetailedResponse> getPokemonDetails(@Path("id") int pokemonID);

}
