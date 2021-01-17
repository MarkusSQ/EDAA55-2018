package memory;

public class MemoryGame {

	public static void main(String[] args) {
		String[] frontFileNames = { "can.jpg", "flopsy_mopsy_cottontail.jpg", "friends.jpg", "mother_ladybird.jpg",
				"mr_mcgregor.jpg", "mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };

		// u[r][c] = [false][false];
		int r;
		int c;
		int i = 0;
		int rt = -1;
		int ct = -1;
		int tries = 0;
		MemoryBoard board = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow window = new MemoryWindow(board);
		window.drawBoard();

		while (true) {
			window.waitForMouseClick();
			r = window.getMouseRow();
			c = window.getMouseCol();
			if(i==0) {
				board.turnCard(r, c);
				window.drawCard(r, c);
				rt =r;
				ct = c;
				i++;
			}else {
				board.turnCard(r,c);
				window.drawCard(r, c);
				i--;
				if (board.getCard(rt, ct) != board.getCard(r, c)) {
					MemoryWindow.delay(1000);
					board.turnCard(rt, ct);
					board.turnCard(r, c);
					window.drawCard(rt, ct);
					window.drawCard(r,c);
					tries++;
					
				} else {
					tries++;
					if (board.hasWon() == true) {
						
					System.out.println("Grattis, du har vunnit!!!1!1!" + tries);
					}
				}
			}
			
		}

	}
}
