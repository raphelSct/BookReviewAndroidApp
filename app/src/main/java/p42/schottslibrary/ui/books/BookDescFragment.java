package p42.schottslibrary.ui.books;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import p42.schottslibrary.R;

public class BookDescFragment extends Fragment {

    private BookViewModel bookViewModel;
    private int mPosition;

    public static BookDescFragment newInstance() {
        return new BookDescFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_desc, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        TextView title=view.findViewById(R.id.title);
        TextView author=view.findViewById(R.id.auhtor);
        TextView tags=view.findViewById(R.id.tags);
        TextView comments=view.findViewById(R.id.comments);
        TextView rating=view.findViewById(R.id.rating);

        /*bookViewModel.getOneBook(mPosition).observe(getViewLifecycleOwner(),book -> {
            Log.d("book",book.toString());
            title.setText("oui");
            author.setText(book.getAuthor());
            tags.setText(book.getSeries());
            comments.setText(book.getQuote());
            rating.setText("non");
        });*/
    }

    public void setPosition(int position) {
        mPosition = position;
    }
}