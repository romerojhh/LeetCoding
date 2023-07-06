package main;

import java.util.HashMap;
import java.util.Map;

/* 1941. Check if All Characters Have Equal Number of Occurrences
Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
 */
public class CheckAllCharactersHaveEqualNumberOccurrences {
    public static void main(String[] args) {
        CheckAllCharactersHaveEqualNumberOccurrences c = new CheckAllCharactersHaveEqualNumberOccurrences();
        System.out.println(c.areOccurrencesEqual("abacbc"));
        System.out.println(c.areOccurrencesEqual("aaabb"));
    }

    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character currChar = s.charAt(i);

            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }
        int reference = s.length() / map.size();
        for(Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() != reference) {
                return false;
            }
        }

        return true;
    }
}
