package com.example.unitconv;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LengthActivity extends AppCompatActivity {

    private EditText inputLength;
    private Spinner lengthConversionOptions;
    private TextView lengthResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        inputLength = findViewById(R.id.inputLength);
        lengthConversionOptions = findViewById(R.id.lengthConversionOptions);
        lengthResult = findViewById(R.id.lengthResult);

        Button convertLengthButton = findViewById(R.id.convertLengthButton);
        convertLengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLengthConversion();
            }
        });
    }

    private void performLengthConversion() {
        String input = inputLength.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        String selectedConversion = lengthConversionOptions.getSelectedItem().toString();
        double result = 0;

        switch (selectedConversion) {
            case "Meters to Kilometers":
                result = value / 1000;
                break;
            case "Meters to Centimeters":
                result = value * 100;
                break;
            case "Meters to Millimeters":
                result = value * 1000;
                break;
        }

        lengthResult.setText("Result: " + result);
    }
}
