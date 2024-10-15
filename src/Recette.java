import java.util.List;

public class Recette {
    private String nom;
    private List<Ingredient> ingredients;
    private String instructions;
    private int tempsDePreparation;
    private String categorie;
    private String typeCuisine;

    public Recette(String nom, List<Ingredient> ingredients, String instructions, int tempsDePreparation, String categorie, String typeCuisine) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.tempsDePreparation = tempsDePreparation;
        this.categorie = categorie;
        this.typeCuisine = typeCuisine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getTempsDePreparation() {
        return tempsDePreparation;
    }

    public void setTempsDePreparation(int tempsDePreparation) {
        this.tempsDePreparation = tempsDePreparation;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTypeCuisine() {
        return typeCuisine;
    }

    public void setTypeCuisine(String typeCuisine) {
        this.typeCuisine = typeCuisine;
    }

    @Override
    public String toString() {
        return "Recette : " + nom + "\nCatégorie : " + categorie + "\nType de Cuisine : " + typeCuisine + "\nTemps de préparation : " + tempsDePreparation + " minutes\nIngrédients : " + ingredients + "\nInstructions : " + instructions;
    }
}
