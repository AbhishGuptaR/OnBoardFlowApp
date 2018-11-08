package com.example.android.onboardapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
//    private LinearLayout linearLayout;
//
//    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //linearLayout = (LinearLayout) findViewById(R.id.linearlayout);


        SliderAdapter sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

    }

//    public void addDotsIndicator(){
//
//        dots = new TextView[3];
//        for (int i = 0; i < 3; i++){
//
//            dots[i] = new TextView(this);
//            dots[i].setText(Html.fromHtml("&#8226"));
//            dots[i].setTextSize(35);
//            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
//
//            linearLayout.addView(dots[i]);
//        }
//
//    }
}
