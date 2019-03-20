package com.BST.capitaltest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Questions extends AppCompatActivity {

    String correctNumber;
    TextView question;
    RadioGroup radioGroup;
    RadioButton option1, option2, option3, option4;
    Button next;

    void updateData() {
        question.setText(MainActivity.questions[MainActivity.questionNumber][0]);
        option1.setText(MainActivity.questions[MainActivity.questionNumber][1]);
        option2.setText(MainActivity.questions[MainActivity.questionNumber][2]);
        option3.setText(MainActivity.questions[MainActivity.questionNumber][3]);
        option4.setText(MainActivity.questions[MainActivity.questionNumber][4]);
        correctNumber = MainActivity.questions[MainActivity.questionNumber][5];

        option1.setBackgroundColor(Color.rgb(250,250,250));
        option2.setBackgroundColor(Color.rgb(250,250,250));
        option3.setBackgroundColor(Color.rgb(250,250,250));
        option4.setBackgroundColor(Color.rgb(250,250,250));

        next.setText(getResources().getText(R.string.answerButton));
        next.setEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions);

        question = findViewById(R.id.question);
        question.setText(MainActivity.questions[MainActivity.questionNumber][0]);

        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        next = findViewById(R.id.next);

        updateData();
    }

    public void onAnswerChange(View v) {
        next.setEnabled(true);
    }

    public void nextClick(View v) {
        if (next.getText().equals("Answer")) {
            switch (correctNumber) {
                case "1":
                    option1.setBackgroundColor(getResources().getColor(R.color.success));
                    if (option1.isChecked()) MainActivity.points += 1;
                    break;
                case "2":
                    option2.setBackgroundColor(getResources().getColor(R.color.success));
                    if (option2.isChecked()) MainActivity.points += 1;
                    break;
                case "3":
                    option3.setBackgroundColor(getResources().getColor(R.color.success));
                    if (option3.isChecked()) MainActivity.points += 1;
                    break;
                case "4":
                    option4.setBackgroundColor(getResources().getColor(R.color.success));
                    if (option4.isChecked()) MainActivity.points += 1;
                    break;
            }
            next.setText(getResources().getText(R.string.nextButton));
        } else {
            MainActivity.questionNumber++;
            if (MainActivity.questionNumber == MainActivity.questions.length) {
                Intent result = new Intent(getApplicationContext(), Result.class);
                startActivity(result);
            } else {
                radioGroup.clearCheck();
                updateData();
            }
        }
    }
}
