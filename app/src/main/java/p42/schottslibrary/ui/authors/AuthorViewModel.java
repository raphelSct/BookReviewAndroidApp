package p42.schottslibrary.ui.authors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import p42.schottslibrary.models.Author;
import p42.schottslibrary.models.Book;

public class AuthorViewModel extends AndroidViewModel {

    private AuthorRepository repository = new AuthorRepository(this.getApplication());
    private MutableLiveData<List<Author>> authors;
    private MutableLiveData<List<Book>> books;

    // Constructeur par défaut


    public AuthorViewModel(@NonNull Application application) throws JSONException, IOException {
        super(application);
        authors = new MutableLiveData<List<Author>>();
        books=new MutableLiveData<>();
    }
    public LiveData<List<Author>> getAuthors() {
        repository.getAllAuthors(authors);
        return authors;
    }
    public LiveData<List<Book>> getAllBooks(int authorId) {
        repository.getAllBooks(books,authorId+1);
        return books;
    }

    public LiveData<List<Author>> createAuthor(String firstname, String lastname) {
        repository.createAuthor(firstname,lastname);
        return authors;
    }
}