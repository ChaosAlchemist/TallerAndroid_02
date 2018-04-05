package model;

public class Data {
    private String clave;

    public Data() {
        this.clave = "123456";
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