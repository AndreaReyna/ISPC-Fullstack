package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.libreria_in_47_app.DataBaseSQLiteHelper;
import com.example.libreria_in_47_app.R;
import com.example.libreria_in_47_app.models.AuthorClass;
import com.example.libreria_in_47_app.models.BookClass;
import com.example.libreria_in_47_app.models.CategoryClass;

import java.util.List;

public class BookDetail extends AppCompatActivity {
    ImageView ivRegresar;
    TextView textTitle;
    TextView bookSubtitle;
    TextView bookAuthor;
    TextView bookPrice;
    TextView bookISBN;
    TextView bookIsbn;
    TextView bookCategorie;
    TextView bookDescriptionTitle;
    TextView textDescription;
    TextView bookSpecificationTitle;
    TextView bookEditorialTitle;
    TextView bookEditorial;
    TextView bookFormatTitle;
    TextView bookFormat;
    TextView bookLanguageTitle;
    TextView bookLanguage;

    Button btnBookAddWish;

    DataBaseSQLiteHelper dbHelper;
    BookClass book;

    List<Integer> booksIdsInWishlist;

    long loggedUserId;
    long wishlistId;

    RatingBar bookRatingBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        dbHelper = new DataBaseSQLiteHelper(this);
        //estan todos los bind completos
        textTitle = findViewById(R.id.textTitle);
        bookSubtitle = findViewById(R.id.bookSubtitle);
        bookAuthor = findViewById(R.id.bookAuthor);
        bookISBN = findViewById(R.id.bookISBN);
        bookIsbn = findViewById(R.id.bookIsbn);
        bookCategorie = findViewById(R.id.bookCategorie);
        bookDescriptionTitle = findViewById(R.id.bookDescriptionTitle);
        bookSpecificationTitle = findViewById(R.id.bookSpecificationTitle);
        bookEditorialTitle = findViewById(R.id.bookEditorialTitle);
        bookEditorial = findViewById(R.id.bookEditorial);
        bookFormatTitle = findViewById(R.id.bookFormatTitle);
        bookFormat = findViewById(R.id.bookFormat);
        bookLanguageTitle = findViewById(R.id.bookLanguageTitle);
        bookLanguage = findViewById(R.id.bookLanguage);
        textDescription = findViewById(R.id.textDescription);
        btnBookAddWish = findViewById(R.id.bookAddWish);
        bookRatingBar = findViewById(R.id.bookScore);

        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BookDetail.this, MainActivity.class);
                startActivity(i);
            }
        });
        // traer usuario
        loggedUserId = dbHelper.getLoggedUserId(this);
        // traer libros de wishlist de usuario
        booksIdsInWishlist = dbHelper.getBookIdsInWishlist(loggedUserId);
        // traer id de wishlist de usuario logeado
        wishlistId = dbHelper.getWishlist(loggedUserId);


        // Recuperar el ID del libro de la Intent
        int bookId = getIntent().getIntExtra("book_id", -1); // -1 es un valor predeterminado en caso de que no se encuentre el ID

        if (bookId != -1) {

            book = dbHelper.getBookById(bookId);

            // Traer id del autor.
            int autorId = book.getAuthorId();

            // Obtener el autor.
            AuthorClass autor = dbHelper.getAuthorById(autorId);

            // Traer id de la categoría.
            int categoriaId = book.getCategoryId();

            // Obtener el categoría.
            CategoryClass categoria = dbHelper.getCategoryById(categoriaId);

            // Actualizar las vistas con los detalles del libro
            textTitle.setText(book.getTitle());
            bookSubtitle.setText(book.getSubtitle());
            bookAuthor.setText(autor.getFullName());
            bookIsbn.setText(book.getIsbn());
            bookCategorie.setText(categoria.getType());
            textDescription.setText(book.getDescription());
            //bookEditorial.setText(book.getEditorialId()); falta traer la editorial
            //bookFormat.setText(book.getFormatId());       falta traer el formato
            //bookLanguage.setText(book.getLanguageId());     falta traer el lenguaje

            // Agregar book a wishlist.
            btnBookAddWish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // traer usuario
                    // traer wishlist de usuario
                    // chequear que el libro no este en la wishlist
                    if (!booksIdsInWishlist.contains(bookId)) {
                        // agregar libro
                        dbHelper.addToWishlist(wishlistId, bookId);
                    }
                }
            });


            bookRatingBar.setRating(book.getScore());

            bookRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    if (fromUser) {
                        dbHelper.rateBook(book.getId(), rating);
                    }
                }
            });

        } else {
            // Manejar el caso en el que no se haya encontrado el ID del libro
            Toast.makeText(this, "Libro no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
}
