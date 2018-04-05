
package com.example.chaos.tallerandroid_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private ArrayList<String> juegos;
    private RecyclerView rvRecyclerView;
    private RecyclerView.LayoutManager rvLayoutManager;
    private RecyclerView.Adapter rvAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        setTitle("RecyclerView: Top Secret");

        cargarLista();
        cargarRecycleView();
        
    }
    
    private void cargarLista(){
        juegos = new ArrayList<>();
        juegos.add("Age of Empires II");
        juegos.add("Dark Souls");
        juegos.add("Fortnite");
        juegos.add("Heroes of the Storm");
    }

    private void cargarRecycleView(){
        rvRecyclerView = findViewById(R.id.rvJuegos);
        rvRecyclerView.setHasFixedSize(true);

        // Inicializa el layout linear y el adaptador.
        rvLayoutManager = new LinearLayoutManager(this);
        rvAdapter = new JuegoAdapter(juegos);

        // Setea el layout y linear para el RecyclerView.
        rvRecyclerView.setLayoutManager(rvLayoutManager);
        rvRecyclerView.setAdapter(rvAdapter);
    }

    public void btnVolverRVOnClick(View view){
        Intent i = new Intent(RecyclerViewActivity.this, MainActivity.class);
        startActivity(i);
    }
}
