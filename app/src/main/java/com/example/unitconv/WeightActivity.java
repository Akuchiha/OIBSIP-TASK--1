package com.example.unitconv;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity {

    private EditText inputWeight;
    private Spinner weightConversionOptions;
    private TextView weightResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        inputWeight = findViewById(R.id.inputWeight);
        weightConversionOptions = findViewById(R.id.weightConversionOptions);
        weightResult = findViewById(R.id.weightResult);

        Button convertWeightButton = findViewById(R.id.convertWeightButton);
        convertWeightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performWeightConversion();
            }
        });
    }

    private void performWeightConversion() {
        String input = inputWeight.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        String selectedConversion = weightConversionOptions.getSelectedItem().toString();
        double result = 0;

        switch (selectedConversion) {
            case "Kilograms to Grams":
                result = value * 1000;
                break;
            case "Kilograms to Pounds":
                result = value * 2.20462;
                break;
        }

        weightResult.setText("Result: " + result);
    }
}
