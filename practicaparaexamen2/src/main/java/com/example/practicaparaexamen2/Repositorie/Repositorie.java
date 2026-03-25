package com.example.practicaparaexamen2.Repositorie;

import com.example.practicaparaexamen2.Model.ObjetoPerdido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Repositorie {
private final String NOMBRE_ARCHIVO = "objetos_perdidos.txt";
public ObservableList<ObjetoPerdido> lista;


public Repositorie(){
lista= FXCollections.observableArrayList();
}
public void AgregarPersonas(ObjetoPerdido objetoPerdido1){
   for (ObjetoPerdido obje:lista){
      if (obje.getNombre().equalsIgnoreCase(objetoPerdido1.getNombre())){
         return;      
   }
   }
      lista.add(objetoPerdido1);

}

public ObjetoPerdido buscarObjetoPerdido(String nombre ){
 for (ObjetoPerdido obje:lista){
 
 if (obje.getNombre().equalsIgnoreCase(nombre)){
   return obje;
 }
 }
return null;
    }
    
 public ObjetoPerdido eliminar(String nombre) {
    ObjetoPerdido obj = buscarObjetoPerdido(nombre); 
    if (obj != null) {
        lista.remove(obj); 
        return obj;       
    }
    return null;
}
public void actualizar(String nombre, ObjetoPerdido nuevoObjeto){
    ObjetoPerdido obj = buscarObjetoPerdido(nombre);
    if(obj != null){
        eliminar(nombre);       
         AgregarPersonas(nuevoObjeto);   
    }
}

  public ObservableList<ObjetoPerdido> getLista() {
        return lista;

    }
    public void cargarArchivo() throws IOException {
    File archivo = new File("canciones.txt");
    if (!archivo.exists()) return; // si no existe, no hace nada

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(";"); // separa por punto y coma
            if (partes.length == 3) {
                ObjetoPerdido c = new ObjetoPerdido(partes[0], partes[1], partes[2]);
                lista.add(c); // canciones = ObservableList
            }
        }
    }
    }
    
    
    
}





