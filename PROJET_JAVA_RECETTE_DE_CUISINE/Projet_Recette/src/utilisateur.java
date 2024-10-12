import java.util.Scanner;


public class utilisateur {
    // Boucle principale
    public static void main(String[] args) {
        while (true) {
            Recette.afficherMenu();
            String choix = Recette.sc1.nextLine();
            switch (choix) {
                case "1":
                    Recette.ajouter_recette();
                    break;
                case "2":
                    Recette.supprimer_recette();
                    break;
                case "3":
                    Recette.modifier_recette();
                    break;
                case "4":
                    System.out.println("Au revoir!");
                    return;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
    private String nom_utilisateur;
    private Recette recette_favorite;

    public utilisateur(String nom_utilisateur,Recette recette_favorite){
        this.nom_utilisateur=nom_utilisateur;
        this.recette_favorite=recette_favorite;

    }

    public String getNom_utilisateur(){return nom_utilisateur;}
    public Recette recette_favorite(){return recette_favorite;}

    public void setNom_utilisateur(String nom_utilisateur){this.nom_utilisateur=nom_utilisateur;}
    public void setRecette_favorite(Recette recette_Favorite){this.recette_favorite=recette_favorite;}


}
