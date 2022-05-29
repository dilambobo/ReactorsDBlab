module com.example.reactorslaba {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;
    requires java.sql;


    opens com.example.reactorslaba to javafx.fxml;
    exports com.example.reactorslaba;
    exports com.example.reactorslaba.jsonObjects;
    opens com.example.reactorslaba.jsonObjects to javafx.fxml;
}