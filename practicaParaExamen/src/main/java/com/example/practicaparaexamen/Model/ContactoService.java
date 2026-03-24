package com.example.practicaparaexamen.Model;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {
    private List<Contacto> listaContactos = new ArrayList<>();
  
     public boolean validate(Contacto contacto){
        if (contacto.getName() == null || contacto.getName().isEmpty()
            || contacto.getParentesco() == null || contacto.getPhone() == null || contacto.getPhone().isEmpty())
            return false;
        try {
            Long.parseLong(contacto.getPhone());
        } catch (NumberFormatException e) {
            return false;
        }
        return contacto.getPhone().length() == 10;
    }
    
    public boolean addContacto(Contacto contacto) {
   
    if (!validate(contacto)) return false;

    for (Contacto c : listaContactos) {
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
        for(Contacto c : listaContactos){
            if(c.getName().equalsIgnoreCase(name)) return c;
        }
        return null;
    }

    public boolean updateContacto(String name, String phone, String parentesco){
        Contacto c = searchContacto(name);
        if(c == null) return false;
        c.setPhone(phone);
        c.setParentesco(parentesco);
        return true;
    }

    public boolean deleteContacto(String name){
        Contacto c = searchContacto(name);
        if(c == null) return false;
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