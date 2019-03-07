package com.example.android.android_me.ui;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

//created a class called BodyPartFragment..TODO#1
public class BodyPartFragment extends Fragment {
   private int displayIndex;
   private List<Integer> imageIds;
   private String partType;
    ImageView fragmentPartImageView;

    //Empty constructor
    public BodyPartFragment() {}

    //setter method

    //created onCreateView
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_body_part, container, false);
        //set reference to image view from xml id
        fragmentPartImageView=view.findViewById(R.id.fragment_image);
        //set to first head in list
        if (imageIds!=null)
            fragmentPartImageView.setImageDrawable(getResources().getDrawable(imageIds.get(displayIndex)));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), partType, Toast.LENGTH_SHORT).show();
                displayChange();
                fragmentPartImageView.setImageDrawable(getResources().getDrawable(imageIds.get(displayIndex)));

            }

        });
        return view;

    }

    public void setImageIds(List<Integer> imageIds) {
        this.imageIds = imageIds;
    }
    //setter method
    public void setPartType(String partType) {
        this.partType = partType;
    }
    //setter method
    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;fa

    }

    public void displayChange(){
        displayIndex=displayIndex+1;
        if(displayIndex>=imageIds.size()){
            displayIndex=0;

        }

    }
}
