package com.forefront.a_array.a_basic;

import com.forefront.util;

/**
 You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is.
 Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in
 both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
 Your friend will use successive guesses and hints to eventually derive the secret number.

 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows.

 Please note that both secret number and friend's guess may contain duplicate digits.

 Example 1:

 Input: secret = "1807", guess = "7810"

 Output: "1A3B"

 Explanation: 1 bull and 3 cows. The bull is 8, the cows are 0, 1 and 7.
 Example 2:

 Input: secret = "1123", guess = "0111"

 Output: "1A1B"

 Explanation: The 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow.
*/

public class _299_Bulls_And_Cows {

    public static void solve() {

        _299_Bulls_And_Cows solver = new _299_Bulls_And_Cows();

//        String secret = "1807";
//        String guess = "7810";

        String secret = "1123";
        String guess = "0111";

        System.out.println("secret: " + secret);
        System.out.println("guess: " + guess);

        String result = solver.getHint(secret, guess);
//        String result = solver.getHint_lc(secret, guess);
        System.out.println("\n\nSolution");
        System.out.println(result);
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] count = new int[10];

        for(int i = 0; i < secret.length(); i++){
            int secretDigit = secret.charAt(i) - '0';
            int guessDigit = guess.charAt(i) - '0';

            if(secretDigit == guessDigit) {
                bulls++;
            }
            else {
                if(count[secretDigit] < 0) {
                    cows++;
                }
                count[secretDigit]++;

                if(count[guessDigit] > 0){
                    cows++;
                }
                count[guessDigit]--;
            }
        }

        return bulls + "A" + cows + "B";
    }

    public String getHint_lc(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                /*
                 * If count is less than zero before we increase it, it means that it was decreased by guess already.
                 */
                if (count[secret.charAt(i) - '0']++ < 0) cows++;
                if (count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";

    }
}
