package com.example.fitness_peso;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class W5_Report extends AppCompatActivity {

    private TextView textViewReport;
    private View viewGraph;
    private TextView textViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.w5_report);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewReport = findViewById(R.id.textViewReport);
        viewGraph = findViewById(R.id.viewGraph);
        textViewDetails = findViewById(R.id.textViewDetails);

        displayReport();
    }

    private void displayReport() {
        // Ejemplo de datos de análisis
        int[] weights = {70, 68, 67, 66, 65}; // pesos en kg xD
        StringBuilder reportDetails = new StringBuilder();
        reportDetails.append("Pesos registrados:\n");

        for (int i = 0; i < weights.length; i++) {
            reportDetails.append("Día ").append(i + 1).append(": ").append(weights[i]).append(" kg\n");
        }

        // Simular un gráfico simple cambiando la altura de viewGraph
        float maxWeight = 70.0f; // peso máximo para la escala del gráfico
        float minWeight = 65.0f; // peso mínimo para la escala del gráfico
        float weightRange = maxWeight - minWeight;
        float currentWeight = weights[weights.length - 1];
        float heightPercentage = (currentWeight - minWeight) / weightRange;

        viewGraph.getLayoutParams().height = (int) (200 * heightPercentage);
        viewGraph.requestLayout();

        textViewDetails.setText(reportDetails.toString());
    }
}
