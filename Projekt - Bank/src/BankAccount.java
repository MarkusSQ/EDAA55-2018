import java.util.ArrayList;

public class BankAccount {
	String holderName; //private på grejer
	long holderId;
	Customer holder;
	int bankAccountNbr = 0; //private static?
	static int bA = 0;
	double amount;
	
	
	/**
	* Skapar ett nytt bankkonto åt en innehavare med namn ’holderName’ och
	* id ’holderId’. Kontot tilldelas ett unikt kontonummer och innehåller
	* inledningsvis 0 kr.
	*/
	BankAccount(String holderName, long holderId){
	this.holderName = holderName;
	this.holderId = holderId;
	this.amount= 0;
	holder = new Customer(holderName, holderId);
	bankAccountNbr = bA;
	bA++;
	}
	
	/**
	* Skapar ett nytt bankkonto med innehavare ’holder’. Kontot tilldelas
	* ett unikt kontonummer och innehåller inledningsvis 0 kr.
	*/
	BankAccount(Customer holder){
	this.holder = holder;
	//holder.name = holderName;
	//holder.idNr = holderId;
	}
	
	/** Tar reda på kontots innehavare. */
	Customer getHolder() {
		return holder;
	}
	
	/** Tar reda på det kontonummer som identifierar detta konto. */
	int getAccountNumber() {
		return bankAccountNbr;
	}
	
	/** Tar reda på hur mycket pengar som finns på kontot. */
	double getAmount() {
		return amount;
	}
	
	/** Sätter in beloppet ’amount’ på kontot. */
	void deposit(double amount) {
		this.amount = this.amount + amount;
	}
	
	/**
	* Tar ut beloppet ’amount’ från kontot. Om kontot saknar täckning
	* blir saldot negativt.
	*/
	void withdraw(double amount) {
		this.amount = this.amount - amount;
	}
	
	/** Returnerar en strängrepresentation av bankkontot. */
	public String toString() {
		return "(Ägare: " + holderName + ", ÄgarID: " + holderId + ", Kontonummer: " + bankAccountNbr + "):" + amount; 
	}

}
