module app {
    requires javafx.controls;
    requires javafx.fxml;

    opens app to javafx.fxml;
    exports app;
    opens view to javafx.fxml; 
    exports view;              
    opens model to javafx.fxml; 
}