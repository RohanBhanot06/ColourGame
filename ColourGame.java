package loopGameProject;

/*
Name: Rohan Bhanot, Darsh Patel
Starting date: Friday, March 31, 2023.
Ending date: Thursday, April 6, 2023.
Course code: ICS3U1
Description: Creating the Colour Game for the Loop Game Project.
*/

import java.util.Scanner;

public class ColourGame {

	public static int userExtraPoints = 0; // Variable to store the user's extra points
	public static int compExtraPoints = 0; // Variable to store the computer's extra points
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userName; // Variable to store the user's name
		int age; // Variable to store the user's age
		int rounds = 10; // Variable to store the number of rounds in the game
		int userScore = 0; // Variable to store the user's score for the game
		int compScore = 0; // Variable to store the computer's score for the game
		String userGuess; // Variable to store the user's guess for the current round
		String compGuess; // Variable to store the computer's guess for the current round
		int userRoundsWon = 0; // Variable to store the number of rounds won by the user
		int compRoundsWon = 0; // Variable to store the number of rounds won by the computer
		String spinnerResult; // Variable to store the spinner's result for the current round
		int extraPoints = 2; // Variable to store the number of extra points available
		// Displays the game title and instructions to start up the game
		System.out.println("COLOUR GAME️‍!");
		System.out.println(" ");
		System.out.println("To boot up the game, please enter the following information: ");
		// Prompts the user to enter their name and age, and checks if the age is valid to play the game
		System.out.print("Enter your name: ");
		userName = input.next();
		System.out.print("Enter your age before we start the game: ");
		age = input.nextInt();
		while (age < 0 || age > 122) {
			System.out.print("Invalid age! Please enter your age again: ");
			age = input.nextInt();
		}
		// Displays a welcome message to the user and calls the rules method to display the game rules
		System.out.println(" ");
		System.out.println("-----------------");
		System.out.println(" ");
		System.out.println("Welcome " + userName + " to the COLOUR GAME! By: Rohan Bhanot & Darsh Patel");
		rules();
		int extraPointsRound1 = (int) (Math.random() * (rounds - 1 + 1) + 1); // Variable to store the round number for extra points 1
		int extraPointsRound2 = (int) (Math.random() * (rounds - 1 + 1) + 1); // Variable to store the round number for extra points 2
		// Loops through each round of the game
		for (int i = 1; i <= rounds; i++) {
			System.out.println("ROUND " + i + ":");
			// Checks if the current round is one where extra points will be awarded
			if (i == extraPointsRound1 || i == extraPointsRound2) {
				System.out.print("Enter your guess (Red, Yellow, Green, or Blue): ");
				userGuess = input.next();
				// Prompts the user to enter their guess and checks if it is valid
				while ((!userGuess.equalsIgnoreCase("red")) && (!userGuess.equalsIgnoreCase("blue"))
						&& (!userGuess.equalsIgnoreCase("green")) && (!userGuess.equalsIgnoreCase("yellow"))) {
					System.out.print("Invalid input! Please enter Red, Yellow, Green, or Blue: ");
					userGuess = input.next();
				}
			} else {
				System.out.print("Enter your guess (Red, Yellow, Green, or Blue): ");
				userGuess = input.next();
				// Prompts the user to enter their guess and checks if it is valid
				while ((!userGuess.equalsIgnoreCase("red")) && (!userGuess.equalsIgnoreCase("blue"))
						&& (!userGuess.equalsIgnoreCase("green")) && (!userGuess.equalsIgnoreCase("yellow"))) {
					System.out.print("Invalid input! Please enter Red, Yellow, Green, or Blue: ");
					userGuess = input.next();
				}
			}
			int computerRandom = (int) (Math.random() * (4 - 1 + 1) + 1); // Variable to store the computer’s random guess as an integer
			if (computerRandom == 1) {
				compGuess = "red";
			} else if (computerRandom == 2) {
				compGuess = "yellow";
			} else if (computerRandom == 3) {
				compGuess = "green";
			} else {
				compGuess = "blue";
			}
			// Displays the computer's guess
			System.out.println("Computer's Guess: " + compGuess);
			int spinnerRandom = (int) (Math.random() * (4 - 1 + 1) + 1); // Variable to store the spinner's result as an integer
			if (spinnerRandom == 1) {
				spinnerResult = "red";
			} else if (spinnerRandom == 2) {
				spinnerResult = "yellow";
			} else if (spinnerRandom == 3) {
				spinnerResult = "green";
			} else {
				spinnerResult = "blue";
			}
			// Displays the spinner's result
			System.out.println("Spinner Colour: " + spinnerResult);
			// Compares the user's guess with the computer's guess and spinner's result to determine if it is a tie
			if (userGuess.equals(spinnerResult) && compGuess.equals(spinnerResult)) {
				tieResponses(userGuess, compGuess, spinnerResult);
				userScore++;
				compScore++;
			// Compares the user's guess with the computer's guess and spinner's result to determine if it is a win
			} else if (userGuess.equals(spinnerResult) && !compGuess.equals(spinnerResult)) {
				winResponses(userGuess, compGuess, spinnerResult);
				userScore = userScore + 2;
				userRoundsWon++;
			// Compares the user's guess with the computer's guess and spinner's result to determine if it is a loss
			} else if (!userGuess.equals(spinnerResult) && compGuess.equals(spinnerResult)) {
				loseResponses(userGuess, compGuess, spinnerResult);
				compScore = compScore + 2;
				compRoundsWon++;
			// If it is not a win, loss, or tie then it prints that no one has won the round
			} else {
				System.out.println("No one wins this round!");
			}
			// Checks if the current round is one where extra points will be awarded and calls the extraPoints method
			if (i == extraPointsRound1 || i == extraPointsRound2) {
				extraPoints(extraPoints);
			}
			System.out.println("");
		}
		// Prints the final results after the 10 rounds have been completed
		System.out.println("-----------------");
		System.out.println(" ");
		System.out.println("FINAL RESULTS:");
		System.out.println(" ");
		// Prints the rounds won by the user and the computer
		System.out.println("ROUNDS WON:");
		System.out.println("Rounds " + userName + " Won: " + userRoundsWon);
		System.out.println("Rounds Computer Won: " + compRoundsWon);
		System.out.println(" ");
		// Prints the bonus points of the user and the computer
		System.out.println("BONUS POINTS:");
		System.out.println("Extra Points " + userName + " Won: " + userExtraPoints);
		System.out.println("Extra Points Computer Won: " + compExtraPoints);
		System.out.println(" ");
		// Prints the final scores of the user and the computer
		System.out.println("FINAL SCORES:");
		System.out.println(userName + ": " + userScore);
		System.out.println("Computer: " + compScore);
		int totalUserScore = userScore + userExtraPoints; // Variable to store the user's total score
		int totalCompScore = compScore + compExtraPoints; // Variable to store the computer's total score
		System.out.println(userName + "'s Total Points: " + totalUserScore);
		System.out.println("Computer's Total Points: " + totalCompScore);
		System.out.println(" ");
		// Prints the winner of the game based on the results of all 10 rounds
		System.out.println("WINNER OF THE GAME:");
		// Checks if the user has won the game
		if (totalUserScore > totalCompScore) {
			System.out.println(userName + " you have won the game!");
		// Checks if the computer has won the game
		} else if (totalUserScore < totalCompScore) {
			System.out.println("Computer wins the game!");
		// Checks if it is a tie between the user and computer
		} else {
			System.out.println("It's a tie game!");
		}
		input.close();
	}

	/*
	 * Purpose of Method: Displays the rules of the Colour Game, including game setup, rounds, scoring, and winner declaration. 
	 * PRE: None 
	 * POST: Rules of the Colour Game are printed to the console.
	 */
	public static void rules() {
		// Prints all the rules to the Colour Game
		System.out.println(" ");
		System.out.println("COLOUR GAME RULES:");
		System.out.println("1. The Colour Game involves two players: the user and the computer.");
		System.out.println("2. A spinner with four colours (red, yellow, green, and blue) is used in the game.");
		System.out.println("3. The game consists of 10 rounds, and the player with the most points at the end wins.");
		System.out.println("4. At the beginning of each round, the spinner randomly selects a colour, and the user and the computer must guess which colour was selected.");
		System.out.println("5. Correct guesses earn two points, while incorrect guesses do not result in any point deductions.");
		System.out.println("6. Ties award one point to each player.");
		System.out.println("7. Throughout the 10 rounds, there will be two rock-paper-scissors matches for extra points.");
		System.out.println("8. In the game of rock-paper-scissors, a point is awarded to the winner while no points are awarded if the result is a tie.");
		System.out.println("9. At the end of the 10 rounds, the final scores, bonus points, and the number of rounds won by each player will be displayed.");
		System.out.println("10. The winner of the game will also be announced.");
		System.out.println(" ");
		System.out.println("Now you can start with the game by entering a guess!");
		System.out.println(" ");
		System.out.println("-----------------");
		System.out.println(" ");
	}

	/*
	 * Purpose of Method: Provides random win responses based on user's guess, computer's guess, and spinner result. 
	 * PRE: 
	 * A String parameter "userGuess" that represents the user's guess for the spinner colour. 
	 * A String parameter "compGuess" that represents the computer's guess for the spinner colour. 
	 * A String parameter "spinnerResult" that represents the actual colour result of the spinner. 
	 * POST: Prints a random win response message based on the outcome of the round.
	 */
	public static void winResponses(String userGuess, String compGuess, String spinnerResult) {
		// Prints all the possible win responses if a round is won
		int winResponses = (int) (Math.random() * 5 + 1); // Variable to store the messages displayed after a player wins
		switch (winResponses) {
		case 1:
			System.out.println("Congratulations, you guessed correctly!");
			break;
		case 2:
			System.out.println("Good guessing you have won the round!");
			break;
		case 3:
			System.out.println("You have outsmarted the computer this round!");
			break;
		case 4:
			System.out.println("Victory is yours!");
			break;
		case 5:
			System.out.println("You have proven your guessing skills, well done!");
			break;
		}
	}

	/*
	 * Purpose of Method: Provides random lose responses based on user's guess, computer's guess, and spinner result. 
	 * PRE: 
	 * A String parameter "userGuess" that represents the user's guess for the spinner colour. 
	 * A String parameter "compGuess" that represents the computer's guess for the spinner colour. 
	 * A String parameter "spinnerResult" that represents the actual colour result of the spinner. 
	 * POST: Prints a random lose response message based on the outcome of the round.
	 */
	public static void loseResponses(String userGuess, String compGuess, String spinnerResult) {
		// Prints all the possible loss responses if a round is lost
		int loseResponses = (int) (Math.random() * 5 + 1); // Variable to store the messages displayed after a player loses
		switch (loseResponses) {
		case 1:
			System.out.println("The computer has outguessed you this time!");
			break;
		case 2:
			System.out.println("Looks like the computer got the best of you this time!");
			break;
		case 3:
			System.out.println("The computer is a tough opponent, but you'll get there!");
			break;
		case 4:
			System.out.println("Keep trying, you'll outguess the computer eventually!");
			break;
		case 5:
			System.out.println("The computer came out on top!");
			break;
		}
	}

	/*
	 * Purpose of Method: Provides random tie responses based on user's guess, computer's guess, and spinner result. 
	 * PRE: 
	 * A String parameter "userGuess" that represents the user's guess for the spinner colour. 
	 * A String parameter "compGuess" that represents the computer's guess for the spinner colour.
	 * A String parameter "spinnerResult" that represents the actual colour result of the spinner. 
	 * POST: Prints a random tie response message based on the outcome of the round.
	 */
	public static void tieResponses(String userGuess, String compGuess, String spinnerResult) {
		// Prints all the possible tie responses if a round is tied
		int tieResponses = (int) (Math.random() * 5 + 1); // Variable to store the messages displayed after the players tie
		switch (tieResponses) {
		case 1:
			System.out.println("It's a draw!");
			break;
		case 2:
			System.out.println("Tie!");
			break;
		case 3:
			System.out.println("Both the computer and player have tied!");
			break;
		case 4:
			System.out.println("It's a tie!");
			break;
		case 5:
			System.out.println("You have tied with the computer!");
			break;
		}
	}

	/*
	 * Purpose of Method: Performs a bonus round for the game and updates user and computer extra scores. 
	 * PRE: 
	 * An integer parameter "extraPoints" that specifies the number of extra points to be awarded.  
	 * POST: Updates user and computer extra scores based on bonus round results.
	 */
	public static void extraPoints(int extraPoints) {
		Scanner input = new Scanner(System.in);
		String userGuess; // Variable to store the user's guess for the current round
		String compGuess; // Variable to store the computer's guess for the current round
		int computerRandom = (int) (Math.random() * 3); // Variable to store the computer’s random guess as an integer
		if (computerRandom == 1) {
			compGuess = "rock";
		} else if (computerRandom == 2) {
			compGuess = "paper";
		} else {
			compGuess = "scissors";
		}
		// Prompts the user to enter their guess and checks if it is valid
		System.out.println(" ");
		System.out.println("BONUS ROUND! ");
		System.out.print("Enter Rock, Paper or Scissors: ");
		userGuess = input.next();
		while ((!userGuess.equalsIgnoreCase("rock")) && (!userGuess.equalsIgnoreCase("paper"))
				&& (!userGuess.equalsIgnoreCase("scissors"))) {
			System.out.print("Invalid input! Please enter Rock, Paper, or Scissors: ");
			userGuess = input.next();
		}
		// Displays the computer's guess
		System.out.println("Computer's Guess: " + compGuess);
		// Compares the user's guess with the computer's guess to determine if it is a tie
		if (userGuess.equals(compGuess)) {
			System.out.println("It's a tie so no one receives points!");
		// Compares the user's guess with the computer's guess to determine if it is a win
		} else if ((userGuess.equalsIgnoreCase("rock") && compGuess.equals("scissors"))
				|| (userGuess.equalsIgnoreCase("paper") && compGuess.equals("rock"))
				|| (userGuess.equalsIgnoreCase("scissors") && compGuess.equals("paper"))) {
			System.out.println("You win and receive 1 extra point!");
			userExtraPoints++;
		// Compares the user's guess with the computer's guess to determine if it is a loss
		} else {
			System.out.println("You lose the computer receives 1 extra point!");
			compExtraPoints++;
		}

	}

}