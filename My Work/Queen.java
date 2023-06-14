import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { color = c; }
    

    public String toString() {
        Color b = Color.BLACK;
        Color w = Color.WHITE;
        String name;
        if(color() == b){
            name = "bq";
            return name;
        }
        else if(color() == w){
            name = "wq";
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
    List<String> diaULvalid = alldiaULchecker(loc, b, pcolor);
    List<String> diaURvalid = alldiaURchecker(loc, b, pcolor);
    List<String> diaLLvalid = alldiaLLchecker(loc, b, pcolor);
    List<String> diaLRvalid = alldiaLRchecker(loc, b, pcolor);
    
    List<String> totalmovesvalid = new ArrayList<String>();
    totalmovesvalid.addAll(leftvalid);
    totalmovesvalid.addAll(rightvalid);
    totalmovesvalid.addAll(downvalid);
    totalmovesvalid.addAll(upvalid);
    totalmovesvalid.addAll(diaULvalid);
    totalmovesvalid.addAll(diaURvalid);
    totalmovesvalid.addAll(diaLLvalid);
    totalmovesvalid.addAll(diaLRvalid);

    return totalmovesvalid;
    }

}