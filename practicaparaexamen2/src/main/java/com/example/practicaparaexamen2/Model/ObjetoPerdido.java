package com.example.practicaparaexamen2.Model;

public class ObjetoPerdido {
private String nombre;
   private String lugar;
   private String estado;

public String getNombre() {return nombre;}
public void setNombre(String nombre) {this.nombre = nombre;}
public String getLugar() {return lugar;}
public void setLugar(String lugar) {this.lugar = lugar;}
public String getEstado() {return estado;}
public void setEstado(String estado) {this.estado = estado;}
public ObjetoPerdido(String name,String lugar,String estado) {
this.nombre=name;
this.lugar=lugar;
this.estado=estado;
}

    @Override
    public String toString() {
        return "ObjetoPerdido" +
                "nombre='" + nombre + ' ' +
                ", lugar='" + lugar + ' ' +
                ", estado='" + estado + ' ' +
                '}';
    }
    
    
    
    
}
