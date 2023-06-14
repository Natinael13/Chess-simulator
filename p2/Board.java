import java.util.ArrayList;
import java.util.List;

public class Board {

    private Piece[][] pieces = new Piece[8][8];

    private  ArrayList<BoardListener> listners = new ArrayList<BoardListener>();

    private static Board theboard;

    private Board() { }
    
    public static Board theBoard() {
	if(theboard == null){
        theboard = new Board();
    }
    return theboard;
    }


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

    //returns row index from properform location
    public static int rowgetter(char row){
    int i = Character.getNumericValue(row);
    return (i-1);
    }

    //returns colum index from proper form location
    public static int columgetter(char colum){
    int i = 97;
    int result = (colum)-(i);
    return result;
    }

    //returns properform location from double array indexes
    public static String toproperform(int row, int col){
    int j = row+1;
    String rowproper = String.valueOf(j);
    int i = col + 97;
    char colproper = (char) i;
    String result = colproper + rowproper;
    return result;
    }

    
    public Piece getPiece(String loc) {
	checkX(loc.charAt(0));
    checkN(Character.getNumericValue(loc.charAt(1)));
    if(pieces[rowgetter(loc.charAt(1))][columgetter(loc.charAt(0))] == null){
        return null;
    }
    else{
        Piece p = pieces[rowgetter(loc.charAt(1))][columgetter(loc.charAt(0))];
        return p;
    }
    }

    
    public void addPiece(Piece p, String loc) {
	checkX(loc.charAt(0));
    checkN(Character.getNumericValue(loc.charAt(1)));
    if(pieces[rowgetter(loc.charAt(1))][columgetter(loc.charAt(0))] != null){
        throw new UnsupportedOperationException();
    }
    else{
        pieces[rowgetter(loc.charAt(1))][columgetter(loc.charAt(0))] = p;
    }
    }

    public void movePiece(String from, String to) {
	checkX(from.charAt(0));
    checkN(Character.getNumericValue(from.charAt(1)));
    checkX(to.charAt(0));
    checkN(Character.getNumericValue(to.charAt(1)));

    Piece p = getPiece(from);
    if(p == null){
        throw new UnsupportedOperationException();
    }

    Boolean valid = false;
    List<String> validmoves = p.moves(theboard, from);
    String move;
    for(int i = 0; i < validmoves.size(); i++){
        move = validmoves.get(i);
        if(to.equals(move) == true){
            valid = true;
            i = validmoves.size();
        }
    }
    if(valid == false){
        throw new UnsupportedOperationException();
    }

    pieces[rowgetter(from.charAt(1))][columgetter(from.charAt(0))] = null;

    if(getPiece(to) == null){
        for(int i = 0; i < listners.size(); i++){
            listners.get(i).onMove(from, to, p);
        }
    }
    if(getPiece(to) != null){
        for(int i = 0; i < listners.size(); i++){
            listners.get(i).onMove(from, to, p);
            listners.get(i).onCapture(p, getPiece(to));
        }
    }
    pieces[rowgetter(to.charAt(1))][columgetter(to.charAt(0))] = p;
    }

    
    public void clear() {
    for (int i = 0; i < pieces.length; i++) {
        for (int j = 0; j < pieces[i].length; j++) {
            pieces[i][j] = null;
        }
    }
    }

    
    public void registerListener(BoardListener bl) {
	listners.add(bl);
    }

    public void removeListener(BoardListener bl) {
	listners.remove(bl);
    }

    public void removeAllListeners() {
	listners.clear();
    }

    
    public void iterate(BoardInternalIterator bi) {
	for(int i = 0; i < pieces.length;i++){
        for(int j = 0; j < pieces[i].length; j++){
            String properloc = toproperform(i, j);
            bi.visit(properloc, getPiece(properloc));
        }
    }
    }
}