package com.example.chaos.tallerandroid_02;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import model.Data;
import model.Nota;

public class MenuActivity extends AppCompatActivity {
    private Data data;
    private ListView listNotas;
    private List<Nota> notas;
    private EditText txtNota;
    private EditText txtPorcentaje;
    private int contador;
    private int porcentajeTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("Ingresar Notas");
        cargarComponentes();
        cargarListaView();
    }

    private void cargarComponentes() {
        txtNota = (EditText) findViewById(R.id.txtNota);
        txtPorcentaje = (EditText) findViewById(R.id.txtPorcentaje);
        listNotas = (ListView) findViewById(R.id.listNotas);
        contador = 1;
        porcentajeTotal = 0;
        notas = new ArrayList<>();

    }

    private void cargarListaView() {
        ArrayAdapter<Nota> adapter;

        adapter = new ArrayAdapter<Nota>(
                this,
                android.R.layout.simple_list_item_1,
                notas
        );

        listNotas.setAdapter(adapter);
    }

    private void calcularPromedio() {
        float promedio = 0;

        for (Nota n : notas) {
            promedio += (n.getValor() * n.getPorcentaje() / 100);
        }

        TextView lblPromedioActual = findViewById(R.id.lblPromedioActual);
        lblPromedioActual.setText(String.format("%.1f", promedio));

        if (promedio >= 4f) {
            lblPromedioActual.setTextColor(Color.BLUE);
            calcularSituacion(true);
        } else {
            lblPromedioActual.setTextColor(Color.RED);
            calcularSituacion(false);
        }
    }

    private void setNotaMayorMenor() {
        float nAlta = 0;
        float nBaja = 7;

        for (Nota n : notas) {
            if (n.getValor() > nAlta) {
                nAlta = n.getValor();
            }

            if (n.getValor() < nBaja) {
                nBaja = n.getValor();
            }
        }

        TextView lblNotaMasAlta = findViewById(R.id.lblNotaMasAlta);
        TextView lblNotaMasBaja = findViewById(R.id.lblNotaMasBaja);

        lblNotaMasAlta.setText(String.format("%.1f", nAlta));
        lblNotaMasBaja.setText(String.format("%.1f", nBaja));
    }

    private void calcularSituacion(boolean aprobado) {
        int suma = 0;
        for (Nota n : notas) {
            suma += n.getPorcentaje();
        }

        TextView lblSituacion = findViewById(R.id.lblSituacion);

        if (suma < 100) {
            lblSituacion.setText("Faltan notas por agregar.");
        } else {
            if (aprobado) {
                lblSituacion.setText("Aprobado.");
                lblSituacion.setTextColor(Color.BLUE);
            } else {
                lblSituacion.setText("Reprobado.");
                lblSituacion.setTextColor(Color.RED);
            }

        }
    }

    private void calcularPorcentajes() {
        int cAzul = 0;
        int cRojo = 0;
        int total = 0;
        int porcentajeAzul;
        int porcentajeRojo;

        for (Nota n : notas) {
            if (n.getValor() >= 4f) {
                cAzul++;
            } else {
                cRojo++;
            }
        }

        total = notas.size();
        porcentajeAzul = ((cAzul * 100) / total);
        porcentajeRojo = ((cRojo * 100) / total);

        TextView lblNotasIngresadas = findViewById(R.id.lblNotasIngresadas);
        TextView lblPorcentajeAzules = findViewById(R.id.lblPorcentajeAzules);
        TextView lblPorcentajeRojos = findViewById(R.id.lblPorcentajeRojos);

        lblNotasIngresadas.setText(String.valueOf(total));
        lblPorcentajeAzules.setText(porcentajeAzul + "%");
        lblPorcentajeRojos.setText(porcentajeRojo + "%");


    }

    private void calcularEstadisticas() {
        calcularPromedio();
        setNotaMayorMenor();
        calcularPorcentajes();


    }

    public void btnIngresarNotaOnClick(View v) {
        String notaStr = txtNota.getText().toString();
        String pcjeStr = txtPorcentaje.getText().toString();


        if (notaStr.equals(null) || notaStr.equals("") || pcjeStr.equals(null) || pcjeStr.equals("")) {
            Toast.makeText(this,
                    "Rellene todos los campos antes de continuar",
                    Toast.LENGTH_SHORT).show();
        } else {
            float nota = Float.parseFloat(txtNota.getText().toString());
            int porcentaje = Integer.parseInt(txtPorcentaje.getText().toString());

            if (nota > 7f) {
                Toast.makeText(this,
                        "La nota no puede superar a 7.0",
                        Toast.LENGTH_SHORT).show();
            } else if (porcentaje > 100) {
                Toast.makeText(this,
                        "El porcentaje no puede superar el 100%",
                        Toast.LENGTH_SHORT).show();
            } else {
                porcentajeTotal += porcentaje;
                if (porcentajeTotal <= 100) {
                    Nota n = new Nota(contador, nota, porcentaje);
                    notas.add(n);
                    cargarListaView();
                    contador++;

                    TextView lblPorcentajeaActual = findViewById(R.id.lblPorcentajeaActual);

                    lblPorcentajeaActual.setText(porcentajeTotal+ "% Actual");

                    txtNota.setText("");
                    txtPorcentaje.setText("");

                    calcularEstadisticas();
                } else {
                    int sobra = (porcentajeTotal - 100);
                    Toast.makeText(this,
                            "Porcentaje máximo sobrepasado por un " + sobra + "%",
                            Toast.LENGTH_SHORT).show();
                    porcentajeTotal -= porcentaje;
                }
            }
        }

    }
}
