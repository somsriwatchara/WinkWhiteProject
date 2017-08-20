package com.example.torey.winkwhiteproject;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.recycler_card_view)
    RecyclerView cardView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        setAdaptor();


    }

    private void setAdaptor() {

        RecyclerView.LayoutManager layoutManager =
                //ครอบlistview ด้วยlinear
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        cardView.setLayoutManager(layoutManager);
        cardView.setAdapter(new CardAdapter(this));

        viewPager.setAdapter(new CustomPagerAdapter(this));
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 3000, 6000);


    }


    private void showToast(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();

    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            SecondActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }

}
