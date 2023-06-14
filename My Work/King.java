import java.util.*;

public class King extends Piece {
    public King(Color c) { color = c; }
    

    public String toString() {
        Color b = Color.BLACK;
        Color w = Color.WHITE;
        String name;
        if(color() == b){
            name = "bk";
            return name;
        }
        else if(color() == w){
            name = "wk";
            return name;
        }
        else{
            throw new UnsupportedOperationException();
        }
        }

    public List<String> moves(Board b, String loc) {
        List<String> validmoves = new ArrayList<String>();
        String left = leftfinder(loc);
        String right = rightfinder(loc);
        String up = upfinder(loc);
        String down = downfinder(loc);
        String diaUL = diaULfinder(loc);
        String diaUR = diaURfinder(loc);
        String diaLL = diaLLfinder(loc);
        String diaLR = diaLRfinder(loc);
        Color pcolor = color();

        if(addmchecker(left, b, pcolor) == true){
            validmoves.add(left);
        }
        if(addmchecker(right, b, pcolor) == true){
            validmoves.add(right);
        }
        if(addmchecker(up, b, pcolor) == true){
            validmoves.add(up);
        }
        if(addmchecker(down, b, pcolor) == true){
            validmoves.add(down);
        }
        if(addmchecker(diaUL, b, pcolor) == true){
            validmoves.add(diaUL);
        }
        if(addmchecker(diaUR, b, pcolor) == true){
            validmoves.add(diaUR);
        }
        if(addmchecker(diaLL, b, pcolor) == true){
            validmoves.add(diaLL);
        }
        if(addmchecker(diaLR, b, pcolor) == true){
            validmoves.add(diaLR);
        }
        return validmoves;
    }

}