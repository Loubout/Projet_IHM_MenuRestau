package com.example.willy.projet_ihm_android.carroussel_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.willy.projet_ihm_android.R;

/**
 * Created by Willy on 06/04/2016.
 */
public class SampleCarouselViewActivity extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.carousel_test_1, R.drawable.carousel_test_2, R.drawable.carousel_test_3, R.drawable.carousel_test_4, R.drawable.carousel_test_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_carousel_view);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}