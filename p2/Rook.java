import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { color = c; }
    

    public String toString() {
        Color b = Color.BLACK;
        Color w = Color.WHITE;
        String name;
        if(color() == b){
            name = "br";
            return name;
        }
        else if(color() == w){
            name = "wr";
            return name;
        }
        else{
            throw new UnsupportedOperationException();
        }
        }

    public List<String> moves(Board b, String loc) {
    Color pcolor = color();
    List<String> leftvalid = allleftchecker(loc, b, pcolor);
    List<String> rightvalid = allrightchecker(loc, b, pcolor);
    List<String> upvalid = allupchecker(loc, b, pcolor);
    List<String> downvalid = alldownchecker(loc, b, pcolor);
    
    List<String> totalmovesvalid = new ArrayList<String>();
    totalmovesvalid.addAll(leftvalid);
    totalmovesvalid.addAll(rightvalid);
    totalmovesvalid.addAll(downvalid);
    totalmovesvalid.addAll(upvalid);

    return totalmovesvalid;
    }

}