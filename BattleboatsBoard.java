//This class makes the board and takes in a user input for the board dimensions
import java.util.Scanner;

public class BattleboatsBoard {
    private int row;private int col;
    private int theLength;private int theWidth;
    private String x="   X   ";private String o="   O   ";
    private String water = "~water~";
    private double holder = (Math.random()); private double holder2 = (Math.random());
    private int placer;
    private int coinToss = (Math.random() <= .5) ? 1 : 2;//50-50 chance that the output is a 1 or 2 (1=heads, 2=tails)
    private String[][] finalBoard;//this is the board that shows the locations
    private String[][] viewBoard;
    private String ship = "|ships|";

    public BattleboatsBoard() {
        theWidth = 3;
        theLength = 3;
        this.finalBoard = new String[3][3];
        this.viewBoard = new String[3][3];

    }

    public BattleboatsBoard(int l, int w) {
        if (12 < l || 12 < w || w < 3 || l < 3) {
            System.out.println("Out of range."+ "\n" + "The board has been set to the maximum size (12x12).");
            theLength = 12;
            theWidth = 12;
            this.finalBoard = new String[12][12];
            this.viewBoard = new String[12][12];
        } else {
            theLength = l;
            theWidth = w;
            this.finalBoard = new String[l][w];
            this.viewBoard = new String[l][w];
        }

    }

    public String[][] placeBoats() {
        for (int i = 0; i < theLength; i++) {
            for (int z = 0; z < theWidth; z++) {
                finalBoard[i][z] = water;
                viewBoard[i][z] = water;
            }
        }
        if (theWidth == 3 || theLength == 3) {
            oneShip();
            System.out.println("There is 1 Battleship. Steady Aim Private!" + "\n");
        } else if (3 < theWidth && theWidth <= 6 || 3 < theLength && theLength <= 6) {
            twoShips();
            System.out.println("There are 2 Battleships. Lead us to victory.");
        } else if (6 < theLength && theLength <= 8 || 6 < theWidth && theWidth <= 8) {
            System.out.println("There are three Battleships! Stay focused.");
            threeShips();
        } else if (8 < theWidth && theWidth <= 10 && 8 < theLength && theLength <= 10) {
            System.out.println("There are four Battleships! Good luck soldier.");
            fourOrsixShips();
        } else {
            System.out.println("There are six Battleships! Failure is not an option.");
            fourOrsixShips();
        }
        return viewBoard;
    }

    public void showBoard() {
        for (int i = 0; i < theWidth; i++) {
            for (int z = 0; z < theLength; z++) {
                System.out.print(viewBoard[z][i] + " ");
            }
            System.out.print("\n");
        }
    }

    public void oneShip() {
        holder = holder * 10;
        placer = (int) Math.floor(holder);//this is a random number that will help determine where, and how the ships are placed
        int temp = (int) (Math.random() * 2);//random number between 0-2 to serve as an index variable for a board that has a width or length of 3
        if (placer % 2 == 0) {//if the random number is even, then the solo ship shall be placed vertically
            finalBoard[0][temp] = (ship);finalBoard[1][temp] = (ship);finalBoard[2][temp] = (ship);
        } else if (placer % 2 == 1) {//if the random number is odd, then the ship will be placed horizontally
            finalBoard[temp][0] = ship;finalBoard[temp][1] = ship;finalBoard[temp][2] = ship;
        }
    }

