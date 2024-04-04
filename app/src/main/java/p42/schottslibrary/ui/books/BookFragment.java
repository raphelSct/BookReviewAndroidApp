package p42.schottslibrary.ui.books;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.MainActivity;
import p42.schottslibrary.MyRequestQueue;
import p42.schottslibrary.R;
import p42.schottslibrary.models.Book;

public class BookFragment extends Fragment {
    private BookAdapter bAdapter;

    private RecyclerView recyclerView;
    private BookViewModel bookViewModel ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        recyclerView=view.findViewById(R.id.bookRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        // recyclerView.setAdapter(new BookAdapter(null));
        bookViewModel.getBooks().observe(getViewLifecycleOwner(),books->
                {
                    Log.d("books",books.toString());

                    bAdapter = new BookAdapter(books);
                    // Set adapter to RecyclerView
                    recyclerView.setAdapter(bAdapter);
                }
        );
    }

        @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}