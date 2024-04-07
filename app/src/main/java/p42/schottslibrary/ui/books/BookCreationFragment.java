package p42.schottslibrary.ui.books;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import p42.schottslibrary.R;
import p42.schottslibrary.models.Author;
import p42.schottslibrary.ui.authors.AuthorViewModel;


public class BookCreationFragment extends Fragment {



    public BookCreationFragment() {
        // Required empty public constructor
    }


    public static BookCreationFragment newInstance() {
        return new BookCreationFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_creation, container, false);

        return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       Button submit=view.findViewById(R.id.submitButton);
       BookViewModel bookViewModel=new ViewModelProvider(this).get(BookViewModel.class);

       submit.setOnClickListener(
               new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       EditText title=view.findViewById(R.id.newTitle);
                       EditText id=view.findViewById(R.id.bookAuthor);
                       EditText firstname=view.findViewById(R.id.auhtoFN);
                       EditText lastname=view.findViewById(R.id.authorLN);
                       Author author = new Author(Integer.parseInt(id.getText().toString()),firstname.getText().toString(),lastname.getText().toString());
                       bookViewModel.createBook(author,title.getText().toString()).observe(getViewLifecycleOwner(),book ->{
                           Navigation.findNavController(view).navigate(R.id.navigation_home);
                       });


                   }
               }
       );


    }
}