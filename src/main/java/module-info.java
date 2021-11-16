module com.example.second_webdata {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.second_webdata to javafx.fxml, com.google.gson;
    exports com.example.second_webdata;
}