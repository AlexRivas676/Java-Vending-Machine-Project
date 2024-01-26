module com.example.vending_machine {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.vending_machine to javafx.fxml;
    exports com.example.vending_machine;
}