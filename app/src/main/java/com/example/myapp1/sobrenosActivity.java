package com.example.myapp1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class sobrenosActivity extends AppCompatActivity {

    FloatingActionButton btn1;
    FloatingActionButton click;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosotros);



        btn1 =  findViewById(R.id.llamamebtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(sobrenosActivity.this, "Llamando a Bacan, pedime una docena", Toast.LENGTH_SHORT).show();
                String numeroTelefono = "+542954376566";
                dialHacerLlamada(numeroTelefono);
            }
            private void dialHacerLlamada(String numeroTelefono){
                Uri uri = Uri.parse("tel:" + numeroTelefono);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                if(intent.resolveActivity(getPackageManager()) !=  null){
                    startActivity(intent);
                }
            }
        });



   click =  findViewById(R.id.btnMail);

        click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(sobrenosActivity.this, emailActivity.class));
                }
            });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }
    @Override
    public void onBackPressed()
    {

    }
}





