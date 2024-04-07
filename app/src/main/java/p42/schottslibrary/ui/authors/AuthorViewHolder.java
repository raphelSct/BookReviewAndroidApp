package p42.schottslibrary.ui.authors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.OnItemClickListener;
import p42.schottslibrary.R;

public class AuthorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private OnItemClickListener clickListener;
    private TextView firstname;
    private TextView lastname;
    public AuthorViewHolder(@NonNull View itemView,OnItemClickListener clickListener) {
        super(itemView);
        firstname=itemView.findViewById(R.id.firstnameTextView);
        lastname=itemView.findViewById(R.id.lastnameTextView);
        this.clickListener=clickListener;
        itemView.setOnClickListener(this);
    }
    public TextView getFirstname(){
        return firstname;
    }
    public TextView getLastname(){ return lastname;}

    @Override
    public void onClick(View view) {
        if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
    }
}
