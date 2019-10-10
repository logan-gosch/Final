public class Main {

    public static void main(String[] args){

        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        int randomSuit1;
        String userSuits1 = "Hi";
        int userNumber1;
        String userAJQK1 = "Hi";

        randomSuit1 = (1 + (int)(Math.random() * 4));
        userNumber1 = (1 + (int)(Math.random() * 13));

        if (randomSuit1 == 1)
            userSuits1 = suits[0];
        else if (randomSuit1 == 2)
            userSuits1 = suits[1];
        else if (randomSuit1 == 3)
            userSuits1 = suits[2];
        else if (randomSuit1 == 4)
            userSuits1 = suits[3];

        if (userNumber1 == 1)
            userAJQK1 = "Ace";
        else if (userNumber1 == 11)
            userAJQK1 = "Jack";
        else if (userNumber1 == 12)
            userAJQK1 = "Queen";
        else if (userNumber1 == 13)
            userAJQK1 = "King";

        if (userNumber1 == 1 || userNumber1 == 11 || userNumber1 == 12 || userNumber1 == 13)
            System.out.println("You have a " + userAJQK1 + " of " + userSuits1 + ".");
        else
            System.out.println("You have a " + userNumber1 + " of " + userSuits1 + ".");
    }
}
