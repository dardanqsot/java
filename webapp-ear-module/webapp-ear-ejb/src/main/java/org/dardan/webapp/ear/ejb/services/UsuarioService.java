package org.dardan.webapp.ear.ejb.services;

import jakarta.ejb.Local;
import org.dardan.webapp.ear.ejb.entities.Usuario;

import java.util.List;

@Local
public interface UsuarioService {
    List<Usuario> listar();
}
