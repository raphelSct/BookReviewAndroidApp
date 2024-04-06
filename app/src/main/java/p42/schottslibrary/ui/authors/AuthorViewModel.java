package p42.schottslibrary.ui.authors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import p42.schottslibrary.models.Author;

public class AuthorViewModel extends ViewModel {

    private AuthorRepository repository = new AuthorRepository();
    private MutableLiveData<List<Author>> authors;

    // Constructeur par défaut
    public AuthorViewModel() {
    }
    public LiveData<List<Author>> getAuthors() {
        if (authors == null) {
            authors = new MutableLiveData<List<Author>>();
            repository.getAllAuthors(authors);
        }
        return authors;
    }


    public AuthorViewModel(@NonNull Application application) throws JSONException, IOException {
        authors = new MutableLiveData<List<Author>>();
    }
}