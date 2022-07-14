module com.taha_albukhaiti.algorithmen_und_datenstrukturen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.taha_albukhaiti.algorithmen_und_datenstrukturen to javafx.fxml;
    exports com.taha_albukhaiti.algorithmen_und_datenstrukturen;
}