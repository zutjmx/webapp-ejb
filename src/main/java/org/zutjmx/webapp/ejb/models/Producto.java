package org.zutjmx.webapp.ejb.models;

public class Producto {
    public String nombre;

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto {" +
                "nombre = '" + nombre + '\'' +
                '}';
    }
}
