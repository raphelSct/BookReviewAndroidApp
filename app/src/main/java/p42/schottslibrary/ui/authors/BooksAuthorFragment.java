package p42.schottslibrary.ui.authors;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import p42.schottslibrary.OnItemClickListener;
import p42.schottslibrary.R;
import p42.schottslibrary.models.Comment;
import p42.schottslibrary.models.Rating;
import p42.schottslibrary.models.Tag;
import p42.schottslibrary.ui.books.BookDescFragment;
import p42.schottslibrary.ui.books.BookViewModel;


public class BooksAuthorFragment extends Fragment implements OnItemClickListener {

    private AuthorViewModel authorViewModel;
    private int mPosition;
    private BooksAuthorAdapter bAdapter;
    private RecyclerView recyclerView;

    public static BooksAuthorFragment newInstance(){
        return new BooksAuthorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_books_from_author, container, false);
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

        authorViewModel = new ViewModelProvider(this).get(AuthorViewModel.class);
        recyclerView=view.findViewById(R.id.booksAuthorsRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));

        authorViewModel.getAllBooks(mPosition).observe(getViewLifecycleOwner(),books -> {

            Log.d("book",books.toString());
            bAdapter=new BooksAuthorAdapter(books);
            recyclerView.setAdapter(bAdapter);
            bAdapter.setClickListener(this);
        });
    }
    @Override
    public void onClick(View view, int position) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        navController.navigate(R.id.bookDescFragment, bundle);

    }
}