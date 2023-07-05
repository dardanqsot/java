package org.dardan.apiservlet.webapp.headers.services;

import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import org.dardan.apiservlet.webapp.headers.configs.Service;
import org.dardan.apiservlet.webapp.headers.models.entities.Usuario;
import org.dardan.apiservlet.webapp.headers.repositories.RepositoryJpa;
import org.dardan.apiservlet.webapp.headers.repositories.UsuarioRepository;

import java.util.Optional;

@Service
@Stateful
public class UsuarioServiceImpl implements UsuarioService{
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username)).filter(u -> u.getPassword().equals(password));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
