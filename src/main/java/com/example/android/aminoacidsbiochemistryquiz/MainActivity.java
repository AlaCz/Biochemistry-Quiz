package com.example.android.aminoacidsbiochemistryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    int score = 0;
    String answer5A = "";
    String answer5B = "";
    String answer5C = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * This method is called when the submit button is clicked.
     * Calculates the score and displays it.
     */
    public void submitAnswers(View view) {
        RadioButton q1bRadioButton = (RadioButton) findViewById(R.id.q1b_radio_button);
        boolean checkedB = q1bRadioButton.isChecked();
        score1 = calculateQuestion1(checkedB);
        RadioButton q2dRadioButton = (RadioButton) findViewById(R.id.q2d_radio_button);
        boolean checkedD = q2dRadioButton.isChecked();
        score2 = calculateQuestion2(checkedD);
        CheckBox q3aCheckBox = (CheckBox) findViewById(R.id.q3a_checkbox);
        boolean marksQ3A = q3aCheckBox.isChecked();
        CheckBox q3cCheckBox = (CheckBox) findViewById(R.id.q3c_checkbox);
        boolean marksQ3C = q3cCheckBox.isChecked();
        score3 = calculateQuestion3(marksQ3A, marksQ3C);
        CheckBox q4aCheckBox = (CheckBox) findViewById(R.id.q4a_checkbox);
        boolean marksQ4A = q4aCheckBox.isChecked();
        CheckBox q4bCheckBox = (CheckBox) findViewById(R.id.q4b_checkbox);
        boolean marksQ4B = q4bCheckBox.isChecked();
        score4 = calculateQuestion4(marksQ4A, marksQ4B);
        TextView answerTo5A = (TextView) findViewById(R.id.q5a_answer_edittext);
        answer5A = answerTo5A.getText().toString();
        TextView answerTo5B = (TextView) findViewById(R.id.q5b_answer_edittext);
        answer5B = answerTo5B.getText().toString();
        TextView answerTo5C = (TextView) findViewById(R.id.q5c_answer_edittext);
        answer5C = answerTo5C.getText().toString();
        score5 = calculateQuestion5(answer5A, answer5B, answer5C);
        score = score1 + score2 + score3 + score4 + score5;
        String scoreMessage = "Your score is " + String.valueOf(score);
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
    }

    /**
     * This method calculates points in question 1.
     * @param checkedB verifying if answer B is checked
     */
    private int calculateQuestion1 (boolean checkedB) {
        int baseScore1 = 0;
                if (checkedB) {
                    baseScore1 = baseScore1 + 1;
                } else {
                    baseScore1 = 0;
                }
        return baseScore1;
    }

    /**
     * This method calculates points in question 2.
     * @param checkedD verifying if answer D is checked
     */
    private int calculateQuestion2 (boolean checkedD) {
        int baseScore2 = 0;
        if (checkedD) {
            baseScore2 = baseScore2 + 1;
        } else {
            baseScore2 = 0;
        }
        return baseScore2;
    }

    /**
     * This method calculates points in question 3.
     * @param markedQ3A verifying if answer A is checked
     * @param markedQ3C verifying if answer C is checked
     */
    private int calculateQuestion3 (boolean markedQ3A, boolean markedQ3C) {
        int baseScore3 = 0;
        if (markedQ3A) {
            baseScore3 = baseScore3 + 1;
        }
        if (markedQ3C) {
            baseScore3 = baseScore3 + 1;
        }
        return baseScore3;
    }

    /**
     * This method calculates points in question 4.
     * @param markedQ4A verifying if answer A is checked
     * @param markedQ4B verifying if answer B is checked
     */
    private int calculateQuestion4 (boolean markedQ4A, boolean markedQ4B) {
        int baseScore4 = 0;
        if (markedQ4A) {
            baseScore4 = baseScore4 + 1;
        }
        if (markedQ4B) {
            baseScore4 = baseScore4 + 1;
        }
        return baseScore4;
    }

    /**
     * This method calculates points in question 5.
     * @param answer5A - text written in answer A
     * @param answer5B - text written in answer B
     * @param answer5C - text written in answer C
     */
    private int calculateQuestion5 (String answer5A, String answer5B, String answer5C) {
        int baseScore5 = 0;
        if (answer5A.equals("Ile, Met, Val")) {
            baseScore5 = baseScore5 + 1;
        }
        if (answer5B.equals("Phe, Trp")) {
            baseScore5 = baseScore5 + 1;
        }
        if (answer5C.equals("Asn, Asp")) {
            baseScore5 = baseScore5 + 1;
        }
        return baseScore5;
    }
}