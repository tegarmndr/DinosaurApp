package com.example.tugasprojectuas.item;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.media.MediaPlayer;
import android.widget.Toast;


import com.example.tugasprojectuas.R;
import com.example.tugasprojectuas.category.CategoryItemActivity;
import com.example.tugasprojectuas.databinding.ActivityDinosaurDetailBinding;

public class DinosaurDetailActivity extends AppCompatActivity {

    ActivityDinosaurDetailBinding binding;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDinosaurDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String dinosaurName = getIntent().getStringExtra("DINOSAUR_NAME");
        String eatingType = getIntent().getStringExtra("EATING_TYPE");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int imageResourceId = getIntent().getIntExtra("IMAGE_RESOURCE", R.drawable.dinosaur_allosaurus);
        int dinosaurSound = getIntent().getIntExtra("DINOSAUR_SOUND", R.raw.sample);
        mediaPlayer = MediaPlayer.create(this, dinosaurSound);


        binding.imageDinosaur.setImageResource(imageResourceId);
        binding.textViewNameFill.setText(dinosaurName);
        binding.textViewEatingTypeFill.setText(eatingType);
        binding.textViewAboutFill.setText(description);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DinosaurDetailActivity.this, CategoryItemActivity.class);
                startActivity(intent);
                finish();
            }
        });

        binding.buttonPlaySound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop(); // Menghentikan pemutaran audio jika sedang berjalan
                        mediaPlayer.release();
                    } else {
                        mediaPlayer.start(); // Memulai pemutaran suara jika belum dimulai
                    }
                } else {
                    // Tampilkan Toast jika suara tidak tersedia
                    Toast.makeText(DinosaurDetailActivity.this, "Suara tidak tersedia", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}