module com.mycompany.zoo2aplication {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.zoo2aplication to javafx.fxml;
    exports com.mycompany.zoo2aplication;
}
