package com.dimedrol.lab2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rw;
    private ViewPager vp;
    private TechAdapter tAdapter;
    private PageAdapter pAdapter;
    private static boolean pageOpened = false;
    private static int pagePosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rw = (RecyclerView) findViewById(R.id.rw);
        vp = (ViewPager) findViewById(R.id.vp);
        if(pageOpened)
        {
            vp.setCurrentItem(pagePosition);
            vp.setVisibility(View.VISIBLE);
            rw.setVisibility(View.GONE);

        }

        tAdapter = new TechAdapter(this);
        pAdapter = new PageAdapter(this);

        vp.setAdapter(pAdapter);

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int i, float v, int i1)
            {}

            @Override
            public void onPageSelected(int i)
            {
                setTitle(TechData.get(i).getName());
            }

            @Override
            public void onPageScrollStateChanged(int i)
            {}
        });

        tAdapter.setOnClickListener(new TechAdapter.ClickListener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
                pagePosition = position;
                vp.setCurrentItem(position);
                rw.setVisibility(View.GONE);
                vp.setVisibility(View.VISIBLE);
                setTitle(TechData.get(position).getName());
                pageOpened = true;

            }
        });

        rw.setAdapter(tAdapter);

    }

    private void setTitle(String title)
    {
        Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public void onBackPressed()
    {
        if(!rw.isShown())
        {
            rw.setVisibility(View.VISIBLE);
            vp.setVisibility(View.GONE);
            setTitle("Technology");
            pageOpened = false;
        }
        else
        {
            finish();
        }
    }

}
