package com.example.libreria_in_47_app.interfaces;

public interface IBook {
    String getIsbn();
    String getTitle();
    String getSubtitle();
    String getDescription();
    String getComments();
    int getAuthorId();
    int getLanguageId();
    int getFormatId();
    int getEditorialId();
    int getCategoryId();
}
