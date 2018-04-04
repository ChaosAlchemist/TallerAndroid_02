package com.example.chaos.tallerandroid_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("Menú Notas");
    }

    public void btnVerEstadisticasOnClick(View v){
        // Redirigir a Ver Estadísticas
        Intent i = new Intent(MenuActivity.this, VerEstadisticasActivity.class);
        startActivity(i);

    }
}
