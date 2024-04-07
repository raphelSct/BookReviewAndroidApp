package p42.schottslibrary.ui.authors;

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
import p42.schottslibrary.ui.books.BookViewModel;


public class AuthorCreationFragment extends Fragment {



    public AuthorCreationFragment() {
        // Required empty public constructor
    }
    public static AuthorCreationFragment newInstance() {
        return new AuthorCreationFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_author_creation, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button submit=view.findViewById(R.id.addAuthorButton);
        AuthorViewModel authorViewModel=new ViewModelProvider(this).get(AuthorViewModel.class);

        submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText firstname=view.findViewById(R.id.firstnameAuth);
                        EditText lastname=view.findViewById(R.id.lastnameAuth);
                        authorViewModel.createAuthor(firstname.getText().toString(),lastname.getText().toString()).observe(getViewLifecycleOwner(),book ->{
                            Navigation.findNavController(view).navigate(R.id.navigation_dashboard);
                        });


                    }
                }
        );


    }
}