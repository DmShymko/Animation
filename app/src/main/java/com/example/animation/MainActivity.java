package com.example.animation;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    boolean showTom = true;
    ImageView tomImageView;
    ImageView jerryImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tomImageView = findViewById(R.id.tomCatImage);
        jerryImageView = findViewById(R.id.jerryMouseImage);

    }

    public void animateImageDisappearance(ImageView imageView){
        imageView.animate().alpha(0)
                .rotation(imageView.getRotation() + 3600)
                .scaleX(0.0F)
                .scaleY(0.0F)
                .setDuration(3000);
    }
    public void animateImageAppearance(ImageView imageView){
        imageView.animate().alpha(1)
                .rotation(imageView.getRotation() + 3600)
                .scaleX(1F)
                .scaleY(1F)
                .setDuration(3000);
    }

    public void eraseTom(View view) {
        if (showTom) {
            animateImageDisappearance(tomImageView);
            animateImageAppearance(jerryImageView);
            showTom = false;
        } else {
            animateImageAppearance(tomImageView);
            animateImageDisappearance(jerryImageView);
            showTom = true;
        }
    }
}