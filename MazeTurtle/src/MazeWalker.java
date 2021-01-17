import se.lth.cs.pt.maze.Maze;
import se.lth.cs.pt.window.SimpleWindow;
import java.util.Scanner;

public class MazeWalker {

	private Turtle turtle;

	public MazeWalker(Turtle turtle) {
		this.turtle = turtle;
	}

	/**
	 * Låter sköldpaddan vandra genom labyrinten maze, från ingången till utgången.
	 */
	public void walk(Maze maze) {
		turtle.penDown();
		turtle.jumpTo(maze.getXEntry(), maze.getYEntry());

		while (maze.atExit(turtle.getX(), turtle.getY()) == false) {
			if (maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) == false) {
				turtle.left(90);
				turtle.forward(1);
			}
			if (maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) == false
					&& maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) == true) {
				turtle.forward(1);
				SimpleWindow.delay(0);
			}
			if (maze.wallInFront(turtle.getDirection(), turtle.getX(), turtle.getY()) == true
					&& maze.wallAtLeft(turtle.getDirection(), turtle.getX(), turtle.getY()) == true) {
				turtle.left(-90);
				
			}
			

		}
		turtle.penUp();
	}
	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		Maze m = new Maze(Scan.nextInt());
		SimpleWindow w = new SimpleWindow(600, 600, "Maze");
		m.draw(w);
		Turtle t = new Turtle(w, 0, 0);
		MazeWalker l = new MazeWalker(t);
		l.walk(m);
		
	
		
	}
}
