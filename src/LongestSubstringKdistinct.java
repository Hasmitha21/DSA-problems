/*
 * Time Complexity #
The time complexity of the above algorithm will be O(N)O(N) where ‘N’ is the number of characters in the input string.
The outer for loop runs for all characters and the inner while loop processes each character only once, 
therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

Space Complexity #
The space complexity of the algorithm is O(K)O(K), as we will be storing a maximum of ‘K+1’ characters in the HashMap.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKdistinct {
	public static int FindLength(String str, int k) {

		if (str == null || str.length() == 0 || str.length() < k) {
			return 0;
		}
		int windowstart = 0;
		int windowend = 0;
		int maxlen = 0;
		Map<Character, Integer> frequencyCounterMap = new HashMap<>();
		for (windowend = 0; windowend < str.length(); windowend++) {
			char rightchar = str.charAt(windowend);
			frequencyCounterMap.put(rightchar, frequencyCounterMap.getOrDefault(rightchar, 0) + 1);
			// shrinking the window
			while (frequencyCounterMap.size() > k) {
				char leftchar = str.charAt(windowstart);
				frequencyCounterMap.put(leftchar, frequencyCounterMap.get(leftchar) - 1);
				if (frequencyCounterMap.get(leftchar) == 0) {
					frequencyCounterMap.remove(leftchar);
				}
				windowstart++;
			}
			maxlen = Math.max(maxlen, windowend - windowstart + 1);
		}

		return maxlen;
	}

	public static void main(String[] args) {
		System.out.println("Length is:" + LongestSubstringKdistinct.FindLength("araaci", 2));
		System.out.println("Length is:" + LongestSubstringKdistinct.FindLength("bbacci", 3));

	}

}
