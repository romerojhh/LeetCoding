package main;

import java.util.HashSet;
import java.util.Set;

/* 1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.
 */
public class CheckSentenceIsPangram {
    public static void main(String[] args) {
        CheckSentenceIsPangram c = new CheckSentenceIsPangram();
        System.out.println(c.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

    public boolean checkIfPangram(String sentence) {
        // pangram basically the same as there is no repeating alphabetic character
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < sentence.length(); i++) {
            if (!Character.isAlphabetic(sentence.charAt(i))) {
                return false;
            }
            set.add(sentence.charAt(i));
            if (set.size() == 26) {
                return true;
            }
        }
        return false;
    }
}
