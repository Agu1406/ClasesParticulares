module org.agu1406.clasesjavafxgradle {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.agu1406.clasesjavafxgradle to javafx.fxml;
    exports org.agu1406.clasesjavafxgradle;
}