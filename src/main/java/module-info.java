module org.example.sistemavotos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.sistemavotos to javafx.fxml;
    exports org.example.sistemavotos;
}