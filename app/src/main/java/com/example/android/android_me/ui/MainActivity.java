/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.Toast;

import com.example.android.android_me.R;

import static com.example.android.android_me.data.KeyValues.BODY_KEY;
import static com.example.android.android_me.data.KeyValues.BODY_TYPE;
import static com.example.android.android_me.data.KeyValues.HEAD_KEY;
import static com.example.android.android_me.data.KeyValues.HEAD_TYPE;
import static com.example.android.android_me.data.KeyValues.LEGS_KEY;
import static com.example.android.android_me.data.KeyValues.LEGS_TYPE;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{
    private int mHeadIndex;
    private int mBodyIndex;
    private int mLegsIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        switch (position/12) {
            case HEAD_TYPE:
                mHeadIndex = position%12;
                break;

            case BODY_TYPE:
                mBodyIndex = position%12;
                break;

            case LEGS_TYPE:
                mLegsIndex = position%12;
                break;
        }
        // Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle mBundle = new Bundle();
        mBundle.putInt(HEAD_KEY, mHeadIndex);
        mBundle.putInt(BODY_KEY, mBodyIndex);
        mBundle.putInt(LEGS_KEY, mLegsIndex);

        final Intent mIntent = new Intent(this, AndroidMeActivity.class);
        mIntent.putExtras(mBundle);

        // Get a reference to the "Next" button and launch the intent when this button is clicked
        Button mButton = (Button) findViewById(R.id.next_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mIntent);
            }
        });
    }

}
