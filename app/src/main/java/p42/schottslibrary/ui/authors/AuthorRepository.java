package p42.schottslibrary.ui.authors;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
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
    private final RequestQueue requestQueue;

    public AuthorRepository(Context context) {
        this.requestQueue = MyRequestQueue.getInstance(context).getRequestQueue();
    }

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
                        Log.d("RepositoryAth", "Authors List: " + authorsList.size()); // Ajout du journal pour la liste d'auteurs
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

        requestQueue.add(jsonArrayRequest);
        Log.d("Repository", "Request: " + jsonArrayRequest.toString()); // Ajout du journal pour la demande envoyée

    }

    public void getAllBooks(MutableLiveData<List<Book>> foundBooks, int authorId) {
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                apiURL + "authors/"+authorId+"/books",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<Book> booksList = new ArrayList<>();
                        Log.d("Repository", apiURL + "authors/"+authorId+"/books");
                        Log.d("Repository", response.toString());
                        try {
                            JSONArray arr=response.getJSONArray("book");

                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject livreUnique = arr.getJSONObject(i);
                                int id = livreUnique.getInt("id");
                                String title = livreUnique.getString("title");



                                Book book = new Book(id, title);
                                booksList.add(book);
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        Log.d("Repository", booksList.toString());
                        foundBooks.setValue(booksList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getAllBooks", "Volley error: " + error.getMessage());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);
    }

    public void createAuthor(String firstname, String lastname) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("firstname", firstname);
            jsonObject.put("lastname", lastname);
        } catch (Exception e){
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                apiURL + "authors",
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        System.out.println("Author created");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        System.out.println("Error creating author"+jsonObject);
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);
    }
}

