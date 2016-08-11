package org.androidlover.animationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jacky on 2016/8/11.
    AccelerateDecelerateInterpolator            在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
    AccelerateInterpolator                      在动画开始的地方速率改变比较慢，然后开始加速
    AnticipateInterpolator                      开始的时候向后然后向前甩
    AnticipateOvershootInterpolator             开始的时候向后然后向前甩一定值后返回最后的值
    BounceInterpolator                          动画结束的时候弹起
    CycleInterpolator                           动画循环播放特定的次数，速率改变沿着正弦曲线
    DecelerateInterpolator                      在动画开始的地方快然后慢
    LinearInterpolator                          以常量速率改变
    OvershootInterpolator                       向前甩一定值后再回到原来位置
 */
public class InterpolatorActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    @BindView(R.id.view)
    View translateView;
    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interpolator);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.add("AccelerateDecelerate");
        adapter.add("Accelerate");
        adapter.add("Decelerate");
        adapter.add("Anticipate");
        adapter.add("AnticipateOvershoot");
        adapter.add("Bounce");
        adapter.add("Cycle");
        adapter.add("Linear");
        adapter.add("Overshoot");
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(InterpolatorActivity.this, R.anim.translate_interpolator);
        if(position == 0) {
            //AccelerateDecelerate
            translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        }else if(position == 1) {
            //Accelerate
            translateAnimation.setInterpolator(new AccelerateInterpolator());
        }else if(position == 2) {
            //Decelerate
            translateAnimation.setInterpolator(new AccelerateInterpolator());
        }else if(position ==3) {
            //Anticipate
            translateAnimation.setInterpolator(new AnticipateInterpolator());
        }else if(position ==4) {
            //AnticipateOverShoot
            translateAnimation.setInterpolator(new AnticipateInterpolator());
        }else if(position == 5) {
            //Bounce
            translateAnimation.setInterpolator(new BounceInterpolator());
        }else if(position == 6) {
            //Cycle
            translateAnimation.setInterpolator(new CycleInterpolator(0.5f));
        }else if(position == 7) {
            //Linear
            translateAnimation.setInterpolator(new LinearInterpolator());
        }else if(position == 8) {
            //Overshoot
            translateAnimation.setInterpolator(new OvershootInterpolator());
        }

        translateView.startAnimation(translateAnimation);
    }
}
