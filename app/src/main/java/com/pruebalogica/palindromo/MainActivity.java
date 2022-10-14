package com.pruebalogica.palindromo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button agregar;
    EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = findViewById(R.id.texto);
        agregar = findViewById(R.id.agregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cadena = texto.getText().toString();
                cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i");
                cadena.toLowerCase().replace("ó", "o").replace("ú", "u");
                int fin = cadena.length()-1;
                int inicia=0;
                boolean validar=true;

                while (inicia<fin) {
                    if(cadena.charAt(inicia)!=cadena.charAt(fin)) {
                        validar= false;
                    }
                    inicia++;
                    fin--;
                }

                if (validar) {
                    Toast.makeText(getApplicationContext(), "La palabra es palíndromo", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "La palabra no es palíndromo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}