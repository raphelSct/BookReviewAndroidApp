package p42.schottslibrary.ui.authors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Author;
import p42.schottslibrary.ui.books.BookAdapter;
import p42.schottslibrary.ui.books.BookViewModel;

public class AuthorFragment extends Fragment {

    private AuthorAdapter authorAdapter;

    private RecyclerView recyclerView;
    private AuthorViewModel authorViewModel ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_author, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView= getView().findViewById(R.id.authorRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        authorViewModel = new ViewModelProvider(this).get(AuthorViewModel.class);
        authorViewModel.getAuthors().observe(getViewLifecycleOwner(),authors->
                {
                    authorAdapter = new AuthorAdapter(authors);
                    // Set adapter to RecyclerView
                    recyclerView.setAdapter(authorAdapter);
                }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}