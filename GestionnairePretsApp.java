public class GestionnairePretsApp {
    public static void main(String[] args) {
        GestionnaireEmprunts gestionnaire = new GestionnaireEmprunts();

        try {
            // Création d'un nouveau compte utilisateur
            Utilisateur utilisateur = gestionnaire.creerNouveauCompte("Doe", "John", "JD123");

            // Enregistrement d'un nouvel emprunt
            gestionnaire.enregistrerNouvelEmprunt("Ordinateur Portable", "JD123", 7);

            // Affichage de l'historique de l'utilisateur
            gestionnaire.afficherHistoriqueUtilisateur("JD123");

            // Liste des retards
            gestionnaire.listerRetards();

            // Enregistrement du retour d'un matériel
            gestionnaire.enregistrerRetour("Ordinateur Portable");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur: " + e.getMessage());
        }
    }
}
