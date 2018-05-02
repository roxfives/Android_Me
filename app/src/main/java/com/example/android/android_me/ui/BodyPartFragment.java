package com.example.android.android_me.ui;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {

    /* Mandatory constructor */
    public BodyPartFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        boolean attatchToRoot = false; //Whether or not the view should be attatched
        View mRootView = (View) inflater.inflate(R.layout.fragment_body_part, container, attatchToRoot);

        ImageView mImageView = (ImageView) mRootView.findViewById(R.id.body_part_img);
        mImageView.setImageResource(AndroidImageAssets.getHeads().get(0)); //Sets the image resourse as the fisrt of the list for the heads

        return mRootView;
    }
}
