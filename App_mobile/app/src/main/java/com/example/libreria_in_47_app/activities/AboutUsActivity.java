package com.example.libreria_in_47_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.libreria_in_47_app.R;

public class AboutUsActivity extends AppCompatActivity {

    ImageView ivRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        ivRegresar = findViewById(R.id.ivRegresar);
        ivRegresar.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(AboutUsActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        /*VideoView video = findViewById(R.id.video1);

        String video_presentacion = "android:resource://" + getPackageName() + "/" + R.raw.video_book;
        Uri uri = Uri.parse(video_presentacion);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);*/
    }
}