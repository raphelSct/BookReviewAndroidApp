package p42.schottslibrary.ui.books;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import p42.schottslibrary.R;

public class BookViewHolder extends RecyclerView.ViewHolder {

    TextView titre;
    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        titre=itemView.findViewById(R.id.tit);
    }

    public TextView getTitre(){
        return titre;
    }


}
