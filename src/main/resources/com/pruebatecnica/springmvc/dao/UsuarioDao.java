package com.pruebatecnica.springmvc.dao;

import com.pruebatecnica.springmvc.model.Usuarios;

import java.util.List;

public interface UsuarioDao {
    public int guardar(Usuarios usuarios);
    public int actualizar(Usuarios usarios);
    public Usuarios obtener(Integer id);
    public int eliminar(Integer id);
    public List<Usuarios> list();
    public Usuarios obtenerUser(String name);

}
