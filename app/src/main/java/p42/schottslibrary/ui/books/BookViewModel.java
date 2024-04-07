package p42.schottslibrary.ui.books;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Author;
import p42.schottslibrary.models.Book;

public class BookViewModel extends AndroidViewModel {

    private BookRepository repository = new BookRepository(this.getApplication());
    private MutableLiveData<List<Book>> books = new MutableLiveData<>();
    private MutableLiveData<Book> book = new MutableLiveData<>();

    public BookViewModel(@NonNull Application application) throws JSONException, IOException {
        super(application);
        books = new MutableLiveData<List<Book>>();
        book = new MutableLiveData<Book>();

    }

    public MutableLiveData<List<Book>> getBooks() {
        repository.getAllBooks(books);
        return books;
    }
    public MutableLiveData<Book> getOneBook(int bookId) {
        repository.getOneBook(book,bookId+1);
        return book;
    }
    public MutableLiveData<Book> createBook(Author author, String title) {

        repository.createBook(author.getId(),title);
        return book;
    }

}