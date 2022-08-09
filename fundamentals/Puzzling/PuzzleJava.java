import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {

    Random randMachine = new Random();

    // Write a method that will generate and return an array with 10 random numbers
    // between 1 and 20 inclusive.
    ArrayList<Integer> getTenRolls(int max, int min) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            int randomNum = randMachine.nextInt((max - min) + 1) + min;
            rolls.add(randomNum);
        }
        return rolls;
    }

    // getRandomLetter

    // Write a method that will:

    // Create an array within the method that contains all 26 letters of the
    // alphabet (this array must have 26 values).
    // Generate a random index between 0-25, and use it to pull a random letter out
    // of the array.
    // Return the random letter.

    char getRandomLetter() {
        // char[] myArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
        // 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        // int randomNumber = randMachine.nextInt(26);
        // char myLetter = myArr[randomNumber];
        // return myLetter;

        // Possible solution with array

        // String getRandomLetterWithArray() {
        // Random rand = new Random();

        // String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        // String[] alphabet = new String[26];
        // for (int i = 0; i < 26; i++) {
        // alphabet[i] = String.valueOf(alphabetString.charAt(i));
        // }
        // return alphabet[rand.nextInt(26)];
        // }

        char c = (char) (randMachine.nextInt(26) + 'a');
        return c;
    }

    // generatePassword

    // Write a method that uses the previous method to create a random string of
    // eight characters, and return that string.

    String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += getRandomLetter();
        }
        return password;
    }

    // getNewPasswordSet

    // Write a method that takes an int length as an argument and creates an array
    // of random eight character words. The array should be the length passed in as
    // an int.

    // String[] getNewPasswordSet(int length) {

    // // With a fixed array
    // String[] passwords = new String[length];
    // for (int i = 0; i < length; i++) {
    // passwords[i] = generatePassword();
    // }
    // return passwords;
    // }

    // With an ArrayList
    ArrayList<String> getNewPasswordSet(int length) {

        ArrayList<String> passwords = new ArrayList<String>();
        for (int i = 0; i < length; i++) {
            passwords.add(generatePassword());
        }
        return passwords;

    }

    // SENSEI BONUS:
    // shuffleArray

    // Write a method that takes an array and mixes up all the values in a
    // pseudo-random way. Hint: use random indexes within the array, and swap values
    // repeatedly.

    ArrayList<String> shuffleArray(ArrayList<String> testArray) {
        for (int i = 0; i < testArray.size(); i++) {
            int index = randMachine.nextInt(testArray.size());
            String temp = testArray.get(index);
            testArray.set(i, testArray.get(index));
            testArray.set(index, temp);
        }
        return testArray;
    }
}
