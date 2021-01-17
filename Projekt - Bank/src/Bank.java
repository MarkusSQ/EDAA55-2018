import java.util.ArrayList;

public class Bank {
	ArrayList<BankAccount> bAccounts;
	ArrayList<Customer> bCustomers;

	/** Skapar en ny bank utan konton. */
	Bank() {
		this.bAccounts = new ArrayList<BankAccount>();
		this.bCustomers = new ArrayList<Customer>();
	}

	/**
	 * Öppna ett nytt konto i banken. Om det redan finns en kontoinnehavare med de
	 * givna uppgifterna ska inte en ny Customer skapas, utan istället den
	 * befintliga användas. Det nya kontonumret returneras.
	 */
	int addAccount(String holderName, long idNr) {
		boolean newCustomer = true;

		if (bCustomers.size() > 0) {
			for (Customer c : bCustomers) {
				if (c.idNr == idNr) {
					newCustomer = false;
				}
			}
		}

		if (newCustomer == true) {
			Customer nCustomer = new Customer(holderName, idNr);
			bCustomers.add(nCustomer);
		}

		BankAccount nBankAccount = new BankAccount(holderName, idNr);
		bAccounts.add(nBankAccount);

		return nBankAccount.getAccountNumber();

	}

	/**
	 * Returnerar den kontoinnehavaren som har det givna id-numret, eller null om
	 * ingen sådan finns.
	 */
	Customer findHolder(long idNr) {
		for(int i = 0; i<bCustomers.size(); i++) {
			if(idNr == bCustomers.get(i).getIdNr()) {
				return bCustomers.get(i);
			}
		}
		return null;
	}

	/**
	 * Tar bort konto med nummer ’number’ från banken. Returnerar true om kontot
	 * fanns (och kunde tas bort), annars false.
	 */
	boolean removeAccount(int number) {
		for (int i = 0; i < bAccounts.size(); i++) {
			if (number == bAccounts.get(i).getAccountNumber()) {
				bAccounts.remove(i);
				return true;
			}
		}
		return false;

	}

	/**
	 * Returnerar en lista innehållande samtliga bankkonton i banken. Listan är
	 * sorterad på kontoinnehavarnas namn.
	 */
	ArrayList<BankAccount> getAllAccounts() { // Stort A-Z 65-90, litet a-z 97-122. Borde göra en kopia av listan (inget
												// krav)
		for (int i = 0; i < bAccounts.size(); i++) {
			for (int k = i + 1; k < bAccounts.size(); k++) { // om vi vill att större värden kommer senare gör vi så
																// här: om i är större (efter i bokstavsordn) så får vi
																// värden mindre än 0.
				if (bAccounts.get(i).getHolder().getName()
						.compareToIgnoreCase(bAccounts.get(k).getHolder().getName()) > 0) {
					BankAccount temp = bAccounts.get(i);
					bAccounts.set(i, bAccounts.get(k));
					bAccounts.set(k, temp);

				}
			}
		}

		for (int c = 0; c < bAccounts.size(); c++) {
			System.out.println(bAccounts.get(c).toString());
		}
		return bAccounts;

		// for (int s = 0; s < bAccounts.size(); s++) {
		// System.out.println("Namn: " + bAccounts.get(s).getHolder().getName() + ",
		// Kontonr: "
		// + bAccounts.get(s).getAccountNumber());
		// }
	}

	/**
	 * Söker upp och returnerar bankkontot med kontonummer ’accountNumber’.
	 * Returnerar null om inget sådant konto finns.
	 */
	BankAccount findByNumber(int accountNumber) {
		int nbrIndex = 0;
		int hit = 0;
		if (bAccounts.size() == 0) {
			return null;
		} else {
			for (int i = 0; i < bAccounts.size(); i++) {
				if (bAccounts.get(i).getAccountNumber() == accountNumber) {
					nbrIndex = i;
					hit++;
				}
			}
			if (hit == 0) {
				return null;
			}

			return bAccounts.get(nbrIndex);
		}
	}

	/**
	 * Söker upp alla bankkonton som innehas av kunden med id-nummer ’idNr’. Kontona
	 * returneras i en lista. Kunderna antas ha unika id-nummer.
	 */
	ArrayList<BankAccount> findAccountsForHolder(long idNr) {
		ArrayList<BankAccount> idAccounts = new ArrayList<BankAccount>();
		for (int bnr = 0; bnr < bAccounts.size(); bnr++) {
			if (bAccounts.get(bnr).getHolder().getIdNr() == idNr) {
				idAccounts.add(bAccounts.get(bnr));
			}
		}
		if (idAccounts.size() == 0) {
			System.out.println("Ingen kund har detta id-nummer.");
		} else {
			for (int i = 0; i < idAccounts.size(); i++) {
				System.out.println(idAccounts.get(i).toString());
			}
		}
		return idAccounts;
	}

	/**
	 * Söker upp kunder utifrån en sökning på namn eller del av namn. Alla personer
	 * vars namn innehåller strängen ’namePart’ inkluderas i resultatet, som
	 * returneras som en lista. Samma person kan förekomma flera gånger i
	 * resultatet. Sökningen är "case insensitive", det vill säga gör ingen skillnad
	 * på stora och små bokstäver.
	 */
	ArrayList<Customer> findByPartofName(String namePart) {
		String namePartLowerCase = namePart.toLowerCase();
		ArrayList<Customer> nameCustomer = new ArrayList<Customer>();
		for (int cnr = 0; cnr < bCustomers.size(); cnr++) {
			if (bCustomers.get(cnr).getName().toLowerCase().contains(namePartLowerCase)) {
				nameCustomer.add(bCustomers.get(cnr));
			}
		}
		if (nameCustomer.size() == 0) {
			System.out.println("Ingen kund med matchande namn kunde hittas.");
		} else {
			for (int i = 0; i < nameCustomer.size(); i++) {
				System.out.println(nameCustomer.get(i).toString());
			}
		}
		return nameCustomer;
	}

}
