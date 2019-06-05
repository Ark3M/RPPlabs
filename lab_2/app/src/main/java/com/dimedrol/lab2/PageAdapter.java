package com.dimedrol.lab2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.dimedrol.lab2.TechData;
import com.dimedrol.lab2.R;
import com.squareup.picasso.Picasso;

public class PageAdapter extends PagerAdapter
{
    private LayoutInflater layoutInflater;
    private Context context;

    public PageAdapter(Context context)
    {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount()
    {
        return TechData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
    {
        return view == o;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        View view = layoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_pager);
        TextView textView = (TextView) view.findViewById(R.id.text_view);

        if (TechData.get(position).getHelptext() != null)
        {
            textView.setText(TechData.get(position).getHelptext());
        }
        else
        {
            textView.setText("This technology has no description");
        }


        Picasso.get()
                .load(TechData.get(position).getGraphicUrl())
                .placeholder(R.drawable.civ_icon)
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        View view = (View) object;
        container.removeView(view);
    }

}