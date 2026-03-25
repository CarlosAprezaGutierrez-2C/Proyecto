module com.example.practicaparaexamen2 {
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
    requires javafx.base;

opens com.example.practicaparaexamen2.Controller to javafx.fxml;
    opens com.example.practicaparaexamen2.Model to javafx.base;

    opens com.example.practicaparaexamen2 to javafx.fxml;
    exports com.example.practicaparaexamen2;
}