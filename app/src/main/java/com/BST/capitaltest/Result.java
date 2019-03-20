package com.BST.capitaltest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    public boolean isBetween(double x, int lower, int upper) {
        return lower <= x && x <= upper;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView mark = findViewById(R.id.mark);

        double points = MainActivity.points;
        double maxPoints = MainActivity.questions.length;
        double percent = points * 100 / maxPoints;

        if (percent == 100) {
            mark.setText("10");
        } else if (isBetween(percent, 93, 99)) {
            mark.setText("9");
        } else if (isBetween(percent, 85, 92)) {
            mark.setText("8");
        } else if (isBetween(percent, 77, 84)) {
            mark.setText("7");
        } else if (isBetween(percent, 70, 76)) {
            mark.setText("6");
        } else if (isBetween(percent, 63, 69)) {
            mark.setText("5");
        } else if (isBetween(percent, 50, 62)) {
            mark.setText("4");
        } else if (isBetween(percent, 40, 49)) {
            mark.setText("3");
        } else if (isBetween(percent, 1, 39)) {
            mark.setText("2");
        } else {
            mark.setText("1");
        }

        Button mainMenu = findViewById(R.id.mainMenu);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.questionNumber = 0;
                MainActivity.points = 0;
                Intent mainMenuActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainMenuActivity);
            }
        });
    }
}
