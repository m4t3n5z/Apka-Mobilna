package com.example.aplikacja;

import android.graphics.Color;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4Paint extends AppCompatActivity {

    private PaintView paintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_paint);
        paintView =  findViewById(R.id.paintView);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.normal:
                paintView.normal();

                return true;
            case R.id.emboss:
                paintView.emboss();
                return true;
            case R.id.blur:
                paintView.blur();
                return true;
            case R.id.clear:
                paintView.clear();
                return true;
            case R.id.RED:

                paintView.DEFAULT_COLOR= Color.RED;
                paintView.Color();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
