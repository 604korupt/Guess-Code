import java.util.Scanner;

public class GuessCode {
    public static void main(String[] args) {
        //Initialise the number of guesses first.
        int count = 0;
        //Make two scanners so that both the codes match.
        Scanner codeScanner = new Scanner(System.in);
        Scanner guessScanner = new Scanner(System.in);
        //Initialise a boolean value for our while loop.
        boolean loop = true;
        System.out.print("What is the secret code?: ");
        String code = codeScanner.next();
        System.out.print("What is the guess code?: ");
        String guess = guessScanner.next();
        while (loop) {
            count++;
            if (code.equals(guess)) {
                System.out.println("Yes, that is correct! You figured it out in " + count + " guess!");
                //When the guess has been made, we can exit out the program, so that it doesn't run the while loop again.
                loop = false;
            } else if (matching(code, guess).equals("")){
                System.out.println("No, and none of the slots are correct.");
                System.out.print("Please guess again!: ");
                guess = guessScanner.next();
            } else {
                //call the matching method so that you get the number of slots correct.
                System.out.println("No, but you have the following slot(s) correct: " + matching(code, guess));
                System.out.print("Please guess again!: ");
                guess = guessScanner.next();
            }
        }
        //Close the scanners
        codeScanner.close();
        guessScanner.close();
    }

    public static String matching(String code1, String code2) {
        //Initialise the sum and the total string.
        int sum;
        String total = "";
        for(int i = 0; i <= 3; i++) {
            //This checks if the characters are the same or not.
            if(code1.charAt(i)==code2.charAt(i)) {
                //Since charAt is 0-indexed, and we want it to return 1, we add 1 to i, which equals our sum.
                sum = i+1;
                //Quotes are added so that it doesn't add the numbers up, but instead separates the numbers.
                total = total + sum + "";
            }
        }
        return total;
    }
}
