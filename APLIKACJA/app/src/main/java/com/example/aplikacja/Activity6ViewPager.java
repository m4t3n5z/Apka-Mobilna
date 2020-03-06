package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.aplikacja.fragments.PageFragment1;
import com.example.aplikacja.fragments.PageFragment2;
import com.example.aplikacja.fragments.PageFragment3;

import java.util.ArrayList;
import java.util.List;

public class Activity6ViewPager extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity6_view_pager);


        List<Fragment> list = new ArrayList<>();
        list.add(new PageFragment1());
        list.add(new PageFragment2());
        list.add(new PageFragment3());



        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePagerAdapter6(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);


    }
}
