package com.example.myfirstappjrl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    private boolean isSwitchChecked = false;  // Variable para almacenar el estado del switch

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtenemos los componentes de la vista xml y los buscamos por id
        EditText editTextText = findViewById(R.id.editTextText);
        EditText editTextNumber = findViewById(R.id.editTextNumber);
        EditText editTextDecimal = findViewById(R.id.editTextDecimal);
        Switch switch1 = findViewById(R.id.switch1);
        Button button = findViewById(R.id.buttonSend);

        // Asignamos un listener al switch para ver si ha sido activado o desactivado
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            //Cremos un método con un compoundbutton que representa nuestro switch y con un valor booleano
            //que indica true si el swtich está activado o false si está descativado
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Actualizamos la variable isSwitchChecked con el nuevo estado del switch
                isSwitchChecked = isChecked;
            }
        });

        // Vamos a asignarle un evento al botón cuando se haga clic para que se envíen los datos
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creamos un intent para navegar desde la second activity hasta la third activity
                Intent intentThirdActivity = new Intent(SecondActivity.this, ThirdActivity.class);

                // Añadimos al intent los valores clave-valor
                intentThirdActivity.putExtra("text", editTextText.getText().toString());
                intentThirdActivity.putExtra("number", editTextNumber.getText().toString());
                intentThirdActivity.putExtra("decimal", editTextDecimal.getText().toString());
                intentThirdActivity.putExtra("switch1", isSwitchChecked);  // Enviamos el estado del switch (true o false)

                // Iniciamos la actividad
                startActivity(intentThirdActivity);
            }
        });
    }
}
