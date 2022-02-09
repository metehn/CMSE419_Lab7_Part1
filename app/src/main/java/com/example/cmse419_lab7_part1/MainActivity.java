package com.example.cmse419_lab7_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText editTextName, editTextCourse, editTextMid1, editTextMid2, editTextFinal;
    Button buttonAdd, buttonListStudent;

    ArrayList<String> list = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("CMSE419StudentsArrayLIntent");

        editTextName = findViewById(R.id.editTextName);
        editTextCourse = findViewById(R.id.editTextCourse);
        editTextMid1 = findViewById(R.id.editTextMid1);
        editTextMid2 = findViewById(R.id.editTextMid2);
        editTextFinal = findViewById(R.id.editTextFinal);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonListStudent = findViewById(R.id.buttonListStudent);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editTextName.getText().toString().isEmpty() && !editTextCourse.getText().toString().isEmpty()  && !editTextMid1.getText().toString().isEmpty() && !editTextMid2.getText().toString().isEmpty() && !editTextFinal.getText().toString().isEmpty()){

                    try {

                        double total =Double.parseDouble(editTextMid1.getText().toString()) *0.25 + Double.parseDouble(editTextMid2.getText().toString()) *0.25 + Double.parseDouble(editTextFinal.getText().toString()) *0.5 ;


                        String student = editTextName.getText().toString() + " " + editTextCourse.getText().toString() + " " + total;

                     list.add(student);

                     editTextName.setText("");
                     editTextCourse.setText("");
                     editTextMid1.setText("");
                     editTextMid2.setText("");
                     editTextFinal.setText("");

                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "Please enter number", Toast.LENGTH_SHORT).show();

                    }


                }
                else{
                    Toast.makeText(MainActivity.this, "All areas must be filled", Toast.LENGTH_SHORT).show();
                }


            }
        });

        buttonListStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                intent.putExtra("list",list);
                startActivity(intent);


            }
        });







    }
}