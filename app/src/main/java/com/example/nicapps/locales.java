package com.example.nicapps;

public class locales {
    private String direccion;
    private String telefono;
    private String cantidadLocales;
    private String sugerencias;

    private String nombre;

    public locales() {
    }

    public locales(String cantidadLocales, String direccion, String nombre,String sugerencias,String telefono) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.cantidadLocales = cantidadLocales;
        this.sugerencias = sugerencias;
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCantidadLocales() {
        return cantidadLocales;
    }

    public String getSugerencias() {
        return sugerencias;
    }

    public String getNombre() {
        return nombre;
    }
}
