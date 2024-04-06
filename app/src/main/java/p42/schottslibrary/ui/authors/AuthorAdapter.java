package p42.schottslibrary.ui.authors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Author;
import p42.schottslibrary.models.Book;
import p42.schottslibrary.ui.books.BookViewHolder;

public class AuthorAdapter extends RecyclerView.Adapter<AuthorViewHolder>{

    private final List<Author> authors;
    public AuthorAdapter(List<Author> auteurs){
        authors=auteurs;
    }

    @NonNull
    @Override
    public AuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.author_view_holder, parent, false);

        return new AuthorViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AuthorViewHolder holder, int position) {
        Author author=authors.get(position);
        holder.getFirstname().setText(author.getFirstname());
        holder.getLastname().setText(author.getLastname());
    }

    @Override
    public int getItemCount() {
        return authors.size();
    }

}
