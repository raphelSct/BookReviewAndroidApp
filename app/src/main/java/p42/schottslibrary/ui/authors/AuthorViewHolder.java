package p42.schottslibrary.ui.authors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AuthorViewHolder extends RecyclerView.ViewHolder{
    private TextView firstname;
    private TextView lastname;
    public AuthorViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public TextView getFirstname(){
        return firstname;
    }
    public TextView getLastname(){ return lastname;}
}
