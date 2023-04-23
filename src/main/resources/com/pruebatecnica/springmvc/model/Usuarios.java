package com.pruebatecnica.springmvc.model;

public class Usuarios {
    private int idUser;
    private String user;
    private String password;

    public Usuarios() {
    }
    public Usuarios(int idUser, String user, String password) {
        this.idUser = idUser;
        this.user = user;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
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

    public void setPassword(String password) {
        this.password = password;
    }
}
