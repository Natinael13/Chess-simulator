import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { color = c; }
    

    public String toString() {
        Color b = Color.BLACK;
        Color w = Color.WHITE;
        String name;
        if(color() == b){
            name = "bn";
            return name;
        }
        else if(color() == w){
            name = "wn";
            return name;
        }
        else{
            throw new UnsupportedOperationException();
        }
        }

    public String movefinder(String loc, int c, int r){
    int colum = columgetter(loc.charAt(0));
    int row = rowgetter(loc.charAt(1));

    colum = colum + c;
    if(colum < 0){
        return null;
    }
    if(colum > 7){
        return null;
    }

    row = row + r;
    if(row < 0){
        return null;
    }
    if(row > 7){
        return null;
    }

    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public List<String> moves(Board b, String loc) {
        List<String> validmoves = new ArrayList<String>();
        String case1 = movefinder(loc, -1, 2);
        String case2 = movefinder(loc, 1, 2);
        String case3 = movefinder(loc, -1, -2);
        String case4 = movefinder(loc, 1, -2);
        String case5 = movefinder(loc, 2, -1);
        String case6 = movefinder(loc, 2, 1);
        String case7 = movefinder(loc, -2, -1);
        String case8 = movefinder(loc, -2, 1);
        Color pcolor = color();

        if(addmchecker(case1, b, pcolor) == true){
            validmoves.add(case1);
        }
        if(addmchecker(case2, b, pcolor) == true){
            validmoves.add(case2);
        }
        if(addmchecker(case3, b, pcolor) == true){
            validmoves.add(case3);
        }
        if(addmchecker(case4, b, pcolor) == true){
            validmoves.add(case4);
        }
        if(addmchecker(case5, b, pcolor) == true){
            validmoves.add(case5);
        }
        if(addmchecker(case6, b, pcolor) == true){
            validmoves.add(case6);
        }
        if(addmchecker(case7, b, pcolor) == true){
            validmoves.add(case7);
        }
        if(addmchecker(case8, b, pcolor) == true){
            validmoves.add(case8);
        }
        return validmoves;
    }

}