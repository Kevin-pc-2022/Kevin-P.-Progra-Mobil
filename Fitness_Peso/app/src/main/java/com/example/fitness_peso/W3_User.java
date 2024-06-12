package com.example.fitness_peso;

import android.content.Intent;
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

public class W3_User extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextHeight;
    private EditText editTextInitialWeight;
    private EditText editTextGoalWeight;
    private Button buttonSaveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.w3_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextInitialWeight = findViewById(R.id.editTextInitialWeight);
        editTextGoalWeight = findViewById(R.id.editTextGoalWeight);
        buttonSaveProfile = findViewById(R.id.buttonSaveProfile);

        buttonSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserProfile();
            }
        });
    }

    private void saveUserProfile() {
        String name = editTextName.getText().toString();
        String ageStr = editTextAge.getText().toString();
        String heightStr = editTextHeight.getText().toString();
        String initialWeightStr = editTextInitialWeight.getText().toString();
        String goalWeightStr = editTextGoalWeight.getText().toString();

        if (name.isEmpty() || ageStr.isEmpty() || heightStr.isEmpty() || initialWeightStr.isEmpty() || goalWeightStr.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            int age = Integer.parseInt(ageStr);
            float height = Float.parseFloat(heightStr);
            float initialWeight = Float.parseFloat(initialWeightStr);
            float goalWeight = Float.parseFloat(goalWeightStr);

            // Aquí puedes guardar los datos del perfil en una base de datos o en SharedPreferences
            Toast.makeText(this, "Perfil guardado exitosamente", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(W3_User.this, W4_Peso.class);
            startActivity(intent);
        }
    }
}
