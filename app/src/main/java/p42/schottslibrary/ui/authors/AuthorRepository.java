package p42.schottslibrary.ui.authors;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import p42.schottslibrary.MyRequestQueue;
import p42.schottslibrary.models.Author;
import p42.schottslibrary.models.Book;

public class AuthorRepository {
    private final String apiURL = "http://10.0.2.2:3000/";

    public void getAllAuthors(MutableLiveData<List<Author>> foundAuthors) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                apiURL + "authors",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Author> authorsList = new ArrayList<>();
                        Log.d("Repository", "Response: " + response.toString()); // Ajout du journal pour la réponse reçue
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject author = response.getJSONObject(i);
                                int id = author.getInt("id");
                                String firstname = author.getString("firstname");
                                String lastname = author.getString("lastname");
                                Author _author = new Author(id, firstname, lastname);
                                authorsList.add(_author);
                            }
                        } catch (JSONException e) {
                            Log.e("Repository", "JSONException: " + e.getMessage()); // Ajout du journal pour les exceptions JSON
                            throw new RuntimeException(e);
                        }
                        Log.d("Repository", "Authors List: " + authorsList.toString()); // Ajout du journal pour la liste d'auteurs
                        foundAuthors.setValue(authorsList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("Error getAllAuthors() : " + error.getMessage());
                    }
                }
        );

        MyRequestQueue.getInstance().add(jsonArrayRequest);
        Log.d("Repository", "Request: " + jsonArrayRequest.toString()); // Ajout du journal pour la demande envoyée

    }
}
