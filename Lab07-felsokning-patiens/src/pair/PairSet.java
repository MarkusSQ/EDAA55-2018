package pair;

import java.util.Random;

public class PairSet {
	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();

	/**
	 * Skapar en mängd av alla talpar (a,b) sådana att 0 <= a < rows och 0 <= b <
	 * cols
	 */
	public PairSet(int rows, int cols) {
		n = 0;
		pairs = new Pair[rows * cols];

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				pairs[n] = new Pair(r, c);
				n++;
			}
		}
	}

	/** Undersöker om det finns fler par i mängden. */
	public boolean more() {
		return n>0; //returnar svaret på statement
	}

	/**
	 * Hämtar ett slumpmässigt valt talpar ur mängden. Mängden blir ett element
	 * mindre. Om mängden är tom returneras null.
	 */
	public Pair pick() {
		if (more()) {
			int pick = rand.nextInt(n);
			n--;
			
			Pair pickedPair = pairs[pick];
			pairs[pick] = pairs[n];
			
			return pickedPair;

		}
		return null;
	}
}
