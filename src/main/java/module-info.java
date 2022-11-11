module com.taha_albukhaiti.algorithmen_und_datenstrukturen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.taha_albukhaiti.algorithmen_und_datenstrukturen to javafx.fxml;
    exports com.taha_albukhaiti.algorithmen_und_datenstrukturen;
    exports datastructures;
    opens datastructures to javafx.fxml;
    exports search;
    opens search to javafx.fxml;
}