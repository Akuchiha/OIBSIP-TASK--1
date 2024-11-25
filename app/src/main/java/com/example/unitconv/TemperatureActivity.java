package com.example.unitconv;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class TemperatureActivity extends AppCompatActivity {

    private EditText inputTemperature;
    private Spinner temperatureConversionOptions;
    private TextView temperatureResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        inputTemperature = findViewById(R.id.inputTemperature);
        temperatureConversionOptions = findViewById(R.id.temperatureConversionOptions);
        temperatureResult = findViewById(R.id.temperatureResult);

        Button convertTemperatureButton = findViewById(R.id.convertTemperatureButton);
        convertTemperatureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performTemperatureConversion();
            }
        });
    }

    private void performTemperatureConversion() {
        String input = inputTemperature.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        double value = Double.parseDouble(input);
        String selectedConversion = temperatureConversionOptions.getSelectedItem().toString();
        double result = 0;

        switch (selectedConversion) {
            case "Celsius to Fahrenheit":
                result = (value * 9 / 5) + 32;
                break;
            case "Fahrenheit to Celsius":
                result = (value - 32) * 5 / 9;
                break;
            case "Celsius to Kelvin":
                result = value + 273.15;
                break;
            case "Kelvin to Celsius":
                result = value - 273.15;
                break;
            case "Fahrenheit to Kelvin":
                result = (value - 32) * 5 / 9 + 273.15;
                break;
            case "Kelvin to Fahrenheit":
                result = (value - 273.15) * 9 / 5 + 32;
                break;
            default:
                Toast.makeText(this, "Invalid conversion selected", Toast.LENGTH_SHORT).show();
                return;
        }

        temperatureResult.setText("Result: " + result);
    }
}
