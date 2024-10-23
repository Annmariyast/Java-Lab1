import java.util.HashMap;
import java.util.Map;

public class AlphabetWarGame {
    private Map<Character, Integer> leftSideStrengths;
    private Map<Character, Integer> rightSideStrengths;

    // Constructor with default strengths
    public AlphabetWarGame() {
        this.leftSideStrengths = new HashMap<>();
        this.rightSideStrengths = new HashMap<>();
        
        // Default strengths for left side letters
        leftSideStrengths.put('w', 4);
        leftSideStrengths.put('p', 3);
        leftSideStrengths.put('b', 2);
        leftSideStrengths.put('s', 1);

        // Default strengths for right side letters
        rightSideStrengths.put('m', 4);
        rightSideStrengths.put('q', 3);
        rightSideStrengths.put('d', 2);
        rightSideStrengths.put('z', 1);
    }

    // Constructor with custom strengths
    public AlphabetWarGame(Map<Character, Integer> customLeftSide, Map<Character, Integer> customRightSide) {
        this.leftSideStrengths = customLeftSide;
        this.rightSideStrengths = customRightSide;
    }

    // Method to fight with a single word
    public String fight(String word) {
        int leftSideScore = 0;
        int rightSideScore = 0;

        // Calculate total score for each side
        for (char c : word.toCharArray()) {
            if (leftSideStrengths.containsKey(c)) {
                leftSideScore += leftSideStrengths.get(c);
            } else if (rightSideStrengths.containsKey(c)) {
                rightSideScore += rightSideStrengths.get(c);
            }
        }

        return determineWinner(leftSideScore, rightSideScore);
    }

    // Method to fight with separate left-side and right-side words
    public String fight(String leftWord, String rightWord) {
        int leftSideScore = 0;
        int rightSideScore = 0;

        // Calculate score for the left side word
        for (char c : leftWord.toCharArray()) {
            if (leftSideStrengths.containsKey(c)) {
                leftSideScore += leftSideStrengths.get(c);
            }
        }

        // Calculate score for the right side word
        for (char c : rightWord.toCharArray()) {
            if (rightSideStrengths.containsKey(c)) {
                rightSideScore += rightSideStrengths.get(c);
            }
        }

        return determineWinner(leftSideScore, rightSideScore);
    }

    // Helper method to determine the winner
    private String determineWinner(int leftScore, int rightScore) {
        if (leftScore > rightScore) {
            return "Left side wins!";
        } else if (rightScore > leftScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a default game
        AlphabetWarGame game = new AlphabetWarGame();

        // Test cases with default strengths
        System.out.println(game.fight("z"));            // Right side wins!
        System.out.println(game.fight("zdqmwpbs"));     // Let's fight again!
        System.out.println(game.fight("wwwwwwz"));      // Left side wins!

        // Custom strengths (optional)
        Map<Character, Integer> customLeft = new HashMap<>();
        customLeft.put('w', 5);  // Custom strength
        customLeft.put('p', 3);
        customLeft.put('b', 2);
        customLeft.put('s', 1);

        Map<Character, Integer> customRight = new HashMap<>();
        customRight.put('m', 4);
        customRight.put('q', 3);
        customRight.put('d', 2);
        customRight.put('z', 2);  // Custom strength

        // Create a game with custom strengths
        AlphabetWarGame customGame = new AlphabetWarGame(customLeft, customRight);
        System.out.println(customGame.fight("zdqmwpbs"));  // Test with custom strengths
    }
}
