package ACL2;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

    	   Scanner scanner = new Scanner(System.in);

           int largeur = 5;
           int hauteur = 5;

           hero hero = new hero(largeur / 2, hauteur / 2, largeur, hauteur);
           Monstre monstre = new Monstre(0, 0, largeur, hauteur);

           while (hero.getVie() > 0) {
        	   monstre.deplacerAleatoire();
               hero.displayGrid(monstre.getX(), monstre.getY());
               hero.displayPosition();

               System.out.println("Utilise u (haut), d (bas), l (gauche), r (droite) pour déplacer le héros.");
               char direction = scanner.next().charAt(0);

               hero.move(direction);
               monstre.deplacerAleatoire();

               // Détecter la collision entre le héros et le monstre
               if (hero.detectCollision(monstre)) {
                   hero.perteVie();
                   if (hero.getVie() == 0) {
                       System.out.println("Le héros est mort. Fin de la partie.");
                       break;
                   }
               }
           }

           scanner.close();
       }
   }