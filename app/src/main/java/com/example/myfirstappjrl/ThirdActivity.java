package com.example.myfirstappjrl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtenemos los componentes de la vista xml y los buscamos por id
        Button button = findViewById(R.id.buttonReturn);
        TextView textViewText = findViewById(R.id.textViewText);
        TextView textViewNumber = findViewById(R.id.textViewNumber);
        TextView textViewDecimal = findViewById(R.id.textViewDecimal);
        TextView textViewSwitchState = findViewById(R.id.textViewSwitch);

        // Le damos al botón un listener para realizar un evento
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creamos un intent para navegar desde la third activity a la main activity
                Intent mainActivity = new Intent(ThirdActivity.this, MainActivity.class);
                startActivity(mainActivity);
            }
        });

        // Recuperamos el intent que inició la actividad
        Intent intent = getIntent();

        // Recuperamos los datos del intent
        String text = intent.getStringExtra("text");
        String number = intent.getStringExtra("number");
        String decimal = intent.getStringExtra("decimal");
        boolean switch1 = intent.getBooleanExtra("switch1", false);  // Obtenemos el estado del switch

        // Asignamos los valores a los TextView
        textViewText.setText(text);
        textViewNumber.setText(number);
        textViewDecimal.setText(decimal);

        // Mostramos el mensaje basado en el estado del Switch en el caso de que esté activado
        //mostramos un mensaje de que lo está y en el caso de que esté desactivado uno que no lo está
        //según la api de java no hace falta poner una condición de true y se puede simplificar a simplemente switch1
        if (switch1) {
            textViewSwitchState.setText("The Switch is activated");
        } else {
            textViewSwitchState.setText("The Switch is deactivated");
        }
    }
}
