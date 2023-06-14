import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { color = c; }

    public String toString() {
        Color b = Color.BLACK;
        Color w = Color.WHITE;
        String name;
        if(color() == b){
            name = "bb";
            return name;
        }
        else if(color() == w){
            name = "wb";
            return name;
        }
        else{
            throw new UnsupportedOperationException();
        }
        }

    public List<String> moves(Board b, String loc) {
    Color pcolor = color();
    List<String> diaULvalid = alldiaULchecker(loc, b, pcolor);
    List<String> diaURvalid = alldiaURchecker(loc, b, pcolor);
    List<String> diaLLvalid = alldiaLLchecker(loc, b, pcolor);
    List<String> diaLRvalid = alldiaLRchecker(loc, b, pcolor);
    
    List<String> totalmovesvalid = new ArrayList<String>();
    totalmovesvalid.addAll(diaULvalid);
    totalmovesvalid.addAll(diaURvalid);
    totalmovesvalid.addAll(diaLLvalid);
    totalmovesvalid.addAll(diaLRvalid);

    return totalmovesvalid;
    }

}