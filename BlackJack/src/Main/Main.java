package Main;

import java.util.Scanner;

class Main{

	public static void main(String[] args){
		
		//Scanner for the user to enter info
		Scanner userInput = new Scanner(System.in);
		double playerMoney;
		double moneyStartedWith;
		double playerMoneyEarnedOrLost = 0;
		int keepPlayingOrQuit = 1;
	 
	
		Graphics.intro();
	 
		//playingDeck will be the deck you are using.
		Deck playingDeck = new Deck();
		playingDeck.createFullDeck();
		playingDeck.shuffle();
		
		//playerCards will be the cards the player is holding
		Deck playerCards = new Deck();
		
		System.out.println("Enter an amount of cash you would like to exchange for chips");
		//playerMoney holds players chips
		playerMoney = userInput.nextDouble();
		moneyStartedWith = playerMoney;
		//dealerCards will be the dealer's cards
		Deck dealerCards = new Deck();
		
		while(keepPlayingOrQuit == 1) {
			//If the player has money, the game goes on
			while(playerMoney>0){
				//Takes how much you want to bet
				System.out.println("You have " + playerMoney + " chips, how much would you like to bet?");
				double playerBet = userInput.nextDouble();
				boolean endRound = false;
				if(playerBet > playerMoney){
					//If the player enters more money then they have, this gets displayed:
					System.out.println("You cannot bet more than you have.");
					break;
				}
		
				System.out.println("Dealing...");
				//Player gets two cards
				playerCards.draw(playingDeck);
				playerCards.draw(playingDeck);
		
				//Dealer gets two cards
				dealerCards.draw(playingDeck);
				dealerCards.draw(playingDeck);
		   
				//This is a while loop to draw cards
				while(true){
					//Shows the cards that the player has
					System.out.println("Your Hand:" + playerCards.toString());
			     
					//The total value of your cards
					System.out.println("Your hand is currently valued at: " + playerCards.cardsValue());
			     
					//Shows the cards that the dealer has
					System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString() + " and [hidden]");
			     
					//Choice to keep your hand or draw one more
					System.out.println("Would you like to (1)Hit or (2)Stand");
					int response = userInput.nextInt(); 
					//If hit then draws new cards until they do stand
					if(response == 1){
						playerCards.draw(playingDeck);
						System.out.println("You draw a:" + playerCards.getCard(playerCards.deckSize()-1).toString());
						//If the player goes over 21 then they go bust
						if(playerCards.cardsValue() > 21){
							System.out.println("Bust. Currently valued at: " + playerCards.cardsValue());
							playerMoney -= playerBet;
							endRound = true;
							break;
						}
					}
			     
					//If stand then moves on to next section
					if(response == 2){
						break;
					}
			     
				}
		
		     
				//Reveals the Dealers extra cards
				System.out.println("Dealer Cards:" + dealerCards.toString());
				//This sees if the dealer has a higher value than the player
				if((dealerCards.cardsValue() > playerCards.cardsValue())&&endRound == false){
					System.out.println("Dealer beats you " + dealerCards.cardsValue() + " to " + playerCards.cardsValue());
					playerMoney -= playerBet;
					endRound = true;
				}
				//Dealer is programmed to hit if their cards are at 16 or below, and stand if at 17 or above.
				while((dealerCards.cardsValue() < 17) && endRound == false){
					dealerCards.draw(playingDeck);
					System.out.println("Dealer draws: " + dealerCards.getCard(dealerCards.deckSize()-1).toString());
				}
				//Displays the total of the dealer's cards
				System.out.println("Dealers hand value: " + dealerCards.cardsValue());
				//Determines if dealer busted
				if((dealerCards.cardsValue()>21)&& endRound == false){
					System.out.println("Dealer Busts. You win!");
					playerMoney += playerBet;
					endRound = true;
				}
				//If the Dealer and Player have the same value then it's a push
				if((dealerCards.cardsValue() == playerCards.cardsValue()) && endRound == false){
					System.out.println("Push.");
					endRound = true;
				}
				//Determines if the player wins or not
				if((playerCards.cardsValue() > dealerCards.cardsValue()) && endRound == false){
					System.out.println("You win the hand.");
					playerMoney += playerBet;
					endRound = true;
				}
				else if(endRound == false) //dealer wins
				{
					System.out.println("Dealer wins.");
					playerMoney -= playerBet;
				}
		
				//At the end of the round the cards go back into the deck
				playerCards.moveAllToDeck(playingDeck);
				dealerCards.moveAllToDeck(playingDeck);
				System.out.println("End of Hand.");
				break;
			}
			
			if(playerMoney > 0) {
				System.out.println("You have " + playerMoney + " chips.\nIf you want to keep playing press (1).\nIf you want to quit press (2).");
				keepPlayingOrQuit = userInput.nextInt();
					if(keepPlayingOrQuit == 2) {
						break;
					}
				}
			else {
				break;
			}
		}
	 
		//Game is over
			if(playerMoney < moneyStartedWith) {
				playerMoneyEarnedOrLost = moneyStartedWith - playerMoney;
				System.out.println("You lost $" + playerMoneyEarnedOrLost);
				Graphics.outroLoss();
			}
			else{
				playerMoneyEarnedOrLost = playerMoney - moneyStartedWith;
				System.out.println("Congratulations. You won $" + playerMoneyEarnedOrLost);
				Graphics.outroWin();
			}
		
			//Closes Scanner
			userInput.close();
	
	}
}

