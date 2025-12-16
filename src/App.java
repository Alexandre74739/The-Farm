import java.util.Scanner;

public class MiniFarm {
    // Variables globales (static)
    private static int money = 100;
    private static int day = 1;
    // Taille du champ (3 parcelles)
    private static final int FIELD_SIZE = 3;
    // Représente le temps de croissance de chaque parcelle. 0 = vide. 
    // Ex: 3 = jour de croissance 1/3, 1 = jour de croissance 3/3 (prêt)
    private static int[] fields = new int[FIELD_SIZE];
    private static final int GROWTH_TIME = 3; 
    private static final int PLANT_COST = 10;
    private static final int HARVEST_VALUE = 25;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The Farm");
        
        while (true) {
            System.out.println("Jour " + day);
            displayStatus();
            System.out.println("\n1. Planter (Maïs, " + PLANT_COST + "€, Pousse en " + GROWTH_TIME + "j)");
            System.out.println("2. Récolter (Vente: " + HARVEST_VALUE + "€)");
            System.out.println("3. Passer au jour suivant");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            String choice = sc.nextLine();

            if (choice.equals("4")) {
                System.out.println("Fin du jeu. Solde : " + money + "€");
                break;
            }
            
            processAction(choice, sc);
        }
        sc.close();
    }

    private static void displayStatus() {
        System.out.println("Argent : " + money + "€");
        System.out.print("Champs : |");
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (fields[i] == 0) System.out.print(" Vide |");
            else if (fields[i] == 1) System.out.print(" PRÊT |");
            else System.out.print(" Croissance " + (GROWTH_TIME - fields[i] + 1) + "/" + GROWTH_TIME + " |");
        }
        System.out.println();
    }

    private static void processAction(String choice, Scanner sc) {
        if (choice.equals("1")) { // Planter
            if (money < PLANT_COST) { System.out.println("Pas assez d'argent."); return; }
            System.out.print("Champ (1-" + FIELD_SIZE + ") : ");
            int index = Integer.parseInt(sc.nextLine()) - 1;
            if (index >= 0 && index < FIELD_SIZE && fields[index] == 0) {
                fields[index] = GROWTH_TIME; // Commence la croissance
                money -= PLANT_COST;
                System.out.println("Maïs planté.");
            } else { System.out.println("Champ invalide ou occupé."); }
        } else if (choice.equals("2")) { // Récolter
            System.out.print("Champ (1-" + FIELD_SIZE + ") : ");
            int index = Integer.parseInt(sc.nextLine()) - 1;
            if (index >= 0 && index < FIELD_SIZE && fields[index] == 1) {
                money += HARVEST_VALUE;
                fields[index] = 0; // Champ vide
                System.out.println("Récolté ! +" + HARVEST_VALUE + "€.");
            } else if (index >= 0 && index < FIELD_SIZE && fields[index] > 1) {
                System.out.println("Pas encore mûr !");
            } else { System.out.println("Champ invalide ou vide."); }
        } else if (choice.equals("3")) { // Passer le jour
            for (int i = 0; i < FIELD_SIZE; i++) {
                if (fields[i] > 0) fields[i]--; // Réduit le compteur de croissance
            }
            day++;
            System.out.println("Les plantes ont poussé.");
        } else { System.out.println("Choix non reconnu."); }
    }
}