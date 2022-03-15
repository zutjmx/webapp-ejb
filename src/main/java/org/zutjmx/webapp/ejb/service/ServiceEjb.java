package org.zutjmx.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.RequestScoped;
//import jakarta.ejb.Stateless;

@RequestScoped
@Stateful
public class ServiceEjb {

    private int contador;

    public String saludar(String nombre) {
        System.out.println(":: Dentro del ejb con instancia: "+this+" ::");
        contador++;
        System.out.println(":: Valor del contador en el método saludar: " + contador + " ::");
        return ":: Hola ".concat(nombre).concat(", buen día ::");
    }
}
