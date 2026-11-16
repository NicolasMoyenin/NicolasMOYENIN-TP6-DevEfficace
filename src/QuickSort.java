import java.util.ArrayList;
import java.util.Random;

public class QuickSort {

    //partitionnement pour ArrayList
    private static int partitionner(ArrayList<Integer> liste, int bas, int haut) {
        int pivot = liste.get(haut);
        int i = (bas - 1);

        for (int j = bas; j < haut; j++) {
            if (liste.get(j) <= pivot) {
                i++;
                // Échange (swap)
                int temp = liste.get(i);
                liste.set(i, liste.get(j));
                liste.set(j, temp);
            }
        }



        int temp = liste.get(i + 1);
        liste.set(i + 1, liste.get(haut));
        liste.set(haut, temp);

        return i + 1;
    }

    public static void quicksort(ArrayList<Integer> liste, int bas, int haut) {
        if (bas < haut) {
            int pi = partitionner(liste, bas, haut);
            quicksort(liste, bas, pi - 1);
            quicksort(liste, pi + 1, haut);
        }
    }

    // Remplissage aléatoire pour l'ArrayList
    public static void randomInit(ArrayList<Integer> liste, int size) {
        Random rand = new Random();
        liste.clear();
        for (int i = 0; i < size; i++) {
            liste.add(rand.nextInt(100000)); // Nombres aléatoires
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> liste = new ArrayList<>();

        // tests
        randomInit(liste, 10);
        System.out.println("\n\nAvant le tri : " + liste);

        quicksort(liste, 0, liste.size() - 1);
        System.out.println("Après le tri : " + liste);
        System.out.println("\n\n--------------------------------------------- \n\n");

        // Format csv
        System.out.println("Taille,Temps(ms)");
        int[] buseTailles = {1000, 5000, 10000, 50000, 100000};

        for (int taille : buseTailles) {
            randomInit(liste, taille);

            // Mesure du temps
            long debut = System.nanoTime();
            quicksort(liste, 0, liste.size() - 1);
            long fin = System.nanoTime();

            // Conversion en ms
            long tempsMs = (fin - debut) / 1_000_000;

            // Affichage au format CSV
            System.out.println(taille + "," + tempsMs);
        }
    }

}