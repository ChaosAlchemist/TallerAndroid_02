package com.example.chaos.tallerandroid_02;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class JuegoAdapter extends RecyclerView.Adapter<JuegoAdapter.ViewHolder> {
    private ArrayList<String> juegos;

    public JuegoAdapter(ArrayList<String> juegos) {
        this.juegos = juegos;
    }

    @NonNull
    @Override
    public JuegoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JuegoAdapter.ViewHolder holder, int position) {
        holder.lblJuego.setText(juegos.get(position));
    }

    @Override
    public int getItemCount() {
        return juegos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView lblJuego;

        public ViewHolder(View itemView) {
            super(itemView);

            lblJuego = (TextView) itemView.findViewById(R.id.lblJuego);
        }
    }
}
