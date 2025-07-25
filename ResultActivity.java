package com.example.bmi_hw2_paigesu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    public TextView bmiResult, suggestion;
    public Button backButton;


    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //text view variables to display the computed BMI and suggestion based on the BMI category.
        TextView bmiResult = findViewById(R.id.bmiResult);
        TextView suggestion = findViewById(R.id.suggestion);
        Button backButton = findViewById(R.id.backButton);

        //Get Data from intent passed in from MainActivty
        // Get data from intent passed from MainActivity
        Intent intent = getIntent();
        int feet = intent.getIntExtra("feet", 0);
        int inches = intent.getIntExtra("inches", 0);
        double weight = intent.getDoubleExtra("weight", 0);

        //Convert the height given in feet to inches
        // Convert height to total inches
        int totalInches = (feet * 12) + inches;

        //Validates the user input so an error will not crash the whole program
        if (totalInches == 0) {
            // Prevent division by zero if height is not valid
            bmiResult.setText("Invalid height: Division by zero");
            suggestion.setText("Please go back and enter a valid height.");
        } else {
            // Correct BMI formula: BMI = (weight in pounds) / (height in inches)^2 * 703
            double bmi = (weight / (totalInches * totalInches)) * 703;
            bmiResult.setText(String.format("Your BMI: %.2f", bmi));


            // Suggestion based on BMI the text that will be returned to the user
            if (bmi < 18.5) {
                suggestion.setText("You are too slim! You need more sandwich!");
            } else if ((18.5 <= bmi) && (bmi < 24.9)) {
                suggestion.setText("Your body is in good shape!");
            } else if ((25 <= bmi) && (bmi < 29.9)) {
                suggestion.setText("Watch out! You are slightly overweight!");
            } else {
                suggestion.setText("You need to lose a couple of pounds!");
            }
        }
        //bmiResult.setText(String.format("Your BMI: %.2f", bmi));

        // Back button functionality
        backButton.setOnClickListener(view -> finish());

    } //create method bracket

} //class ending brace





