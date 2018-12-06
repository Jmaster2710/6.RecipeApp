package com.example.joel_.recipeapp2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * A placeholder fragment containing a simple view.
 */
public class FoodFragment extends Fragment {
    private static final String ARG_DATA = "data";

    private Recipe mData;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static FoodFragment newInstance(Recipe recipe) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();

        args.putParcelable(ARG_DATA, recipe);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mData = getArguments().getParcelable(ARG_DATA);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        TextView textView = rootView.findViewById(R.id.food_image);
        ImageView imageView = rootView.findViewById(R.id.food_image);
        textView.setText(mData.getTitle());

        Log.i("testing",mData.getImageUrl());
        // byte[] imgByte = getArguments().getByteArray("FOOD_IMAGE");
        //  Bitmap b = BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        //  imageView.setImageBitmap( b );
        Glide.with(this)
                .load(mData.getImageUrl())
                .into(imageView);

        return rootView;
    }
}