    public void twoShips() {
        holder = holder * 10;
        int placer = (int) Math.floor(holder);//this is a random number that will help determine where, and how the ships are placed
        int iii = (Math.random() <= .5) ? 0 : 1;//random number between 0-1 to serve as an index variable for a board that has a width or length of 3. 50-50 chance its 1 or 2
        int moreBoats1 = (int) (Math.random() * (theLength - 3) + 2);//(Math.random() <= .5) ? 2 : 3;//theLength-1;// horizontal
        int moreBoats2 = (int) (Math.random() * (theWidth - 3) + 2);//(Math.random() <= .5) ? 2 : 3;//theWidth-1;// vertical
        if (placer % 2 == 0) {//if placer is even, then it places 2 ships that are aligned vertically or horizontally on the board
            if (coinToss == 1) {//if coin toss is heads, it places them vertically
                finalBoard[iii][iii] = (ship);finalBoard[iii + 1][iii] = (ship);finalBoard[iii + 2][iii] = (ship);
                finalBoard[iii][moreBoats2] = (ship);finalBoard[iii + 1][moreBoats2] = (ship);finalBoard[iii + 2][moreBoats2] = (ship);
            } else {//if tails, it places them horizontally
                finalBoard[iii][moreBoats1] = (ship);finalBoard[iii][moreBoats1 - 2] = (ship);finalBoard[iii][moreBoats1 - 1] = (ship);
                finalBoard[moreBoats1][iii] = (ship);finalBoard[moreBoats1][iii + 2] = (ship);finalBoard[moreBoats1][iii + 1] = (ship);
            }
        } else if (placer % 2 == 1) {//if the placer is odd, then it places one horizontal ship and one vertical ship
            System.out.println(iii);
            if (iii == 1) {
                finalBoard[iii+2][moreBoats2] = (ship);finalBoard[iii+2][moreBoats2 + 1] = (ship);finalBoard[iii+2][moreBoats2 - 1] = (ship);//horizontal
                finalBoard[iii][0] = (ship);finalBoard[iii + 1][0] = (ship);finalBoard[iii - 1][0] = (ship);//vertical
            } else {
                finalBoard[iii][moreBoats2] = (ship);finalBoard[iii][moreBoats2 - 1] = (ship);finalBoard[iii][moreBoats2 - 2] = (ship);//horizontal
                finalBoard[moreBoats2 - 1][moreBoats2+1] = (ship);finalBoard[moreBoats2 + 1][moreBoats2+1] = (ship);finalBoard[moreBoats2][moreBoats2+1] = (ship);
                 } } }

    public void threeShips() {
        //threeShips has multiple possible patterns
        holder = holder * 10;
        placer = (int) Math.floor(holder);//if placer is even number, will place 2 vertical ships and 1 horizontal, if it is odd, 2 horizontal and 1 vertical
        //below, there are multiple possible patterns that will be made, depending on the value of 'placer' and 'coin toss'.
        for (int i = 0; i < theLength; i++) {
            for (int z = 0; z < theWidth; z++) {
                if (finalBoard[i][z].equals(water)) {
                    if (placer <= 3) {
                        finalBoard[theLength/2+1][theWidth%2+2]=ship;finalBoard[theLength / 2 + 2][theWidth % 2 + 2] = ship;finalBoard[theLength / 2 + 3][theWidth % 2 + 2] = ship;
                        //vertical ship
                        finalBoard[theWidth%2][theLength / 2] = ship;finalBoard[theWidth % 2][theLength / 2 + 1] = ship;finalBoard[theWidth%2][theLength / 2 - 1] = ship;
                        //horizontal ship
                        finalBoard[theLength/2-1][theLength/2]=ship;finalBoard[theLength/2-1][theLength / 2 - 1] = ship;finalBoard[theLength / 2 - 1][theLength / 2 - 2] = ship;
                        //the three ships placed above, make  a shape similar to a T, and have a horizontally placed ship above and to the right of the T.
                    } else if (3 < placer && placer <= 6) {//what shape do we want? two vertical on the sides, and one horizontal in between the two. Like a spaced out 'H'.
                        if (theWidth % 2 == 0 && theLength % 2 == 0) {//essentially only works for 8x8 and 6x8/8/6 boards, but its a good change of pace at times
                            finalBoard[theLength/2][theWidth%2]=ship;finalBoard[theLength/2-1][theWidth%2]=ship;finalBoard[theLength/2+1][theWidth % 2] = ship;
                            //the leftmost vertical ship
                            finalBoard[theLength/2][theWidth-1] = ship;finalBoard[theLength / 2 - 1][theWidth - 1] = ship;finalBoard[theLength / 2 + 1][theWidth - 1] = ship;
                            //the rightmost vertical ship
                            finalBoard[theLength / 2][theWidth / 2] = ship;finalBoard[theLength / 2][theWidth / 2 - 1] = ship;finalBoard[theLength / 2][theWidth / 2 + 1] = ship;
                            //the middle ship, meant to be placed at the middle index of the other two ships
                        } else {//goal here is to make something other than a T shape and an H. Want to make a Spaced out F shape that is more towards the bottom right corner/middle
                            finalBoard[theLength % 2 + 2][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 3][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 4][theWidth % 2 + 1] =ship;

                            finalBoard[theLength % 2 + 3][theWidth - 1] = ship;finalBoard[theLength % 2 + 3][theWidth - 2] = ship;finalBoard[theLength % 2 + 3][theWidth - 3] = ship;

                            finalBoard[theLength % 2 + 2][theWidth - 1] = ship;finalBoard[theLength % 2 + 2][theWidth - 2] = ship;finalBoard[theLength % 2 + 2][theWidth - 3] = ship;
                            }
                    } else if (6 < placer && placer <= 10) {
                        finalBoard[theLength % 2][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 1][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 2][theWidth % 2 + 1] = ship;
                        if (coinToss == 1) {//heads, puts three vertical ships
                            finalBoard[theLength% 2 + 2][theWidth % 2] = ship;finalBoard[theLength % 2 + 3][theWidth % 2] = ship;finalBoard[theLength % 2 + 4][theWidth % 2] = ship;

                            finalBoard[theLength % 2 + 3][theWidth / 2] = ship;finalBoard[theLength % 2 + 4][theWidth / 2] = ship;finalBoard[theLength % 2 + 5][theWidth / 2] = ship;
                        } else {
                            finalBoard[theLength%2+1][theWidth-3]=ship;finalBoard[theLength%2+1][theWidth-2]=ship;finalBoard[theLength % 2 + 1][theWidth - 1] = ship;

                            finalBoard[theLength-1][theWidth%2+1]=ship;finalBoard[theLength-1][theWidth%2+2]=ship;finalBoard[theLength-1][theWidth%2+3]=ship; } } } } }
    }

