package p42.schottslibrary.ui.authors;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import p42.schottslibrary.OnItemClickListener;
import p42.schottslibrary.R;
import p42.schottslibrary.models.Author;
import p42.schottslibrary.models.Book;

public class BooksAuthorAdapter extends RecyclerView.Adapter<BooksAuthorViewHolder>{
    private final List<Book> books;
    private OnItemClickListener clickListener;


    public BooksAuthorAdapter(List<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BooksAuthorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.books_author_view_holder, parent, false);

        return new BooksAuthorViewHolder(view,clickListener);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BooksAuthorViewHolder holder, int position) {
        Book book=this.books.get(position);
        holder.getTitle().setText(book.getTitle());
        holder.getTitle().setTag(book.getId());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setClickListener(OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}
