package p42.schottslibrary.ui.authors;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import p42.schottslibrary.models.Author;

public class AuthorViewModel extends AndroidViewModel {

    private AuthorRepository repository = new AuthorRepository();
    private MutableLiveData<List<Author>> authors;

    // Constructeur par défaut

    public LiveData<List<Author>> getAuthors() {
        repository.getAllAuthors(authors);
        return authors;
    }


    public AuthorViewModel(@NonNull Application application) throws JSONException, IOException {
        super(application);
        authors = new MutableLiveData<List<Author>>();
    }
}