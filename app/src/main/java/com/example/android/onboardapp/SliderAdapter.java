package com.example.android.onboardapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    //Arrays for the content in the sliding pages.

    public int[] slide_icons = {
        R.drawable.analytics,
        R.drawable.debitcard,
        R.drawable.paymentmethod
    };

    public int[] slide_backgrounds = {
            R.drawable.obp1,
            R.drawable.obp2,
            R.drawable.obp3
    };

    public String[] slide_text = {
            "Get your financial chart of spendings over a period",
            "Get your financial chart of spendings over a period",
            "Get your financial chart of spendings over a period"
    };


    @Override
    public int getCount() {
        return slide_backgrounds.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(final ViewGroup container, int position){

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView background = (ImageView) view.findViewById(R.id.obbackground);
        ImageView icon = (ImageView) view.findViewById(R.id.obicon);
        TextView text = (TextView) view.findViewById(R.id.obtext);
        TextView pageno = (TextView) view.findViewById(R.id.obpageno);
        TextView skip = (TextView) view.findViewById(R.id.obskip);
        TextView done = (TextView) view.findViewById(R.id.obdone);

        pageno.setText(""+(position+1));
        background.setImageResource(slide_backgrounds[position]);
        icon.setImageResource(slide_icons[position]);
        text.setText(slide_text[position]);

        if (position<2){
            done.setText("");
            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context,MenuPage.class);
                    context.startActivity(i);
                    ((Activity)context).finish();
                }
            });
        }

        if(position==2){
            skip.setText("");
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context,MenuPage.class);
                    context.startActivity(i);
                    ((Activity)context).finish();
                }
            });
        }

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container,int poition, Object o){

        container.removeView((RelativeLayout)o);
    }

}
