package main;

import java.util.HashSet;
import java.util.Set;

/* 2351. First Letter to Appear Twice

Given a string s consisting of lowercase English letters, return the first letter to appear twice.

Note:

A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
s will contain at least one letter that appears twice.
 */
public class FirstLetterAppearTwice {
    public static void main(String[] args) {
        FirstLetterAppearTwice f = new FirstLetterAppearTwice();
        System.out.println(f.repeatedCharacter("abccbaacz"));
    }

    public char repeatedCharacter(String s) {
        if (s == null || s.isEmpty()) {
            return '\0';
        }
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                return s.charAt(i);
            } else {
                set.add(s.charAt(i));
            }
        }
        return '\0';
    }
}
