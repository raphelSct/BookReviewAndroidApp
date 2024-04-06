package p42.schottslibrary.ui.authors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.R;

public class AuthorViewHolder extends RecyclerView.ViewHolder{
    private TextView firstname;
    private TextView lastname;
    public AuthorViewHolder(@NonNull View itemView) {
        super(itemView);
        firstname=itemView.findViewById(R.id.firstnameTextView);
        lastname=itemView.findViewById(R.id.lastnameTextView);
    }
    public TextView getFirstname(){
        return firstname;
    }
    public TextView getLastname(){ return lastname;}
}
