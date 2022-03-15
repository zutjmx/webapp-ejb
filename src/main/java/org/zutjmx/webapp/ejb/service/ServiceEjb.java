package org.zutjmx.webapp.ejb.service;

import jakarta.ejb.Stateless;

@Stateless
public class ServiceEjb {
    public String saludar(String nombre) {
        System.out.println(":: Dentro del ejb con instancia: "+this+" ::");
        return ":: Hola ".concat(nombre).concat(", buen día ::");
    }
}
