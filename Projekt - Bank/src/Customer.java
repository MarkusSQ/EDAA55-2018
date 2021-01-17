import java.util.ArrayList;

public class Customer {
	String name;
	long idNr;
	public static ArrayList<Integer> customers = new ArrayList<Integer>(); //viktigt att skriva Integer (generisk form) istället för int.
	int customerNbr = 0; //vad betyder det när något är public men inte static?
	static int bC;
	/**
	* Skapar en kund (kontoinnehavare) med namnet ’name’ och id-nummer ’idNr’.
	* Kunden tilldelas också ett unikt kundnummer.
	*/
	Customer(String name, long idNr){
		this.name = name;
		this.idNr = idNr;
		customers.add(customerNbr);
		customerNbr = bC;
		bC++;
	}
	
	
	/** Tar reda på kundens namn. */
	String getName() {
		return name;
	}
	/** Tar reda på kundens personnummer. */
	public long getIdNr() { //vad händer om man tar bort private(frågan gäller ej exakt här längre, men kolla upp!
		return idNr;
	}
	/** Tar reda på kundens kundnummer. */
	public int getCustomerNr() {
		return customerNbr;
	}
	/** Returnerar en strängbeskrivning av kunden. */
	public String toString() {
		return "Namn:" + name + ", ID:" + Long.toString(idNr) + ", Kundnummer:" + Integer.toString(customerNbr);
	}
}
