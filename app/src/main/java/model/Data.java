package model;

import java.util.List;

public class Data {
    private List<Nota> notas;
    private String clave;

    public Data() {
        this.clave = "123456";
        this.notas = notas;
    }

    public List<Nota> getNotas(){
        return notas;
    }

    public String getPass() {
        return this.clave;
    }

    public boolean login(String pass) {
        if (pass.equals(clave)) {
            //Entro
            return true;
        } else {
            //Clave Incorrecta
            return false;
        }

    }
}