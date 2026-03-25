import java.util.Scanner;

public class App {

    static int argent = 100;
    static int jour = 1;

    static final int[] champs = new int[3];

    static final int COUT_PLANTATION = 10;
    static final int VALEUR_RECOLTE = 25;
    static final int TEMPS_POUSSE = 3;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("");
        System.out.println("Bienvenue sur The Farm");
        System.out.println("");

        while (true) {
            System.out.println("Jour : " + jour);
            afficherStatut();
            afficherMenu();

            System.out.print("Votre choix : ");
            String choix = s.nextLine();

            if (choix.equals("1")) {
                planter(s);
            } else if (choix.equals("2")) {
                recolter(s);
            } else if (choix.equals("3")) {
                passerAuJourSuivant();
            } else if (choix.equals("4")) {
                System.out.println("Fin du jeu. Solde final : " + argent + "€");
                s.close();
                return;
            } else {
                System.out.println("Choix invalide, réessayez.");
                System.out.println("");
            }
        }
    }

    static void afficherStatut() {
        System.out.println("Argent : " + argent + "€");
        System.out.print("Champs : ");

        for (int i = 0; i < champs.length; i++) {
            int etat = champs[i];

            switch (etat) {
                case 0 -> System.out.print("[" + (i + 1) + ": Vide] ");
                case 1 -> System.out.print("[" + (i + 1) + ": PRÊT] ");
                default -> {
                    int jourActuel = TEMPS_POUSSE - etat + 1;
                    System.out.print("[" + (i + 1) + ": Pousse " + jourActuel + "/" + TEMPS_POUSSE + "] ");
                }
            }
        }

        System.out.println();
    }

    static void afficherMenu() {
        System.out
                .println("1. Planter du maïs  (coût : " + COUT_PLANTATION + "€, pousse en " + TEMPS_POUSSE + " jours)");
        System.out.println("2. Récolter          (rapporte : " + VALEUR_RECOLTE + "€)");
        System.out.println("3. Passer au jour suivant");
        System.out.println("4. Quitter");
    }

    static void planter(Scanner s) {
        if (argent < COUT_PLANTATION) {
            System.out.println("Pas assez d'argent pour planter !");
            System.out.println("");
            return;
        }

        System.out.print("Dans quel champ planter ? (1 à " + champs.length + ") : ");
        int numero = Integer.parseInt(s.nextLine());
        int index = numero - 1;

        if (index < 0 || index >= champs.length) {
            System.out.println("Numéro de champ invalide.");
            System.out.println("");
            return;
        }

        if (champs[index] != 0) {
            System.out.println("Ce champ est déjà occupé !");
            System.out.println("");
            return;
        }

        champs[index] = TEMPS_POUSSE;
        argent -= COUT_PLANTATION;
        System.out.println("Maïs planté dans le champ " + numero + ".");
        System.out.println("");
    }

    static void recolter(Scanner s) {
        System.out.print("Quel champ récolter ? (1 à " + champs.length + ") : ");
        int numero = Integer.parseInt(s.nextLine());
        int index = numero - 1;

        if (index < 0 || index >= champs.length) {
            System.out.println("Numéro de champ invalide.");
            System.out.println("");
            return;
        }

        if (champs[index] == 0) {
            System.out.println("Ce champ est vide, rien à récolter.");
            System.out.println("");
        } else if (champs[index] > 1) {
            System.out.println("La plante n'est pas encore mûre, attendez encore !");
            System.out.println("");
        } else {
            champs[index] = 0;
            argent += VALEUR_RECOLTE;
            System.out.println("Récolte réussie ! Vous gagnez " + VALEUR_RECOLTE + "€.");
            System.out.println("");
        }
    }

    static void passerAuJourSuivant() {
        for (int i = 0; i < champs.length; i++) {
            if (champs[i] > 1) {
                champs[i]--;
            }
        }

        jour++;
        System.out.println("Un jour s'est écoulé. Les plantes ont poussé.");
        System.out.println("");
    }
}