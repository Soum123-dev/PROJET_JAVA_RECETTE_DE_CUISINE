import java.util.ArrayList;
import java.util.List;

public class RecetteManager {
    private List<Recette> recettes;

    public RecetteManager() {
        recettes = new ArrayList<>();
    }

    public void ajouterRecette(Recette recette) {
        recettes.add(recette);
    }

    public void modifierRecette(Recette recetteModifiee) {
        for (int i = 0; i < recettes.size(); i++) {
            if (recettes.get(i).getNom().equalsIgnoreCase(recetteModifiee.getNom())) {
                recettes.set(i, recetteModifiee);
                return;
            }
        }
        System.out.println("Recette non trouvée.");
    }

    public void supprimerRecette(String nomRecette) {
        recettes.removeIf(recette -> recette.getNom().equalsIgnoreCase(nomRecette));
    }

    public List<Recette> getRecettes() {
        return recettes;
    }

    public List<Recette> getRecettesParCategorie(String categorie) {
        List<Recette> recettesCategorie = new ArrayList<>();
        for (Recette recette : recettes) {
            if (recette.getCategorie().equalsIgnoreCase(categorie)) {
                recettesCategorie.add(recette);
            }
        }
        return recettesCategorie;
    }

    public List<Recette> getRecettesParTypeCuisine(String typeCuisine) {
        List<Recette> recettesTypeCuisine = new ArrayList<>();
        for (Recette recette : recettes) {
            if (recette.getTypeCuisine().equalsIgnoreCase(typeCuisine)) {
                recettesTypeCuisine.add(recette);
            }
        }
        return recettesTypeCuisine;
    }
}
