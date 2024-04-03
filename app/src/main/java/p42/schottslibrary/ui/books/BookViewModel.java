package p42.schottslibrary.ui.books;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Book;

public class BookViewModel extends ViewModel {

    private BookRepository repository = new BookRepository();
    private MutableLiveData<List<Book>> books;
    public LiveData<List<Book>> getBooks() {
        if (books == null) {
            books = new MutableLiveData<List<Book>>();
            repository.getAllUsers(books);
        }
        return books;
    }


    public BookViewModel(@NonNull Application application) throws JSONException, IOException {
        books = new MutableLiveData<List<Book>>();


    }

}