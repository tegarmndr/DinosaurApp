package com.example.tugasprojectuas.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.tugasprojectuas.R;
import com.example.tugasprojectuas.databinding.ActivityCategoryItemBinding;
import com.example.tugasprojectuas.home.HomeCategoryActivity;
import com.example.tugasprojectuas.item.DinosaurDetailActivity;

public class CategoryItemActivity extends AppCompatActivity {

    ActivityCategoryItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String[] dinosaurName = {
                "ALLOSAURUS",
                "APATOSAURUS",
                "ARCHAEOPTERYX",
                "BRACHIOSAURUS",
                "DILOPHOSAURUS",
                "PARASAURLOPHUS",
                "PLESIOSAURUS",
                "PTEROSAUR",
                "SPINOSAURUS",
                "STEGOSAURUS",
                "TRICERATOPS",
                "TYRANNOSAURUS-REX",
                "VELOCIRAPTOR"
        };

        int[] dinosaurImage = {R.drawable.dinosaur_allosaurus, R.drawable.dinosaur_apatosaurus, R.drawable.dinosaur_archaeopteryx, R.drawable.dinosaur_brachiosaurus,
                R.drawable.dinosaur_dilophosaurus, R.drawable.dinosaur_parasaurolophus, R.drawable.dinosaur_plesiosaurus, R.drawable.dinosaur_pterosaur,
                R.drawable.dinosaur_spinosaurus, R.drawable.dinosaur_stegosaurus, R.drawable.dinosaur_triceratops, R.drawable.dinosaur_tryannosaurus_rex, R.drawable.dinosaur_velociraptor};

        String[] dinosaurEatingType = {"Carnivore", "Herbivore", "Omnivore", "Herbivore",
                "Carnivore", "Herbivore", "Herbivore", "Omnivore",
                "Carnivore", "Herbivore", "Herbivore", "Carnivore", "Carnivore"};

        String[] dinosaurDescription = {"This big meat-eater from the Jurassic of North America had a small horn over each eye. The horns may have helped Allosaurus recognize others of its kind.",
                "Lorem",
                "Archaeopteryx is a feathered carnivore from the Jurassic period. Like modern birds, it had feathers and lightweight bones. But like dinosaurs, it had teeth and a long, bony tail.",
                "This dinosaur was an herbivore from the Jurassic. With its head perched on such a long neck, it probably ate leaves high up in the trees.",
                "Lorem",
                "Parasaurolophus was a duck-billed dinosaur that lived during the Cretaceous. It had a large tube-like crest on its head that may have been used for making deep sounds.",
                "Lorem",
                "Lorem",
                "This giant meat-eating dinosaur lived in Africa during the Cretaceous. It had a long snout and tall spines along its back.",
                "This animal had large bony plates on its back. It may have used those plates to warm up on a cold day; or cool down on a hot day.",
                "This dinosaur was an herbivore from the Cretaceous. It used its tough beak to eat low-lying green plants. With hundreds of teeth in its jaws, this animal sliced its food into bite sized chunks.",
                "This dinosaur was a carnivore from the Cretaceous. It ate large dinosaurs, like Triceratops. Some scientists think that Tyrannosaurus rex could eat more than 200 pounds of meat in one bite! That’s bigger than a goat!",
                "Velociraptor was a small, feathered dinosaur that lived during the Cretaceous. It has been found only in Asia and lived in desert habitats with sand dunes."};

        int[] dinosaurSound = {
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
                R.raw.sample,
        };

        String selectedEatingType = getIntent().getStringExtra("EATING_TYPE");

        GridCategoryItemAdapter gridCategoryItemAdapter = new GridCategoryItemAdapter(CategoryItemActivity.this, dinosaurName, dinosaurImage, dinosaurEatingType, selectedEatingType, dinosaurEatingType, dinosaurSound);

        binding.gridViewItem.setAdapter(gridCategoryItemAdapter);


        binding.gridViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedDinosaurName = dinosaurName[position];
                String selectedEatingType = dinosaurEatingType[position];
                String selectedDescription = dinosaurDescription[position];
                int selectedImageResourceId = dinosaurImage[position];
                int selectedDinosaurSound = dinosaurSound[position];

                Intent intent = new Intent(CategoryItemActivity.this, DinosaurDetailActivity.class);
                intent.putExtra("DINOSAUR_NAME", selectedDinosaurName);
                intent.putExtra("EATING_TYPE", selectedEatingType);
                intent.putExtra("DESCRIPTION", selectedDescription);
                intent.putExtra("IMAGE_RESOURCE", selectedImageResourceId);
                intent.putExtra("DINOSAUR_SOUND", selectedDinosaurSound);
                startActivity(intent);
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryItemActivity.this, HomeCategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
