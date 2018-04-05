package model;


public class Nota {
    private int id;
    private float valor;
    private int porcentaje;


    public Nota(int id, float valor, int porcentaje) {
        this.id = id;
        this.valor = valor;
        this.porcentaje = porcentaje;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "N" + this.id + ": → " + this.valor + " → (" + this.porcentaje + ")%";
    }
}
