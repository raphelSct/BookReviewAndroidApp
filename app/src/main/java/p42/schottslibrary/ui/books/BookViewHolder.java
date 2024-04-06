package p42.schottslibrary.ui.books;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.OnItemClickListener;
import p42.schottslibrary.R;


public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private OnItemClickListener clickListener;

    TextView titre;
    public BookViewHolder(@NonNull View itemView,OnItemClickListener clickListener) {
        super(itemView);
        titre=itemView.findViewById(R.id.tit);
        this.clickListener=clickListener;
    }

    public TextView getTitre(){
        return titre;
    }


    @Override
    public void onClick(View v) {
        if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
    }
}
