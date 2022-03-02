package main;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChar {
    public static void main (String[] args) {
        LongestSubstringWithoutRepeatingChar l = new LongestSubstringWithoutRepeatingChar();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring(" "));
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
        System.out.println(l.lengthOfLongestSubstring("qrsvbspk"));

        System.out.println(l.lengthOfLongestSubstring("anviaj"));

        //System.out.println(" ".length());
    }

    // "abcabcbb" -> 3 ("abc")
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 ) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int maxLength = 0;
        int currSize = 0;
        int j = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                maxLength = Math.max(maxLength, map.size() - currSize);
                int deleteIdx = map.get(currChar);
                currSize = deleteIdx + 1;
                map.remove(currChar);
                map.put(s.charAt(i), i);
                map.clear();
                i = deleteIdx;
            } else {
                map.put(s.charAt(i), i);
            }


        }

        maxLength = Math.max(maxLength, map.size() - currSize);

        return maxLength;
    }
}
