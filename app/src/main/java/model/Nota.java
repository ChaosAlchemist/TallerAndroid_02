package model;

public class Nota {
    float valor;
    int porcentaje;

    public Nota(float valor, int porcentaje) {
        this.valor = valor;
        this.porcentaje = porcentaje;
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
        return "Nota{" +
                "valor=" + valor +
                ", porcentaje=" + porcentaje +
                '}';
    }
}
