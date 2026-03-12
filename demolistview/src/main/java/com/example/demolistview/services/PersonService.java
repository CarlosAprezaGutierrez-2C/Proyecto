package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();

        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);

            String name = parts[0].trim();
            String correo = parts[1].trim();

            String edad = "Sin edad";

            if (parts.length > 2) {
                edad = parts[2].trim();
            }

            result.add(name + " - " + correo + " - " + edad);
        }

        return result;
    }

    public void addPerson(String name, String email,int edad) throws IOException {
        validatePerson(name, email,edad);
        String Name= name.replace(",","");
        String emailNoComa= email.replace(",","");
        int edadComa= edad ;
        repo.appendNewLine(Name+","+emailNoComa+","+edadComa);
    }

    private void validatePerson(String name, String email,int edad){
         if (edad<0 || edad<18 || edad>100 ){
             throw new IllegalArgumentException("La persona no puede ser menor de edad y tampoco se puede agregar una persona" +
                     " con numeros negativos");
         }
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank()|| !em.contains("@") || ! em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");
        }

    }
}