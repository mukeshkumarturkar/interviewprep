package ds;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

   /* Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with length 3.*/

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(input));  // Output: 3
    }
    static int lengthOfLongestSubstring(String s){
        Set<Character> seen = new HashSet<>();
        int left =0, right =0;
        int maxLength =0;

        while(right<s.length()){
            char  currentChar= s.charAt(right);

            // If duplicate found, shrink window from the left
             while(seen.contains(currentChar)){
                 System.out.println("Removed " + s.charAt(left));
                 seen.remove(s.charAt(left));
                 left++;
             }

            // Add current character and update max length
            seen.add(currentChar);
            maxLength = Math.max(maxLength, right-left +1);
            right++;

            System.out.println("Left : " +left + " Right :"+right + " maxLength :"+maxLength + " Set : " +seen);
        }
        return maxLength;
    }
}
