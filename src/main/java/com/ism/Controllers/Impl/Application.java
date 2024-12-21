package com.ism.Controllers.Impl;

import java.util.List;
import java.util.Scanner;
import com.ism.core.factory.Factory;
import com.ism.core.factory.FactoryService;
import com.ism.core.factory.FactoryView;
import com.ism.data.entites.Client;
import com.ism.data.entites.Commande;
import com.ism.services.ClientService;
import com.ism.services.CommandeService;

public class Application {
    private final FactoryService factoryService;
    private final FactoryView factoryView;
    private final Scanner scanner;

    public Application(Factory factory, Scanner scanner) {
        this.factoryService = factory.getFactoryService();
        this.factoryView = factory.getFactoryView();
        this.scanner = scanner;
    }

    public void run() {
        boolean continuerApp = true;
        while (continuerApp) {
            System.out.println("=== Connexion ===");
            System.out.print("Login : ");
            String login = scanner.nextLine();
            System.out.print("Mot de passe : ");
            String password = scanner.nextLine();

            // Authentification non associée aux utilisateurs
            boolean authenticated = authenticate(login, password);
            if (!authenticated) {
                System.out.println("Identifiants incorrects !");
            } else {
                continuerApp = afficherMenu();
            }
        }
        System.out.println("Application terminée.");
    }

    private boolean authenticate(String login, String password) {
        // Simpler authentication logic
        return login.equals("admin") && password.equals("admin");
    }

    private boolean afficherMenu() {
        int choice;
        do {
            choice = menu();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    factoryService.getInstanceClientService().createClient(factoryView.getInstanceClientView().saisir());
                    break;
                case 2:
                    factoryView.getInstanceClientView().afficher(factoryService.getInstanceClientService().findAllClient());
                    break;
                case 5:
                    factoryService.getInstanceCommandeService().createCommande(factoryView.getInstanceCommandeView().saisir());
                    break;
                case 6:
                    factoryView.getInstanceCommandeView().afficher(factoryService.getInstanceCommandeService().findAll());
                    break;
                case 9:
                    afficherDetailCommande();
                    break;
                case 10:
                    System.out.println("Déconnexion...");
                    return true;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choice != 10);
        return false;
    }

    private void afficherDetailCommande() {
        System.out.print("Entrez l'ID de la commande pour voir les détails : ");
        int commandeId = scanner.nextInt();
        Commande commande = factoryService.getInstanceCommandeService().findById(commandeId);
        if (commande != null) {
            System.out.println("Détails de la commande :");
            System.out.println("ID : " + commande.getId());
            System.out.println("Client : " + commande.getClient().getId() + " " + commande.getClient().getSurname());
            System.out.println("Montant total : " + commande.getMontantTotal());
            System.out.println("Date : " + commande.getDate());
        } else {
            System.out.println("Commande non trouvée !");
        }
    }

    private int menu() {
        System.out.println("=== Menu Principal ===");
        System.out.println("1- Créer un client");
        System.out.println("2- Lister les clients");
        System.out.println("5- Créer une commande");
        System.out.println("6- Lister les commandes");
        System.out.println("9- Voir les détails d'une commande");
        System.out.println("10- Déconnexion");
        System.out.print("Faites votre choix : ");
        return scanner.nextInt();
    }
}
