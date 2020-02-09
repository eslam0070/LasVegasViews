package com.eso.lasvegasviews;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView mCardView1, mCardView2, mCardView3;
    Animation anim_from_bottom, anim_from_top, anim_from_left;
    TextView mFistText,mTextView4,mTextView,mTextView2,mTextView5;
    ImageView mImageView;
    SearchView mSearchView;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideBar();
        mCardView1 = findViewById(R.id.cardView1);
        mCardView2 = findViewById(R.id.cardView2);
        mCardView3 = findViewById(R.id.cardView3);
        mFistText = findViewById(R.id.fistText);
        mTextView = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView2);
        mTextView4 = findViewById(R.id.textView4);
        mTextView5 = findViewById(R.id.textView5);
        mImageView = findViewById(R.id.imageView);
        mSearchView = findViewById(R.id.search_view);
        anim_from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_bottom);
        anim_from_top = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        mCardView1.setAnimation(anim_from_bottom);
        mCardView2.setAnimation(anim_from_bottom);
        mCardView3.setAnimation(anim_from_bottom);
        mFistText.setAnimation(anim_from_top);
        mTextView.setAnimation(anim_from_top);
        mTextView2.setAnimation(anim_from_top);
        mTextView4.setAnimation(anim_from_top);
        mTextView5.setAnimation(anim_from_top);
        mImageView.setAnimation(anim_from_left);
        mSearchView.setAnimation(anim_from_top);

    }

    private void hideBar() {
        //Hide status bar and navigation bar at the bottom
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }

    public void intent(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}
