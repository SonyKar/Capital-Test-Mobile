package com.BST.capitaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static int points = 0, questionNumber = 0;

    // question, option1, option2, option3, option4, number of correct answer (1-4)
    static String[][] questions = {
        {"The capital of Moldova?", "Balti", "Chisinau", "Cagul", "Calarasi", "2"},
        {"The capital of Russia?", "Moscow", "Peterburg", "Voronej", "Novosibirsk", "1"},
        {"The capital of Italy?", "Milan", "Rome", "Florence", "Venice", "2"},
        {"The capital of Turkey?", "Side", "Alania", "Stambul", "Kemer", "3"},
        {"The capital of Egypt?", "Hurgada", "Asuan", "Alexandria", "Kair", "4"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.startTest);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startTest = new Intent(getApplicationContext(), Questions.class);
                startActivity(startTest);
            }
        });
    }
}
