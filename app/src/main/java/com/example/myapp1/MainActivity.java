package com.example.myapp1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mainBtnIngresar;

    EditText Usuariotext;
    EditText Contraseñatext;
    private boolean esperarSegundos =false;
    private int intentos =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       referenciaViews();
    }

    private void ValidarDatos(String mail, String password) {

        if (mail.equals("alumno") && password.equals("1234")) {
            Toast.makeText(this, "Acceso Correcto", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);

        } else {
            intentos++;

            if (intentos < 3) {
                Toast.makeText(this, "Acceso Incorrecto. Numero de intentos: " + intentos, Toast.LENGTH_SHORT).show();
            } else {

                if (esperarSegundos) {
                    Toast.makeText(this, "Por favor espere 10 segundos para volver a intentarlo", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(this, "Datos invalidos, has gastado tus 3 intentos.", Toast.LENGTH_SHORT).show();
                esperarSegundos = true;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        esperarSegundos = false;
                        intentos = 0;
                    }
                }, 10000);
            }
        }
    }



    private void referenciaViews(){

        mainBtnIngresar = findViewById(R.id.mainBtnIngresar);
        Usuariotext = findViewById(R.id.Usuariotext);
        Contraseñatext = findViewById(R.id.Contraseñatext);

        mainBtnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidarDatos(Usuariotext.getText().toString(),Contraseñatext.getText().toString());
            }
        });
    }
    @Override
    public void onBackPressed()
    {

    }
}