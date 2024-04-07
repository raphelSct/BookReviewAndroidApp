package p42.schottslibrary.ui.books;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import p42.schottslibrary.MainActivity;
import p42.schottslibrary.MyRequestQueue;
import p42.schottslibrary.OnItemClickListener;
import p42.schottslibrary.R;
import p42.schottslibrary.models.Book;

public class BookFragment extends Fragment implements OnItemClickListener {
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
                    bAdapter.setClickListener(this);
                }
        );
        FloatingActionButton fab = view.findViewById(R.id.fabBook);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ajouter le fragment "BookCreateFragment"
                Navigation.findNavController(view).navigate(R.id.bookCreationFragment);

            }
        });
    }

        @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View view, int position) {
        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        navController.navigate(R.id.bookDescFragment, bundle);

    }
}