package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LongestIncreasingSubseqRecursive
{
    // Stores the LIS
    static int max_ref;

    static int longestSeqRecursive(int[] arr, int n)
    {
        // Base case
        if (n == 1)
        {
            return 1;
        }
            int res, max_ending_here = 1;

        for (int i = 1; i < n; i++)
        {
            res = longestSeqRecursive(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
            {
                max_ending_here = res + 1;
            }
        }

        if (max_ref < max_ending_here)
        {
            max_ref = max_ending_here;
        }

        return max_ending_here;
    }

    static int lis(int[] arr, int n)
    {
        // The max variable holds the result
        max_ref = 1;

        // The function _lis() stores its result in max
        longestSeqRecursive(arr, n);

        // Returns max
        return max_ref;
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