    public void fourOrsixShips() {
        //does the same as 3 ships, but prints an extra ship depending on the board length
        holder = holder * 10;
        placer = (int) Math.floor(holder);//if placer is even number, will place 2 vertical ships and 1 horizontal, if it is odd, 2 horizontal and 1 vertical
        System.out.println(placer);
        //below, there are multiple possible patterns that will be made, depending on the value of 'placer' and 'coin toss'.
        for (int i = 0; i < theLength; i++) {
            for (int z = 0; z < theWidth; z++) {
                if (finalBoard[i][z].equals(water)) {
                    if (placer <= 3) {
                        finalBoard[theLength/ 2 + 1][theWidth % 2 + 2] = ship;finalBoard[theLength / 2 + 2][theWidth % 2 + 2] = ship;finalBoard[theLength / 2 + 3][theWidth % 2 + 2] = ship;//vert
                        finalBoard[theWidth % 2][theLength / 2] = ship;finalBoard[theWidth % 2][theLength / 2 + 1] = ship;finalBoard[theWidth % 2][theLength / 2 - 1] = ship;//horiz
                        finalBoard[theLength / 2 - 1][theLength / 2] = ship;finalBoard[theLength / 2 - 1][theLength / 2 - 1] = ship;finalBoard[theLength / 2 - 1][theLength / 2 - 2] = ship;//vert
                        finalBoard[theLength / 3 - 1][theWidth % 2 + 6] = ship;finalBoard[theLength / 3 - 2][theWidth % 2 + 6] = ship;finalBoard[theLength / 3][theWidth % 2 + 6] = ship;//vert
                        if (10 < theWidth && theWidth <= 12 && 10 < theLength && theLength <= 12) {
                            finalBoard[theLength/2+3][theLength/2+1] = ship;finalBoard[theLength/2+3][theLength / 2 + 2] = ship;finalBoard[theLength/2+3][theLength / 2 +3] = ship;
                            finalBoard[theWidth % 2][theLength % 2] = ship;finalBoard[theWidth % 2 + 1][theLength % 2] = ship;finalBoard[theWidth % 2 + 2][theLength % 2] = ship;
                        }
                        //the three ships placed above, make  a shape similar to a T, and have a horizontally placed ship above and to the right of the T.
                    } else if (3 < placer && placer <= 6) {//what shape do we want? two vertical on the sides, and one horizontal in between the two. Like a spaced out 'H'.
                        if (theWidth % 2 == 0 && theLength % 2 == 0) {//essentially only works for 8x8 and 6x8/8/6 boards, but its a good change of pace at times
                            finalBoard[theLength / 2][theWidth % 2] = ship;finalBoard[theLength / 2 - 1][theWidth % 2] = ship;finalBoard[theLength / 2 + 1][theWidth % 2] = ship;
                            //the leftmost vertical ship
                            finalBoard[theLength / 2][theWidth - 1] = ship;finalBoard[theLength / 2 - 1][theWidth - 1] = ship;finalBoard[theLength / 2 + 1][theWidth - 1] = ship;
                            //the rightmost vertical ship
                            finalBoard[theLength / 2][theWidth / 2] = ship;finalBoard[theLength / 2][theWidth / 2 - 1] = ship;finalBoard[theLength / 2][theWidth / 2 + 1] = ship;
                            //the middle ship, meant to be placed at the middle index of the other two ships
                            finalBoard[theLength / 2 - 3][theWidth / 2 - 2] = ship;finalBoard[theLength / 2 - 3][theWidth / 2 - 3] = ship;finalBoard[theLength / 2 - 3][theWidth / 2 - 1] = ship;
                            if (10 < theWidth && theWidth <= 12 && 10 < theLength && theLength <= 12) {
                                finalBoard[theWidth % 3][theWidth % 3] = ship;finalBoard[theWidth % 3][theWidth % 3 + 1] = ship;finalBoard[theWidth % 3][theWidth % 3 + 2] = ship;
                                finalBoard[theLength % 7 + 3][theLength % 7 + 3] = ship;finalBoard[theLength % 7 + 3][theLength % 7 + 2] = ship;finalBoard[theLength % 7 + 3][theLength % 7 + 1] = ship;
                            }
                        } else {//goal here is to make something other than a T shape and an H. Want to make a Spaced out F shape that is more towards the bottom right corner/middle
                            finalBoard[theLength % 2 + 2][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 3][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 4][theWidth % 2 + 1] = ship;
                            finalBoard[theLength % 2 + 3][theWidth - 1] = ship;finalBoard[theLength % 2 + 3][theWidth - 2] = ship;finalBoard[theLength % 2 + 3][theWidth - 3] = ship;
                            finalBoard[theLength % 2 + 2][theWidth - 1] = ship;finalBoard[theLength % 2 + 2][theWidth - 2] = ship;finalBoard[theLength % 2 + 2][theWidth - 3] = ship;
                            finalBoard[theLength % 7 + 4][theLength % 7] = ship;finalBoard[theLength % 7 + 4][theLength % 7 + 1] = ship;finalBoard[theLength % 7 + 4][theLength % 7 + 2] = ship;
                            if (10 < theWidth && theWidth <= 12 && 10 < theLength && theLength <= 12) {
                                finalBoard[theLength - 1][theWidth % 3] = ship;finalBoard[theLength - 1][theWidth % 3 + 1] = ship;finalBoard[theLength - 1][theWidth % 3 + 2] = ship;
                                finalBoard[theWidth % 2][theLength % 2] = ship;finalBoard[theWidth % 2 + 1][theLength % 2] = ship;finalBoard[theWidth % 2 + 2][theLength % 2] = ship;
                            }
                        }
                    } else if (6 < placer && placer <= 10) {
                        finalBoard[theLength % 2][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 1][theWidth % 2 + 1] = ship;finalBoard[theLength % 2 + 2][theWidth % 2 + 1] = ship;
                        if (coinToss == 1) {//heads, puts three vertical ships
                            finalBoard[theLength % 2 + 2][theWidth % 2] = ship;finalBoard[theLength % 2 + 3][theWidth % 2] = ship;finalBoard[theLength % 2 + 4][theWidth % 2] = ship;
                            finalBoard[theLength % 2 + 3][theWidth / 2] = ship;finalBoard[theLength % 2 + 4][theWidth / 2] = ship;finalBoard[theLength % 2 + 5][theWidth / 2] = ship;
                            finalBoard[theLength % 2][theWidth - 1] = ship;finalBoard[theLength % 2 + 1][theWidth - 1] = ship;finalBoard[theLength % 2 + 2][theWidth - 1] = ship;
                            if (10 < theWidth && theWidth <= 12 && 10 < theLength && theLength <= 12) {
                                finalBoard[theLength % 2 + 4][theWidth / 2 + 2] = ship;finalBoard[theLength % 2 + 5][theWidth / 2 + 2] = ship;finalBoard[theLength % 2 + 6][theWidth / 2 + 2] = ship;
                                finalBoard[theLength % 2 + 4][theWidth / 2 - 2] = ship;finalBoard[theLength % 2 + 5][theWidth / 2 - 2] = ship;finalBoard[theLength % 2 + 6][theWidth / 2 - 2] = ship;
                            }
                        } else {
                            finalBoard[theLength % 2 + 1][theWidth - 3] = ship;finalBoard[theLength % 2 + 1][theWidth - 2] = ship;finalBoard[theLength % 2 + 1][theWidth - 1] = ship;
                            finalBoard[theLength - 1][theWidth % 2 + 1] = ship;finalBoard[theLength - 1][theWidth % 2 + 2] = ship;finalBoard[theLength - 1][theWidth % 2 + 3] = ship;
                            finalBoard[theLength % 2 + 2][theWidth - 1] = ship;finalBoard[theLength % 2 + 3][theWidth - 1] = ship;finalBoard[theLength % 2 + 4][theWidth - 1] = ship;
                            if (10 < theWidth && theWidth <= 12 && 10 < theLength && theLength <= 12) {
                                finalBoard[theLength - 1][theWidth % 7 + 2] = ship;finalBoard[theLength - 2][theWidth % 7 + 2] = ship;finalBoard[theLength - 3][theWidth % 7 + 2] = ship;
                                finalBoard[theLength % 2 + 4][theWidth / 3] = ship;finalBoard[theLength % 2 + 4][theWidth / 3 + 1] = ship;finalBoard[theLength % 2 + 4][theWidth / 3 + 2] = ship;
                            } } } } } }
    }

