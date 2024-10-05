import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recette {
    public static void main(String[] args){

    }
    private String nom_recette;
    private String list_ingredient;
    private String instructions;
    private int temps_preparation;

    public Recette(String nom_recette,String list_ingredient,String instructions,int temps_preparation){
        this.nom_recette=nom_recette;
        this.list_ingredient=list_ingredient;
        this.instructions=instructions;
        this.temps_preparation=temps_preparation;
    }

    public String getNom_recette(){return nom_recette;}
    public String getList_ingredient(){return list_ingredient;}
    public String getInstructions(){return instructions;}
    public int getTemps_preparation(){return temps_preparation;}

    public void setNom_recette(String nom_recette) {
        this.nom_recette = nom_recette;
    }

    public void setList_ingredient(String list_ingredient) {
        this.list_ingredient = list_ingredient;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setTemps_preparation(int temps_preparation) {
        this.temps_preparation = temps_preparation;
    }

    // Liste pour stocker les recettes
    private static List<Recette> recettes = new ArrayList<>();
    public static Scanner sc1 = new Scanner(System.in);

    //fonction pour ajouter une recette
    public static void ajouter_recette(){
        System.out.println("Entrer le nom de la recette ");
        String nom =sc1.nextLine();
        System.out.println("Entrer la liste des ingredients :");
        String ingredient=sc1.nextLine();
        System.out.print("Entrez les instructions: ");
        String instructions = sc1.nextLine();
        System.out.print("Entrez le temps de préparation (en minutes): ");
        int tempsPreparation = sc1.nextInt();
        sc1.nextLine();

        Recette recette=new Recette(nom,ingredient,instructions,tempsPreparation);
        recettes.add(recette);
        System.out.println("Recette "+nom+ " ajouté avec succès ");
    }


    // Fonction pour supprimer une recette
    public static void supprimer_recette() {
        System.out.print("Entrez le nom de la recette à supprimer: ");
        String nom = sc1.nextLine();
        for (Recette recette : recettes) {
            if (recette.getNom_recette().equalsIgnoreCase(nom)) {
                recettes.remove(recette);
                System.out.println("Recette " + nom + " supprimée avec succès.");
                return;
            }
        }
        System.out.println("Aucune recette trouvée avec le nom " + nom + ".");
    }


    // Fonction pour modifier une recette
    public static void modifier_recette() {
        System.out.print("Entrez le nom de la recette à modifier: ");
        String nom = sc1.nextLine();

        // Rechercher la recette dans la liste
        for (Recette recette : recettes) {
            if (recette.getNom_recette().equalsIgnoreCase(nom)) {
                System.out.println("Recette trouvée. Que voulez-vous modifier ?");
                System.out.println("1. Nom de la recette");
                System.out.println("2. Liste des ingrédients");
                System.out.println("3. Instructions");
                System.out.println("4. Temps de préparation");
                System.out.println("5. Modifier tout");
                System.out.print("Choisissez une option: ");
                String choix = sc1.nextLine();

                switch (choix) {
                    case "1":
                        System.out.print("Entrez le nouveau nom de la recette: ");
                        String nouveauNom = sc1.nextLine();
                        recette.setNom_recette(nouveauNom);
                        break;
                    case "2":
                        System.out.print("Entrez la nouvelle liste des ingrédients: ");
                        String nouveauxIngredients = sc1.nextLine();
                        recette.setList_ingredient(nouveauxIngredients);
                        break;
                    case "3":
                        System.out.print("Entrez les nouvelles instructions: ");
                        String nouvellesInstructions = sc1.nextLine();
                        recette.setInstructions(nouvellesInstructions);
                        break;
                    case "4":
                        System.out.print("Entrez le nouveau temps de préparation (en minutes): ");
                        int nouveauTemps = sc1.nextInt();
                        sc1.nextLine();  // Nettoyage du buffer
                        recette.setTemps_preparation(nouveauTemps);
                        break;
                    case "5":
                        System.out.print("Entrez le nouveau nom de la recette: ");
                        nouveauNom = sc1.nextLine();
                        recette.setNom_recette(nouveauNom);

                        System.out.print("Entrez la nouvelle liste des ingrédients: ");
                        nouveauxIngredients = sc1.nextLine();
                        recette.setList_ingredient(nouveauxIngredients);

                        System.out.print("Entrez les nouvelles instructions: ");
                        nouvellesInstructions = sc1.nextLine();
                        recette.setInstructions(nouvellesInstructions);

                        System.out.print("Entrez le nouveau temps de préparation (en minutes): ");
                        nouveauTemps = sc1.nextInt();
                        sc1.nextLine();  // Nettoyage du buffer
                        recette.setTemps_preparation(nouveauTemps);
                        break;
                    default:
                        System.out.println("Option invalide. Aucune modification effectuée.");
                }

                System.out.println("Recette modifiée avec succès.");
                return;
            }
        }
        System.out.println("Aucune recette trouvée avec le nom " + nom + ".");
    }




    // Fonction pour afficher le menu
    public static void afficherMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Ajouter une recette");
        System.out.println("2. Supprimer une recette");
        System.out.println("3. Modifier une recette");
        System.out.println("4. Quitter");
        System.out.print("Choisissez une option: ");
    }


}
