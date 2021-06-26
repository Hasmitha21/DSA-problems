// Using sliding window ---- Time complexity O(N)
public class MaxSumSubarray {
	public static int maxSumSubarr(int k, int[] arr) {
		int windowstart = 0;
		int windowsum = 0;
		int maxSum = 0;
		for (int windowend = 0; windowend < arr.length; windowend++) {
			windowsum = windowsum + arr[windowend];
			if (windowend >= k - 1) {
				maxSum = Math.max(maxSum, windowsum);
				windowsum = windowsum - arr[windowstart];
				windowstart++;
			}
		}
		return maxSum;
	}

	public static void main(String args[]) {
		System.out.println("Maximum Sum of a contiguous subarray is:"
				+ MaxSumSubarray.maxSumSubarr(3, new int[] { 1, 2, 5, 2, 4, -1, 3 }));
		System.out.println("Maximum Sum of a contiguous subarray is:"
				+ MaxSumSubarray.maxSumSubarr(2, new int[] { 2, 3, 4, 2, 1, 6, 4 }));

	}

}
