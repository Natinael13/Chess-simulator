import java.io.BufferedReader;
import java.io.FileReader;

public class Chess {

	public static Board b = Board.theBoard();

	public static void checkX(char x){
	for (int i = 97; i < 105; i++) { 
		if(x == i){
			return;
		}
	}
	throw new UnsupportedOperationException();
	}

	public static void checkN(int n){
	for (int i = 1; i < 9; i++) { 
		if(i == n){
			return;
		}
	}
	throw new UnsupportedOperationException();
	}

	public static void checkC(char c){
	if(c == 98){
		return;
	}
	else if(c == 119){
		return;
	}
	throw new UnsupportedOperationException();
	}

	public static void checkM(char m, char divider){
	if(m == divider){
		return;
	}
	throw new UnsupportedOperationException();
	}

	public static void checkP(char p){
	if(p == 'k'){
		return;
	}
	else if(p == 'q'){
		return;
	}
	else if(p == 'n'){
		return;
	}
	else if(p == 'b'){
		return;
	}
	else if(p == 'r'){
		return;
	}
	else if(p == 'p'){
		return;
	}
	throw new UnsupportedOperationException();
	}

	public static void insert(String loc, String p){
	Piece newp = Piece.createPiece(p);
	b.addPiece(newp, loc);
	}

    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}

	//register peices
	Piece.registerPiece(new KingFactory());
	Piece.registerPiece(new QueenFactory());
	Piece.registerPiece(new KnightFactory());
	Piece.registerPiece(new BishopFactory());
	Piece.registerPiece(new RookFactory());
	Piece.registerPiece(new PawnFactory());

	Board.theBoard().registerListener(new Logger());

	//read layout file
	try {
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String currline;
		while ((currline = reader.readLine()) != null) {
			if((currline.charAt(0)) != ('#')){
				checkX(currline.charAt(0));
				checkN(Character.getNumericValue(currline.charAt(1)));
				checkM(currline.charAt(2), '=');
				checkC(currline.charAt(3));
				checkP(currline.charAt(4));
				insert(currline.substring(0, 2), currline.substring(3, 5));
			}
		}
		reader.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	//read moves file
	try {
		BufferedReader reader = new BufferedReader(new FileReader(args[1]));
		String currline;
		while ((currline = reader.readLine()) != null) {
			if((currline.charAt(0)) != ('#')){
				checkX(currline.charAt(0));
				checkN(Character.getNumericValue(currline.charAt(1)));
				checkM(currline.charAt(2), '-');
				checkX(currline.charAt(3));
				checkN(Character.getNumericValue(currline.charAt(4)));
				b.movePiece(currline.substring(0, 2), currline.substring(3, 5));
			}
		}
		reader.close();
	} catch (Exception e) {
		e.printStackTrace();
	}


	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}