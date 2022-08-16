import java.util.Locale;
import java.util.Scanner;

class Parachutiste {

	public static void main(String[] args) {

		Scanner clavier = new Scanner(System.in); // pour opouvoir comparer le resultat avec l'IA online

		Locale.setDefault(new Locale("en", "US"));

		/*
		 * double masse = 80.0; do {
		 * System.out.print("masse du parachutiste (>= 40) ? "); masse =
		 * clavier.nextDouble(); } while (masse < 40.0);
		 * 
		 * double h0 = 39000.0; do {
		 * System.out.print("hauteur de depart du parachutiste (>= 250) ? "); h0 =
		 * clavier.nextDouble(); } while (h0 < 250.0);
		 */

		/*******************************************
		 * Completez le programme a partir d'ici.
		 *******************************************/

		double masse = 80.0;
		double h0 = 39000.0;

		double g = 9.81;
		double v0 = 0, t0 = 0; // vitesse et temps référence

		double vitesse; // vitesseChute
		double hauteur; // altitude
		double accel; // acceleration
		double t = 0; // temps

		// init
		double surfaceCorps = 2.0;
		hauteur = h0;
		vitesse = v0;
		accel = g;

		double s = surfaceCorps / masse; // expression 1
		double q; // expression 2

		do {
			q = Math.exp(-s * (t - t0)); // temps courant - temps initial
			vitesse = ((g / s) * (1 - q)) + (v0 * q);

			accel = g - (s * vitesse);

			hauteur = h0 - ((g / s) * (t - t0)) - (((v0 - (g / s)) / s) * (1 - q));
			if (hauteur > 0) {

				System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);

				t++;
			}

		} while (hauteur > 0);

		/*******************************************
		 * Ne rien modifier apres cette ligne.
		 *******************************************/
		clavier.close();
	}
}