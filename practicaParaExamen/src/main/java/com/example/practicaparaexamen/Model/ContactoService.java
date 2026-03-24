package com.example.practicaparaexamen.Model;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {

    private List<Contacto> listaContactos = new ArrayList<>();

public boolean validate(Contacto contacto){

    if (contacto.getName() == null || contacto.getName().isEmpty()){
        return false;
    }

    if (contacto.getParentesco() == null){
        return false;
    }

    if (contacto.getPhone() == null || contacto.getPhone().isEmpty()){
        return false;
    }

    if(contacto.getPhone().length() != 10){
        return false;
    }

    
    for(int i = 0; i < contacto.getPhone().length(); i++){

        char c = contacto.getPhone().charAt(i);

        if(c < '0' || c > '9'){
            return false;
        }}

    return true;
}
    public boolean addContacto(Contacto contacto) {

        if (!validate(contacto)){
            return false;
        }

        for (int i = 0; i < listaContactos.size(); i++) {

            Contacto c = listaContactos.get(i);

            if (c.getName().equalsIgnoreCase(contacto.getName())
                    && c.getPhone().equals(contacto.getPhone())
                    && c.getParentesco().equalsIgnoreCase(contacto.getParentesco())) {

                return false;
            }
        }

        listaContactos.add(contacto);
        return true;
    }

    public Contacto searchContacto(String name){

        for(int i = 0; i < listaContactos.size(); i++){

            Contacto c = listaContactos.get(i);

            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }

        return null;
    }

    public boolean updateContacto(String name, String phone, String parentesco){

        Contacto c = searchContacto(name);

        if(c == null){
            return false;
        }

        c.setPhone(phone);
        c.setParentesco(parentesco);

        return true;
    }

    public boolean deleteContacto(String name){

        Contacto c = searchContacto(name);

        if(c == null){
            return false;
        }

        listaContactos.remove(c);
        return true;
    }

    public void clearAll(){
        listaContactos.clear();
    }

    public List<Contacto> getAll(){
        return listaContactos;
    }
}