package org.dardan.webapp.ejb.controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dardan.webapp.ejb.models.Producto;
import org.dardan.webapp.ejb.service.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceEjbLocal service = null;
        ServiceEjbLocal service2 = null;
        try {
            InitialContext ctx = new InitialContext();
            service = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.dardan.webapp.ejb.service.ServiceEjbLocal");
            service2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.dardan.webapp.ejb.service.ServiceEjbLocal");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        System.out.println("service si es igual a service2 = " + service.equals(service2));

        Producto  p = service.crear(new Producto("uvas"));
        System.out.println("nuevo producto " + p);

        req.setAttribute("saludo", service.saludar("Darwin"));
        req.setAttribute("saludo2", service2.saludar("Daniel"));
        req.setAttribute("listado", service.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
