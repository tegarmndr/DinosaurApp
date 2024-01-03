package com.example.tugasprojectuas.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.tugasprojectuas.category.CategoryItemActivity;
import com.example.tugasprojectuas.R;
import com.example.tugasprojectuas.databinding.ActivityHomeCategoryBinding;

public class HomeCategoryActivity extends AppCompatActivity {

    ActivityHomeCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] categoryName = {"ALL CATEGORY", "HERBIVORE",
                                "CARNIVORE", "OMNIVORE"};
        int[] categoryImage = {R.drawable.ornament_bone10, R.drawable.category_herbivore,
                                R.drawable.category_carnivore, R.drawable.category_omnivore};

        GridHomeCategoryAdapter gridHomeCategoryAdapter = new GridHomeCategoryAdapter(HomeCategoryActivity.this, categoryName, categoryImage);

        binding.gridViewItem.setAdapter(gridHomeCategoryAdapter);

        binding.gridViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categoryName[position];

                String selectedEatingType = getEatingTypeForCategory(selectedCategory);

                // Kirim jenis pemakan sebagai extra ke CategoryItemActivity
                Intent intent = new Intent(HomeCategoryActivity.this, CategoryItemActivity.class);
                intent.putExtra("EATING_TYPE", selectedEatingType);
                startActivity(intent);
                finish();
            }
        });
    }
    private String getEatingTypeForCategory(String category) {
        // Anda dapat mengganti ini sesuai dengan logika atau pemetaan kategori ke jenis pemakan yang sesuai
        if (category.equals("Herbivore")) {
            return "Herbivore";
        } else if (category.equals("Carnivore")) {
            return "Carnivore";
        } else if (category.equals("Omnivore")) {
            return "Omnivore";
        } else {
            // Kategori lainnya atau default
            return "All"; // Atau jenis pemakan lain yang sesuai
        }
    }
}