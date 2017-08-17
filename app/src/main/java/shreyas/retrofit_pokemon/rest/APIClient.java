package shreyas.retrofit_pokemon.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shreyasmp on 8/13/17.
 */

public class APIClient {

    private static final String TAG = APIClient.class.getSimpleName();
    private static String pokemonURL = "http://pokeapi.co/api/v2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                        .baseUrl(pokemonURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }
        return  retrofit;
    }

}
