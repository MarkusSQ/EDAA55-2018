package memory;

import java.util.Random;

public class MemoryBoard {
	int size;
	int NbrCards;
	MemoryCardImage[][] m;
	boolean[][] u;
	int won;

	/**
	 * Skapar ett memorybräde med size * size kort. backFileName är filnamnet för
	 * filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen för
	 * frontbilderna.
	 */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		NbrCards = size * size / 2; // Antalet unika kort
		m = new MemoryCardImage[size][size];
		createCards(backFileName, frontFileNames);
		u = new boolean[size][size];
	}

	/*
	 * Skapar size * size / 2 st memorykortbilder. Placerar ut varje kort på två
	 * slumpmässiga ställen på spelplanen.
	 */
	private void createCards(String backFileName, String[] frontFileNames) {
		Random rand = new Random();
		int r = rand.nextInt(size);
		int c = rand.nextInt(size);
		MemoryCardImage[] m2 = new MemoryCardImage[NbrCards];
		for (int i = 0; i < NbrCards; i++) {
			m2[i] = new MemoryCardImage(frontFileNames[i], backFileName);
		}
		for (int t = 0; t < 2; t++) {
			for (int k = 0; k < NbrCards;) {
				if (m[r][c] == null) {
					m[r][c] = m2[k];
					k++;
				}
				r = rand.nextInt(size);
				c = rand.nextInt(size);
			}

		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}

	/**
	 * Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c. Raderna och
	 * kolonnerna numreras från 0 och uppåt.
	 */
	public MemoryCardImage getCard(int r, int c) {
		return m[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		if (u[r][c] == false) {
			u[r][c] = true;
		} else
			u[r][c] = false;
	}

	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return u[r][c]; // Tänker såhär: nu är alla element null, alltså false. måste tilldelas värden
						// för att bli true
	}

	/**
	 * Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2,
	 * kolonn c2.
	 */
	public boolean same(int r1, int c1, int r2, int c2) {
		return false;
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m.length; c++) {
				if (frontUp(r, c) == false) {
					return false;
				}
				}
			}
		return true;
		
	}
}
