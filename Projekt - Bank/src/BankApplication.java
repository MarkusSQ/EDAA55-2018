import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BankApplication {
	private static boolean run = true;
	private static int val;
	private static Bank bank = new Bank();
	static Scanner scan;
	private static int start = 0;

	public static void main(String[] args) { // viktigt att runApplication och printMenu i rätt ordning
		printMenu();

//		bank.addAccount("Ko", 123);
//		bank.addAccount("Ko", 123);
//		bank.addAccount("Stina Svennson", 9867);
//		bank.addAccount("Stina Svennsom", 9866);
//		bank.addAccount("Morgan Freeman", 786);
//		bank.addAccount("Örjan Larsson", 90);

		while (run) {
			secondStart();
			scan = new Scanner(System.in);
			val = scan.nextInt();
			runApplication();
			start++;

		}
	}

	private static void runApplication() { // kolla vad det var med if och else
		if (val == 1) {
			System.out.print("Ange id-nummer: ");
			long idNr = scan.nextLong();
			bank.findAccountsForHolder(idNr);

		} else if (val == 2) {
			System.out.print("Ange hela eller del av namn: ");
			scan.nextLine();
			String namePart = scan.nextLine();
			bank.findByPartofName(namePart);

		} else if (val == 3) {
			System.out.print("Välj konto du vill sätta in pengar på: ");
			int bankAccountNbr = scan.nextInt();
			if (bank.findByNumber(bankAccountNbr) == null) {
				System.out.println("Fel: Kontot existerar inte.");

			} else {
				System.out.print("Ange mängd kr du vill sätta in: ");
				double amount = scan.nextDouble();
				if(amount>=0) {
				bank.findByNumber(bankAccountNbr).deposit(amount);
				}else {
					System.out.println("Fel: Kan ej sätta in negativa summor. Se alternativ 4.");
				}
			}
		} else if (val == 4) {
			System.out.print("Välj konto du vill ta ut pengar från: ");
			int bankAccountNbr = scan.nextInt();
			if (bank.findByNumber(bankAccountNbr) == null) {
				System.out.println("Fel: Kontot existerar inte.");
			} else {
				System.out.print("Ange mängd kr du vill ta ut: ");
				double amount = scan.nextDouble();
				if(amount>=0) {
				if (amount < bank.findByNumber(bankAccountNbr).amount) {
					bank.findByNumber(bankAccountNbr).withdraw(amount);
				} else {
					System.out.println("Fel: Kan inte ta ut mer än kontots balans. ):<");
				}
				}else {
					System.out.println("Fel: Kan ej ta ut negativa summor. Se alternativ 3.");
				}
			}

		} else if (val == 5) {
			System.out.print("Välj konto du vill överföra från: ");
			int bankAccountNbrWithDraw = scan.nextInt();
			System.out.print("Välj konto du vill överföra till: ");
			int bankAccountNbrDeposit = scan.nextInt();
			scan.nextLine();
			if (bank.findByNumber(bankAccountNbrWithDraw) == null || bank.findByNumber(bankAccountNbrDeposit) == null) {
				System.out.println("Fel: Kontot existerar inte.");
			} else {
				System.out.print("Ange mängd kr du vill överföra: ");
				double amount = scan.nextDouble();
				if(amount>0) {
				if (amount < bank.findByNumber(bankAccountNbrWithDraw).amount) {
					bank.findByNumber(bankAccountNbrWithDraw).withdraw(amount);
					bank.findByNumber(bankAccountNbrDeposit).deposit(amount);
				} else {
					System.out.println("Fel: Kan inte överföra mer än balansen från kontot du överför från");
				}
				}else {
					System.out.println("Fel: Kan ej överföra negativa summor. Byt ordning på konto som ska överföras till och som ska överföras från.");
				}
			}

		} else if (val == 6) {
			System.out.print("Ägarens namn: ");
			scan.nextLine();
			String holderName = scan.nextLine();
			System.out.print("Ägarens ID: ");
			long idNr = scan.nextLong();
			bank.addAccount(holderName, idNr);

		} else if (val == 7) {
			System.out.println("Välj konto du vill radera: ");
			int nummer = scan.nextInt();
			if (bank.findByNumber(nummer) == null) {
				System.out.println("Kontot finns inte, inget har raderats.");
			} else {
				bank.removeAccount(nummer);
				System.out.println("Kontot har raderats.");
			}

		} else if (val == 8) {
			bank.getAllAccounts();

		} else if (val == 9) {
			System.out.println("Programmet avslutat. Hejdå! <3");
			run = false;
		} else {
			System.out.println("Fel: alternativet existerar inte");
		}

	}

	private static void printMenu() {
		System.out.println("1. Hitta konton för en viss kontoinnehavare");
		System.out.println("2. Sök kontoinnehavare på (del av) namn");
		System.out.println("3. Sätta in pengar");
		System.out.println("4. Ta ut pengar");
		System.out.println("5. Överföring mellan konton");
		System.out.println("6. Skapa nytt konto");
		System.out.println("7. Ta bort konto");
		System.out.println("8. Skriv ut bankens alla konton");
		System.out.println("9. Avsluta");
		System.out.print("val: ");
	}

	private static void secondStart() {
		if (start > 0) {
			System.out.println("Åtgärd utförd. Vill du skriva ut menyn igen?");
			scan.nextLine();
			String svar = scan.nextLine();
			if (svar.toLowerCase().equals("ja")) {
				printMenu();
			} else if (svar.toLowerCase().equals("nej") == false && svar.toLowerCase().equals("ja") == false) {
				System.out.println("Ogiltigt svar, skriver ut menyn: ");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				printMenu();

			}

		}
	}

}
