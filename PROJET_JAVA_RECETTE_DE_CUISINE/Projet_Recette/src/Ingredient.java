public class Ingredient {
    public static void main(String[] args){

    }
    private String nom_ingredient;
    private int quantite_ingredient;
    private int unite_mesure;

    public Ingredient(String nom_ingredient,int quantite_ingredient,int unite_mesure){
        this.nom_ingredient=nom_ingredient;
        this.quantite_ingredient=quantite_ingredient;
        this.unite_mesure=unite_mesure;
    }

    public String getNom_ingredient(){return nom_ingredient;}
    public int getQuantite_ingredient(){return quantite_ingredient;}
    public int getUnite_mesure(){return unite_mesure;}

    public void setNom_ingredient(String nom_ingredient){this.nom_ingredient=nom_ingredient;}
    public void setQuantite_ingredient(int quantite_ingredient){this.quantite_ingredient=quantite_ingredient;}
    public void setUnite_mesure(int unite_mesure){this.unite_mesure=unite_mesure;}
}
