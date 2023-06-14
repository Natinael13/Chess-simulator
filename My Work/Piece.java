import java.util.*;

abstract public class Piece {

    protected Color color;
    public static HashMap<Character, PieceFactory> symbolmap = new HashMap<>();


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

    public static String leftfinder(String loc){
    int colum = columgetter(loc.charAt(0));
    colum = colum - 1;
    if(colum < 0){
        return null;
    }
    int row = rowgetter(loc.charAt(1));
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String rightfinder(String loc){
    int colum = columgetter(loc.charAt(0));
    colum = colum + 1;
    if(colum > 7){
        return null;
    }
    int row = rowgetter(loc.charAt(1));
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String upfinder(String loc){
    int row = rowgetter(loc.charAt(1));
    row = row +1;
    if(row > 7){
        return null;
    }
    int colum = columgetter(loc.charAt(0));
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String downfinder(String loc){
    int row = rowgetter(loc.charAt(1));
    row = row -1;
    if(row < 0){
        return null;
    }
    int colum = columgetter(loc.charAt(0));
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String diaULfinder(String loc){
    int row = rowgetter(loc.charAt(1));
    int colum = columgetter(loc.charAt(0));
    row = row +1;
    if(row > 7){
        return null;
    }
    colum = colum - 1;
    if(colum < 0){
        return null;
    }
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String diaURfinder(String loc){
    int row = rowgetter(loc.charAt(1));
    int colum = columgetter(loc.charAt(0));
    row = row +1;
    if(row > 7){
        return null;
    }
    colum = colum + 1;
    if(colum > 7){
        return null;
    }
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String diaLLfinder(String loc){
    int row = rowgetter(loc.charAt(1));
    int colum = columgetter(loc.charAt(0));
    row = row -1;
    if(row < 0){
        return null;
    }
    colum = colum - 1;
    if(colum < 0){
        return null;
    }
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static String diaLRfinder(String loc){
    int row = rowgetter(loc.charAt(1));
    int colum = columgetter(loc.charAt(0));
    row = row -1;
    if(row < 0){
        return null;
    }
    colum = colum +1;
    if(colum > 7){
        return null;
    }
    String resultloc = toproperform(row, colum);
    return resultloc;
    }

    public static Boolean addmchecker(String loc, Board b, Color pcolor){
    Boolean result = false;
    if(loc != null){
        if(b.getPiece(loc) == null){
            result = true;
            return result;
        }
        if(b.getPiece(loc).color() != pcolor){
            result = true;
            return result;
        }
    }
    return result;
    }

    public static List<String> allleftchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = leftfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> allrightchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = rightfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> allupchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = upfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> alldownchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = downfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> alldiaULchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = diaULfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> alldiaURchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = diaURfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> alldiaLLchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = diaLLfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }

    public static List<String> alldiaLRchecker(String loc, Board b, Color pcolor){
    List<String> leftvalid = new ArrayList<String>();
    String holderloc;
    Boolean keepgoing = true;
    while(keepgoing == true){
        holderloc = diaLRfinder(loc);
        if(holderloc == null){
            keepgoing = false;
        }
        else if(b.getPiece(holderloc) == null){
            leftvalid.add(holderloc);
            loc = holderloc;
        }
        else if(b.getPiece(holderloc).color() != pcolor){
            leftvalid.add(holderloc);
            keepgoing = false;
        }
        else if(b.getPiece(holderloc).color() == pcolor){
            keepgoing = false;
        }
    }
    return leftvalid;
    }


    public static void registerPiece(PieceFactory pf) {
	symbolmap.put(pf.symbol(), pf);
    }

    public static Piece createPiece(String name) {
	if(name.charAt(0) == 'b'){
        Piece p = (symbolmap.get(name.charAt(1))).create(Color.BLACK);
        return p;
    }
    else if(name.charAt(0) == 'w'){
        Piece p = (symbolmap.get(name.charAt(1))).create(Color.WHITE);
        return p;
    }
    else{
        throw new UnsupportedOperationException();
    }
    }

    public Color color() {
	return color;
    }

    abstract public String toString();

    abstract public List<String> moves(Board b, String loc);
}