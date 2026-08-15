import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Frequency of characters required from t
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int formed = 0;

        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Add character to current window
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // This character has now satisfied its required frequency
            if (need.containsKey(ch)
                    && window.get(ch).intValue() == need.get(ch).intValue()) {

                formed++;
            }

            // Window is valid
            while (formed == need.size()) {

                // Check whether this is the smallest window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character
                window.put(leftChar, window.get(leftChar) - 1);

                // We no longer satisfy the requirement for this character
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {

                    formed--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(minLeft, minLeft + minLength);
    }
}