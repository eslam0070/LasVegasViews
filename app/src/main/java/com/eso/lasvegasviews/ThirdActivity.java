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
import android.widget.ScrollView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    ImageView mDownArrow;
    ScrollView mThirdScrollView;
    Animation from_bottom,from_top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        hideBar();
        mDownArrow = findViewById(R.id.down_arrow);
        mDownArrow.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(mDownArrow,"backgroud_image_transition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ThirdActivity.this,pairs);
                startActivity(intent,options.toBundle());
                finish();
            }
        });
        mThirdScrollView = findViewById(R.id.third_scroll_view);

        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_bottom);
        from_top = AnimationUtils.loadAnimation(this, R.anim.anim_top);
        mDownArrow.setAnimation(from_top);
        mThirdScrollView.setAnimation(from_bottom);

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
