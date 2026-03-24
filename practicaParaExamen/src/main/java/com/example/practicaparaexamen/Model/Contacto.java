package com.example.practicaparaexamen.Model;

import java.util.ArrayList;

public class Contacto {
private String name;
private String phone;
private String parentesco;
public Contacto(String name, String phone, String parentesco){
this.name=name;
this.phone=phone;
this.parentesco=parentesco;
}

public String getName() {return name;}
public void setName(String name) {this.name = name;}
public String getPhone() {return phone;}
public void setPhone(String phone) {this.phone = phone;}
public String getParentesco() {return parentesco;}
public void setParentesco(String parentesco) {this.parentesco = parentesco;}

    @Override
public String toString() {
    return "Nombre: " + name + " | Teléfono: " + phone + " | Parentesco: " + parentesco;
}
    public boolean validate(){
    if (name.isEmpty() || parentesco==null || phone.isEmpty()  ){
     return false;
     }
         try {
         Long.parseLong(phone);
          
          } catch (NumberFormatException e) {
           return false;
          }

     if (phone.length() !=10){
     return false;
      }
      return true;
}
}



