module com.convertidor {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.convertidor to javafx.fxml;
    exports com.convertidor;
}
