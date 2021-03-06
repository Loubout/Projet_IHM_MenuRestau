package com.example.willy.projet_ihm_android.fragment_view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.willy.projet_ihm_android.MainActivity;
import com.example.willy.projet_ihm_android.R;
import com.example.willy.projet_ihm_android.carroussel_view.CarouselView;
import com.example.willy.projet_ihm_android.carroussel_view.ImageListener;

/**
 * Created by Tomohiro on 09/04/16.
 */
public class CarrousselFragment extends PaneFragment {
    MainActivity act ;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.food_accompagnement_item1, R.drawable.food_accompagnement_item2, R.drawable.food_accompagnement_item3, R.drawable.food_dessert_item4, R.drawable.food_dessert_item5};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return getCarrousselView(inflater, container, savedInstanceState);
    }

        /****************
         *  CARROUSSEL  *
         ****************/
    public View getCarrousselView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
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
            final int pos = position;
            act = (MainActivity) getActivity();
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (pos){
                        case 0:

                            act.afficheDesc(getActivity().getResources().getString(R.string.item1_name),
                                    getActivity().getResources().getString(R.string.item1_desc),
                                    getActivity().getResources().getString(R.string.item1_price),
                                    getActivity().getResources().getDrawable(R.drawable.food_accompagnement_item1)
                                    );
                            break;
                        case 1:
                            act.afficheDesc(getActivity().getResources().getString(R.string.item2_name),
                                    getActivity().getResources().getString(R.string.item2_desc),
                                    getActivity().getResources().getString(R.string.item2_price),
                                    getActivity().getResources().getDrawable(R.drawable.food_accompagnement_item2)
                            );
                            break;
                        case 2:
                            act.afficheDesc(getActivity().getResources().getString(R.string.item3_name),
                                    getActivity().getResources().getString(R.string.item3_desc),
                                    getActivity().getResources().getString(R.string.item3_price),
                                    getActivity().getResources().getDrawable(R.drawable.food_accompagnement_item3)
                            );
                            break;
                        case 3:
                            act.afficheDesc(getActivity().getResources().getString(R.string.item4_name),
                                    getActivity().getResources().getString(R.string.item4_desc),
                                    getActivity().getResources().getString(R.string.item4_price),
                                    getActivity().getResources().getDrawable(R.drawable.food_dessert_item4)
                            );
                            break;
                        case 4:
                            act.afficheDesc(getActivity().getResources().getString(R.string.item5_name),
                                    getActivity().getResources().getString(R.string.item5_desc),
                                    getActivity().getResources().getString(R.string.item5_price),
                                    getActivity().getResources().getDrawable(R.drawable.food_dessert_item5)
                            );
                            break;
                    }


                }
            });

        }
    };
}
