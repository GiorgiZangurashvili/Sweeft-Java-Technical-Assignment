package maxnumelements;

import java.util.Arrays;

public class MaxNumElementsToSumKSolution {

    public static void main(String[] args) {
        var solution = new MaxNumElementsToSumKSolution();
        int[] array = new int[] {6,2, 2, 3, 4, 1};
        int k = 8;
        System.out.println(solution.maxNumElementsToSumKDp(array, k));
        System.out.println(solution.maxNumElementsToSumKRec(array, k));
    }

    private int maxNumElementsToSumKRec(int[] arr, int k) {
        return maxNumElementsToSumKRecWrapper(arr, k, 0, 0);
    }

    private int maxNumElementsToSumKRecWrapper(int[] arr, int k, int index, int numberOfElements) {
        if (index == arr.length && k == 0) {
            return numberOfElements;
        } else if (k < 0 || index >= arr.length) {
            return -1;
        }
        return Math.max(
                maxNumElementsToSumKRecWrapper(arr, k - arr[index], index + 1, numberOfElements + 1),
                maxNumElementsToSumKRecWrapper(arr, k, index + 1, numberOfElements));
    }

    // Better time complexity than the one with recursion
    // Only works for non-negative k's
    private int maxNumElementsToSumKDp(int[] array, int k) {
        int[][] dp = new int[array.length + 1][k + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= array.length; ++i) {
            for (int j = 0; j <= k; ++j) {
                if (dp[i - 1][j] != -1) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j - array[i - 1] >= 0 && dp[i - 1][j - array[i - 1]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - array[i - 1]] + 1);
                }
            }
        }
        return dp[array.length][k];
    }
}
