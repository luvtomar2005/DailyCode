#include <string>
#include <vector>

class Solution {
public:
    bool isAnagram(std::string s, std::string t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) return false;
        
        // Use a fixed-size vector (or a primitive array: int freq[26] = {0};)
        std::vector<int> freq(26, 0);
        
        // Single loop to increment for s and decrement for t
        for (size_t i = 0; i < s.length(); i++) {
            freq[s[i] - 'a']++;
            freq[t[i] - 'a']--;
        }
        
        // Check if any frequency bucket is non-zero
        for (int count : freq) {
            if (count != 0) return false;
        }
        
        return true;
    }
};
