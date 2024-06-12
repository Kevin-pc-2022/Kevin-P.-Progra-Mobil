package com.example.fitness_peso;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class W4_Peso extends AppCompatActivity {

    private EditText editTextWeight;
    private Button buttonSaveWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.w4_peso);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextWeight = findViewById(R.id.editTextWeight);
        buttonSaveWeight = findViewById(R.id.buttonSaveWeight);

        buttonSaveWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveWeightEntry();
            }
        });
    }

    private void saveWeightEntry() {
        String weightStr = editTextWeight.getText().toString();
        if (!weightStr.isEmpty()) {
            double weight = Double.parseDouble(weightStr);
            // Aquí puedes guardar el peso en una base de datos o en SharedPreferences
            Toast.makeText(this, "Peso guardado: " + weight + " kg", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, ingrese su peso.", Toast.LENGTH_SHORT).show();
        }
    }
}
