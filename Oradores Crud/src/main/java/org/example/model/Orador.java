package org.example.model;

import java.util.Date;

public class Orador {

    private Long id;
    private String nombre;
    private String apellido;
    private String tema;
    private Date fecha;

    public Orador() {
    }

    public Orador(String mateo, String carrizo, String seguridad, String s) {
    }

    public Orador(Long id, String nombre, String apellido, String tema, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
        this.fecha = fecha;
    }

    public Orador(String nombre, String apellido, String tema, Date fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tema = tema;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + apellido +" "+ tema +" "+ fecha ;
    }
}
