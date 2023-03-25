module com.example.projeto03javafz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.projeto03javafz to javafx.fxml;
    exports com.example.projeto03javafz;
}