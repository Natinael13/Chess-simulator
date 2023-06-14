import java.util.*;

abstract public class Piece {
    public static void registerPiece(PieceFactory pf) {
	throw new UnsupportedOperationException();
    }

    public static Piece createPiece(String name) {
	throw new UnsupportedOperationException();
    }

    public Color color() {
	// You should write code here and just inherit it in
	// subclasses. For this to work, you should know
	// that subclasses can access superclass fields.
	throw new UnsupportedOperationException();
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}