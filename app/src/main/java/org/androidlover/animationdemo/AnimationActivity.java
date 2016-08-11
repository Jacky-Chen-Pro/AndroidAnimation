package org.androidlover.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Animation类继承的属性
 * Animation类是所有动画（scale、alpha、translate、rotate）的基类，这里以scale标签为例，讲解一下，Animation类所具有的属性及意义。关于Animation类的官方文档位置为：《Animation》
android:duration        动画持续时间，以毫秒为单位
 android:fillAfter          如果设置为true，控件动画结束时，将保持动画最后时的状态
 android:fillBefore       如果设置为true,控件动画结束时，还原到开始动画前的状态
 android:fillEnabled    与android:fillBefore 效果相同，都是在动画结束时，将控件还原到初始化状态
 android:repeatCount 重复次数
 android:repeatMode	重复类型，有reverse和restart两个值，reverse表示倒序回放，restart表示重新放一遍，必须与repeatCount一起使用才能看到效果。因为这里的意义是重复的类型，即回放时的动作。
 android:interpolator  设定插值器，其实就是指定的动作效果，比如弹跳效果等，不在这小节中讲解，后面会单独列出一单讲解。
 对于android:duration，就不再讲解了，就是动画的持续时长，以毫秒为单位，下面看看android:fillAfter和android:fillBefore
 */
public class AnimationActivity extends AppCompatActivity {
    @BindView(R.id.view)
    View animView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.scale)
    void onScale() {
        ScaleAnimation scaleAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.scale);
        animView.startAnimation(scaleAnimation);
    }

    @OnClick(R.id.rotate)
    void onRotate() {
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.rotate);
        animView.startAnimation(rotateAnimation);
    }

    @OnClick(R.id.alpha)
    void onAlpha() {
        AlphaAnimation alphaAnimation = (AlphaAnimation) AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha);
        animView.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.translate)
    void onTranslate() {
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.translate);
        animView.startAnimation(translateAnimation);
    }

    @OnClick(R.id.set)
    void onSet() {
        AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.set_anim);
        animationSet.setRepeatCount(3);
        animationSet.setRepeatMode(Animation.REVERSE);
        animView.startAnimation(animationSet);
    }
}
