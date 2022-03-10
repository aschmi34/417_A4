import java.util.Scanner;

public class DFA {
    public static void main(String[] args) {


        /*
        Criteria:

        at most 20 states
        alphabet is {0,1}
        outputs ACCEPT for valid strings and REJECT for invalid strings
        starting state is 1

        User input:

        Ask user to enter transition function delta

        ask user to enter the set of accepting states

        ask user to enter input string

         */


        int[] states, accepts;
        int [][] delta;
        int state = 1, totalStates;

        String input;
        boolean ACCEPTS;

        Scanner scan = new Scanner(System.in);

        /* A DFA is defined by {Q, sigma, delta, q_0, F} where

        Q is the set of states
        sigma is the alphabet
        delta is the transition function
        q_0 is the starting state
        and F it the set of accepting states

        |Q| <= 20
        sigma = {0,1}
        q_0 = 1

         */

        /*
        What we need to know:

        how many states are there?
        what is the transition function?
        what are the accepting states?
         */

        //to get the user's input on the total number of states
        System.out.println(
                "Welcome to the DFA game!!" +
                "\n" +
                "\nThe purpose of this game is for you to enter a deterministic finite automata, or DFA, and then enter strings to test on it." +
                "\n" +
                "\nThis DFA can have up to 20 states, will start on state 1 and will have the alphabet {0, 1}, meaning all of its inputs which it makes transitions on will be 0 or 1. " +
                "\n" +
                "\nWe will start by entering the number of states this DFA will have.");

        totalStates = getInt(scan, "Please input the number of states: ");

        System.out.println(
                "\nGreat! Next we will input the transition function, delta." +
                "\n" +
                "The transition function describes where you will go from each state on each member of the alphabet." +
                "\nSince our alphbet is {0, 1}, I will ask you where you want to go on each state given the inputs 0 and 1.\n");

        delta = delta(totalStates);
        System.out.print(deltaToString(delta, totalStates));

        System.out.print("Please input the set of accepting states: ");
        String acceptingStates = scan.nextLine();

        System.out.print("Please input a string to test: ");

        String again = "y";

        while (again.equals("y") || again.equals("Y")){



            //lastly to ask if they want to continue entering strings
            System.out.print("Do you want to continue: y/n ");
            again = scan.next();

        }


    }

    public static int[][] delta(int totalStates){

        Scanner input = new Scanner(System.in);
        int state = 1;

        int[][] delta = new int[totalStates][3];

        //to get the user to input the transition function
        for (int i = 0; i < totalStates; i++){
            delta[i][0]= state;

            int on0, on1;

            System.out.print("Please input the transition state from state "+state+" on input 0: ");
            on0 = input.nextInt();
            while (on0 > totalStates || on0 < 1)
            {
                System.out.println("Invalid input!!");
                System.out.print("Please input the state we will move to from state "+state+" on input 0: ");

                on0 = input.nextInt();
            }
            delta[i][1]= on0;

            System.out.print("Please input the transition state from state "+state+" on input 1: ");
            on1 = input.nextInt();
            while (on1 > totalStates || on1 < 1)
            {
                System.out.println("Invalid input!!");
                System.out.print("Please input the state we will move to from state "+state+" on input 1: ");

                on1 = input.nextInt();
            }
            delta[i][2]= on1;
            System.out.println();
            state++;
        }

        return delta;
    }

    public static String deltaToString(int[][] delta, int totalStates) {
        String outgoing = "Alrighty then, here is your transition function: " +
                "\nState\t0\t1" +
                "\n-----\t-\t-\n";
        for (int i = 0; i < totalStates; i++){
            outgoing = outgoing + delta[i][0] + "\t\t" + delta[i][1] + "\t" + delta[i][2] + "\n";
        }
        outgoing = outgoing + "\n";
        return outgoing;
    }



    public int[] acceptingStates(){
        return new int[1];
    }

    public static int getInt (Scanner input, String message){
        System.out.print(message);
        while (!input.hasNextInt()){
            input.nextLine();
            System.out.println("This is not an integer value.\n Please try again.");
            System.out.print(message);
        }
        return input.nextInt();
    }
}

