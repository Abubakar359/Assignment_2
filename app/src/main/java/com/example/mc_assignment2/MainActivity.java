package com.example.mc_assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    RadioGroup radioGroup;
    RadioButton option1;
    RadioButton option2;
    RadioButton option3;
    RadioButton option4;
    RadioButton selectedRadioButton;

    Button button;

    String[] questions;
    String[] answers;
    String[] options;

    int questionCounter;
    int check;
    int correctAns;

    Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textViewQuestion);

        radioGroup = findViewById(R.id.radioGroup);
        option1=findViewById(R.id.radioButton1);
        option2=findViewById(R.id.radioButton2);
        option3=findViewById(R.id.radioButton3);
        option4=findViewById(R.id.radioButton4);

        button =findViewById(R.id.button);

        questions=getResources().getStringArray(R.array.questions);
        answers=getResources().getStringArray(R.array.answers);
        options=getResources().getStringArray(R.array.options);

        questionCounter=0;

        correctAns=0;

        showNextQuestion();
    }

    private void showNextQuestion() {

        textView.setText(questions[questionCounter]);
        option1.setText(options[questionCounter*4]);
        option2.setText(options[(questionCounter*4)+1]);
        option3.setText(options[(questionCounter*4)+2]);
        option4.setText(options[(questionCounter*4)+3]);
    }


    public void showNextQuestion(View view) {

        check = radioGroup.getCheckedRadioButtonId();
        selectedRadioButton=findViewById(check);

        if(selectedRadioButton.getText().equals(answers[questionCounter])){
            correctAns++;
            Log.i("correct answers: ", String.valueOf(correctAns));
        }

        //questionCounter=rand.nextInt(15);
        questionCounter++;

        if(questionCounter<=9){
            textView.setText(questions[questionCounter]);
            option1.setText(options[questionCounter*4]);
            option2.setText(options[(questionCounter*4)+1]);
            option3.setText(options[(questionCounter*4)+2]);
            option4.setText(options[(questionCounter*4)+3]);
        }
        else
        {
            button.setVisibility(View.INVISIBLE);
            textView=findViewById(R.id.textViewResult);
            textView.setText("Correct Answers: "+ correctAns);
        }

        if(questionCounter==9)
        {
            button.setText("Submit");
        }
    }
}
