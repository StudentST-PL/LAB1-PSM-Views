package com.example.kospekt1views;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kospekt1views.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // View Binding replaces findViewById. The ActivityMainBinding class is
    // generated automatically from the activity_main.xml layout file.
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // The click handler is registered in code, not via the android:onClick attribute
        binding.toggleButton.setOnClickListener(v -> {
            boolean isDataVisible = binding.fullNameTextView.getVisibility() == View.VISIBLE;
            binding.fullNameTextView.setVisibility(isDataVisible ? View.INVISIBLE : View.VISIBLE);
            binding.toggleButton.setText(isDataVisible ? R.string.show_data : R.string.hide_data);
        });
    }
}