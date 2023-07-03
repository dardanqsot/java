package org.dardan.webapp.ejb.service;

import jakarta.ejb.Local;
import org.dardan.webapp.ejb.models.Producto;

import java.util.List;

@Local
public interface ServiceEjbLocal {
    String saludar(String nombre);
    List<Producto> listar();
    Producto crear(Producto producto);
}
