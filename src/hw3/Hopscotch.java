package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hopscotch {

    public static int hopscotchRecusive(int[] arr, int length, int index, int sum) {
        if (index + 2 >= length) {
            return arr[index] + sum;
        }
        if (index + 3 == length) {
            return hopscotchRecusive(arr, length, index + 2, sum + arr[index]);
        }
        int x = hopscotchRecusive(arr, length, index + 2, sum + arr[index]);
        int y = hopscotchRecusive(arr, length, index + 3, sum + arr[index]);

        return Math.max(x, y);
    }

    public static int maxSum(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return nums[0] + nums[1];
        }
        if (n == 3) {
            return Math.max(nums[0] + nums[1], Math.max(nums[0] + nums[2], nums[1] + nums[2]));
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[0] + nums[1];
        dp[2] = Math.max(nums[0] + nums[2], nums[1] + nums[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return Math.max(dp[n - 1], Math.max(dp[n - 2], dp[n - 3]));
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw3/InputFiles/input-5.1"));
        int length = Integer.parseInt(scanner.nextLine());
        int[] vals = new int[length];
        String[] line = scanner.nextLine().split(" ");
        for (int i = 0; i < length; i++) {
            vals[i] = Integer.parseInt(line[i]);
        }
        System.out.println(maxSum(vals));
    }
}
