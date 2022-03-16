package org.zutjmx.webapp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.zutjmx.webapp.ejb.service.ServiceEjb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    /*@Inject
    private ServiceEjb serviceEjbUno;

    @Inject
    private ServiceEjb serviceEjbDos;*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjb serviceEjbUno = null;
        ServiceEjb serviceEjbDos = null;

        try {
            InitialContext initialContext = new InitialContext();
            serviceEjbUno = (ServiceEjb) initialContext.lookup("java:global/webapp-ejb/ServiceEjb!org.zutjmx.webapp.ejb.service.ServiceEjb");
            serviceEjbDos = (ServiceEjb) initialContext.lookup("java:global/webapp-ejb/ServiceEjb!org.zutjmx.webapp.ejb.service.ServiceEjb");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        System.out.println(":: Comparación entre serviceEjbUno y serviceEjbDos: " +
                serviceEjbUno.equals(serviceEjbDos) + " ::");

        req.setAttribute("saludoUno", serviceEjbUno.saludar("Jesús Zúñiga Trejo"));
        req.setAttribute("saludoDos", serviceEjbDos.saludar("Ana María Alejandre Arroyo"));

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(req,resp);

    }
}
