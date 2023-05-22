package com.example.myapp1;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class emailActivity extends Activity {


            EditText editTextTo,editTextSubject,editTextMessage;
        Button send,volver;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_email);

            editTextTo=(EditText)findViewById(R.id.to);
            editTextSubject=(EditText)findViewById(R.id.subject);
            editTextMessage=(EditText)findViewById(R.id.message);

            send=(Button)findViewById(R.id.btnEnviar);
            volver=(Button)findViewById(R.id.btnVolver);
            send.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View arg0) {
                    String to=editTextTo.getText().toString();
                    String subject=editTextSubject.getText().toString();
                    String message=editTextMessage.getText().toString();


                    Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","federicotrani@ites.org", null));
                   email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(Intent.createChooser(email, "Elije un cliente de Mail:"));

                    //need this to prompts email client only
                    email.setType("message/rfc822");



                }

            });
            volver.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View arg0) {
                    onBackPressed();

                }

            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_item, menu);
            return true;
        }

    }

