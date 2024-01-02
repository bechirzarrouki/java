import java.util.ArrayList;

class Utilisateur {
    private String nom;
    private String prenom;
    private String identifiant;
    private ArrayList<Emprunt> emprunts;

    public Utilisateur(String nom, String prenom, String identifiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.emprunts = new ArrayList<>();
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void ajouterEmprunt(Emprunt emprunt) {
        emprunts.add(emprunt);
    }

    public ArrayList<Emprunt> getEmprunts() {
        return emprunts;
    }

    @Override
    public String toString() {
        return prenom + " " + nom + " (ID: " + identifiant + ")";
    }
}
