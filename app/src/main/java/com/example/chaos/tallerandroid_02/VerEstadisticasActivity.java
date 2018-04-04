package com.example.chaos.tallerandroid_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class VerEstadisticasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_estadisticas);
        setTitle("Estadísticas");
    }

    public void btnVolverOnClick(View v){
        // Redirigir a Menú
        Intent i = new Intent(VerEstadisticasActivity.this, MenuActivity.class);
        startActivity(i);

    }
}
