import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String nom;
    private List<Recette> recettesFavorites;

    public Utilisateur(String nom) {
        this.nom = nom;
        this.recettesFavorites = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Recette> getRecettesFavorites() {
        return recettesFavorites;
    }

    public void ajouterRecetteFavorite(Recette recette) {
        recettesFavorites.add(recette);
    }

    public void supprimerRecetteFavorite(Recette recette) {
        recettesFavorites.remove(recette);
    }
}
