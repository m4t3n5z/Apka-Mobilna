package com.example.androiddatabase.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.androiddatabase.db.Training;
import com.example.aplikacja.Activity11_baza;

public class TrainingData extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME ="trainings.db";
    private static final  int DATA_BASE_VERSION = 1;

    public TrainingData(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION );
    }

    public TrainingData(Context context) {
        super(context, DATA_BASE_NAME,null, DATA_BASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE "+ Training.TABLE_NAME + " ("+Training._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + Training.TITLE + " TEXT NOT NULL, "+Training.TIME_DURATION_MINUTES + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS "+ Training.TABLE_NAME);
            onCreate(db);
    }
}
