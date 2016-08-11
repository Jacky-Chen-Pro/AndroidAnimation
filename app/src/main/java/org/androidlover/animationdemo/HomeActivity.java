package org.androidlover.animationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jacky on 2016/8/11.
 */
public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @BindView(R.id.listview)
    ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1);
        adapter.add("Animation(Scale,Rotate,Alpha,Translate,Set)");
        adapter.add("Interpolator 差值器");
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0) {
            startActivity(new Intent(HomeActivity.this,AnimationActivity.class));
        }else if(position == 1) {
            startActivity(new Intent(HomeActivity.this, InterpolatorActivity.class));
        }
    }
}
