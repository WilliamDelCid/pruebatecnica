package com.pruebatecnica.springmvc.model;

public class Usuarios {
    private Integer idUser;
    private String user;
    private String password;
    private String rol;

    public Usuarios() {
    }

    public Usuarios(String user, String password, String rol) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public Usuarios(Integer idUser, String user, String password, String rol) {
        this.idUser = idUser;
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
