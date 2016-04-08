package com.example.willy.projet_ihm_android.fragment_view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.carroussel_view.CarouselView;
import com.example.willy.projet_ihm_android.carroussel_view.ImageListener;

/**
 * Created by Tomohiro on 22/03/16.
 */
public class MainPaneFragment extends Fragment implements AdapterView.OnClickListener {


    CarouselView carouselView;

    int[] sampleImages = {R.drawable.carousel_test_1, R.drawable.carousel_test_2, R.drawable.carousel_test_3, R.drawable.carousel_test_4, R.drawable.carousel_test_5};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_sample_carousel_view, container, false);

        carouselView = (CarouselView)view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        return view;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };


    @Override
    public void onClick(View view) {
        //Ici, la position récupérée est celle fournie par la méthode getItem de notre classe MyAdapter
        Toast.makeText(getActivity(), "MainPaneClick ", Toast.LENGTH_SHORT).show();
    }
}