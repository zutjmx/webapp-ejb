package org.zutjmx.webapp.ejb.service;

import jakarta.ejb.Stateless;
import org.zutjmx.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

//@RequestScoped
@Stateless
public class ServiceEjb implements ServiceEjbLocal {

    private int contador;

    public String saludar(String nombre) {
        System.out.println(":: Dentro del ejb con instancia: "+this+" ::");
        contador++;
        System.out.println(":: Valor del contador en el método saludar: " + contador + " ::");
        return ":: Hola ".concat(nombre).concat(", buen día ::");
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Papaya"));
        productos.add(new Producto("Pitaya"));
        productos.add(new Producto("Guayaba"));
        productos.add(new Producto("Guanabana"));
        productos.add(new Producto("Boniato"));
        productos.add(new Producto("Yuca"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println(":: Guardando producto: " + producto + " ::");
        Producto productoNuevo = new Producto();
        productoNuevo.setNombre(producto.getNombre());
        return productoNuevo;
    }

}
