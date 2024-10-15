import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterfaceConsole {
    private RecetteManager recetteManager;
    private Scanner scanner;
    private Utilisateur utilisateur;

    public InterfaceConsole() {
        recetteManager = new RecetteManager();
        scanner = new Scanner(System.in);
    }

    public void demarrer() {
        System.out.println("Entrez votre nom : ");
        String nomUtilisateur = scanner.nextLine();
        utilisateur = new Utilisateur(nomUtilisateur);

        while (true) {
            System.out.println("Menu principal");
            System.out.println("1. Afficher les recettes");
            System.out.println("2. Ajouter une recette");
            System.out.println("3. Modifier une recette");
            System.out.println("4. Supprimer une recette");
            System.out.println("5. Ajouter une recette à vos favoris");
            System.out.println("6. Afficher les recettes par catégorie");
            System.out.println("7. Afficher les recettes par type de cuisine");
            System.out.println("8. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    afficherRecettes();
                    break;
                case 2:
                    try {
                        Recette recette = saisirRecette();
                        recetteManager.ajouterRecette(recette);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    modifierRecette();
                    break;
                case 4:
                    supprimerRecette();
                    break;
                case 5:
                    ajouterRecetteFavorite();
                    break;
                case 6:
                    afficherRecettesParCategorie();
                    break;
                case 7:
                    afficherRecettesParTypeCuisine();
                    break;
                case 8:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void afficherRecettes() {
        System.out.println("Liste des recettes :");
        for (Recette recette : recetteManager.getRecettes()) {
            System.out.println(recette.getNom());
        }
    }

    private Recette saisirRecette() throws Exception {
        System.out.println("Entrez le nom de la recette :");
        String nom = scanner.nextLine();

        // Entrée des ingrédients
        List<Ingredient> ingredients = new ArrayList<>();
        System.out.println("Entrez les ingrédients (nom, quantité, unité) un par un. Tapez 'fin' pour terminer l'entrée des ingrédients.");
        while (true) {
            System.out.println("Ingrédient :");
            String ingredientInput = scanner.nextLine();
            if (ingredientInput.equalsIgnoreCase("fin")) {
                break;
            }

            String[] parts = ingredientInput.split(",");
            if (parts.length < 2 || parts.length > 3) {
                System.out.println("Erreur de format. Veuillez entrer l'ingrédient sous la forme 'nom, quantité' ou 'nom, quantité, unité'.");
                continue;
            }

            String ingredientNom = parts[0].trim();
            float quantite;
            try {
                quantite = Float.parseFloat(parts[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("La quantité doit être un nombre valide.");
                continue;
            }

            String unite = (parts.length == 3) ? parts[2].trim() : "non spécifiée"; // Unité par défaut si non fournie

            ingredients.add(new Ingredient(ingredientNom, quantite, unite));
        }

        // Entrée des instructions
        System.out.println("Entrez les instructions de la recette. Tapez 'fin' pour terminer l'entrée des instructions.");
        List<String> instructions = new ArrayList<>();
        while (true) {
            String instruction = scanner.nextLine();
            if (instruction.equalsIgnoreCase("fin")) {
                break;
            }
            instructions.add(instruction);
        }

        System.out.println("Entrez le temps de préparation de la recette (en minutes) :");
        int tempsDePreparation = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        System.out.println("Entrez la catégorie de la recette (entrée, plat principal, dessert) :");
        String categorie = scanner.nextLine();

        System.out.println("Entrez le type de cuisine (ex: africaine, italienne, asiatique) :");
        String typeCuisine = scanner.nextLine();

        return new Recette(nom, ingredients, String.join("\n", instructions), tempsDePreparation, categorie, typeCuisine);
    }

    private void modifierRecette() {
        System.out.println("Entrez le nom de la recette à modifier :");
        String nom = scanner.nextLine();
        try {
            Recette recetteModifiee = saisirRecette();
            recetteModifiee.setNom(nom); // Conserver le même nom
            recetteManager.modifierRecette(recetteModifiee);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void supprimerRecette() {
        System.out.println("Entrez le nom de la recette à supprimer :");
        String nom = scanner.nextLine();
        recetteManager.supprimerRecette(nom);
    }

    private void ajouterRecetteFavorite() {
        System.out.println("Entrez le nom de la recette à ajouter à vos favoris :");
        String nom = scanner.nextLine();
        for (Recette recette : recetteManager.getRecettes()) {
            if (recette.getNom().equalsIgnoreCase(nom)) {
                utilisateur.ajouterRecetteFavorite(recette);
                System.out.println("Recette ajoutée à vos favoris.");
                return;
            }
        }
        System.out.println("Recette non trouvée.");
    }

    private void afficherRecettesParCategorie() {
        System.out.println("Entrez la catégorie (entrée, plat principal, dessert) :");
        String categorie = scanner.nextLine();
        List<Recette> recettes = recetteManager.getRecettesParCategorie(categorie);
        if (recettes.isEmpty()) {
            System.out.println("Aucune recette trouvée dans cette catégorie.");
        } else {
            for (Recette recette : recettes) {
                System.out.println(recette.getNom());
            }
        }
    }

    private void afficherRecettesParTypeCuisine() {
        System.out.println("Entrez le type de cuisine (ex:  africaine, italienne, asiatique) :");
        String typeCuisine = scanner.nextLine();
        List<Recette> recettes = recetteManager.getRecettesParTypeCuisine(typeCuisine);
        if (recettes.isEmpty()) {
            System.out.println("Aucune recette trouvée pour ce type de cuisine.");
        } else {
            for (Recette recette : recettes) {
                System.out.println(recette.getNom());
            }
        }
    }
}