    public void debugMode(){
        for (int i = 0; i < theWidth; i++) {
            for (int z = 0; z < theLength; z++) {
                System.out.print(finalBoard[z][i] + " "); }
            System.out.print("\n"); }
    }

    public String doBattle() {
        String str="";
        Scanner s = new Scanner(System.in);
        System.out.println("Guns are loaded soldier." + "\n");
        System.out.println("Be sure to fire within the valid bounds that have been set. 0-Max Length/Width"+"\n");
        //String choose= s.nextLine();
        System.out.println("Enter Column Value:");row = s.nextInt();

        System.out.println("Enter Row Value:");col = s.nextInt();

        if(col>=theWidth || row >= theLength || row<0 || col < 0){
            System.out.print("Not even close. Lost a turn.");
            return "skip";
        }
        else if(finalBoard[row][col].equals(x)||viewBoard[row][col].equals(o)){
            System.out.print("You already targeted this location! Lost a turn.");
            return "skip";
        }
        else if (finalBoard[row][col].equals("|ships|")) {
            finalBoard[row][col] = x;
            viewBoard[row][col] = x;
            str = "Hit";
            if(sinkShip()){
                System.out.println("Sunk");
            }
            System.out.println(str);
        }
        else {
            if (!(finalBoard[row][col].equals(x)||finalBoard[row][col].equals(ship))){
                viewBoard[row][col] = o;
                str = "Miss";
                System.out.println(str);
            }
        }

        return "play";
    }

