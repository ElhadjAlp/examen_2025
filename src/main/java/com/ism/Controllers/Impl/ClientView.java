package com.ism.Controllers.Impl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import com.ism.Controllers.IClientView;
import com.ism.data.entites.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class ClientView extends View<Client> implements IClientView, Initializable {
    @FXML
    private TextField surnameField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField emailField;

    // Constructor
    public ClientView() {
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Initialize if needed
    }

    @FXML
    public void dashbord(ActionEvent e) {
        // Dashboard action
    }

    @FXML
    public void dettes(ActionEvent e) {
        // Manage dettes action
    }

    @FXML
    public void clients(ActionEvent e) {
        // Manage clients action
    }

    @FXML
    public void articles(ActionEvent e) {
        // Manage articles action
    }

    @FXML
    public void utilisateurs(ActionEvent e) {
        // Manage utilisateurs action
    }

    @FXML
    public void Annuler(ActionEvent e) {
        // Cancel action
    }

    @FXML
    public void Enregistrer(ActionEvent e) {
        // Display values entered in fields
        System.out.println("Nom: " + surnameField.getText());
        System.out.println("Téléphone: " + telephoneField.getText());
        System.out.println("Email: " + emailField.getText());

        // Create a new Client instance based on the form data
        Client client = new Client();
        client.setNom(surnameField.getText());
        client.setTelephone(telephoneField.getText());
        client.setEmail(emailField.getText());

        // Optionally save the client entity if needed
    }

    @Override
    public Client saisir() {
        Scanner scanner = new Scanner(System.in);

        // Create a new Client instance
        Client client = new Client();

        // Prompt for client details
        System.out.println("Veuillez entrer le nom du client :");
        String nom = scanner.nextLine();
        client.setNom(nom);

        System.out.println("Veuillez entrer le numéro de téléphone du client :");
        String telephone = scanner.nextLine();
        client.setTelephone(telephone);

        System.out.println("Veuillez entrer l'email du client :");
        String email = scanner.nextLine();
        client.setEmail(email);

        return client;
    }

    @Override
    public void afficher(List<Client> list) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'afficher'");
    }
}
