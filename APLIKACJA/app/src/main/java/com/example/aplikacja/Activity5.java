package com.example.aplikacja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class Activity5 extends AppCompatActivity {
//
//    AutoCompleteTextView txtSearch;
//    List<People> mList;
//    PeopleAdapter adapter;
//    private People selectedPerson;
//
//    final AutoCompleteTextView myAutoCompleteTextView =
//            (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_5);
//
//        final AutoCompleteTextView myAutoCompleteTextView =
//                (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
//
//        ///String[] countries = getResources().getStringArray(R.array.list_of_countries);
//        ArrayAdapter<String> adapter = new
//              ///  ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,countries);
//      ///  myAutoCompleteTextView.setAdapter(adapter);
//
//      ///  mList = retrievePeople();
//        ///txtSearch = (AutoCompleteTextView) findViewById(R.id.auto_name);
//        ///adapter = new PeopleAdapter(this, R.layout.activity_5, R.id.lbl_name, mList);
//        txtSearch.setAdapter(adapter);
//
//
//
//        txtSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
////this is the way to find selected object/item
//                selectedPerson = (People) adapterView.getItemAtPosition(pos);
//            }
//        });
//    }
//    private List<People> retrievePeople() {
//        List<People> list = new ArrayList<People>();
//        list.add(new People("James", "Bond", 1));
//        list.add(new People("Jason", "Bourne", 2));
//        list.add(new People("Ethan", "Hunt", 3));
//        list.add(new People("Sherlock", "Holmes", 4));
//        list.add(new People("David", "Beckham", 5));
//        list.add(new People("Bryan", "Adams", 6));
//        list.add(new People("Arjen", "Robben", 7));
//        list.add(new People("Van", "Persie", 8));
//        list.add(new People("Zinedine", "Zidane", 9));
//        list.add(new People("Luis", "Figo", 10));
//        list.add(new People("John", "Watson", 11));
//        return list;
//    }
}
