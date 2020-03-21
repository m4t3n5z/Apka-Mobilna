package com.example.aplikacja;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int ACTIVITY2_REQUEST_CODE = 2;
    private static final int PERMISSION_READ = 2;
    Button but;
    Button but2;
    Button but3;
    Button but4;
    Button but5;
    Button but6;
    Button but7;
    Button but8;
    Button but10;
    ImageButton but11;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_READ);
        }

        final TextView textview=findViewById(R.id.textView2);
        textview.setText("Hakuna matata");
        but=findViewById(R.id.Snikers);
        but2=findViewById(R.id.Mars);
        but3=findViewById(R.id.Kinderbueno);
        but4=findViewById(R.id.Paint);
        but5=findViewById(R.id.Testy);
        but6=findViewById(R.id.ViewPager);
        but7=findViewById(R.id.NavigationDrawer);
        but8=findViewById(R.id.Camera_button);
        but10=findViewById(R.id.Note_button);
        but11=findViewById(R.id.BaseButton);

     // ctr spacja  alt enter
    ///  MainActivityOnClickListener mainActivityOnClickListener = new MainActivityOnClickListener(textview);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.append("piwo");
            }
        });


        String firstWord="zielona herbatka";
        String lastWord="Kokaina o 12 apteka";
        Spannable spannable = new SpannableString(firstWord+lastWord);
    ///    int firstWordColor  = 50;

        spannable.setSpan(new ForegroundColorSpan(Color.BLUE), 0, firstWord.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    ///    int lastWordColor = 200;
        spannable.setSpan(new ForegroundColorSpan(-165555), firstWord.length(),
                firstWord.length()+lastWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textview.append( spannable );


        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this,Activity2.class),ACTIVITY2_REQUEST_CODE);
            }
        });

    but3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Activity3.class));
        }
    });


    but4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Activity4Paint.class));
        }
    });

    but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity5.class));
            }
        });

    but6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Activity6ViewPager.class));
         }
        });



    but7.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, activity_7NavigationView.class));
        }
    });

        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity8_camera.class));
            }
        });

        but10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity10_Note.class));
            }
        });
        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Activity11_baza.class));
            }
        });

        /// navigation view
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle (this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
    navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
        public boolean onOptionsItemSelected( MenuItem item){
                if(mToggle.onOptionsItemSelected(item)){
                    return true;

                }
                return super.onOptionsItemSelected(item);
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==ACTIVITY2_REQUEST_CODE) {
            if(resultCode==RESULT_OK){
                Toast.makeText(this,"Nacisnales OK",Toast.LENGTH_LONG).show();
                (( TextView)findViewById(R.id.textView2)).append(" OK!");
            }else
                if(resultCode==RESULT_CANCELED){
                Toast.makeText(this,"Nacisnales  NO OK ",Toast.LENGTH_LONG).show();
                TextView textView = findViewById(R.id.textView2);
                textView.append(" NO OK !");
            }
        }
    }
//    @Override
//    public void onPause() {
//
//        Toast.makeText(this,"Powrociles!",Toast.LENGTH_LONG).show();

//       /// super.onResume();
//    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
        int id = Item.getItemId();
        if (id == R.id.camera)
        {
            Toast.makeText(this, "this is home",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, Activity8_camera.class));
        }

        if (id == R.id.paint)
        { startActivity(new Intent(MainActivity.this, Activity4Paint.class));

        }
        if (id == R.id.login)
        { startActivity(new Intent(MainActivity.this, Activity9_log.class));

        }


        return false;
    }
}


