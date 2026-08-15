import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : s1.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {

            sCount[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                sCount[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                return true;
            }
        }

        return false;
    }
}