package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity9_log extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_9_log);


        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Info.setText("No of attempts reamining: 5");
        Login = (Button) findViewById(R.id.btnLogin);


            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate(Name.getText().toString(), Password.getText().toString());
                }
            });
    }

    private void validate(String userName, String userPassowrd) {
        if((userName.equals("Atcholn") )&& (userPassowrd.equals("Mati"))){

            startActivity(new Intent(Activity9_log.this, Activity9_access.class));


        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));


            if(counter==0){
                Login.setEnabled(false);
            }
        }

    }

}
