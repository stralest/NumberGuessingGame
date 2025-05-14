module org.example.igrapogadjanjabrojeva {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jsoup;

    opens org.example.igrapogadjanjabrojeva.model to javafx.base;
    opens org.example.igrapogadjanjabrojeva to javafx.fxml;

    exports org.example.igrapogadjanjabrojeva;
    exports org.example.igrapogadjanjabrojeva.utils;
}