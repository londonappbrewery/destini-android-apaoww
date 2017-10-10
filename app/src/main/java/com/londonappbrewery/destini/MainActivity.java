package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mTextViewStory;
    Button mButtonTop;
    Button mButtonBottom;

    int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mTextViewStory = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        if(savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("scoreKey");
            Log.d("Destini", "Stored Index : "+mStoryIndex);

        } else {
            mStoryIndex = 1;
        }
        // Resume state condition
        if (mStoryIndex == 1 || mStoryIndex == 2) {
            mTextViewStory.setText(getString(R.string.T3_Story));
            mButtonTop.setText(getString(R.string.T3_Ans1));
            mButtonBottom.setText(getString(R.string.T3_Ans2));
            //mStoryIndex = 3;
        } else if (mStoryIndex == 3) {
            mTextViewStory.setText(getString(R.string.T6_End));
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
            //mStoryIndex = 6;
        } else if(mStoryIndex == 5) {
            mTextViewStory.setText(getString(R.string.T5_End));
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        } else if(mStoryIndex == 6) {
            mTextViewStory.setText(getString(R.string.T6_End));
            mButtonTop.setVisibility(View.GONE);
            mButtonBottom.setVisibility(View.GONE);
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    mTextViewStory.setText(getString(R.string.T3_Story));
                    mButtonTop.setText(getString(R.string.T3_Ans1));
                    mButtonBottom.setText(getString(R.string.T3_Ans2));
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    mTextViewStory.setText(getString(R.string.T6_End));
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    mStoryIndex = 6;
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStoryIndex == 1){
                    mTextViewStory.setText(getString(R.string.T2_Story));
                    mButtonTop.setText(getString(R.string.T2_Ans1));
                    mButtonBottom.setText(getString(R.string.T2_Ans2));
                    mStoryIndex = 2;
                } else if(mStoryIndex == 2) {
                    mTextViewStory.setText(getString(R.string.T3_Story));
                    mButtonTop.setText(getString(R.string.T3_Ans1));
                    mButtonBottom.setText(getString(R.string.T3_Ans2));
                    mStoryIndex = 3;
                } else if(mStoryIndex == 3){
                    mTextViewStory.setText(getString(R.string.T5_End));
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);
                    mStoryIndex = 5;
                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreKey", mStoryIndex);
    }
}
