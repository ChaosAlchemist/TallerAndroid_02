package com.example.chaos.tallerandroid_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

import model.Data;

public class MainActivity extends AppCompatActivity {
    private Data data;
    private EditText txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Sistema Notas");

        data = new Data();
        txtPassword = (EditText) findViewById(R.id.txtPassword);

    }

    public void btnIngresarMenuOnClick(View v) {
        String pass = txtPassword.getText().toString();
        Boolean login = data.login(pass);

        // Verificar usuario y contraseña
        if (login) {
            // Redirigir al menú si está OK
            Intent i = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(i);
        } else {
            Toast mensaje =
                    Toast.makeText(getApplicationContext(),
                            "La contraseña es incorrecta",
                            Toast.LENGTH_SHORT);
            mensaje.setGravity(Gravity.CENTER | Gravity.CENTER, 0, 0);
            mensaje.show();
            txtPassword.setText("");
        }
    }

    public void btnTopSecretOnClick(View v) {
        Intent i = new Intent(MainActivity.this, RecyclerViewActivity.class);
        startActivity(i);
    }
}
