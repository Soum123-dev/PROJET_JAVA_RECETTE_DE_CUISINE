public class Ingredient {
    private String nom;
    private float quantite;
    private String unite;

    public Ingredient(String nom, float quantite, String unite) {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = (unite == null || unite.isEmpty()) ? "non spécifiée" : unite; // Unité par défaut
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return nom + ", " + quantite + " " + unite;
    }
}
