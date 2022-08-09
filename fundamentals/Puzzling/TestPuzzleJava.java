import java.util.ArrayList;

public class TestPuzzleJava {

    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();

        System.out.println("---- Get 10 Rolls Test ----");
        ArrayList<Integer> randomRolls = generator.getTenRolls(20, 1);
        System.out.println(randomRolls);

        System.out.println("\n---- Get Letter Test ----");
        char letter = generator.getRandomLetter();
        System.out.println(letter);

        System.out.println("\n---- Generate Password Test ----");
        String myPassword = generator.generatePassword();
        System.out.println(myPassword);

        System.out.println("\n---- New Password Set Test ----");
        // For fixed Array
        // String[] myPasswords = generator.getNewPasswordSet(4);
        // for (int i = 0; i < myPasswords.length; i++) {
        // System.out.println(myPasswords[i]);
        // }

        ArrayList<String> myPasswords = generator.getNewPasswordSet(4);
        System.out.println(myPasswords);

        System.out.println("\n---- Shuffle Aray Test ----");
        ArrayList<String> shuffledPasswords = generator.shuffleArray(myPasswords);
        System.out.println(shuffledPasswords);
    }
}
