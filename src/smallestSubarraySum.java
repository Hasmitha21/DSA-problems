/*
 * Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous subarray whose sum 
 * is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 * 
 * The time complexity of the above algorithm will be O(N)O(N). 
 * The outer for loop runs for all elements and the inner while loop processes each element only once, 
 * therefore the time complexity of the algorithm will be O(N+N)O(N+N) which is asymptotically equivalent to O(N)O(N).

Space Complexity #
The algorithm runs in constant space O(1)O(1).
 */
public class smallestSubarraySum {
	public static int FindMinSubarray(int S, int[] arr) {
		int windowsum = 0;
		int windowstart = 0;
		int windowend = 0;
		int Minlength = Integer.MAX_VALUE;
		for (windowend = 0; windowend < arr.length; windowend++) {
			windowsum = windowsum + arr[windowend];

			while (windowsum >= S) {
				Minlength = Math.min(Minlength, windowend - windowstart + 1);
				windowsum = windowsum - arr[windowstart];
				windowstart++;
			}

		}

		return Minlength == Integer.MAX_VALUE ? 0 : Minlength;
	}

	public static void main(String args[]) {
		int result = smallestSubarraySum.FindMinSubarray(7, new int[] { 2, 3, 4, 4, 5, 1, 2, 1, 3 });
		System.out.println("Smallest subarray length:" + result);
	}
}
