package com.example.libreria_in_47_app.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.AuthorClass;
import com.example.libreria_in_47_app.models.BookClass;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<BookClass> data;
    private Context context;

    private OnItemClickListener enviarLibro;

    private OnRatingChangeListener onRatingChangeListener;

    DataBaseSQLiteHelper dbHelper;

    public interface OnItemClickListener {
        void enviarLibro(BookClass book);
    }

    public interface OnRatingChangeListener {
        void onRatingChange(int bookId, float rating);
    }


    public BookAdapter(Context context, List<BookClass> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Instanciar un objeto de la clase DataBaseSQLiteHelper.
        dbHelper = new DataBaseSQLiteHelper(this.context);

        final BookClass book = data.get(position);

        // Traer id del autor.
        int autorId = book.getAuthorId();

        // Obtener el autor.
        AuthorClass autor = dbHelper.getAuthorById(autorId);

        holder.textTitle.setText(book.getTitle());
        holder.textDescription.setText(book.getDescription());
        holder.ratingBook.setRating(book.getScore());
        holder.textAutor.setText(autor.getFullName());

        // Listener para RatingBar
        holder.ratingBook.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser && onRatingChangeListener != null) {
                    onRatingChangeListener.onRatingChange(book.getId(), rating);
                }
            }
        });

        // Obtener la referencia al ImageView de la tapa del libro.
        ImageView bookCoverImageView = holder.itemView.findViewById(R.id.imageView4);

        // Configurar el OnClickListener en la tapa del libro.
        bookCoverImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enviarLibro != null) {
                    enviarLibro.enviarLibro(book);
                }
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        enviarLibro = listener;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener listener) {
        this.onRatingChangeListener = listener;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDescription;
        RatingBar ratingBook;

        TextView textAutor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            ratingBook = itemView.findViewById(R.id.ratingBook);
            textAutor = itemView.findViewById(R.id.textAutor);
        }
    }
}
