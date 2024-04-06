package p42.schottslibrary.ui.books;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import p42.schottslibrary.MyRequestQueue;
import p42.schottslibrary.models.Book;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;


public class BookRepository {
    private final String apiURL = "http://10.0.2.2:3000/";
    private final RequestQueue requestQueue;
    public BookRepository(Context context) {
        requestQueue = MyRequestQueue.getInstance(context).getRequestQueue();
    }

    public void getAllBooks(MutableLiveData<List<Book>> foundBooks) {
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                apiURL + "books",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        List<Book> booksList = new ArrayList<>();
                        Log.d("Repository", response.toString());
                        try {
                            JSONArray arr=response.getJSONArray("books");

                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject livreUnique = arr.getJSONObject(i);
                                int id = livreUnique.getInt("id");
                                String title = livreUnique.getString("title");
                                int authorId = livreUnique.getInt("authorId");


                                Book book = new Book(id, title, authorId);
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

    public void getOneBook(MutableLiveData<Book> foundBook,int bookId) {
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                apiURL + "books/"+bookId,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d("Repository", response.toString());
                        try {
                            JSONArray arr=response.getJSONArray("books");

                            for (int i = 0; i < arr.length(); i++) {
                                JSONObject livreUnique = arr.getJSONObject(i);
                                int id = livreUnique.getInt("id");
                                String title = livreUnique.getString("title");
                                int authorId = livreUnique.getInt("authorId");


                                Book book = new Book(id, title, authorId);
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
}
