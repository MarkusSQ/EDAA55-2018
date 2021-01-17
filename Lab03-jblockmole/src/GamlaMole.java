public class GamlaMole {
	public class Mole {
		publi stati void main(String[] args) {
			System.out.println("Keep on digging!");
			Graphics g = new Graphics(30, 50, 10); //Svar 2.d: Variabeln g är inte definierad, alltså ger nästa sats endast felmeddelanden
			//Svar 3.e: Java kommer att använda sig av "default constructor", som skapar objekt. Denna är alltså definierad av Java, inte programmeraren
			g.square(); //svar 2.c: vi har endast deklarerat objektet Graphics, inte använt någon metod inuti den (ex square)
			g.block(1, 10, Colors.SOIL);
			g.rectangle(5, 5, 10, 10, Colors.TUNNEL);	
			}
		}
}
