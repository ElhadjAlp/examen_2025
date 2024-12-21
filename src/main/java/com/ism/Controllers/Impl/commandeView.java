package com.ism.Controllers.Impl;

import com.ism.data.entites.Commande;
import com.ism.data.repository.jpa.impl.ArticleRepositoryJPA;
import com.ism.data.repository.jpa.impl.ClientRepositoryJPA;
import com.ism.data.repository.jpa.impl.CommandeRepositoryJPA;
import com.ism.Controllers.ICommandeView;
import com.ism.data.entites.Article;
import com.ism.data.entites.Client;
import com.ism.services.ClientService;
import com.ism.services.CommandeService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class commandeView implements ICommandeView {
    
    @FXML
    private TextField nomClientField;
    
    @FXML
    private TextField telephoneField;
    
    @FXML
    private ComboBox<Article> articleComboBox;
    
    @FXML
    private TextField quantiteField;
    
    @FXML
    private TableView<Article> tableCommande;
    
    @FXML
    private TableColumn<Article, String> articleColumn;
    
    @FXML
    private TableColumn<Article, Double> prixColumn;
    
    @FXML
    private TableColumn<Article, Integer> quantiteColumn;
    
    @FXML
    private TableColumn<Article, Double> montantColumn;
    
    @FXML
    private TableColumn<Article, String> actionsColumn;
    
    @FXML
    private Label totalLabel;

    private ClientService clientService;
    private CommandeService commandeService;
    private Commande commande;

    public commandeView() {
        
        this.clientService = new ClientService(new ClientRepositoryJPA());
        this.commandeService = new CommandeService(new CommandeRepositoryJPA(), new ArticleRepositoryJPA());
        this.commande = new Commande();
    }

    @FXML
    public void initialize() {
        
        articleColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));
        quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantiteStock"));
        montantColumn.setCellValueFactory(new PropertyValueFactory<>("montant"));

        
        articleComboBox.getItems().addAll(commandeService.getAllArticles());
    }

    @FXML
    public void handleSearchClient() {
        String telephone = telephoneField.getText();
        Client client = clientService.findOrCreateClient(telephone, "", "", "");
        if (client != null) {
            nomClientField.setText(client.getNom() + " " + client.getPrenom());
            commande.setClient(client);
        } else {
            nomClientField.setText("Client introuvable");
        }
    }

    @FXML
    public void handleAddArticle() {
        Article article = articleComboBox.getValue();
        int quantite = Integer.parseInt(quantiteField.getText());
        try {
            commandeService.addLigneCommande(commande, article, quantite);
            tableCommande.getItems().add(article);
            totalLabel.setText(String.valueOf(commande.getMontantTotal()));
        } catch (IllegalArgumentException e) {
            showAlert("Erreur", e.getMessage());
        }
    }

    @FXML
    public void handleValidateCommande() {
        commandeService.saveCommande(commande);
        showAlert("Succès", "Commande validée !");
        resetForm();
    }

    private void resetForm() {
        commande = new Commande();
        telephoneField.clear();
        nomClientField.clear();
        tableCommande.getItems().clear();
        totalLabel.setText("0,0");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public Commande saisir() {
        // Méthode non implémentée
        throw new UnsupportedOperationException("Unimplemented method 'saisir'");
    }
}
