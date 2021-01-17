public class Mole {
	private Graphics g = new Graphics(30, 50, 10);
	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
		}
	public void drawWorld () {
		g.rectangle(0, 0, 300, 500, Colors.SOIL); //hur fixar man för alla fönster?
	}
	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() /2; 
		while (true) {
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			
			g.block(x, y, Colors.TUNNEL);
			
			if (key == 'w') {
				y = y - 1;
			}
			else if (key == 'a') {
				x = x - 1;
			}
			else if (key == 's') {
				y = y + 1;
		}
			else if (key == 'd') {
				x = x + 1;
		}
	}
	
	}
}

	