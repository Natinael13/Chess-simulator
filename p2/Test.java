import java.util.ArrayList;
import java.util.List;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

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

    public static void test1() {
	Board b = Board.theBoard();
	Piece.registerPiece(new KingFactory());
    Piece.registerPiece(new PawnFactory());
	Piece p = Piece.createPiece("wp");
    Piece p2 = Piece.createPiece("bk");
    List<String> moves = p.moves(b, "d2");
    for(int i = 0; i < moves.size(); i++){
        System.out.println(moves.get(i));
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
        Piece p = b.getPiece(loc);
        Color pcolor = p.color();
    
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
            if(rowgetter(loc.charAt(1)) == 7){
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
            if(rowgetter(loc.charAt(1)) == 2){
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


    
    public static void main(String[] args) {
    test1();
    }

}