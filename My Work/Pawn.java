import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) { color = c;}


    public String toString() {
    Color b = Color.BLACK;
    Color w = Color.WHITE;
    String name;
	if(color() == b){
        name = "bp";
        return name;
    }
    else if(color() == w){
        name = "wp";
        return name;
    }
    else{
        throw new UnsupportedOperationException();
    }
    }

    public static Boolean pawnmchecker(String loc, Board b, Color pcolor){
    Boolean result = false;
    if(loc != null){
        if(b.getPiece(loc) == null){
            result = true;
            return result;
        }
    }
    return result;
    }

    public static Boolean pawndiamchecker(String loc, Board b, Color pcolor){
    Boolean result = false;
    if(loc != null){
        if(b.getPiece(loc) != null){
            result = true;
            return result;
        }
    }
    return result;
    }

    public List<String> moves(Board b, String loc) {
    List<String> validmoves = new ArrayList<String>();
    Color pcolor = color();

    //case1
    if(pcolor == Color.BLACK){
        String case1 = downfinder(loc);
        if(pawnmchecker(case1, b, pcolor) == true){
            validmoves.add(case1);
        }
    }

    if(pcolor == Color.WHITE){
        String case1 = upfinder(loc);
        if(pawnmchecker(case1, b, pcolor) == true){
            validmoves.add(case1);
        }
    }

    //case 2
    if(pcolor == Color.BLACK){
        if(rowgetter(loc.charAt(1)) == 6){
            String case1 = downfinder(loc);
            if(pawnmchecker(case1, b, pcolor) == true){
                String case2 = downfinder(case1);
                if(pawnmchecker(case2, b, pcolor) == true){
                    validmoves.add(case2);
                }
            }
        }
    }

    if(pcolor == Color.WHITE){
        if(rowgetter(loc.charAt(1)) == 1){
            String case1 = upfinder(loc);
            if(pawnmchecker(case1, b, pcolor) == true){
                String case2 = upfinder(case1);
                if(pawnmchecker(case2, b, pcolor) == true){
                    validmoves.add(case2);
                }
            }
        }
    }

    //case3
    if(pcolor == Color.BLACK){
        String case3 = diaLLfinder(loc);
        if(pawndiamchecker(case3, b, pcolor) == true){
            validmoves.add(case3);
        }
    }

    if(pcolor == Color.WHITE){
        String case3 = diaULfinder(loc);
        if(pawndiamchecker(case3, b, pcolor) == true){
            validmoves.add(case3);
        }
    }

    //case4
    if(pcolor == Color.BLACK){
        String case3 = diaLRfinder(loc);
        if(pawndiamchecker(case3, b, pcolor) == true){
            validmoves.add(case3);
        }
    }

    if(pcolor == Color.WHITE){
        String case3 = diaURfinder(loc);
        if(pawndiamchecker(case3, b, pcolor) == true){
            validmoves.add(case3);
        }
    }

    return validmoves;
    }

}