package p42.schottslibrary.ui.books;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Book;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{
    private final List<Book> books;
    public BookAdapter(List<Book> livres){
        books=livres;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_view_holder, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book=books.get(position);
        holder.getTitre().setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
