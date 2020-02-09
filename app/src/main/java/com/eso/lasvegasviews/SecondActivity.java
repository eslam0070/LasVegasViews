package com.eso.lasvegasviews;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ImageView mSecondBackArrow,mSecondArrowUp;
    TextView mSecondTitle,mSecondSubtitle,mSecondRatingNumber,mSecondRatingNumber2,mSecondMoreDetails;
    RatingBar mSecondRatingBar;
    Animation from_left,from_right,from_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        hideBar();
        mSecondBackArrow = findViewById(R.id.second_back_arrow);
        mSecondBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mSecondTitle = findViewById(R.id.second_title);
        mSecondSubtitle = findViewById(R.id.second_subtitle);
        mSecondRatingBar = findViewById(R.id.second_ratingBar);
        mSecondRatingNumber = findViewById(R.id.second_rating_number);
        mSecondRatingNumber2 = findViewById(R.id.second_rating_number2);
        mSecondArrowUp = findViewById(R.id.second_arrow_up);
        mSecondArrowUp.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(mSecondArrowUp,"backgroud_image_transition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SecondActivity.this,pairs);
                startActivity(intent, options.toBundle());
            }
        });
        mSecondMoreDetails = findViewById(R.id.second_more_details);

        //Loading Animation
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_left);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_right);
        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_bottom);

        //Set Animation
        mSecondBackArrow.setAnimation(from_left);
        mSecondRatingBar.setAnimation(from_left);
        mSecondTitle.setAnimation(from_right);
        mSecondSubtitle.setAnimation(from_right);
        mSecondRatingNumber.setAnimation(from_right);
        mSecondRatingNumber2.setAnimation(from_right);
        mSecondArrowUp.setAnimation(from_bottom);
        mSecondMoreDetails.setAnimation(from_bottom);
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
}
