import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class Kvadrater {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "Kvadrater");
		int oldX = 250;
		int oldY = 250;
		Square sq = new Square(250, 250, 100);
		sq.draw(w);
		while (true) {
			w.waitForMouseClick();
			int a = w.getMouseX();
			int b = w.getMouseY();
			sq.erase(w);
			sq = new Square(oldX, oldY, 100);
			sq.move(a - oldX, b - oldY);
			// Varför går det inte att direkt skriva in getx och gety?
			sq.draw(w);
			oldX = w.getX();
			oldY = w.getY();

		}
	}
}

