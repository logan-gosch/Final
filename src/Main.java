import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int[] randomSuits = new int[4];
        String usedSuits = "Hi";
        int[] numbers = new int[3];
        String AJQK = "Hi";
        int userTotal;
        int computerTotal;
        int hitOrStand;

        for (int i = 0; i < 3; ++i){
            randomSuits[i] = (1 + (int)(Math.random() * 4));
            numbers[i] = (1 + (int)(Math.random() * 13));

            if (randomSuits[i] == 1)
                usedSuits = suits[0];
            else if (randomSuits[i] == 2)
                usedSuits = suits[1];
            else if (randomSuits[i] == 3)
                usedSuits = suits[2];
            else if (randomSuits[i] == 4)
                usedSuits = suits[3];

            if (numbers[i] == 1)
                AJQK = "Ace";
            else if (numbers[i] == 11)
                AJQK = "Jack";
            else if (numbers[i] == 12)
                AJQK = "Queen";
            else if (numbers[i] == 13)
                AJQK = "King";

            if (i == 0 || i == 1){
                if (numbers[i] == 1 || numbers[i] == 11 || numbers[i] == 12 || numbers[i] == 13)
                    System.out.println("You have a " + AJQK + " of " + usedSuits + ".");
                else
                    System.out.println("You have a " + numbers[i] + " of " + usedSuits + ".");
            }
            else{
                if (numbers[i] == 1 || numbers[i] == 11 || numbers[i] == 12 || numbers[i] == 13)
                    System.out.println("\nComputer has a " + AJQK + " of " + usedSuits + ".");
                else
                    System.out.println("\nComputer has a " + numbers[i] + " of " + usedSuits + ".");
            }
        }

        if (numbers[0] == 11 || numbers[0] == 12 || numbers[0] == 13){
            numbers[0] = 10;
        }
        if (numbers[1] == 11 || numbers[1] == 12 || numbers[1] == 12){
            numbers[1] = 10;
        }

        userTotal = numbers[0] + numbers[1];
        System.out.println("\nYou have " + userTotal + " in total.");
        computerTotal = numbers[2];
        System.out.println("Computer has " + computerTotal + " in total.\n");
        Scanner input = new Scanner(System.in);

        if (userTotal == 21){
            System.out.println("Congratulations you got black jack.");
        }
        else if (userTotal > 21){
            System.out.println("Sorry you got bust.");
        }
    }
}
