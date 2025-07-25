package com.example.bmi_hw2_paigesu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //input screen variables are initialized here for the input screen
    private EditText heightFeet, heightInches, weightPounds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        heightFeet = findViewById(R.id.heightFeet);
        heightInches = findViewById(R.id.heightInches);
        weightPounds = findViewById(R.id.weightPounds);
        //Button initialization
        Button computeButton = findViewById(R.id.computeButton);


        computeButton.setOnClickListener(view -> {

        //how to handle if a feild in the calulotr is empty field
            String feetSTR = heightFeet.getText().toString();
            String inchesSTR = heightInches.getText().toString();
            String weightSTR = weightPounds.getText().toString();

            if (feetSTR.isEmpty() || inchesSTR.isEmpty() || weightSTR.isEmpty()){
                //Show an error message to the user
                Toast.makeText(MainActivity.this, "Please enter values in all fields", Toast.LENGTH_SHORT).show();
                return;
            }


            //Get input values               //could put feetSTR in the parentheses
            int feet = Integer.parseInt(heightFeet.getText().toString());
            int inches = Integer.parseInt(heightInches.getText().toString());
            double weight = Double.parseDouble((weightPounds.getText().toString()));

            //Handle invalid height
            if (feet == 0 && inches == 0){
                Toast.makeText(MainActivity.this, "Height cannot be zero",Toast.LENGTH_SHORT).show();
                return;
            }



            //Pass the data into the ResultActivity which is our 2nd screen here
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            intent.putExtra("feet", feet);
            intent.putExtra("inches", inches);
            intent.putExtra("weight", weight);
            startActivity(intent);
        });
    }


    @Override
    protected void onResume() {

        super.onResume();
        //Clear input fields when returning from the 2nd activity part (Back Button)
        heightFeet.setText("");
        heightInches.setText("");
        weightPounds.setText("");
    }
}
