package com.example.libreria_in_47_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_inicio);
        bottomNavigationView.setOnItemSelectedListener(item -> {
           if (item.getItemId() == R.id.bottom_inicio) {
               return true;
           } else if (item.getItemId() == R.id.bottom_deseos) {
               startActivity(new Intent(getApplicationContext(), BookDetail.class));
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
               finish();
               return true;
           } else if (item.getItemId() == R.id.bottom_compartir) {
               startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
               finish();
               return true;
           } else if (item.getItemId() == R.id.bottom_perfil) {
               startActivity(new Intent(getApplicationContext(), AboutUsActivity.class));
               overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
               finish();
               return true;
           }
           return false;
        });
   }
}