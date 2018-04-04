package com.example.chaos.tallerandroid_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Sistema Notas");
    }

    public void btnIngresarMenuOnClick(View v){
        // Verificar usuario y contraseña
        // !!

        // Redirigir al menú si está OK
        Intent i = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(i);

    }
}
