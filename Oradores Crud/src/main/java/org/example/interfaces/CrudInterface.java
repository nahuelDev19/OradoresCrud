package org.example.interfaces;

import org.example.model.Orador;

import java.util.List;

public interface CrudInterface <T>{

    public List<T> listar();
    public T buscarId(Long id);
    public void guardar(Orador t);
    public void eliminar(Long id);
}
