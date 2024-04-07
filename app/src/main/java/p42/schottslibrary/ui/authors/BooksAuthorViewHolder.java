package p42.schottslibrary.ui.authors;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.OnItemClickListener;
import p42.schottslibrary.R;

public class BooksAuthorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private OnItemClickListener clickListener;
    private TextView title;

    public BooksAuthorViewHolder(@NonNull View itemView, OnItemClickListener clickListener) {
        super(itemView);
        title=itemView.findViewById(R.id.authBookTitle);
        this.clickListener=clickListener;
        itemView.setOnClickListener(this);

    }
    public TextView getTitle(){
        return title;
    }


    @Override
    public void onClick(View view) {
        if (clickListener != null) clickListener.onClick(view, ((Integer) title.getTag())-1);
    }
}
