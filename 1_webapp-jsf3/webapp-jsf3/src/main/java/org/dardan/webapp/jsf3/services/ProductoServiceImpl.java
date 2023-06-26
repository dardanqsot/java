package org.dardan.webapp.jsf3.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.dardan.webapp.jsf3.entities.Producto;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductoServiceImpl implements ProductoService {


    @Override
    public List<Producto> listar() {
        return null;
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.empty();
    }
}
