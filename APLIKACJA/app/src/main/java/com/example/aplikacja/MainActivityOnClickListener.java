package com.example.aplikacja;

import android.view.View;
import android.widget.TextView;

public class MainActivityOnClickListener implements View.OnClickListener {

    TextView Kamil;
    public MainActivityOnClickListener(TextView Kamil){
        this.Kamil=Kamil;
    }
    @Override
    public void onClick(View view) {
        Kamil.append("NAUKA");
    }
}
