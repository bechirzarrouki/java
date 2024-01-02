import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class GestionnaireEmprunts {
    private Map<String, Utilisateur> utilisateurs;
    private ArrayList<Emprunt> emprunts;

    public GestionnaireEmprunts() {
        utilisateurs = new HashMap<>();
        emprunts = new ArrayList<>();
    }

    public Utilisateur creerNouveauCompte(String nom, String prenom, String identifiant) {
        if (!utilisateurs.containsKey(identifiant)) {
            Utilisateur utilisateur = new Utilisateur(nom, prenom, identifiant);
            utilisateurs.put(identifiant, utilisateur);
            return utilisateur;
        } else {
            throw new IllegalArgumentException("Un utilisateur avec cet identifiant existe déjà.");
        }
    }

    public void enregistrerNouvelEmprunt(String materiel, String identifiantUtilisateur, int dureeEmprunt) {
        Utilisateur utilisateur = utilisateurs.get(identifiantUtilisateur);
        if (utilisateur != null) {
            Emprunt emprunt = new Emprunt(materiel, utilisateur, dureeEmprunt);
            emprunts.add(emprunt);
            utilisateur.ajouterEmprunt(emprunt);
        } else {
            throw new IllegalArgumentException("Utilisateur non trouvé. Veuillez créer un compte d'abord.");
        }
    }

    public void afficherHistoriqueUtilisateur(String identifiantUtilisateur) {
        Utilisateur utilisateur = utilisateurs.get(identifiantUtilisateur);
        if (utilisateur != null) {
            for (Emprunt emprunt : utilisateur.getEmprunts()) {
                System.out.println(emprunt);
            }
        } else {
            throw new IllegalArgumentException("Utilisateur non trouvé.");
        }
    }

    public void listerRetards() {
        for (Emprunt emprunt : emprunts) {
            if (emprunt.estEnRetard()) {
                System.out.println(emprunt);
            }
        }
    }

    public void enregistrerRetour(String materiel) {
        for (Emprunt emprunt : emprunts) {
            if (emprunt.materiel.equals(materiel) && !emprunt.retourne) {
                emprunt.retourner();
                System.out.println("Retour enregistré pour " + emprunt);
                return;
            }
        }
        throw new IllegalArgumentException("Aucun emprunt en cours pour ce matériel.");
    }
}
