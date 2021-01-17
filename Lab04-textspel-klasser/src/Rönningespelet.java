import java.util.Scanner;
import java.util.Random;

public class Rönningespelet {
	public static void main(String[] args) {
		System.out.println(
				"Välkommen till spelet som testar din Rönningehet! Skriv endast svar, och sedan på knappen 'Enter'");
		int poäng = 0;
		int godkänd = 0;
		while (godkänd < 1) {
			for (int i = 0; i < 10; i++) {
				int t1 = 1;
				int t2 = 1;
				int t3 = 1;
				int t4 = 1;
				int t5 = 1;
				int t6 = 1;
				int t7 = 1;
				int t8 = 1;
				int t9 = 1;
				int t10 = 1;

				

					Scanner svar = new Scanner(System.in);

					Random rand = new Random();
					int n = rand.nextInt(10);
					n += 1;

					if (n == 1 && t1 == 1) {
						System.out.println(Frågor.getf(1));
						t1 = 2;
						String sv1 = svar.next();
						if (sv1.equals("112") || sv1.contentEquals("112 år")) {
							poäng = poäng + 1;
						}

					} else if (n == 2 && t2 == 1) {
						System.out.println(Frågor.getf(2));
						t2 = 2;
						String sv2 = svar.next();
						if (sv2.equalsIgnoreCase("Nära Ting")) {
							poäng = poäng + 1;
						}

					} else if (n == 3 && t3 == 1) {
						System.out.println(Frågor.getf(3));
						t3 = 2;
						String sv3 = svar.next();
						if (sv3.equals("Berga") || sv3.equals("Berga bollplan")) {
							poäng = poäng + 1;
						}

					} else if (n == 4 && t4 == 1) {
						System.out.println(Frågor.getf(4));
						t4 = 2;
						String sv4 = svar.next();
						if (sv4.equalsIgnoreCase("Nej")) {
							poäng = poäng + 1;
						}

					} else if (n == 5 && t5 == 1) {
						System.out.println(Frågor.getf(5));
						t5 = 2;
						String sv5 = svar.next();
						if (sv5.equalsIgnoreCase("Rönninge Gymnasium")) {
							poäng = poäng + 1;
						}
					} else if (n == 6 && t6 == 1) {
						System.out.println(Frågor.getf(6));
						t6 = 2;
						String sv6 = svar.next();
						if (sv6.equalsIgnoreCase("Ja")) {
							poäng = poäng + 1;
						}

					} else if (n == 7 && t7 == 1) {
						System.out.println(Frågor.getf(7));
						t7 = 2;
						String sv7 = svar.next();
						if (sv7.equalsIgnoreCase("Nej")) {
							poäng = poäng + 1;
						}

					} else if (n == 8 && t8 == 1) {
						System.out.println(Frågor.getf(8));
						t8 = 2;
						String sv8 = svar.next();
						if (sv8.equalsIgnoreCase("Spindel")) {
							poäng = poäng + 1;
						}

					} else if (n == 9 && t9 == 1) {
						System.out.println(Frågor.getf(9));
						t9 = 2;
						String sv9 = svar.next();
						if (sv9.equalsIgnoreCase("Uttran")) {
							poäng = poäng + 1;
						}

					} else if (n == 10 && t10 == 1) {
						System.out.println(Frågor.getf(10));
						t10 = 2;
						String sv6 = svar.next();
						if (sv6.equalsIgnoreCase("Salems kommun") || sv6.equalsIgnoreCase("Salem")) {
							poäng = poäng + 1;
						}

					}

					}
				if (poäng >= 8) {
					godkänd = 1;
					System.out.println("Bra jobbat! Du är en sann Rönningebo!");
				} else {
					System.out.println("Det är uppenbart att du har mycket att lära om Rönninge. Försök igen!");
				}

			
		}

	}
}