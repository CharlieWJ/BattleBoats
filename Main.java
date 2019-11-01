import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        BattleboatsBoard final_board = null;
        System.out.println(" _______       ______        _______   ________________   ________             ________   ______________   ______                  _____   ________________");
        System.out.println("|       |     |      |      |       | |                | |        |           (        | |              | |      |                |     | |                |");
        System.out.println("|        |    |      |      /       | |                | |        |          (     ____| |              | |       |              |      | |                |");
        System.out.println("|        |   |        |    /        | |       _________| |        |         (      |     |  ___________ | |        |            |       | |       _________|");
        System.out.println("|         |  |        |   /         | |       |________  |        |        (      |      | |          | | |         |          |        | |      |_________");
        System.out.println("|         |__|        |__/          | |                | |        |       (      |       | |          | | |          |__    __|         | |                |");
        System.out.println(" |                                 |  |         _______| |        |       (      |       | |          | | |       _    |____|   _       | |       _________|");
        System.out.println(" |                                 |  |        |_______  |        |        (     |       | |__________| | |       ||           ||       | |      |_________");
        System.out.println("  |             ______            |   |                | |        |________ (    |_____  |              | |      | |_         _| |      | |                |");
        System.out.println("   |           |      |          |    |                | |                 | (         | |              | |     |   |         |   |     | |                |");
        System.out.println("    |__________|      |_________/     |________________| |_________________|  (________| |______________| |____|     |_______|     |____| |________________|");
        System.out.println("Do you want to use the default board (3x3) or enter your own dimensions?" + "\n" + "Enter 'Default' or 'Custom'");
        String pick = s.nextLine();
        Boolean runner=false;
        if(pick.equals("Default")||pick.equals("default")||pick.equals("d")){
            System.out.println("Prepare for Battle..."+"\n");
            BattleboatsBoard defaultBoard=new BattleboatsBoard();
            defaultBoard.placeBoats();
            final_board=defaultBoard;
            System.out.println("Do you want to activate 'Debug Mode'? (shows the board with all ship placements)"+"\n"+"Enter 'Yes' or 'No': ");
            String mode=s.nextLine();
            if(mode.equals("Yes")||mode.equals("yes")){
                runner=true; }
            else{
                runner=false; }
        }
        else if(pick.equals("custom")||pick.equals("Custom")||pick.equals("c")) {
            System.out.println("Do you want to activate 'Debug Mode'? (shows the board with all ship placements)" + "\n" + "Enter 'Yes' or 'No': ");
            String mode = s.nextLine();
            if (mode.equals("Yes") || mode.equals("yes")) {
                runner = true; }
            else {
                runner = false; }
            System.out.println("What are the desired board dimensions?" + "\n" + "Keep in mind, the minimum and maximum board sizes are 3x3 and 12x12, respectively." + "\n");
            System.out.println("Enter your desired value for the number of rows. This will be your y-axis (vertically, otherwise known as the height.):");
            int l = s.nextInt();
            System.out.println("Enter your desired value for the number of columns (horizontally, otherwise known as the width):");
            int w = s.nextInt();
            BattleboatsBoard customBoard = new BattleboatsBoard(l, w);
            System.out.println("\n" + "Prepare for Battle..." + "\n");
            customBoard.placeBoats();
            final_board = customBoard;
        }
        int turn=1;
        while(final_board.getHealth()){
            System.out.println("\n"+"Turn "+turn+":"+"\n");
            final_board.showBoard();
            System.out.println("\n");
            if(runner){
                final_board.debugMode();
            }
            System.out.println("\n"+"Shoot or Send a Drone?");
            String option=s.nextLine();

            if(option.equals("shoot")||option.equals("Shoot")){
                if(final_board.doBattle().equals("skip")){
                    turn+=2;
                }
                else{
                    turn++;
                }
            }
            else if(option.equals("Send")||option.equals("send")||option.equals("drone")||option.equals("Drone")){
                if(!(final_board.useDrone())){
                    turn+=5;
                }
                else{
                    turn+=4;
                }
            }
            else if(final_board.sinkShip()){
                System.out.print("You sunk a ship");
            }
        }
        System.out.println("Final Ship has been terminated.");
        System.out.println("Good work Soldier! Victory is ours.");
        final_board.showBoard();
    }
}
