package com.example.practicaparaexamen2.Controller;
import com.example.practicaparaexamen2.Repositorie.Repositorie;
import com.example.practicaparaexamen2.Model.ObjetoPerdido;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.List;

public class Controller {

@FXML 
private ListView <ObjetoPerdido>  lvlObjects;
@FXML private Button btnAdd;
@FXML private TextField txtName;
@FXML private TextField txtLugar;
@FXML private Button btnSearch;
@FXML private Button btnDelete;
@FXML private Button btnUpdate;
@FXML private Button btnClean;
@FXML private ComboBox<String> cmbEstado;
private Repositorie repo = new Repositorie();
@FXML 
public void initialize() {
String[] listaEstado={"Activo","Inactivo"};
cmbEstado.getItems().addAll(listaEstado);

}
@FXML
public void addPeople(){
if (!validarCampos()) return;
ObjetoPerdido obj1=new ObjetoPerdido(txtName.getText(),txtLugar.getText(),cmbEstado.getValue());
repo.AgregarPersonas(obj1);
lvlObjects.setItems(repo.getLista());
clean();
}

@FXML
public void searchPeople(){
String nombre=txtName.getText();
if (nombre.isEmpty()){
    System.out.println("El nombre no puede estar vacio");
 return;
}
ObjetoPerdido obj1=repo.buscarObjetoPerdido(nombre);
if (obj1!=null){
txtName.setText(obj1.getNombre());
txtLugar.setText(obj1.getLugar());
cmbEstado.setValue(obj1.getEstado());
}else{
System.out.println("objeto no encontrado");
}
clean();
}

@FXML
public void actualizarPeople(){
String nombre=txtName.getText();
if (!validarCampos())return;
ObjetoPerdido obj1=new ObjetoPerdido(txtName.getText(),txtLugar.getText(),cmbEstado.getValue());
    repo.actualizar(nombre, obj1);
    lvlObjects.setItems(repo.getLista());
clean();

}



public boolean validarCampos(){
if (txtName.getText().isEmpty() || txtLugar.getText().isEmpty() || cmbEstado.getValue()==null){
    return false;
}
return true;
}
public void clean(){
txtName.clear();
txtLugar.clear();
cmbEstado.getSelectionModel().clearSelection();
lvlObjects.getSelectionModel().clearSelection();

}
}
