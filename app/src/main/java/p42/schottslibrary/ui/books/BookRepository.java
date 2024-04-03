package p42.schottslibrary.ui.books;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;


import p42.schottslibrary.MyRequestQueue;
import p42.schottslibrary.models.Book;

import com.android.volley.toolbox.JsonObjectRequest;

import java.util.ArrayList;
import java.util.List;


public class BookRepository {
    private final String apiURL = "https://monserveur.org/api/";
    public void getAllUsers( MutableLiveData<List<Book>> foundUsers ) {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(apiURL + "...",
                books -> {
                    List<Book> userList = new ArrayList<>();
                    // On ajoute tous les utilisateurs du JsonObject users dans userList puis...
                    foundUsers.setValue(userList);
                },
                error -> { Log.d("getAllUsers", "Volley error");}
        );
        MyRequestQueue.getInstance().add(jsonRequest);
    }

}
