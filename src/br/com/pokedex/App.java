package br.com.pokedex;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.pokedex.network.HTTPRequest;

public class App {
    public static void main(String[] args) throws Exception {

        JSONObject object = new HTTPRequest()
                .requestGetMethod("https://pokeapi.co/api/v2/pokemon?limit=151");

        // int count = object.getInt("count");
        // String next = object.getString("next");
        JSONArray array = object.getJSONArray("results");

        for (int index = 0; index < array.length(); index++) {

            JSONObject pokeObject = array.getJSONObject(index);

            String pokeNome = pokeObject.getString("name");
            String pokeUrl = pokeObject.getString("url");
            System.out.println(pokeNome + " - " + pokeUrl);
        }

    }
}
