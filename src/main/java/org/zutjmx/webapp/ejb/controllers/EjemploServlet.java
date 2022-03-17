package org.zutjmx.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zutjmx.webapp.ejb.models.Producto;
import org.zutjmx.webapp.ejb.service.ServiceEjb;
import org.zutjmx.webapp.ejb.service.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    /*@Inject
    private ServiceEjbLocal serviceEjbUno;

    @Inject
    private ServiceEjbLocal serviceEjbDos;*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjbLocal serviceEjbUno = null;
        ServiceEjbLocal serviceEjbDos = null;

        try {
            InitialContext initialContext = new InitialContext();
            serviceEjbUno = (ServiceEjb) initialContext.lookup("java:global/webapp-ejb/ServiceEjb!org.zutjmx.webapp.ejb.service.ServiceEjbLocal");
            serviceEjbDos = (ServiceEjb) initialContext.lookup("java:global/webapp-ejb/ServiceEjb!org.zutjmx.webapp.ejb.service.ServiceEjbLocal");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        System.out.println(":: Comparación entre serviceEjbUno y serviceEjbDos: " +
                serviceEjbUno.equals(serviceEjbDos) + " ::");

        Producto producto = serviceEjbUno.crear(new Producto("Plátano"));
        System.out.println(":: Nuevo producto: " + producto + " ::");

        req.setAttribute("saludoUno", serviceEjbUno.saludar("Jesús Zúñiga Trejo"));
        req.setAttribute("saludoDos", serviceEjbDos.saludar("Ana María Alejandre Arroyo"));
        req.setAttribute("listado", serviceEjbDos.listar());


        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(req,resp);

    }
}
