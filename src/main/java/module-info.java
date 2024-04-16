module org.example.runme {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.runme to javafx.fxml;
    exports org.example.runme;
}