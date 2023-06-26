package main;

import java.util.HashMap;

/*
    3. Longest Substring Without Repeating Characters

    Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChar {
    public static void main (String[] args) {
        LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();
        System.out.println(l.lengthOfLongestSubstring("anviaj"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 ) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                int duplicateCharIdx = map.get(currChar);
                // restart from duplicateIdx + 1;
                i = duplicateCharIdx;
                maxLength = Math.max(maxLength, map.size());
                map.clear();
            } else {
                map.put(currChar, i);
            }
        }

        maxLength = Math.max(maxLength, map.size());

        return maxLength;
    }

    // O(N^2)
    //public int lengthOfLongestSubstring(String s) {
    //        int longest = 0;
    //        HashSet<Character> set = new HashSet<>();
    //        for (int i = 0 ; i < s.length(); i++) {
    //            for (int j = i ; j < s.length(); j++) {
    //                if (!set.contains(s.charAt(j))) {
    //                    set.add(s.charAt(j));
    //                } else {
    //                    longest = Math.max(longest, set.size());
    //                    set.clear();
    //                    break;
    //                }
    //            }
    //            longest = Math.max(longest, set.size());
    //            if (longest == s.length()) {
    //                break;
    //            }
    //        }
    //
    //        return longest;
    //    }
}
