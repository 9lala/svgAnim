package com.svg.demo;

import android.animation.ObjectAnimator;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView xjbDrawImg;
    private ImageView mIvImageView;
    private ImageView mIvLoging;
    private View mView1;
    private View mView2;
    private View mView3;
    private RelativeLayout mRLBili;
    private boolean lodingIsStart = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xjbDrawImg = findViewById(R.id.img_xjbdraw);
        mIvImageView = findViewById(R.id.main_iv_image_view);
        mView1 = findViewById(R.id.view1);
        mView2 = findViewById(R.id.view2);
        mView3 = findViewById(R.id.view3);
        mRLBili = findViewById(R.id.rl_bili);
        mIvLoging = findViewById(R.id.iv_loding);
        animateImage();
        xjbDrawImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) xjbDrawImg.getDrawable();
                animatedVectorDrawable.start();
            }
        });
        mRLBili.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animateImage();
            }
        });
        mIvLoging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) mIvLoging.getDrawable();
                if (lodingIsStart) {

                } else {
                    animatedVectorDrawable.start();
                }
                lodingIsStart = !lodingIsStart;
            }
        });
        // 加载SVG
//        anim1 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim1);  anim1.start();
//        anim2 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim2);  anim2.start();
//        anim3 = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim3);  anim3.start();

    }


    // 只支持5.0以上.
    private void animateImage() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 获取动画效果
            AnimatedVectorDrawable mAnimatedVectorDrawable = (AnimatedVectorDrawable)
                    ContextCompat.getDrawable(getApplication(), R.drawable.v_heard_animation);
            mIvImageView.setImageDrawable(mAnimatedVectorDrawable);
            if (mAnimatedVectorDrawable != null) {
                mAnimatedVectorDrawable.start();
            }
            mView1.setAlpha(0);
            mView2.setAlpha(0);
            mView3.setAlpha(0);

            ObjectAnimator animator = ObjectAnimator.ofFloat(mView1, "alpha", 0, 1, 0, 1);
            animator.setStartDelay(2000);
            animator.setDuration(2000);
            animator.start();

            ObjectAnimator animator2 = ObjectAnimator.ofFloat(mView2, "alpha", 0, 1, 0, 1);
            animator2.setStartDelay(2100);
            animator2.setDuration(2000);
            animator2.start();

            ObjectAnimator animator3 = ObjectAnimator.ofFloat(mView3, "alpha", 0, 1, 0, 1);
            animator3.setStartDelay(2200);
            animator3.setDuration(2000);
            animator3.start();
        }
    }
}
