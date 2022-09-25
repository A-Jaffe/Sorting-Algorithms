import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        // Declare variables and populate String[]
        String[] wordList = {"right", "subdued", "trick", "crayon", "punishment",
                "silk", "describe", "royal", "prevent", "slope"};
        String temp;

        // Display wordList before sorting
        System.out.println("UNSORTED WORDS:");
        for (String word : wordList) {
            System.out.println(word);
        }

        // Run BubbleSort on wordList
        System.out.println("\nSORTED WORDS:");
        for (int i = 0; i < wordList.length; i++) {
            for (int j = i + 1; j < wordList.length; j++) {
                if (wordList[j].compareTo(wordList[i]) < 0) {
                    temp = wordList[i];
                    wordList[i] = wordList[j];
                    wordList[j] = temp;
                }
            }
            // Display sorted words
            System.out.println(wordList[i]);
        }
    }
}
