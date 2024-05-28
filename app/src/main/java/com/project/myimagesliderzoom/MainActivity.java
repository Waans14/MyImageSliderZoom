package com.project.myimagesliderzoom;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.project.myimagesliderzoom.databinding.ActivityMainBinding;
import com.smarteist.autoimageslider.SliderAnimations;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int images[] = {R.drawable.langkah_aplikasi_1,
            R.drawable.langkah_aplikasi_2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupImageSlider();
    }

    private void setupImageSlider() {
        SlideAdapter adapter = new SlideAdapter(images);

        binding.imageSlider.setSliderAdapter(adapter);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.CLOCK_SPINTRANSFORMATION);
    }
}