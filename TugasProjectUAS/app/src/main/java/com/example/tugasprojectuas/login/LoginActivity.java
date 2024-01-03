package com.example.tugasprojectuas.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugasprojectuas.home.HomeCategoryActivity;
import com.example.tugasprojectuas.databinding.ActivityLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize Firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        binding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loginUser() {
        String email = binding.columnEmail.getText().toString().trim();
        String password = binding.columnPassword.getText().toString().trim();

        // Validasi email dan password
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Email dan password harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Membaca data dari Firebase Realtime Database
        databaseReference.child("user").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        // Dapatkan nilai email dan password dari Firebase
                        String userEmail = userSnapshot.child("email").getValue(String.class);
                        String userPassword = userSnapshot.child("password").getValue(String.class);

                        // Bandingkan nilai email dan password
                        if (email.equals(userEmail) && password.equals(userPassword)) {
                            // Email dan password cocok, user berhasil login
                            Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();

                            // Navigasi ke halaman beranda setelah login berhasil
                            Intent intent = new Intent(LoginActivity.this, HomeCategoryActivity.class);
                            startActivity(intent);
                            finish();
                            return;
                        }
                    }
                    // Email atau password tidak cocok
                    Toast.makeText(LoginActivity.this, "Email atau password salah", Toast.LENGTH_SHORT).show();
                } else {
                    // Tidak ada user di database
                    Toast.makeText(LoginActivity.this, "User tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Tangani kesalahan pembacaan data
                Toast.makeText(LoginActivity.this, "Gagal membaca data", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
