import java.util.Arrays;

//Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

//1. Brute Force Method --- Time Complexity O(N*K)
public class SlidingWindowSubarray {
	public static double[] findAverages(int K, int arr[]) {
		double[] result = new double[arr.length - K + 1];
		for (int i = 0; i <= arr.length - K; i++) {
			// Find sum of next K elements
			double sum = 0;
			for (int j = i; j < i + K; j++) {
				sum = sum + arr[j];
				result[i] = sum / K; // average calculated
			}
		}
		return result;
	}

	public static void main(String[] args) {
		double[] result = SlidingWindowSubarray.findAverages(3, new int[] { 1, 2, 4, 9, 6, -1, 8 });
		double[] result2 = SlidingWindowSubarray.findAverages2(3, new int[] { 1, 2, 4, 9, 6, -1, 8 });
		System.out.println("Averages are:" + Arrays.toString(result));
		System.out.println("Averages are:" + Arrays.toString(result2));

	}

//2. Using sliding window method -- Time Complexity O(N)
	public static double[] findAverages2(int K, int arr[]) {
		double[] result = new double[arr.length - K + 1];
		int windowstart = 0;
		double windowsum = 0;
		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowsum = windowsum + arr[windowEnd]; // adding next element
			// Slide until we get the K amount to indexes
			if (windowEnd >= K - 1) {
				result[windowstart] = windowsum / K; // calc the average
				windowsum = windowsum - arr[windowstart];
				windowstart++;
			}
		}
		return result;
	}

}
