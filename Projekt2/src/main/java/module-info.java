module com.mycompany.projekt2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.projekt2 to javafx.fxml;
    exports com.mycompany.projekt2;
    requires javafx.graphicsEmpty;
}