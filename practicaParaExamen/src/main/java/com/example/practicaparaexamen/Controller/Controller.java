package com.example.practicaparaexamen.Controller;

import com.example.practicaparaexamen.Model.Contacto;
import com.example.practicaparaexamen.Model.ContactoService;
import com.example.practicaparaexamen.Model.ContactoService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML private TextField txtName;
    @FXML private TextField txtPhone;
    @FXML private ComboBox<String> cbParentezco;
    @FXML private ListView<String> lvlContactos;

    private ContactoService service = new ContactoService();

    private String[] parentescos = {"Padre","Madre","Hermano","Hermana","Abuelo","Abuela","Tio","Tia"};

    @FXML
    public void initialize(){
        cbParentezco.getItems().addAll(parentescos);
    }

    @FXML
    public void onAdd(){
        Contacto contacto = new Contacto(txtName.getText(), txtPhone.getText(), cbParentezco.getValue());
        if(service.addContacto(contacto)){
            lvlContactos.getItems().add(contacto.toString());
            onClean();
        } else {
            System.out.println("Contacto inválido o duplicado");
        }
    }

    @FXML
    public void onSearch(){
        Contacto c = service.searchContacto(txtName.getText());
        if(c != null){
            txtName.setText(c.getName());
            txtPhone.setText(c.getPhone());
            cbParentezco.setValue(c.getParentesco());
        } else {
            System.out.println("Contacto no encontrado");
        }
    }

    @FXML
    public void onUpdate(){
        if(service.updateContacto(txtName.getText(), txtPhone.getText(), cbParentezco.getValue())){
            lvlContactos.getItems().clear();
            service.getAll().forEach(contact -> lvlContactos.getItems().add(contact.toString()));
            System.out.println("Contacto actualizado con éxito");
        } else {
            System.out.println("No se pudo actualizar el contacto");
        }
    }

    @FXML
    public void onDelete(){
        if(service.deleteContacto(txtName.getText())){
            lvlContactos.getItems().clear();
            service.getAll().forEach(contact -> lvlContactos.getItems().add(contact.toString()));
            onClean();
            System.out.println("Contacto eliminado con éxito");
        } else {
            System.out.println("No se pudo eliminar el contacto");
        }
    }

    @FXML
    public void onClean(){
        txtName.clear();
        txtPhone.clear();
        cbParentezco.setValue(null);
    }

    @FXML
    public void onClearAll(){
        service.clearAll();
        lvlContactos.getItems().clear();
        onClean();
    }
}