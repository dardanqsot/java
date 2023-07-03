package org.dardan.webapp.ear.ejb.repositories;

import org.dardan.webapp.ear.ejb.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}
