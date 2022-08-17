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

		double s; // expression 1
		double q; // expression 2

		boolean vitSon = true, vitMax = true, paraOpen = true;
		double q2, newVit = 0, newAccel = 0, newAlt = 0;

		do {
			s = surfaceCorps / masse; // expression 1
			
			q = Math.exp(-s * (t - t0)); // temps courant - temps initial
			vitesse = ((g / s) * (1 - q)) + (v0 * q);

			accel = g - (s * vitesse);

			hauteur = h0 - ((g / s) * (t - t0)) - (((v0 - (g / s)) / s) * (1 - q));
			if (hauteur > 0) {

				if (newVit > 343 && vitSon == true) {
					System.out.println("## Felix depasse la vitesse du son");
					vitSon = false;
				}

				if (accel < .5 && vitMax == true) {
					System.out.println("## Felix a atteint sa vitesse maximale");
					vitMax = false;
				}

				/*
				 * if(newAlt<2500 && paraOpen==true) {
				 * System.out.println("## Felix ouvre son parachute"); paraOpen = false; }
				 */

				System.out.printf("%.0f, %.4f, %.4f, %.5f\n", t, hauteur, vitesse, accel);

				t++;

				// prochaine vitesse
				q2 = Math.exp(-s * (t - t0));
				newVit = ((g / s) * (1 - q2)) + (v0 * q2);

				// prochaine hauteur
				newAlt = h0 - ((g / s) * (t - t0)) - (((v0 - (g / s)) / s) * (1 - q2));
				// System.out.println("####### nouvelle hauteur"+newAlt);

				if (newAlt < 2500 && paraOpen == true) {
					System.out.println("## Felix ouvre son parachute");

					paraOpen = false;
					surfaceCorps = 25.0;

					t0 = t;
					h0 = newAlt;
					v0 = newVit;
				}

			}

		} while (hauteur > 0);

		/*******************************************
		 * Ne rien modifier apres cette ligne.
		 *******************************************/
		clavier.close();
	}
}