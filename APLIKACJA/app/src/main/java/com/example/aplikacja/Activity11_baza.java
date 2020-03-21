package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddatabase.db.Training;
import com.example.androiddatabase.db.TrainingData;
import com.example.aplikacja.R;

import java.util.ArrayList;

public class Activity11_baza extends AppCompatActivity {
 /// SQLiteOpenHelper
    /// klasa bazowa do operacji na tabeli - onCreate()  wywolywanie przypadku pierwszego uruchomienia(tworzenie tabeli)
 // -on Upgrad() wywolywanie w przypadku zmiany struktury bazy danych samemu nalezy zapewnić migracje poprzez odpowiedni kod sql aktualizujacy
        /// dobra praktyka - tworzenie osoben j klasy do kazdej z tabel , odzielenie modelu danych od widoku .   MVC
    // SQLite datebase - uchwytdo umozliwajacy manipulacje danymi w bazie , nalezy pamietac o jego odpwoeidnm zamykaniu podczas zakonczenie aplikacji
    // cursor - umozliwia pobieranie wynikow z aktualnie wybranego wiersza
    /// niezbedna w przypadku zapytanie o dane

    private EditText descriptionET;
    private ImageButton saveBtn;




    private TrainingData trainingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_11_baza);

        descriptionET=findViewById(R.id.WriteNoteEditText);
        saveBtn=findViewById(R.id.AddNoteButton);



        trainingData = new TrainingData(this);
        try{
            Cursor cursor =  takeTrainings();
            showTrainings(cursor);
            saveBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s1 = descriptionET.getText().toString();
                    addTraining(s1,45);
                    Cursor cursor =  takeTrainings();
                    showTrainings(cursor);
                }
            });


        }finally {
        //zamykamy polaczenie z baza danych
            trainingData.close();
        }
    }




    private void showTrainings(Cursor cursor) {
        StringBuilder stringBuilder = new StringBuilder("BNSit trainings: \n");

        while(cursor.moveToNext()){
            long id = cursor.getLong(0);
            String title = cursor.getString(1);
            int timeInMinetes = cursor.getInt(2);

            stringBuilder.append(id+":");
            stringBuilder.append(title +":");
            stringBuilder.append(timeInMinetes + "\n");
        }

        TextView textView = (TextView) findViewById(R.id.textViewBase);
        textView.setText(stringBuilder);
    }

    private Cursor takeTrainings() {
        /// zwraca klase kursor odpowiedzialna za uch po kursach ?
        SQLiteDatabase database = trainingData.getReadableDatabase();
        Cursor cursor = database.query(Training.TABLE_NAME, new String []{Training._ID,Training.TITLE,Training.TIME_DURATION_MINUTES},
                null, null, null,null,Training._ID + " DESC");
        startManagingCursor(cursor);
        return cursor;

    }

    private void addTraining(String title, int duration) {
        SQLiteDatabase database= trainingData.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Training.TITLE ,title);
        values.put(Training.TIME_DURATION_MINUTES, duration);
        database.insertOrThrow(Training.TABLE_NAME, null, values);

    }









}