    public boolean useDrone(){
        int theRow;int theCol;
        System.out.println("Where would you like to scan for enemies? (Will lose 4 turns)");
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Row coordinate: ");
        theRow=s.nextInt();
        System.out.println("Enter Column coordinate: ");
        theCol=s.nextInt();
        if(theRow>=theWidth||theCol>=theLength||theRow<0||theCol<0){
            System.out.println("Error: Drone out of range. Penalty activated... Lose 5 turns");
            return false;
        }
        else{
            for(int i=0;i<theWidth;i++){
                System.out.println(finalBoard[theRow][i]+"(row,col) = ("+theRow+","+i+")");//this is showing the row that they chose to see
            }
            for(int z=theRow;z<theLength;z++) {
                System.out.println(finalBoard[z][theCol]+ "(row,col) = (" + z + "," + theCol + ")");//this is showing the row that they chose to see
            }
        }
        return true;
    }

    public boolean sinkShip() {
        for (int i = 0; i < row; i++) {
            for (int z = 0; z < col; z++) {
                if (row + 2 < theLength && row + 1 < theLength) {
                    if (viewBoard[row + 2][col].equals(x) && viewBoard[row + 1][col].equals(x)) {
                        System.out.println("You sunk a ship");
                    }
                } else if (row - 2 > 0 && row - 1 > 0) {
                    if (finalBoard[row - 2][col].equals(x) && finalBoard[row - 1][col].equals(x)) {
                        System.out.println("You sunk a ship");
                    }
                } else if (row - 1 > 0 && row + 1 < theLength) {
                    if (finalBoard[row - 1][col].equals(x) && finalBoard[row + 1][col].equals(x)) {
                        System.out.println("You sunk a ship");
                    }
                } else if (col + 2 < theWidth && col + 1 < theWidth) {
                    if (finalBoard[row][col + 2].equals(x) && finalBoard[row][col + 1].equals(x)){
                        System.out.println("You sunk a ship");
                    }
                } else if (col - 2 > 0 && col - 1 > 0) {
                    if (finalBoard[row][col - 2].equals(x) && finalBoard[row][col - 1].equals(x)) {
                        System.out.println("You sunk a ship");
                    }
                } else if (col - 1 > 0 && col + 1 < theWidth) {
                    if (finalBoard[row][col - 1].equals(x) && finalBoard[row][col + 1].equals(x)) {
                        System.out.println("You sunk a ship");
                    }
                }
            }
            return true;
        }
        return false;
    }

        public Boolean getHealth(){
            for (int i = 0; i < theWidth; i++) {
                for (int z = 0; z < theLength; z++) {
                    if ((finalBoard[i][z].equals("|ships|"))) {
                        return true; } }
            }
            return false; }
    }


