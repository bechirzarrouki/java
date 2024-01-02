import java.time.LocalDate;

class Emprunt {
    public String materiel;
    private Utilisateur utilisateur;
    private LocalDate dateEmprunt;
    private int dureeEmprunt;
    public boolean retourne;

    public Emprunt(String materiel, Utilisateur utilisateur, int dureeEmprunt) {
        this.materiel = materiel;
        this.utilisateur = utilisateur;
        this.dateEmprunt = LocalDate.now();
        this.dureeEmprunt = dureeEmprunt;
        this.retourne = false;
    }

    public void retourner() {
        this.retourne = true;
    }

    public boolean estEnRetard() {
        LocalDate dateRetourAttendue = dateEmprunt.plusDays(dureeEmprunt);
        return !retourne && LocalDate.now().isAfter(dateRetourAttendue);
    }

    @Override
    public String toString() {
        return "Emprunt de " + materiel + " par " + utilisateur + ", Date: " + dateEmprunt + ", Durée: " + dureeEmprunt + " jours";
    }
}
