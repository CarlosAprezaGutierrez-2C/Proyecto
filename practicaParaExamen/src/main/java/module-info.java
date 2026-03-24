module com.example.practicaparaexamen {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
   opens com.example.practicaparaexamen.Controller to javafx.fxml;
   opens com.example.practicaparaexamen.Model to javafx.fxml;

    opens com.example.practicaparaexamen to javafx.fxml;
    exports com.example.practicaparaexamen;
}