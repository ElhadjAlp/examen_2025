module com.ism {
    requires javafx.controls;
    requires transitive javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires org.yaml.snakeyaml;
    requires java.persistence;
    requires lombok;

    // Assurez-vous que tous les paquets nécessaires sont ouverts et exportés correctement.
    opens com.ism to javafx.fxml;  // Ouvre le paquet principal à javafx.fxml
    opens com.ism.Controllers.Impl to javafx.fxml;  // Ouvre com.ism.Controllers.Impl à javafx.fxml pour la réflexion
    opens com.ism.data.entites to javafx.fxml;  // Ouvre com.ism.data.entites à javafx.fxml

    exports com.ism;  // Exporte le paquet principal
    exports com.ism.Controllers.Impl;  // Exporte com.ism.Controllers.Impl
    exports com.ism.data.entites;  // Exporte com.ism.data.entites
}


