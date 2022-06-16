package br.com.pokedex;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.pokedex.network.HTTPRequest;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        JSONObject object = new HTTPRequest().requestGetMethod("https://pokeapi.co/api/v2/pokemon?limit=151");

        int count = object.getInt("count");
        System.out.println("Total: " + count);

        JSONArray listPokemonData = object.getJSONArray("results");
        for (int index = 0; index < listPokemonData.length(); index++) {
            JSONObject pokemonData = listPokemonData.getJSONObject(index);

            String name = pokemonData.getString("name");
            String url = pokemonData.getString("url");
            System.out.println(index + " - " + name + " - " + url);
        }
    }
}
