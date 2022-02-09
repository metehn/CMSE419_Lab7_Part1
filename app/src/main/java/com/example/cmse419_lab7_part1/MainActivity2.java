package com.example.cmse419_lab7_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lv;

    ArrayList<String> list2;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = findViewById(R.id.lv);

        list2 = (ArrayList<String>) getIntent().getSerializableExtra("list");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list2);

        lv.setAdapter(adapter);


    }
}