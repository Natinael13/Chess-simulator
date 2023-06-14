public class Board {

    private Piece[][] pieces = new Piece[8][8];

    private Board() { }
    
    public static Board theBoard() {
	return null; // implement this
    }

    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
	throw new UnsupportedOperationException();
    }

    public void addPiece(Piece p, String loc) {
	throw new UnsupportedOperationException();
    }

    public void movePiece(String from, String to) {
	throw new UnsupportedOperationException();
    }

    public void clear() {
	throw new UnsupportedOperationException();
    }

    public void registerListener(BoardListener bl) {
	throw new UnsupportedOperationException();
    }

    public void removeListener(BoardListener bl) {
	throw new UnsupportedOperationException();
    }

    public void removeAllListeners() {
	throw new UnsupportedOperationException();
    }

    public void iterate(BoardInternalIterator bi) {
	throw new UnsupportedOperationException();
    }
}