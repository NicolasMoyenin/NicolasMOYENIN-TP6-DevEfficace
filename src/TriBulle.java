public class TriBulle {

    static class Node<T> {
        T valeur;
        Node<T> suivant;
        Node(T val) {
            this.valeur = val;
        }
    }

    Node<Integer> tete;

    public void afficher() {
        Node<Integer> courant = tete;
        while (courant != null) {
            System.out.print(courant.valeur + " ");
            courant = courant.suivant;
        }
        System.out.println();
    }


    public void trierBulles() {
        if (tete == null || tete.suivant == null) return;
        int n = 0;
        Node<Integer> courant = tete;
        while (courant != null) {
            n++;
            courant = courant.suivant;
        }
        for (int i = n - 1; i >= 1; i--) {
            Node<Integer> noeudJ = tete;
            for (int j = 0; j < i; j++) {
                Node<Integer> noeudSuivant = noeudJ.suivant;
                if (noeudJ.valeur.compareTo(noeudSuivant.valeur) > 0) {
                    Integer temp = noeudJ.valeur;
                    noeudJ.valeur = noeudSuivant.valeur;
                    noeudSuivant.valeur = temp;
                }
                noeudJ = noeudSuivant;
            }
        }
    }


    public static void main(String[] args) {
        TriBulle liste = new TriBulle();

        liste.tete = new Node<>(3);
        liste.tete.suivant = new Node<>(1);
        liste.tete.suivant.suivant = new Node<>(4);
        liste.tete.suivant.suivant.suivant = new Node<>(2);



        System.out.println("Liste avant le tri : ");
        liste.afficher();

        liste.trierBulles();

        System.out.println("Liste triée : ");
        liste.afficher();
    }
}