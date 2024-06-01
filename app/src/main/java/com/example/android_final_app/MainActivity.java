package com.example.android_final_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.android_final_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Edge-to-edge 설정
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setBottomNavigationView();

        // 앱 초기 실행 시 홈화면으로 설정
        if (savedInstanceState == null) {
            binding.bottomNavigationView.setSelectedItemId(R.id.fragment_home);
        }
    }

    private void setBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.fragment_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
                return true;
            } else if (itemId == R.id.fragment_register) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new RegisterFragment()).commit();
                return true;
            } else if (itemId == R.id.fragment_frequency) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new FrequencyFragment()).commit();
                return true;
            } else if (itemId == R.id.fragment_settings) {
                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new SettingsFragment()).commit();
                return true;
            } else {
                return false;
            }
        });
    }
}