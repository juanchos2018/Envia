package com.example.envia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    EditText edt_msj;
    Button btn_enviar;
    RadioButton rd1,rd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        rd1=(RadioButton)findViewById((R.id.opcion1));
        rd2=(RadioButton)findViewById((R.id.opcion2));

        final String nombre="calavera 2";

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,nombre);



             /*   if (rd1.isChecked()){
                    sendIntent.putExtra(Intent.EXTRA_TEXT, rd1.getText().toString());
                }if (rd2.isChecked()){
                    sendIntent.putExtra(Intent.EXTRA_TEXT, rd2.getText().toString());
                }*/


                sendIntent.setType("text/plain");
                if (null != sendIntent.resolveActivity(getPackageManager())) {
                    startActivity(Intent.createChooser(
                            sendIntent, getResources().getText(R.string.send_to)
                    ));
                }
            }
        });
    }
}
