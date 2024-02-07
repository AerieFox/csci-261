package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestIncreasingSubseqDP
{


    static int findLongestSubseq(int idx, int prev_idx, int n, int[] arr, int[][] dp)
    {
        if (idx == n)
        {
            return 0;
        }

        if (dp[idx][prev_idx + 1] != -1)
        {
            return dp[idx][prev_idx + 1];
        }

        int notTake = findLongestSubseq(idx + 1, prev_idx, n, arr, dp);
        int take = Integer.MIN_VALUE;
        if (prev_idx == -1 || arr[idx] > arr[prev_idx])
        {
            take = 1 + findLongestSubseq(idx + 1, idx, n, arr, dp);
        }

        return dp[idx][prev_idx + 1] = Math.max(take, notTake);
    }

    static int lis(int[] arr, int n)
    {
        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp)
        {
            for(int i = 0; i < row.length; i++)
            {
                row[i] = -1;
            }
        }
        return findLongestSubseq(0, -1, n, arr, dp);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw3/InputFiles/test"));
        int length = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[length];
        String[] line = scanner.nextLine().split(" ");
        for(int i = 0; i < length; i++)
        {
            arr[i] = Integer.parseInt(line[i]);
        }
        long startTime = System.nanoTime();
        System.out.println(lis(arr, length));
        long endTime = System.nanoTime();
        long execTime = (endTime - startTime) / 100000;
        System.out.println("Operation took: " + execTime + " ms");
    }
}
