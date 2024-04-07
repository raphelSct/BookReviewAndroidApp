package p42.schottslibrary.ui.books;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Comment;
import p42.schottslibrary.models.Rating;
import p42.schottslibrary.models.Tag;

public class BookDescFragment extends Fragment {

    private BookViewModel bookViewModel;
    private int mPosition;

    public static BookDescFragment newInstance() {
        return new BookDescFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_book_desc, container, false);
        Bundle args = getArguments();
        if (args != null) {
            // Récupérer la position depuis les arguments
            mPosition = args.getInt("position", 0); // Utilisez une valeur par défaut si la position n'est pas présente
        }


        return view;

    }

    @SuppressLint("SetTextI18n")
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        TextView title=view.findViewById(R.id.title);
        TextView author=view.findViewById(R.id.auhtor);
        TextView tags=view.findViewById(R.id.tags);
        TextView comments=view.findViewById(R.id.comments);
        TextView rating=view.findViewById(R.id.rating);

        bookViewModel.getOneBook(mPosition).observe(getViewLifecycleOwner(),book -> {

            Log.d("book",book.toString());

            title.setText(book.getTitle());
            author.setText(book.getAuthor().getFirstname()+" "+book.getAuthor().getLastname());

            List<Tag> temptags=book.getTags();
            StringBuilder dumpstr= new StringBuilder();
            for(int i=0;i<temptags.size();i++){
                dumpstr.append(temptags.get(i).getName()).append(" ");
            }
            tags.setText(dumpstr);

            List<Comment> tempcomments=book.getComments();
            dumpstr=new StringBuilder();
            for(int i=0;i<tempcomments.size();i++){
                dumpstr.append(tempcomments.get(i).getContent()).append(" ");
            }
            comments.setText(dumpstr);

            List<Rating> temprates=book.getRatings();
            dumpstr= new StringBuilder();
            for(int i=0;i<temprates.size();i++){
                dumpstr.append(temprates.get(i).getValue()).append(" ");
            }
            rating.setText(dumpstr);
        });
    }

}