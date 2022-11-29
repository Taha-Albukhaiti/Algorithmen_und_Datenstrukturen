module com.taha_albukhaiti.algorithmen_und_datenstrukturen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.taha_albukhaiti.algorithmen_und_datenstrukturen to javafx.fxml;
    exports com.taha_albukhaiti.algorithmen_und_datenstrukturen;
    exports sorting;
    opens sorting to javafx.fxml;
    exports search;
    opens search to javafx.fxml;
}