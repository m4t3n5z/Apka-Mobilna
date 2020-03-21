package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity10_Note extends AppCompatActivity {


    // private EditText titleET;

    private EditText descriptionET;
    private Button saveBtn;
    private ListView notesLV;
    private TextView test;
    private int ktory;
    private TextView ktory_w_liscie;
    ArrayList<String> arrayList= new ArrayList<>();

   private String[] notatki = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10_note);

        ktory = 0;
        ktory_w_liscie = (TextView)findViewById(R.id.textView7);
        descriptionET=findViewById(R.id.descriptioEditText);
        saveBtn=findViewById(R.id.btnSave);
        test=findViewById(R.id.textView7);
        notesLV=findViewById(R.id.showData);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeText();
            }
        });


    }


    public void changeText(){
        String s1 = descriptionET.getText().toString();

        ktory_w_liscie.setText(Integer.toString(ktory+1));
        if(ktory<20){arrayList.add(s1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        notesLV.setAdapter(arrayAdapter);
        notatki[ktory]= s1;
        ktory++;}
        else Toast.makeText(getApplicationContext(),"osiagnieto maximum",Toast.LENGTH_LONG).show();

    }



    }
