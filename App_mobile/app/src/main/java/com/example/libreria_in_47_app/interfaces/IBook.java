package com.example.libreria_in_47_app.interfaces;

public interface IBook {
    int getId();
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
    float getScore();
    int getNumberScores();
}
