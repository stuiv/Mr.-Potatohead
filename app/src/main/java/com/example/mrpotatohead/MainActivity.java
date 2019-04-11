/*
*   Robert Houten
*   Mr-Potatohead
*
*   In this program you can dress Mr-Potatohead
*   */

package com.example.mrpotatohead;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static int[] Images = {R.id.arms, R.id.eyes, R.id.eyebrows, R.id.ears, R.id.glasses,
                            R.id.hat, R.id.mouth, R.id.mustache, R.id.nose, R.id.shoes};

    static int[] checkboxes = {R.id.Arms_box, R.id.Eyes_box, R.id.Eyebrows_box, R.id.Ears_box,
                                 R.id.Glasses_box, R.id.Hat_box, R.id.Mouth_box, R.id.Mustache_box,
                                 R.id.Nose_box, R.id.Shoes_box};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            return;
        }

        for (int ID : Images) {
            if (savedInstanceState.containsKey(Integer.toString(ID))) {
                findViewById(ID).setVisibility(savedInstanceState.getInt(Integer.toString(ID)));
            }
        }
    }

    /*Iterate over the bodyparts and load there visibility state.*/
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState); // always call super

        for (int ID : Images) {
            outState.putInt(Integer.toString(ID),
                            findViewById(ID).getVisibility());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        for (int ID : Images) {
            if (savedInstanceState.containsKey(Integer.toString(ID))) {
                findViewById(ID).setVisibility(savedInstanceState.getInt(Integer.toString(ID)));
            }
        }
    }

/* This function makes everything invisible again and resets the Checkboxes*/
    public void ButtonOnClick(View v) {

        for (int Box : checkboxes) {
            ImageChecker(Box).setVisibility(View.INVISIBLE);
            final CheckBox checkBox = (CheckBox) findViewById(Box);
            checkBox.setChecked(false);
        }
    }


/*  This functions checks if a checkbox is clicked
*   and changes the visibility status*/
    public void checkClicked(View v) {

        CheckBox checkbox = (CheckBox) v;
        int checkboxID = checkbox.getId();
        Boolean check = checkbox.isChecked();

        if (check) {
            ImageChecker(checkboxID).setVisibility(View.VISIBLE);
        } else {
            ImageChecker(checkboxID).setVisibility(View.INVISIBLE);
        }
    }

// Switch functions that returns the bodypart to checkClicked
    private ImageView ImageChecker(int checkboxID) {
        switch (checkboxID) {
            case R.id.Arms_box:
                return findViewById(R.id.arms);
            case R.id.Mustache_box:
                return findViewById(R.id.mustache);
            case R.id.Eyes_box:
                return findViewById(R.id.eyes);
            case R.id.Nose_box:
                return findViewById(R.id.nose);
            case R.id.Glasses_box:
                return findViewById(R.id.glasses);
            case R.id.Hat_box:
                return findViewById(R.id.hat);
            case R.id.Ears_box:
                return findViewById(R.id.ears);
            case R.id.Eyebrows_box:
                return findViewById(R.id.eyebrows);
            case R.id.Mouth_box:
                return findViewById(R.id.mouth);
            default:
                return findViewById(R.id.shoes);
        }
    }
}
